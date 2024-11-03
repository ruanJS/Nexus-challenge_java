package br.com.fiap.nexus.service;

import br.com.fiap.nexus.model.Course;
import br.com.fiap.nexus.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll(); // Obtém todos os cursos do repositório
    }

    public void addCourse(Course course) {
        courseRepository.save(course); // Salva um novo curso no repositório
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null); // Obtém um curso pelo ID
    }

    public void updateCourse(Long id, Course course) {
        // A lógica aqui deve verificar se o curso existe e atualizá-lo
        if (courseRepository.existsById(id)) {
            course.setId(id); // Define o ID do curso a ser atualizado
            courseRepository.save(course); // Salva o curso atualizado
        }
    }

    public List<Course> getMyCourses() {
        // Adicione a lógica para retornar os cursos do usuário logado
        return List.of(); // Placeholder
    }
}
