package vn.tuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login"; // Trỏ đúng tới file templates/auth/login.html
    }
}