# Dialogue-Generator-1

`nouns.csv` and `adjectives.csv` each contain 200 words. `RandomSentence.DialogueGenerator`
accepts a noun and adjective, or a sequence of choices for either, and returns a sentence:

```python
from random_sentence import RandomSentence

sentence = RandomSentence.DialogueGenerator(["otter", "fox"], ["curious", "clever"])
```
