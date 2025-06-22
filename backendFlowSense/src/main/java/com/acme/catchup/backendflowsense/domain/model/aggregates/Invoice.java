package com.acme.catchup.backendflowsense.domain.model.aggregates;

import com.acme.catchup.backendflowsense.domain.model.valueobjects.InvoiceStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status;

    public Invoice() {
    }

    public Invoice(String invoiceNumber, Project project, LocalDate issueDate, LocalDate dueDate, BigDecimal amount) {
        this.invoiceNumber = invoiceNumber;
        this.project = project;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = InvoiceStatus.DRAFT;
    }
} 