package my.pet.app.bank_statement_analyzer;

import my.pet.app.bank_statement_analyzer.analyzer.BankStatementAnalyzer;
import my.pet.app.bank_statement_analyzer.parser.BankStatementCSVParser;
import my.pet.app.bank_statement_analyzer.parser.BankStatementParser;

import java.io.IOException;

public class Main {

    private static final String STATEMENT_CSV = "statement.csv";

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parser = new BankStatementCSVParser();
        analyzer.analyze(STATEMENT_CSV, parser);
    }
}