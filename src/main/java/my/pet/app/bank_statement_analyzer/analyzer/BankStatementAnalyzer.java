package my.pet.app.bank_statement_analyzer.analyzer;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;
import my.pet.app.bank_statement_analyzer.parser.BankStatementCSVParser;
import my.pet.app.bank_statement_analyzer.processor.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * Выполняет анализ банковской выписки и выводит информацию по ней
 */
public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final BankStatementCSVParser parser = new BankStatementCSVParser();
        final List<BankTransaction> transactions = parser.parseLines(lines);

        final BankStatementProcessor processor = new BankStatementProcessor(transactions);
        System.out.println("The total amount for all transactions: " + processor.getTotalAmount());
        System.out.println("The total amount for January: " + processor.getTotalByMonth(Month.JANUARY));
        System.out.println("The total amount for February: " + processor.getTotalByMonth(Month.FEBRUARY));
        System.out.println("The total amount for 'Salary': " + processor.getTotalByCategory("salary"));
    }
}
