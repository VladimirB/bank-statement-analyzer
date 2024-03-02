package my.pet.app.bank_statement_analyzer.parser;

import my.pet.app.bank_statement_analyzer.model.BankTransaction;

import java.util.List;

public interface BankStatementParser {

    List<BankTransaction> parseLines(final List<String> lines);

    BankTransaction parseLine(final String line);
}
