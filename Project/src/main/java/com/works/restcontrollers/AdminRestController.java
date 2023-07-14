package com.works.restcontrollers;

import com.works.entities.Admin;
import com.works.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {

    final AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Admin admin) {
        return adminService.register(admin);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

}
