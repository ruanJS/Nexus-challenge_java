package br.com.fiap.nexus.controller;

import br.com.fiap.nexus.model.Course;
import br.com.fiap.nexus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Exibir lista de cursos
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "cursos/listar"; // Nome do arquivo HTML para listar os cursos
    }

    // Exibir página de adicionar curso
    @GetMapping("/cadastrar")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("titulo", "Cadastrar Curso");
        return "cursos/cadastrar"; // Nome do template HTML do formulário de cadastro
    }

    // Salvar novo curso
    @PostMapping("/cadastrar")
    public String saveCourse(@ModelAttribute("course") @Valid Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "cursos/cadastrar"; // Retorna à página de cadastro se houver erros
        }
        courseService.addCourse(course);
        return "redirect:/courses"; // Redireciona para a lista de cursos após salvar
    }

    // Exibir página de edição de curso
    @GetMapping("/{id}/edit")
    public String showEditCourseForm(@PathVariable Long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "cursos/editar";
        } else {
            return "error/404"; // Página de erro caso o curso não seja encontrado
        }
    }

    // Editar curso existente
    @PostMapping("/{id}/edit")
    public String updateCourse(@PathVariable Long id, @ModelAttribute @Valid Course course, BindingResult result) {
        if (result.hasErrors()) {
            course.setId(id);
            return "cursos/editar";
        }
        courseService.updateCourse(id, course);
        return "redirect:/courses";
    }

    // Exibir meus cursos
    @GetMapping("/my")
    public String listMyCourses(Model model) {
        List<Course> myCourses = courseService.getMyCourses();
        model.addAttribute("myCourses", myCourses);
        return "cursos/my-courses";
    }

    // Exibir confirmação de exclusão do curso
    @GetMapping("/{id}/delete")
    public String confirmDeleteCourse(@PathVariable Long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "cursos/deletar";
        } else {
            return "error/404";
        }
    }

    // Excluir curso
    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
