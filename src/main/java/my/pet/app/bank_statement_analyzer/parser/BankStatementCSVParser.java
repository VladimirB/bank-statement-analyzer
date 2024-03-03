package my.pet.app.bank_statement_analyzer.parser;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;
import my.pet.app.bank_statement_analyzer.model.Notification;
import my.pet.app.bank_statement_analyzer.validator.BankStatementValidator;
import my.pet.app.bank_statement_analyzer.validator.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<BankTransaction> parseLines(final List<String> lines) {
        final List<BankTransaction> transactions = new ArrayList<>();
        for (final String line : lines) {
            BankTransaction transaction = parseLine(line);
            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public BankTransaction parseLine(final String line) {
        String[] columns = line.split(",");

        final Validator validator = new BankStatementValidator(columns[0], columns[1], columns[2]);
        final Notification notification = validator.validate();

        if (!notification.hasErrors()) {
            LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            double amount = Double.parseDouble(columns[1]);
            String category = columns[2];
            return new BankTransaction(date, amount, category);
        } else {
            System.out.println(notification);
        }

        return null;
    }
}
