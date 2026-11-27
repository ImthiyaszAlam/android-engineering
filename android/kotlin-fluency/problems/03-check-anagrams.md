# 03. Check Anagrams

## Problem statement
Determine whether two strings contain identical character frequencies. State case, whitespace and punctuation policy.

## Input/output examples
"listen", "silent" -> true; "hello", "world" -> false; "aab", "aba" -> true

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Can reject unequal normalized lengths. Frequency counts account for repeated characters. Clarify normalization and Unicode policy.

## Edge cases to test
- [ ] Same strings
- [ ]  unequal lengths
- [ ]  repeats
- [ ]  empty strings
- [ ]  case/space differences

## Kotlin concepts to practice
- Frequency maps, Map, IntArray, character processing
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Could sorting work?
- Compare complexity. How would you normalize case or spaces?
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
