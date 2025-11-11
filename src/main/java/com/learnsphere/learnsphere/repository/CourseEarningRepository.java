package com.learnsphere.learnsphere.repository;

import com.learnsphere.learnsphere.entity.CourseEarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEarningRepository extends JpaRepository<CourseEarning, Long> {
}
