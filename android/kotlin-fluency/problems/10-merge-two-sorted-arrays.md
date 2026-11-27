# 10. Merge Two Sorted Arrays

## Problem statement
Merge two ascending arrays into one ascending array. Clarify duplicate retention and whether inputs may mutate.

## Input/output examples
[1,3,5] + [2,4,6] -> [1,2,3,4,5,6]; []+[1,2] -> [1,2]; [1,2]+[2,3] -> [1,2,2,3]

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Either input empty; retain duplicates by default; exploit sorted order rather than sorting result; handle unequal sizes.

## Edge cases to test
- [ ] Both empty
- [ ]  one empty
- [ ]  duplicates
- [ ]  unequal lengths
- [ ]  negative numbers

## Kotlin concepts to practice
- Two pointers, output array, comparisons, boundaries
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Can merge in-place with spare capacity?
- How adapt for descending inputs?
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
