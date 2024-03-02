package my.pet.app.bank_statement_analyzer.parser;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BankStatementCSVParserTest {

    private final BankStatementParser parser = new BankStatementCSVParser();

    @Test
    public void shouldParseLineCorrectly() {
        final String line = "30-01-2017,200,Salary";

        final BankTransaction actual = parser.parseLine(line);
        final BankTransaction expected = new BankTransaction(
                LocalDate.of(2017, 1, 30),
                200.0,
                "Salary"
        );

        Assertions.assertEquals(expected, actual);
    }
}