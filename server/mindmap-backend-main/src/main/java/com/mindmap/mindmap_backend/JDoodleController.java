package com.mindmap.mindmap_backend;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class JDoodleController {
    private static final String JDoodle_API_URL = "https://api.jdoodle.com/v1/execute";
    private static final String CLIENT_ID = "ad44c5a46f0cae10e0e5c069f3f95647";
    private static final String CLIENT_SECRET = "22a95ec5a7b1e0298843aa538f19e6b4f341ddccc210de92d15837004dd675f";

    @PostMapping("/execute") // This handles POST requests at "/api/execute"
    public ResponseEntity<String> executeCode(@RequestBody CodeRequest codeRequest) {
        // Log incoming request for debugging
        System.out.println("Received Code Request: " + codeRequest.getScript() + " for language: " + codeRequest.getLanguage());

        // Construct payload to send to JDoodle API
        String payload = "{"
                + "\"clientId\": \"" + CLIENT_ID + "\","
                + "\"clientSecret\": \"" + CLIENT_SECRET + "\","
                + "\"script\": \"" + escapeJson(codeRequest.getScript()) + "\","
                + "\"language\": \"" + codeRequest.getLanguage() + "\","
                + "\"versionIndex\": \"" + (codeRequest.getVersionIndex() != null ? codeRequest.getVersionIndex() : "0") + "\""
                + "}";

        System.out.println("Sending Payload: " + payload);

        // Send the request using RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(JDoodle_API_URL, HttpMethod.POST, entity, String.class);
        return response;
    }

    private String escapeJson(String script) {
        return script.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }
}
