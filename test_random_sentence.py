import unittest
from pathlib import Path
from unittest.mock import patch

from random_sentence import RandomSentence


class RandomSentenceTests(unittest.TestCase):
    def test_word_lists_contain_200_values_each(self):
        for filename in ("nouns.csv", "adjectives.csv"):
            with self.subTest(filename=filename):
                values = (Path(__file__).with_name(filename)).read_text().splitlines()
                self.assertEqual(len(values), 200)

    def test_formats_single_values(self):
        self.assertEqual(
            RandomSentence.DialogueGenerator("otter", "curious"),
            "What a curious otter!",
        )

    @patch("random_sentence.random.choice", side_effect=lambda values: values[-1])
    def test_selects_values_from_lists(self, _choice):
        self.assertEqual(
            RandomSentence.DialogueGenerator(["otter", "fox"], ["curious", "clever"]),
            "What a clever fox!",
        )


if __name__ == "__main__":
    unittest.main()
