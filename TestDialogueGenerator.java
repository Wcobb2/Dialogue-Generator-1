import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestDialogueGenerator {
    public static void main(String[] args) {
        testVarietyAndStyle();
        testSeed();
        testNullStyle();
    }

    private static void testVarietyAndStyle() {
        Map<DialogueGenerator.Style, Set<String>> phrasesByStyle =
                new EnumMap<>(DialogueGenerator.Style.class);
        for (DialogueGenerator.Style style : DialogueGenerator.Style.values()) {
            DialogueGenerator generator = new DialogueGenerator(42, style);
            Set<String> seen = new HashSet<>();
            String previous = null;
            for (int i = 0; i < 500; i++) {
                String phrase = generator.nextPhrase();
                check(!phrase.isBlank(), "phrases should not be blank");
                check(!phrase.contains("\n"), "each result should be a single line");
                check(!phrase.equals(previous), "consecutive phrases should differ");
                seen.add(phrase);
                previous = phrase;
            }
            check(seen.size() >= 5, "each style should offer several phrases");
            phrasesByStyle.put(style, seen);
        }
        for (DialogueGenerator.Style first : DialogueGenerator.Style.values()) {
            for (DialogueGenerator.Style second : DialogueGenerator.Style.values()) {
                if (first != second) {
                    check(phrasesByStyle.get(first).stream()
                                    .noneMatch(phrasesByStyle.get(second)::contains),
                            "styles should select from distinct phrase sets");
                }
            }
        }
    }

    private static void testSeed() {
        for (DialogueGenerator.Style style : DialogueGenerator.Style.values()) {
            DialogueGenerator first = new DialogueGenerator(123, style);
            DialogueGenerator second = new DialogueGenerator(123, style);
            for (int i = 0; i < 100; i++) {
                check(first.nextPhrase().equals(second.nextPhrase()),
                        "same seed and style should reproduce the sequence");
            }
        }
    }

    private static void testNullStyle() {
        try {
            new DialogueGenerator(1, null);
            throw new AssertionError("null style should be rejected");
        } catch (NullPointerException expected) {
            check("style".equals(expected.getMessage()), "error should identify the missing style");
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
