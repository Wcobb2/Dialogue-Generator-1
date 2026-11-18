# Dialogue-Generator-1

`nouns.csv` and `adjectives.csv` each contain 200 words. The Java
`RandomSentence.DialogueGenerator` accepts paths to the noun and adjective CSV files
and returns a sentence. It also accepts lists of choices for either:

```java
import java.util.List;

String sentence = RandomSentence.DialogueGenerator("nouns.csv", "adjectives.csv");

String fromChoices = RandomSentence.DialogueGenerator(
    List.of("otter", "fox"), List.of("curious", "clever"));
```

The file-based overload throws `IOException` if either CSV file cannot be read.

```java
import java.io.IOException;

try {
    String sentence = RandomSentence.DialogueGenerator("nouns.csv", "adjectives.csv");
} catch (IOException e) {
    // Handle a CSV file read failure.
}
```

Compile and run the standalone tests with `javac RandomSentence.java TestRandomSentence.java`
and `java TestRandomSentence`.
