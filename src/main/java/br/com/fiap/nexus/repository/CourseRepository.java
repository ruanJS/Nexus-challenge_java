package br.com.fiap.nexus.repository;

import br.com.fiap.nexus.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
