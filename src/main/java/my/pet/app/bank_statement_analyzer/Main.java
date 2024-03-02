package my.pet.app.bank_statement_analyzer;

import my.pet.app.bank_statement_analyzer.analyzer.BankStatementAnalyzer;

import java.io.IOException;

public class Main {

    private static final String STATEMENT_CSV = "statement.csv";

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        analyzer.analyze(STATEMENT_CSV);
    }
}