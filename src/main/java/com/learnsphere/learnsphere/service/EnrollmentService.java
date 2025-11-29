package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Enrollment;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.mapper.EnrollmentMapper;
import com.learnsphere.learnsphere.repository.EnrollmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EntityManager entityManager;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id:" + id));
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id:" + id));

        //Update the fields
        existingEnrollment.setEnrolledAt(enrollment.getEnrolledAt());
        existingEnrollment.setProgress(enrollment.getProgress());
        existingEnrollment.setCompletionStatus(enrollment.getCompletionStatus());
        enrollment.setStudent(enrollment.getStudent());
        enrollment.setUpdatedAt(enrollment.getUpdatedAt());

        return enrollmentRepository.save(existingEnrollment);

    }

    public Page<Enrollment> search(String courseTitle, String studentName, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Enrollment> query = cb.createQuery(Enrollment.class);
        Root<Enrollment> root = query.from(Enrollment.class);

        List<Predicate> predicates = new ArrayList<>();

        // Join course
        if (courseTitle != null && !courseTitle.isEmpty()) {
            Join<Enrollment, Course> courseJoin = root.join("course", JoinType.INNER);
            predicates.add(cb.like(cb.lower(courseJoin.get("name")), "%" + courseTitle.toLowerCase() + "%"));
        }

        // Join student
        if (studentName != null && !studentName.isEmpty()) {
            Join<Enrollment, Student> studentJoin = root.join("student", JoinType.INNER);
            predicates.add(cb.like(cb.lower(studentJoin.get("firstname")), "%" + studentName.toLowerCase() + "%"));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Enrollment> typedQuery = entityManager.createQuery(query);

        // Pagination
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<Enrollment> enrollments = typedQuery.getResultList();

        // Count Query
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Enrollment> countRoot = countQuery.from(Enrollment.class);
        countQuery.select(cb.count(countRoot))
                .where(predicates.toArray(new Predicate[0]));

        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(enrollments, pageable, total);
    }
}
