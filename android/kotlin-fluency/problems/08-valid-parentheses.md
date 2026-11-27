# 08. Valid Parentheses

## Problem statement
Check that brackets close in the correct type and order. Clarify handling of non-bracket characters.

## Input/output examples
"()[]{}" -> true; "([)]" -> false; "(" -> false

Examples show expected behavior; confirm ambiguous rules with the interviewer.

## Requirements and constraints
Closing without opener invalid; wrong nesting invalid; empty is valid; leftovers invalid. Decide reject/ignore other chars.

## Edge cases to test
- [ ] Empty
- [ ]  nested
- [ ]  mismatched
- [ ]  extra closing
- [ ]  missing closing
- [ ]  other chars

## Kotlin concepts to practice
- Stack/ArrayDeque, when, early return
- Clarifying contracts, selecting data structures, and readable Kotlin.
- Avoid unnecessary intermediate collections; reason about actual complexity.

## Follow-up interview questions
- Why is a counter insufficient for mixed types?
- How extend to new bracket types?
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
