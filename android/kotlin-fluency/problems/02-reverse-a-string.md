# 02. Reverse a String

## Problem statement
Reverse the input string. Clarify whether reversing Kotlin Char units or user-perceived Unicode characters is expected.

## Input/output examples
"hello" -> "olleh"; "Kotlin" -> "niltoK"; "" -> ""

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Empty and single-character strings work. Consider spaces, punctuation, Unicode surrogate pairs and grapheme clusters.

## Edge cases to test
- [ ] Empty
- [ ]  one char
- [ ]  whitespace
- [ ]  punctuation
- [ ]  Unicode

## Kotlin concepts to practice
- String, Char, indexing, ranges, StringBuilder, Unicode semantics
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Can you reverse in-place for a CharArray?
- What does String indexing represent in Kotlin?
- Discuss Unicode-safe reversal.
- Explain correctness with an invariant or proof sketch.
- What trade-offs would change under different constraints?

## Time and space complexity
- **Time:** `TODO` — derive and justify for your implementation.
- **Auxiliary space:** `TODO` — distinguish auxiliary storage from required output storage.
- **Alternative approach:** `TODO` — discuss its trade-offs and complexity.

## Personal completion checklist
- [ ] Clarified input/output contract and assumptions.
- [ ] Worked examples and added edge-case tests.
- [ ] Identified and justified an algorithmic pattern.
- [ ] Implemented independently in Kotlin.
- [ ] Tested boundaries and adversarial inputs.
- [ ] Explained correctness and time/space complexity.
- [ ] Answered follow-ups without notes.
- [ ] Re-solved under interview timing.
