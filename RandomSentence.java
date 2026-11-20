import java.util.List;
import java.util.random.RandomGenerator;

public class RandomSentence {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static String getRandomSentence(List<String> nouns, List<String> adjectives) {
        return format(DialogueGenerator.getRandomPhrase(), select(nouns), select(adjectives));
    
    }


    private static String select(List<String> values) {
        return values.get(RANDOM.nextInt(values.size()));
    }

    private static String format(String phrase, String noun, String adjective) {
        return phrase.replace("<noun>", noun).replace("<adjective>", adjective);
    }
}
