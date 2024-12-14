package com.mindmap.mindmap_backend;

public class CodeRequest {
    
    private String script;      // The script code submitted by the user
    private String language;    // The programming language selected by the user
    private String versionIndex;  // Optional: version of the language or JDoodle version

    // Constructor
    public CodeRequest(String script, String language, String versionIndex) {
        this.script = script;
        this.language = language;
        this.versionIndex = versionIndex;
    }

    // Getters and Setters
    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVersionIndex() {
        return versionIndex;
    }

    public void setVersionIndex(String versionIndex) {
        this.versionIndex = versionIndex;
    }
}
