package com.example.tomopibot.service;

import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    public boolean isDigit(String text) {
        boolean result = false;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}
