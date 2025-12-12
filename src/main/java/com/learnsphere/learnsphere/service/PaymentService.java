package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Enrollment;
import com.learnsphere.learnsphere.entity.Payment;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.enums.EnrollmentCompletionStatus;
import com.learnsphere.learnsphere.enums.PaymentStatus;
import com.learnsphere.learnsphere.enums.PaymentType;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.CourseRepository;
import com.learnsphere.learnsphere.repository.EnrollmentRepository;
import com.learnsphere.learnsphere.repository.PaymentRepository;
import com.learnsphere.learnsphere.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MailService mailService;

    @Autowired
    private RefundService refundService;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with Id:" + id));
    }

    public Payment createPayment(Payment payment) {
        payment.setType(PaymentType.PAYMENT);
        Long studentId = payment.getStudent().getId();
        Student student = studentService.getStudentByID(studentId);

        Long courseId = payment.getCourse().getId();
        Course course = courseService.getCourseById(courseId);

        Enrollment enrollment = new Enrollment();
        enrollment.setCompletionStatus(EnrollmentCompletionStatus.COMPLETED);
        enrollment.setStudent(payment.getStudent());
        enrollment.setCourse(payment.getCourse());
        enrollment.setEnrolledAt(LocalDateTime.now());
        enrollmentService.createEnrollment(enrollment);
        mailService.sendEmail(payment.getStudent().getEmail(),
                "LearnSphere",
                "You are enrolled to course:" + enrollment.getCourse().getTitle());
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with Id:" + id));

        existingPayment.setStatus(payment.getStatus());
        existingPayment.setUpdateAt(payment.getUpdateAt());

        return paymentRepository.save(existingPayment);
    }
}
