package my.pet.app.bank_statement_analyzer.processor;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

class BankStatementProcessorTest {

    private final List<BankTransaction> transactions = List.of(
            new BankTransaction(LocalDate.of(2017, 1, 15), 200.0, "Salary"),
            new BankTransaction(LocalDate.of(2017, 1, 20), -1000.0, "Rent"),
            new BankTransaction(LocalDate.of(2017, 2, 20), 2000.0, "Salary")
    );
    private final BankStatementProcessor processor = new BankStatementProcessor(transactions);

    @Test
    public void shouldCalculateTotalAmountCorrect() {
        var total = processor.getTotalAmount();

        Assertions.assertEquals(1200, total);
    }

    @Test
    public void shouldCalculateTotalByMonthCorrect() {
        var totalByMonth = processor.getTotalByMonth(Month.JANUARY);

        Assertions.assertEquals(-800, totalByMonth);
    }

    @Test
    public void shouldCalculateTotalByCategoryCorrect() {
        var totalByCategory = processor.getTotalByCategory("salary");

        Assertions.assertEquals(2200, totalByCategory);
    }

    @Test
    public void shouldCalculateMaxExpenseCorrect() {
        var actual = processor.getMaxExpenseAmount();
        var expected = new BankTransaction(LocalDate.of(2017, 1, 20), -1000.0, "Rent");

        Assertions.assertEquals(expected, actual);
    }
}