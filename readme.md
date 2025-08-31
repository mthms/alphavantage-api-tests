# Automation Framework for AlphaVantage API Testing

This automation framework provides support for testing alphaVantage APIs.
It is built using Java and requires the IntelliJ IDE, Java 21 or higher.

## Prerequisites (Preparing your machine)

Before running the project, ensure that you have the following:

- IntelliJ IDE
- Java core is installed on your machine https://www.java.com/en/download/
- For Windows users: Install choco from here: https://chocolatey.org/install
- If you don't have git installed, install it using choco: https://community.chocolatey.org/packages/git
- Create a GitHub account and send your username to Automation lead then clone the project from GitHub
    - In order to be able to clone either from terminal/cmd/intelliJ you will need to do the below:
        - Open github website and login with your username and password
        - Go to this page https://github.com/settings/tokens/new
        - Name your access token with a unique name
        - Mark the below roles:
            - repo
            - Workflow
            - write:packages
            - gist
            - user
            - project
        - create a personal access token
        - Copy the token then use it while cloning through IntelliJ or terminal/CMD
            - While cloning from terminal CMD, you will be instructed to input the username and the password
            - In the password field, don't use the regular password but use the token that we just created
- Java 21 or higher installed on your machine. In intelliJ you can do the following after you open the project:
    - Go to File -> Project structure
    - In project menu:
        - SDK: Select Java 21 or higher and preferred to be oracle openJDK
        - Language Level: SDK default
    - In modules:
        - Language level: Select project/language default.

## Configuration (Preparing your project's configs)

- There is 1 config file. Please, follow the below guide to build them:
    - In the project's terminal on intelliJ, run the below commands:
        - `cp resources/environments/config.properties.example resources/environments/config_testing.properties`

## Running the Project

- Open the project in the IntelliJ IDE.
- Build the project and make sure the build process is completed and all dependencies are loaded
- Wait until the maven dependencies are loaded
- Running an API test:
    - Navigate to the file: src/test/java/api/SearchApiTests.java
    - Run any of the tests from the green play button ▶.
    - or by using the below commands to run tests highlighted in the testNG file
      - `mvn test -q -Pdefault-tests -Dmaven.test.failure.ignore=true -Denv=testing`

## Support

If you encounter any issues or have questions related to the framework or its usage, please reach out.