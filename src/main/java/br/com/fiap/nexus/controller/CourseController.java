package br.com.fiap.nexus.controller;

import br.com.fiap.nexus.model.Course;
import br.com.fiap.nexus.service.CourseService;
import br.com.fiap.nexus.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Display list of courses
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "cursos/listar";
    }

    // Display form to add a new course
    @GetMapping("/cadastrar")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("titulo", "Cadastrar Curso");
        return "cursos/cadastrar";
    }

    // Save new course
    @PostMapping("/cadastrar")
    public String saveCourse(@ModelAttribute("course") @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Cadastrar Curso");
            return "cursos/cadastrar";
        }
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    // Display edit course form using query parameter
    @GetMapping("/editar")
    public String showEditCourseForm(@RequestParam Long id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com ID " + id));
        model.addAttribute("course", course);
        model.addAttribute("titulo", "Editar Curso");
        return "cursos/editar";
    }

    // Update an existing course
    @PostMapping("/editar")
    public String updateCourse(@ModelAttribute @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar Curso");
            return "cursos/editar";
        }
        courseService.updateCourse(course.getId(), course);
        return "redirect:/courses";
    }

    // Display course deletion confirmation using query parameter
    @GetMapping("/deletar")
    public String confirmDeleteCourse(@RequestParam Long id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com ID " + id));
        model.addAttribute("course", course);
        return "cursos/deletar";
    }

    // Delete a course
    @PostMapping("/deletar")
    public String deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    @GetMapping("/my")
    public String listMyCourses(Model model) {
        List<Course> myCourses = courseService.getMyCourses();
        model.addAttribute("myCourses", myCourses);
        return "cursos/my-courses"; // Certifique-se que my-courses.html está correto
    }

    // Handle Resource Not Found exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/404";
    }
}
