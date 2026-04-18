package com.example.loans.audit;


import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AuditAwareServiceImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Loans_MS");
    }
}
