package com.example.project.Exeption;

import lombok.Data;

@Data
public class ApiException {
    private final String message;
    private final int code;
}
