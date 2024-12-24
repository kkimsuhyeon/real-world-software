package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/resources/";

    private static void collectSummary(final BankStatementProcessor processor) {
        System.out.println(processor.calculateTotalAmount());
        System.out.println(processor.calculateTotalInMonth(Month.JANUARY));
        System.out.println(processor.calculateTotalForCategory("category"));
    }


    public void analyze(final String fileName, final BankStatementParser parser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }
}
