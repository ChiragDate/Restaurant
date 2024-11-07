package com.chirag.festaurant.restaurant.helper;

import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptionService {
    private final PasswordEncoder passwordEncoder;

    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean validatePassword(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
