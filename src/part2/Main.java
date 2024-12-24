package part2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        BankStatementParser parser = new BankStatementCSVParser();

        analyzer.analyze("data.csv", parser);
    }
}