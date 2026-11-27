# 04. Find Duplicate Elements

## Problem statement
Return each value occurring more than once, only once in the result. Define output ordering (e.g. discovery order or unspecified).

## Input/output examples
[1,2,3,2,4,1] -> [2,1] (discovery order); [5,5,5] -> [5]; [1,2,3] -> []

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Empty input; report repeated value once; negatives allowed. Compare hash-set approach with sorting trade-offs.

## Edge cases to test
- [ ] No duplicates
- [ ]  one repeated many times
- [ ]  multiple duplicates
- [ ]  empty
- [ ]  negative values

## Kotlin concepts to practice
- HashSet, MutableSet, collection operations, uniqueness
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- How return sorted duplicates?
- What is hash-based expected complexity?
- Compare sorting memory and time.
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
