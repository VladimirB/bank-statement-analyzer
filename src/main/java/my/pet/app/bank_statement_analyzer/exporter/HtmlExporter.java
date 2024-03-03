package my.pet.app.bank_statement_analyzer.exporter;

import my.pet.app.bank_statement_analyzer.model.SummaryStats;

public class HtmlExporter implements Exporter {
    @Override
    public String export(SummaryStats stats) {
        String result = "<!doctype html>";
        result += "<html lang=`en`'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + stats.sum() + "</li>";
        result += "<li><strong>The average is</strong>: " + stats.average() + "</li>";
        result += "<li><strong>The max is</strong>: " + stats.max() + "</li>";
        result += "<li><strong>The min is</strong>: " + stats.min() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
