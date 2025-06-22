package com.acme.catchup.backendflowsense.domain.repositories;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);
} 