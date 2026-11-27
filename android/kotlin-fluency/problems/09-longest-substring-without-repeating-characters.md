# 09. Longest Substring Without Repeating Characters

## Problem statement
Return the length of the longest contiguous substring with no repeated characters (not subsequence).

## Input/output examples
"abcabcbb" -> 3; "bbbbb" -> 1; "pwwkew" -> 3; "" -> 0

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Empty is zero. Consider all-identical and repeats inside current window. Define character/Unicode normalization model.

## Edge cases to test
- [ ] Empty
- [ ]  all identical
- [ ]  no repeats
- [ ]  repeat in window
- [ ]  repeat before window
- [ ]  Unicode

## Kotlin concepts to practice
- Sliding window, set/map, indices, invariant
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Can you achieve O(n)?
- Why must left boundary not move backward?
- Explain window invariant.
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
