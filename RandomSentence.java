import java.util.List;
import java.util.random.RandomGenerator;

public class RandomSentence {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static String DialogueGenerator(String noun, String adjective) {
        return format(noun, adjective);
    }

    public static String DialogueGenerator(List<String> nouns, List<String> adjectives) {
        return format(select(nouns), select(adjectives));
    }

    public static String DialogueGenerator(String noun, List<String> adjectives) {
        return format(noun, select(adjectives));
    }

    public static String DialogueGenerator(List<String> nouns, String adjective) {
        return format(select(nouns), adjective);
    }

    private static String select(List<String> values) {
        return values.get(RANDOM.nextInt(values.size()));
    }

    private static String format(String noun, String adjective) {
        return "What a " + adjective + " " + noun + "!";
    }
}
