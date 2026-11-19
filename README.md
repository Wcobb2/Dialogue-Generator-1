# Dialogue-Generator-1

## Playful competition phrases

`DialogueGenerator` produces one playful, competition-focused phrase at a
time:

```java
DialogueGenerator generator = new DialogueGenerator(42, DialogueGenerator.Style.CONFIDENT);
System.out.println(generator.nextPhrase());
```

Styles are `CONFIDENT`, `SILLY`, and `DRAMATIC`. The seed makes the sequence
repeatable; use `new DialogueGenerator(DialogueGenerator.Style.CONFIDENT)` for
an unseeded sequence. A generator avoids repeating the previous phrase.

The phrase lists are in `DialogueGenerator.java`; add phrases to the
appropriate style to expand the selection.
To run the example, use `javac DialogueGenerator.java Test2.java` followed by
`java Test2`.

## Simple sentences

The existing `RandomSentence.DialogueGenerator` methods remain available for
the original "What a [adjective] [noun]!" format. They accept lists for both
words, or a fixed value for either word:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

List<String> nouns = Files.readAllLines(Path.of("nouns.csv"));
List<String> adjectives = Files.readAllLines(Path.of("adjectives.csv"));
String sentence = RandomSentence.DialogueGenerator(nouns, adjectives);
String fixedNoun = RandomSentence.DialogueGenerator("otter", adjectives);
```

The CSV files contain one word per line. `Files.readAllLines` throws
`IOException` if a file cannot be read.

Compile and run the standalone tests:

```sh
javac RandomSentence.java DialogueGenerator.java TestRandomSentence.java TestDialogueGenerator.java
java TestRandomSentence
java TestDialogueGenerator
```
