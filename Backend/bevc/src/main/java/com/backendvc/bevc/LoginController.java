package com.backendvc.bevc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @Autowired
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

   @PostMapping("/login")
    public String authenticate(String username, String password) {
        UserInfo user = userService.findUserByUsername(username);

        if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            // Authentication successful
            return "redirect:/home";  // Redirect to the home page or dashboard
        }

        return "redirect:/login?error=true";  // Return to login page with error
    }

    @GetMapping("/home")
    public String homePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Add user details to the model if needed
        return "index";  // Return home page
    }
}
