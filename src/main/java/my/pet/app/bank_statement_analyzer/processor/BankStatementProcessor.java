package my.pet.app.bank_statement_analyzer.processor;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;

import java.time.Month;
import java.util.List;

/**
 * Производит расчет различной информации по банковским транзакциям
 */
public class BankStatementProcessor {

    private final List<BankTransaction> transactions;

    public BankStatementProcessor(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    public double getTotalAmount() {
        double total = 0;
        for (final BankTransaction transaction : transactions) {
            total += transaction.amount();
        }
        return total;
    }

    public double getTotalByMonth(final Month month) {
        double total = 0;
        for (final BankTransaction transaction : transactions) {
            if (transaction.date().getMonth() == month) {
                total += transaction.amount();
            }
        }
        return total;
    }

    public double getTotalByCategory(final String category) {
        double total = 0;
        for (final BankTransaction transaction : transactions) {
            if (transaction.category().equalsIgnoreCase(category)) {
                total += transaction.amount();
            }
        }
        return total;
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
}
