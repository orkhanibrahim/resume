# resume

This repository now includes a simple domain model for building resumes. The model lives under `src/main/java/com/example/resume/model` and contains:

- **Resume** – personal details and a list of resume `Section`s.
- **Section** – represents a part of the resume with ordering and a list of `Entry` items.
- **Entry** – generic item for work or education history including title, description and start/end dates.
