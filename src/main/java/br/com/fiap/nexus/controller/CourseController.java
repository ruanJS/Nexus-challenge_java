package br.com.fiap.nexus.controller;

import br.com.fiap.nexus.model.Course;
import br.com.fiap.nexus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Método para exibir a lista de cursos
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses(); // Obtém todos os cursos
        model.addAttribute("courses", courses);
        return "home/home"; // Retorna o nome da página HTML (home.html)
    }

    // Método para exibir a página de adicionar curso
    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course()); // Adiciona um novo curso ao modelo
        return "cursos/add-course"; // Retorna o nome da página HTML (add-course.html)
    }

    // Método para adicionar um novo curso
    @PostMapping
    public String addCourse(@ModelAttribute Course course) {
        courseService.addCourse(course); // Adiciona o curso usando o serviço
        return "redirect:/courses"; // Redireciona para a lista de cursos
    }

    // Método para exibir a página de editar curso
    @GetMapping("/{id}/edit")
    public String showEditCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id); // Obtém o curso pelo ID
        model.addAttribute("course", course);
        return "cursos/edit-course"; // Retorna o nome da página HTML (edit-course.html)
    }

    // Método para editar um curso
    @PutMapping("/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        courseService.updateCourse(id, course); // Atualiza o curso usando o serviço
        return "redirect:/courses"; // Redireciona para a lista de cursos
    }

    // (Opcional) Método para exibir meus cursos
    @GetMapping("/my")
    public String listMyCourses(Model model) {
        // Aqui você pode filtrar os cursos de acordo com o usuário logado
        List<Course> myCourses = courseService.getMyCourses(); // Método hipotético para obter cursos do usuário
        model.addAttribute("myCourses", myCourses);
        return "cursos/my-courses"; // Retorna o nome da página HTML (my-courses.html)
    }
}
