package my.pet.app.bank_statement_analyzer.processor;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;
import my.pet.app.bank_statement_analyzer.model.Summary;

import java.time.Month;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Производит расчет различной информации по банковским транзакциям
 */
public class BankStatementProcessor {

    private final List<BankTransaction> transactions;

    public BankStatementProcessor(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    public Summary getTotalAmount() {
        var amount = transactions.stream()
                .mapToDouble(BankTransaction::amount)
                .sum();
        return new Summary(amount);
    }

    public Summary getTotalByMonth(final Month month) {
        var amount = transactions.stream()
                .filter(it -> it.date().getMonth() == month)
                .mapToDouble(BankTransaction::amount)
                .sum();
        return new Summary(amount);
    }

    public Summary getTotalByCategory(final String category) {
        var amount = transactions.stream()
                .filter(it -> it.category().equalsIgnoreCase(category))
                .mapToDouble(BankTransaction::amount)
                .sum();
        return new Summary(amount);
    }

    public BankTransaction getMaxExpenseAmount() {
        BankTransaction result = null;
        for (final BankTransaction transaction : transactions) {
            if (result == null) {
                result = transaction;
            }

            if (result.amount() > transaction.amount()) {
                result = transaction;
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactions(final Predicate<BankTransaction> predicate) {
        return transactions.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}