import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestRandomSentence {
    public static void main(String[] args) throws Exception {
        testWordListsContain200ValuesEach();
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

    private static void testFormatsSingleValues() {
        check(RandomSentence.DialogueGenerator("otter", "curious")
                        .equals("What a curious otter!"),
                "single values should be formatted");
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
