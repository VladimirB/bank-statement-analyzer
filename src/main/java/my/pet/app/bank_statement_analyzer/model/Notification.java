package my.pet.app.bank_statement_analyzer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Доменный объект для инкапсуляции в себе всех произошедших ошибок валидации.
 * Благодаря ему можно производить логику валидации ввода на домене и отдавать
 * объект с ошибками на слой представления.
 */
public class Notification {

    private final List<String> errors = new ArrayList<>();

    public void addError(final String error) {
        errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "errors=" + Arrays.toString(errors.toArray()) +
                '}';
    }
}
