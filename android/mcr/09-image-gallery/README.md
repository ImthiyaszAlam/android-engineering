# Image Gallery

## Interview prompt

Display images in a responsive grid and open a preview with efficient loading.

## Expected behavior

- Clarify the required screens and user flow before coding.
- Implement the main happy path.
- Show loading, empty, success, and error states where relevant.
- Provide retry or recovery actions for failures.
- Keep UI responsive and state consistent.

## Suggested Android implementation

- **Core skills:** LazyVerticalGrid, Coil, MediaStore, caching.
- Compose UI renders state; it should not own networking or business rules.
- ViewModel exposes immutable UI state using StateFlow.
- Repository coordinates data sources when that boundary is useful.
- Use lifecycle-aware state collection and stable keys in lazy lists.
- Avoid adding architecture layers that do not solve a real requirement.

## Edge cases and trade-offs

Handle broken URLs, large images, low memory, rapid scrolling, permissions, and removed media. Load thumbnails at appropriate sizes.

## Testing checklist

- [ ] Main success flow
- [ ] Loading, empty, and error states
- [ ] Invalid or missing input/data
- [ ] Retry/cancellation behavior
- [ ] ViewModel or business-logic unit tests
- [ ] Important Compose UI interactions

## Interview walkthrough

1. Clarify functional requirements and constraints.
2. Sketch the UI and define the state model.
3. Explain the data flow: Compose → ViewModel → Repository → data source.
4. Implement the core flow first.
5. Add failure handling and edge cases.
6. Test core logic and explain alternatives/trade-offs.

## Completion checklist

- [ ] App builds and runs
- [ ] Main user flow works
- [ ] State is handled correctly across recomposition/configuration changes
- [ ] No blocking work on the main thread
- [ ] Edge cases are addressed
- [ ] Tests cover core logic
- [ ] README documents setup and implementation decisions
