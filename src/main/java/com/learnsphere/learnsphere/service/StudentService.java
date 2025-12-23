package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.exception.ConflictException;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final EntityManager entityManager;

    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByID(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id:" +id));
    }

    public Student createStudent(Student student) {
        try{
            return studentRepository.save(student);
        }catch (DataIntegrityViolationException e){
            throw new ConflictException("Email is already used");
        }
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id:" +id));

        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setContactNo(student.getContactNo());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setCity(student.getCity());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setNicUrl(student.getNicUrl());
        existingStudent.setProfileUrl(student.getProfileUrl());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setStatus(student.getStatus());
        existingStudent.setUpdatedAt(student.getUpdatedAt());

        return studentRepository.save(existingStudent);
    }

    public Page<Student> search(String firstName, String lastName, String email, String city, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        if(firstName != null && !firstName.isEmpty()){
            predicates.add(cb.like(cb.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%"));
        }

        if(lastName != null && !lastName.isEmpty()){
            predicates.add(cb.like(cb.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%"));
        }

        if(email != null && !email.isEmpty()){
            predicates.add(cb.equal(root.get("email") , email));
        }

        if(city != null && !city.isEmpty()){
            predicates.add(cb.equal(root.get("city"), city));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Student> typedQuery = entityManager.createQuery(query);

        // Pagination
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<Student> students = typedQuery.getResultList();

        // Count Query
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Student> countRoot = countQuery.from(Student.class);
        countQuery.select(cb.count(countRoot))
                .where(predicates.toArray(new Predicate[0]));

        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(students, pageable, total);
}
}
