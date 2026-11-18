import random
from collections.abc import Sequence


class RandomSentence:
    @staticmethod
    def DialogueGenerator(
        noun: str | Sequence[str], adjective: str | Sequence[str]
    ) -> str:
        selected_noun = noun if isinstance(noun, str) else random.choice(noun)
        selected_adjective = (
            adjective if isinstance(adjective, str) else random.choice(adjective)
        )
        return f"What a {selected_adjective} {selected_noun}!"
