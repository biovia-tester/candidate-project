# candidate-project

Welcome to the BIOVIA Interview Candidate challenge project.  The purpose of this project is to allow interview
candidates to show off their technical skills in a real-world example.

## Assignment

In this scenario, an automation engineer (you)
has been asked by the developers and QA on the team to automate a certain piece of functionality in the 3DExperience platform.
A QA member of found a bug with scrolling in the User Community section of the platform; the posts in the community forum
weren't loading properly as the user was scrolling down the page.  You have been asked to create a new automated test which
does the following:

1. Opens the 3DExperience Platform in a browser and signs into the User Communities section of the application.
2. Wait for the first couple of posts to load.
3. Scroll the browser downward until at least 20 posts have loaded in the forum.
4. Verify that the title of each post contains text (is not empty).
5. Write the titles of all the posts that are loaded to a text file called "titles.txt"

The existing automation framework (Gradle/Java/Selenium) has been setup already, including Page Objects for the Login and
Community pages, including an initial test which is able to login to the Communities section of the platform.  Your task is
to extend the test to automate the rest of the steps (3-5).  Good luck!

## Setup notes

This project is based off of the Gradle build tool and expects that Java JDK 17+ is installed on the system.  It is also
recommended that you install IntelliJ Community Edition (free) to work on the assignment, as it provides built in support
for developing Java/Gradle/JUnit tests.  You will need to update the variables in the gradle.properties file with values
provided to you.

To build the project, run the command from the command line:
```bash
./gradlew testClasses
```
And to run the test:
```bash
./gradlew test
```

Once you have come up with a solution that you're happy with, please run the command:
```bash
git diff > candidate-project.patch
```
And send the zipped file ```candidate-project.patch``` to the e-mail address provided to you.