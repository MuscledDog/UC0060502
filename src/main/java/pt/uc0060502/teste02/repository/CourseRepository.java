package pt.uc0060502.teste02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.uc0060502.teste02.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
