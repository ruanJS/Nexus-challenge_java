package br.com.fiap.nexus.service;

import br.com.fiap.nexus.model.Course;
import br.com.fiap.nexus.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Listar todos os cursos
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Adicionar um novo curso
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    // Obter um curso pelo ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Atualizar um curso existente
    public void updateCourse(Long id, Course updatedCourse) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course existingCourse = courseOptional.get();
            existingCourse.setName(updatedCourse.getName());
            // Atualizar outros campos necessários
            courseRepository.save(existingCourse);
        }
    }

    // Deletar um curso pelo ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // (Opcional) Listar cursos do usuário logado
    public List<Course> getMyCourses() {
        // Implementação hipotética: Filtrar cursos baseados no usuário logado
        // Exemplo: courseRepository.findByUserId(loggedUserId);
        return courseRepository.findAll(); // Modifique esta linha conforme a lógica do seu projeto
    }
}
