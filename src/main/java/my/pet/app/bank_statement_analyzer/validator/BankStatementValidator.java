package my.pet.app.bank_statement_analyzer.validator;

import my.pet.app.bank_statement_analyzer.model.Notification;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BankStatementValidator implements Validator {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final int MAX_CATEGORY_LENGTH = 20;

    private final String date;
    private final String amount;
    private final String category;

    public BankStatementValidator(String date, String amount, String category) {
        this.date = Objects.requireNonNull(date);
        this.amount = Objects.requireNonNull(amount);
        this.category = Objects.requireNonNull(category);
    }

    @Override
    public Notification validate() {
        final Notification notification = new Notification();

        try {
            LocalDate date = LocalDate.parse(this.date, DATE_PATTERN);
            if (date.isAfter(LocalDate.now())) {
                notification.addError("Date can't be in a future");
            }
        } catch (DateTimeException e) {
            notification.addError(e.getMessage());
        }

        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            notification.addError("Amount in incorrect format");
        }

        if (category.length() > MAX_CATEGORY_LENGTH) {
            notification.addError("Category too long");
        }

        return notification;
    }
}
