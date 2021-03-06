# Todo MVC user application using Serenity and Cucumber

### Abstract

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

## The sample scenario
Both variations of the sample project uses the sample Cucumber scenario.

```Gherkin language

	@creating-reminder
	Feature: As a busy tester, I should be able to create reminders, so that I can plan my day and not 	forget key tasks

  	@single-reminder
  	Scenario: Creating single reminder task
     Given user is on create reminder landing page
     When user creates a reminder "Write TestCases"
     Then user should see "Write TestCases" added to the reminder list
     And user should see a total of 1 reminders added to the list

```

## Executing the tests
To run the  project, you can either;
 * run the `CucumberTestSuite` test runner class
 * run `mvn verify` from the command line.

Default browser for the tests is Chrome. It can be changed to other browser if required by passing below command line argument

```mvn command

$ mvn clean verify -Ddriver=firefox

```
Results will be recorded in the `target/site/serenity` directory.

## Generating the reports

The reports are available in target folder file://${RootDirectory}//target/site/serenity/index.html

Since the Serenity reports contain aggregate information about all of the tests, they are not generated after each individual test (as this would be extremenly inefficient). Rather, The Full Serenity reports are generated by the `serenity-maven-plugin`. This can be triggered by running `mvn serenity:aggregate` from the command line or from IDE.

They reports are also integrated into the Maven build process: the following code in the `pom.xml` file causes the reports to be generated automatically once all the tests have completed when you run `mvn verify`?

```
             <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.maven.version}</version>
                <configuration>
                    <tags>${tags}</tags>
                </configuration>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```

## External Configurations

This project uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as mentioned below:

```java
	webdriver {
    	driver = chrome
	}

```


### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:

```json
environments {
  default {
    webdriver.base.url = "https://todomvc.com/examples/vue/"
  }
  dev {
    webdriver.base.url = "https://todomvc.com/examples/vue/"
  }
  prod {
    webdriver.base.url = "https://todomvc.com/examples/vue/"
  }
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the dev environment, you could run:

```mvn command

$ mvn clean verify -Denvironment=dev

```
