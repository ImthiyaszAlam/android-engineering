# 06. Two Sum

## Problem statement
Given integer array and target, return indices of two distinct elements whose values sum to target. Agree on no-solution behavior and whether one pair is enough.

## Input/output examples
[2,7,11,15], target=9 -> [0,1]; [3,3], target=6 -> [0,1]; [1,2,3], target=7 -> no pair

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Do not reuse an index. Duplicates, negatives and zero allowed. Consider overflow if constraints require. Distinguish one pair from all pairs.

## Edge cases to test
- [ ] Pair at ends
- [ ]  duplicate values
- [ ]  negative values
- [ ]  no solution
- [ ]  zero

## Kotlin concepts to practice
- HashMap, complement lookup, indices, pair handling
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- What if all pairs are needed?
- How prevent reusing current index?
- Compare brute-force and map approach.
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
