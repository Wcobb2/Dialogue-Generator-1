# Dialogue-Generator-1

`nouns.csv` and `adjectives.csv` each contain 200 words. The Java
`RandomSentence.DialogueGenerator` accepts a noun and adjective, or lists of choices
for either, and returns a sentence:

```java
import java.util.List;

String sentence = RandomSentence.DialogueGenerator(
    List.of("otter", "fox"), List.of("curious", "clever"));
```

Compile and run the standalone tests with `javac RandomSentence.java TestRandomSentence.java`
and `java TestRandomSentence`.
