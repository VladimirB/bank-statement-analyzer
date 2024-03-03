package my.pet.app.bank_statement_analyzer.exporter;

import my.pet.app.bank_statement_analyzer.model.SummaryStats;

public interface Exporter {

    String export(SummaryStats stats);
}
