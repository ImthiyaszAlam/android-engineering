# 07. Move All Zeros to End

## Problem statement
Move every zero to the end, preserving the relative order of nonzero elements. Clarify if mutation is required.

## Input/output examples
[0,1,0,3,12] -> [1,3,12,0,0]; [0,0] unchanged; [1,2,3] unchanged

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Stable ordering of nonzeros; all-zero/no-zero arrays; in-place requirement and minimizing writes; empty input.

## Edge cases to test
- [ ] All zeros
- [ ]  no zeros
- [ ]  zeros in every position
- [ ]  empty
- [ ]  order preservation

## Kotlin concepts to practice
- Mutable arrays, two pointers, in-place updates, stability
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Can you do it in-place with O(1) extra space?
- Minimize writes?
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
