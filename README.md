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

The phrase lists are templates in `DialogueGenerator.java`; each contains
`<noun>` and `<adjective>` placeholders. Add templates to the appropriate
style to expand the selection. Pass a selected template and the word lists to
`RandomSentence.DialogueGenerator` to fill those placeholders.
To run the example, use `javac DialogueGenerator.java Test2.java` followed by
`java Test2`.

## Simple sentences

`RandomSentence.DialogueGenerator` accepts noun and adjective lists and
replaces the `<noun>` and `<adjective>` placeholders in a phrase template. The
two-list overload without a template retains the original
"What a [adjective] [noun]!" format; that format also accepts a fixed value
for either word:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

List<String> nouns = Files.readAllLines(Path.of("nouns.csv"));
List<String> adjectives = Files.readAllLines(Path.of("adjectives.csv"));
String sentence = RandomSentence.DialogueGenerator(nouns, adjectives);
String fixedNoun = RandomSentence.DialogueGenerator("otter", adjectives);
String phrase = RandomSentence.DialogueGenerator(
        generator.nextPhrase(), nouns, adjectives);
```

The CSV files contain one word per line. `Files.readAllLines` throws
`IOException` if a file cannot be read.

Compile and run the standalone tests:

```sh
javac RandomSentence.java DialogueGenerator.java TestRandomSentence.java TestDialogueGenerator.java
java TestRandomSentence
java TestDialogueGenerator
```
