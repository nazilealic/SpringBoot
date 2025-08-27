package com.example.Spring_Security_Example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin")
    public String admin(Authentication authentication) {
        return "Merhaba " + authentication.getName() + "! Admin sayfasına hoş geldiniz.";
    }

    @GetMapping("/index")
    public String index() {
        return "Ana sayfa - Herkes erişebilir";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {
        return "Merhaba " + authentication.getName() + "! Dashboard'a hoş geldiniz.";
    }
}
