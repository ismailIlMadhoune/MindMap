package com.mindmap.mindmap_backend;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api")
public class JDoodleController {

    private static final String JDoodle_API_URL = "https://api.jdoodle.com/v1/execute";
    private static final String CLIENT_ID = "ad44c5a46f0cae10e0e5c069f3f95647"; 
    private static final String CLIENT_SECRET = "22a95ec5a7b1e0298843aa538f19e6b4f341ddccc210de92d15837004dd675f"; 

    @PostMapping("/execute")
    public ResponseEntity<String> executeCode(@RequestBody CodeRequest codeRequest) {
        // Log the incoming request for debugging
        System.out.println("Received Code Request: " + codeRequest.getScript() + " for language: " + codeRequest.getLanguage());

        // Construct the JSON payload using the user's code and language
        String payload = "{"
                + "\"clientId\": \"" + CLIENT_ID + "\","
                + "\"clientSecret\": \"" + CLIENT_SECRET + "\","
                + "\"script\": \"" + escapeJson(codeRequest.getScript()) + "\","
                + "\"language\": \"" + codeRequest.getLanguage() + "\","
                + "\"versionIndex\": \"" + (codeRequest.getVersionIndex() != null ? codeRequest.getVersionIndex() : "0") + "\""
                + "}";

        // Log the payload for debugging
        System.out.println("Sending Payload: " + payload);

        // Prepare the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Send the request using RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = restTemplate.exchange(JDoodle_API_URL, HttpMethod.POST, entity, String.class);

        // Return the response from JDoodle API
        return response;
    }

    // Helper method to escape special characters in the user's script
    private String escapeJson(String script) {
        return script.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }
}
