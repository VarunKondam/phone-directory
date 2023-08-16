package com.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private Timestamp timestamp;
    private String status;
    private String error;
    private String trace;
    private String message;
    private String path;

    public ErrorResponse() {

    }
}
