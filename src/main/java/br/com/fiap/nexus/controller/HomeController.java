//package br.com.fiap.nexus.controller;
//
//import br.com.fiap.nexus.model.Course;
//import br.com.fiap.nexus.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class HomeController {
//
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping("/home")
//    public String showHomePage(Model model) {
//        List<Course> courses = courseService.getAllCourses();
//        model.addAttribute("courses", courses);
//        return "home"; // Home template name
//    }
//}
