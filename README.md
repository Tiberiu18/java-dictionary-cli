# Java Dictionary CLI

A small Java command line application for translating words and sentences between languages. The project demonstrates basic dictionary management features and works with JSON dictionaries located in the `input-dictionaries` folder.

## Features
- Add new words and definitions
- Remove words or definitions
- Retrieve word definitions
- Translate single words
- Translate entire sentences
- Translate sentences using synonyms
- Export dictionaries as JSON

## Getting Started
1. Ensure you have Java (11 or later) installed.
2. Clone this repository and compile all sources:
   ```bash
   javac -cp "path/to/libs/*" -d out $(find src -name "*.java")
   ```
   External libraries such as [Gson](https://github.com/google/gson) and Apache Commons are required for compilation.
3. Run the application:
   ```bash
   java -cp "out:path/to/libs/*" main.main
   ```
   The program loads dictionaries, initializes word lists and executes the test scenarios defined in `src/TestCases`.

## Project Structure
- `src/` – Java source code
- `input-dictionaries/` – sample JSON dictionaries used as input
- `exported-dictionaries/` – output directory for exported dictionaries
- `wordLists/` – language word lists used to build the database

## Contributing
Contributions are welcome. Please see [CONTRIBUTING.md](CONTRIBUTING.md) for a short guideline.

## License
This project is licensed under the [Apache 2.0 License](LICENSE).
