# 01. Find Second Largest Element

## Problem statement
Given an integer array, find the second-largest distinct value. Return null or another agreed sentinel when fewer than two distinct values exist.

## Input/output examples
[5,1,4,2,3] -> 4; [7,7,7] -> null; [-10,-3,-8] -> -8

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Clarify empty input, duplicates, return type and distinctness. Values may be negative. Aim for one pass; sorting is an alternative.

## Edge cases to test
- [ ] Empty/single array
- [ ]  all equal
- [ ]  repeated maximum
- [ ]  negatives
- [ ]  second value at either end.

## Kotlin concepts to practice
- Arrays, iteration, nullable results, invariants
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- What if max is repeated?
- Can you solve in one pass?
- Why not sort?
- Explain correctness and complexity.
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
