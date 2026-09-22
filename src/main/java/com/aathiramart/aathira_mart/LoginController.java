package com.aathiramart.aathira_mart;

import com.aathiramart.aathira_mart.entity.User;
import com.aathiramart.aathira_mart.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String userId,
            @RequestParam String password) {

        User user = userRepository.findByUserId(userId).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            return "dashboard";
        }

        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String userId,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            return "register";
        }

        if (userRepository.findByUserId(userId).isPresent()) {
            return "register";
        }

        User user = new User(name, userId, email, password);

        userRepository.save(user);

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    @GetMapping("/sales")
    public String salesPage() {
        return "sales";
    }

    @GetMapping("/customers")
    public String customersPage() {
        return "customers";
    }

    @GetMapping("/inventory")
    public String inventoryPage() {
        return "inventory";
    }
}