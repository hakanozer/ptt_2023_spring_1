package com.works.services;

import com.works.entities.Admin;
import com.works.repositories.AdminRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    final AdminRepository adminRepository;
    final TinkEncDec tinkEncDec;

    public ResponseEntity register( Admin admin ) {
        try {
            admin.setPassword(tinkEncDec.encrypt( admin.getPassword() ) );
            adminRepository.save(admin);
            return Rest.success(admin);
        }catch (Exception ex) {
            return Rest.fail(admin, HttpStatus.BAD_REQUEST);
        }
    }

}
