package my.pet.app.bank_statement_analyzer.parser;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<BankTransaction> parseLines(final List<String> lines) {
        final List<BankTransaction> transactions = new ArrayList<>();
        for (final String line : lines) {
            BankTransaction transaction = parseLine(line);
            transactions.add(transaction);
        }
        return transactions;
    }

    private BankTransaction parseLine(final String line) {
        String[] columns = line.split(",");

        LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        double amount = Double.parseDouble(columns[1]);
        String category = columns[2];

        return new BankTransaction(date, amount, category);
    }
}
