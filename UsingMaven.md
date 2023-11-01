.gitignore ignores target/ directory to avoid including outdated compiled code.

The file structure is important. All tests must be in src/test/java/group28 whereas all main code must be in src/main/java/group28. This is because dependencies marked as `<scope>test</scope>` in the `pom.xml` is only available to code in that specific test path. We don't want to include junit or our tester classes with our main build, it's only for testing purposes, so it makes sense to isolate them.

Run Maven commands in the directory containing the main `pom.xml` file (financial-support/)

Removing compiled files: `mvn clean`

Compiling: `mvn compile`

Running all tests: `mvn test`

Generating jar: `mvn package`. Note this runs all junit tests, and fails if any tests fail.

Currently the only way of running the project is `mvn javafx:run`, it uses App.java as the main class. I have not figured out how to change this yet.