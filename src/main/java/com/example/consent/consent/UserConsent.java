package com.example.consent.consent;

import jakarta.persistence.*;

@Entity
public class UserConsent {

    @Id
    private String uuid;
    private boolean consentGranted;

    // Getters and Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isConsentGranted() {
        return consentGranted;
    }

    public void setConsentGranted(boolean consentGranted) {
        this.consentGranted = consentGranted;
    }
}
