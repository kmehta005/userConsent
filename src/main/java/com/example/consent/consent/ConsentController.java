package com.example.consent.consent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Allow all origins
public class ConsentController {

    @Autowired
    private ConsentService consentService;

    @PostMapping("/get-consent-status")
    public boolean getConsentStatus(@RequestBody String uuid) {
        return consentService.getConsent(uuid);
    }

    @PostMapping("/set-consent-status")
    public void setConsentStatus(@RequestBody ConsentRequest request) {
        consentService.setConsent(request.getUuid(), request.isConsentGranted());
    }

    public static class ConsentRequest {
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
}
