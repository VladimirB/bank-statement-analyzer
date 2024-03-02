package my.pet.app.bank_statement_analyzer.model;

import java.time.LocalDate;

public record BankTransaction(LocalDate date, Double amount, String category) {
}