# 05. Find First Non-Repeating Character

## Problem statement
Return the first character whose frequency is one; return nullable result if none exists. Define case/Unicode policy.

## Input/output examples
"swiss" -> w; "aabb" -> null; "" -> null

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Preserve original sequence when locating first unique character. Empty/all-repeating inputs are valid cases.

## Edge cases to test
- [ ] Unique at start/middle/end
- [ ]  all repeats
- [ ]  empty
- [ ]  case differences

## Kotlin concepts to practice
- Frequency map, ordered scan, nullable Char
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Can you do two passes?
- How would streaming input change the design?
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
