package com.example.consent.consent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsentService {

    @Autowired(required = false)
    private ConsentRepository consentRepository;

    public boolean getConsent(String uuid) {
        System.out.println("***************  getConsent***************** "+uuid);
        System.out.println("***************  userConsent ***************** "+consentRepository.findById(uuid).isPresent());
        return Boolean.TRUE.equals(consentRepository.findById(uuid).map(UserConsent::isConsentGranted).orElse(null));

       // return userConsent != null && userConsent.isConsentGranted();
    }

    public void setConsent(String uuid, boolean consentGranted) {
        System.out.println("##############  setConsent***************** ");

        System.out.println("##############  setConsent***************** "+uuid);
        UserConsent userConsent = new UserConsent();
        userConsent.setUuid(uuid);
        userConsent.setConsentGranted(consentGranted);
        consentRepository.save(userConsent);
    }
}
