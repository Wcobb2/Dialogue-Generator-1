import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestRandomSentence {
    public static void main(String[] args) throws Exception {
        testWordListsContain200ValuesEach();
        testReadsCsvFiles();
        testPropagatesIoErrors();
        testFormatsSingleValues();
        testSelectsValuesFromLists();
        testAcceptsMixedValuesAndLists();
    }

    private static void testWordListsContain200ValuesEach() throws Exception {
        for (String filename : List.of("nouns.csv", "adjectives.csv")) {
            check(Files.readAllLines(Path.of(filename)).size() == 200,
                    filename + " should contain 200 values");
        }
    }

    private static void testReadsCsvFiles() throws Exception {
        Path nouns = Files.createTempFile("nouns", ".csv");
        Path adjectives = Files.createTempFile("adjectives", ".csv");
        try {
            Files.write(nouns, List.of("otter", "fox"));
            Files.write(adjectives, List.of("curious", "clever"));

            String sentence = RandomSentence.DialogueGenerator(
                    nouns.toString(), adjectives.toString());
            check(List.of("What a curious otter!", "What a curious fox!",
                            "What a clever otter!", "What a clever fox!")
                            .contains(sentence),
                    "CSV values should be used to form the sentence");
        } finally {
            Files.deleteIfExists(nouns);
            Files.deleteIfExists(adjectives);
        }
    }

    private static void testPropagatesIoErrors() throws Exception {
        Path adjectives = Files.createTempFile("adjectives", ".csv");
        try {
            Files.write(adjectives, List.of("curious"));
            try {
                RandomSentence.DialogueGenerator(
                        adjectives.resolveSibling("missing-nouns.csv").toString(),
                        adjectives.toString());
                throw new AssertionError("a missing CSV file should cause an IOException");
            } catch (IOException expected) {
                // The file-reading error should be visible to the caller.
            }
        } finally {
            Files.deleteIfExists(adjectives);
        }
    }

    private static void testFormatsSingleValues() {
        check(RandomSentence.DialogueGenerator(List.of("otter"), List.of("curious"))
                        .equals("What a curious otter!"),
                "single values in lists should be formatted");
    }

    private static void testSelectsValuesFromLists() {
        String sentence = RandomSentence.DialogueGenerator(
                List.of("otter", "fox"), List.of("curious", "clever"));
        check(List.of("What a curious otter!", "What a curious fox!",
                        "What a clever otter!", "What a clever fox!")
                        .contains(sentence),
                "selected values should come from the provided lists");
    }

    private static void testAcceptsMixedValuesAndLists() {
        check(List.of("What a curious otter!", "What a clever otter!")
                        .contains(RandomSentence.DialogueGenerator(
                                "otter", List.of("curious", "clever"))),
                "a fixed noun and adjective list should be accepted");
        check(List.of("What a curious otter!", "What a curious fox!")
                        .contains(RandomSentence.DialogueGenerator(
                                List.of("otter", "fox"), "curious")),
                "a noun list and fixed adjective should be accepted");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
