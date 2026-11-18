# Dialogue-Generator-1

Generate a random nickname or compliment from the command line. With JDK 11
or later, run these commands from the repository root:

```sh
java DialogueGenerator.java nickname "Sam Lee"
java DialogueGenerator.java compliment "Sam Lee" kind
```

Each command prints one message. For example, the first might print
`Captain Sam Lee`, and the second might print `Sam Lee, you're absolutely kind!`.
Run either command again for another random selection; messages can repeat.