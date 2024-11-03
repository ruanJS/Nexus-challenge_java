package br.com.fiap.nexus.controller;

import br.com.fiap.nexus.model.Email;
import br.com.fiap.nexus.model.User;
import br.com.fiap.nexus.repository.UserRepository;
import br.com.fiap.nexus.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService; // Injeção do EmailService

    @Autowired
    private AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        User user = new User();
        model.addAttribute("users", user);
        return "form";  // Verifique se este template está correto
    }

    @GetMapping("/auth/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("usuario", new User());
        return "home/signup";  // Atualizado para o caminho correto
    }

    @PostMapping("/auth/signup")
    public String registerUser(User users) {
        // Verifica se o usuário já existe
        if (userRepository.findByUsername(users.getUsername()).isPresent()) {
            return "redirect:/req/signup?error=usuarioExistente";
        }

        // Criptografa a senha antes de salvar
        if (users.getPassword() != null && !users.getPassword().isEmpty()) {
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            userRepository.save(users);

            // Cria e envia o email de boas-vindas
            Email emailModel = new Email();
            emailModel.setOwnerRef(users.getUsername());
            emailModel.setEmailFrom("devguedess@gmail.com"); // Altere para seu email
            emailModel.setEmailTo(users.getEmail()); // Adicione o campo de email na classe Usuario
            emailModel.setSubject("Bem-vindo!");
            emailModel.setText("Obrigado por se registrar em nosso site!");
            emailService.sendEmail(emailModel); // Envia o email
        } else {
            return "redirect:/auth/signup?error=senhaObrigatoria";
        }

        return "redirect:/auth/login";
    }

    @PostMapping("/auth/login")
    public String loginUser(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/home"; // Redireciona para a página home após login
        } catch (Exception e) {
            return "redirect:/auth/login?error=loginInvalido"; // Redireciona em caso de erro
        }
    }

    @GetMapping("/auth/login")
    public String showLoginForm() {
        return "home/login";  // Atualizado para o caminho correto
    }

    @GetMapping("/home")
    public String mostrarHome(Model model) {
        return "home/home"; // Certifique-se de que o caminho para home.html está correto
    }
}
