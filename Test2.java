import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.random.RandomGenerator;

public class Test2 {
    public static void main(String[] args) throws IOException {
        List<String> nouns = Files.readAllLines(Path.of("nouns.csv"));
        List<String> adjectives = Files.readAllLines(Path.of("adjectives.csv"));
        for(int i = 0;i < 15;i ++){
            System.out.println(RandomSentence.DialogueGenerator(nouns,adjectives));
        }
    }

}