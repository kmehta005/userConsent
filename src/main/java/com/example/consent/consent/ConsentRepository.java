package com.example.consent.consent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentRepository extends JpaRepository<UserConsent, String> {
}
