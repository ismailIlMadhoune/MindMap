package com.mindmap.mindmap_backend;

public class CodeResponse {
    private String output;
    private String statusCode;

    // Constructor that takes two strings
    public CodeResponse(String output, String statusCode) {
        this.output = output;
        this.statusCode = statusCode;
    }

    // Getters and setters for output and statusCode (optional)
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
