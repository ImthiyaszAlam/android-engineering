# Kotlin DSA Fluency

## Project objective
Practice foundational array, string, hash-based, stack, two-pointer and sliding-window patterns in Kotlin. This repo deliberately contains prompts and empty class shells—not algorithms or answers—so you implement the solutions independently.

## Target level
Android developers preparing for Kotlin coding interviews at product-based companies; emphasis on core language fluency and reasoning, not Android APIs.

## Repository structure
```
kotlin-dsa-fluency/
├── README.md
├── problems/   # prompts, examples, constraints, edge cases and follow-ups
└── solutions/  # blank Kotlin class shells
```

## Problem list and concepts
| # | Problem | Concepts to practice |
|---|---|---|
| 01 | [Find Second Largest Element](problems/01-second-largest-element.md) | Arrays, iteration, nullable results, invariants |
| 02 | [Reverse a String](problems/02-reverse-a-string.md) | String, Char, indexing, ranges, StringBuilder, Unicode semantics |
| 03 | [Check Anagrams](problems/03-check-anagrams.md) | Frequency maps, Map, IntArray, character processing |
| 04 | [Find Duplicate Elements](problems/04-find-duplicates.md) | HashSet, MutableSet, collection operations, uniqueness |
| 05 | [Find First Non-Repeating Character](problems/05-first-non-repeating-character.md) | Frequency map, ordered scan, nullable Char |
| 06 | [Two Sum](problems/06-two-sum.md) | HashMap, complement lookup, indices, pair handling |
| 07 | [Move All Zeros to End](problems/07-move-zeros-to-end.md) | Mutable arrays, two pointers, in-place updates, stability |
| 08 | [Valid Parentheses](problems/08-valid-parentheses.md) | Stack/ArrayDeque, when, early return |
| 09 | [Longest Substring Without Repeating Characters](problems/09-longest-substring-without-repeating-characters.md) | Sliding window, set/map, indices, invariant |
| 10 | [Merge Two Sorted Arrays](problems/10-merge-two-sorted-arrays.md) | Two pointers, output array, comparisons, boundaries |

## Kotlin syntax checklist
- [ ] `val` vs `var`; immutability and mutation intent
- [ ] `IntArray`, `CharArray`, arrays and generic collections
- [ ] Indexing, bounds, loops (`for`, `while`), ranges
- [ ] Functions, parameter/return types and expression bodies
- [ ] Nullable types, `?`, safe calls, explicit null handling
- [ ] `String`, `Char`, `StringBuilder`, conversions and Unicode caveats
- [ ] `Set`/`MutableSet`, `Map`/`MutableMap`, frequency counts
- [ ] `ArrayDeque` stack/deque usage, `when`, early return
- [ ] Two pointers, sliding-window invariants and hash lookups s
- [ ] Complexity: time, auxiliary space, and output space
- [ ] Avoid unnecessary allocations and repeated scans

## Recommended practice methodology
1. Restate the problem; clarify return contract, ordering, duplicates, mutation and constraints.
2. Trace examples manually and invent edge cases.
3. Explain brute force first, then identify a more efficient pattern.
4. Write pseudocode and an invariant before Kotlin.
5. Implement in the matching `.kt` shell without solution references.
6. Test boundaries, duplicates, empty inputs and adversarial cases.
7. Explain correctness, complexity and trade-offs aloud.
8. Re-solve from scratch later, timed, and answer follow-ups.

## Completion checklist
- [ ] Can restate all problem contracts and clarify ambiguity
- [ ] Can recognize the pattern and implement all 10 in Kotlin unaided
- [ ] Tests edge cases and explains correctness
- [ ] Gives accurate time/space complexity, including output-space distinction
- [ ] Can compare an alternative approach and its trade-offs
- [ ] Re-solves each problem under interview timing

## Suggested sequence
Session 1: 01–03. Session 2: 04–06. Session 3: 07–08. Session 4: 09–10. Session 5: timed re-solves and review. Keep this repository solution-free by design.
