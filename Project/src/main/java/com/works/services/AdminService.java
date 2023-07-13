package com.works.services;

import com.works.entities.Admin;
import com.works.repositories.AdminRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    final AdminRepository adminRepository;
    final TinkEncDec tinkEncDec;
    final HttpServletRequest req;

    public ResponseEntity register( Admin admin ) {
        try {
            admin.setPassword(tinkEncDec.encrypt( admin.getPassword() ) );
            adminRepository.save(admin);
            return Rest.success(admin);
        }catch (Exception ex) {
            return Rest.fail(admin, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity login( Admin admin ) {
        Optional<Admin> optionalAdmin = adminRepository.findByUsernameEqualsIgnoreCase(admin.getUsername());
        if (optionalAdmin.isPresent()) {
            Admin adm = optionalAdmin.get();
            String dbPass = tinkEncDec.decrypt(adm.getPassword());
            if ( dbPass.equals(admin.getPassword()) ) {
                req.getSession().setAttribute("admin", adm);
                return Rest.success(adm);
            }
        }
        return Rest.fail("Username or Password Fail", HttpStatus.BAD_REQUEST);
    }

}
