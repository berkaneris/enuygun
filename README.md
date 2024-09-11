Mustafa Sayar : Cucumber and Selenium  Framework 
================================

Author 
----------
Mustafa Sayar

Purpose
----------

The aim of developing the MustafaSayar test automation framework is to enhance the quality of the ENUYGUN Web Application by enabling reliable and efficient testing processes. The framework intends to reduce the time and cost of testing while simultaneously increasing the accuracy and thoroughness of test coverage. Ultimately, the project aims to improve the overall software quality and user experience, leading to increased customer satisfaction. Additionally, the framework promotes the use of industry-standard tools and practices for test automation to help organizations stay competitive in the rapidly evolving software development industry.


Test Executions
----------- 

Prerequisites: Maven and Java installation

In order to start the tests after receiving the project via email, follow these steps:

1. **Download the ZIP file** sent to you via email.
2. **Extract the ZIP file** to a location on your local computer.
3. Open the command prompt and navigate to the extracted project root directory.
4. Run the following command to install dependencies: `mvn install` (if needed).
5. To start the tests, run the following command: `mvn test`.

Ensure that you have Maven installed on your local machine and the Java Development Kit (JDK) configured correctly.


Overview
--------

The MustafaSayar test automation framework is designed to test the e-commerce website, ENUYGUN, which provides many aspects of service. The framework incorporates industry-standard tools and practices for test automation and employs the page object model and page factory design to enhance maintainability and reusability. The framework uses Selenium WebDriver for user interface testing automation . Moreover, the framework implements the behavior-driven development (BDD) approach, allowing expected software behaviors to be specified in a language understandable to customers. The framework generates detailed Cucumber HTML reports that provide insights into test results and enable easy tracking of defects. By using the MustafaSayar test automation framework, organizations can efficiently and effectively test the ENUYGUN e-commerce website, ensuring high-quality performance, user experience, and customer satisfaction.

Tools
-------

`Java` - My framework is written using Java language, 17 version.

`Maven` - My framework is a Maven project, which is a Java build application tool that I use to manage dependencies and run tests from the endpoint as Maven goals. This allows me to streamline the process of managing dependencies and running tests.

`Selenium WebDriver` - This is a tool and library used for browser automation that I have implemented in this project. It allows me to automate browser actions such as clicking buttons, filling out forms, and navigating pages to perform automated tests.

`Cucumber` - I used Cucumber to perform behavior-driven development (BDD) in my project. Gherkin allows me to specify the expected behaviors of the software in a logical language that anyone can understand. Cucumber runs automated acceptance tests that are written in a behavior-driven development (BDD) style, which streamlines the testing process and ensures that the software meets the expected requirements.

`Extent` - I've used Extent (an open-source reporting library used in Java-based automation frameworks) to generate detailed Cucumber HTML reports that are easy for non-technical team members to read and understand. These reports include detailed test steps and screenshots for any test failures that may occur, which helps to identify issues and troubleshoot them quickly. Additionally, with a small adjustment, the reports can also provide metrics on the percentage of passing, failing, skipped tests, etc. Be sure that your system language is English for test reports to be displayed.

`IDE` - I have used IntelliJ as my integrated development environment (IDE).


Design
-------

`Page Object model` - In my framework, we adopted the Page Object Model design for our automated tests. This model involves creating a separate class for each page in our web application, which is stored in the "pages" folder. By using the Page Object Model, I was able to separate my test code from the code that defines the elements and actions of each page. This allows us to create a more organized and scalable testing framework that can easily adapt to changes in our web application. In addition, the page object model helps in writing tests that are easier to maintain and reuse, which improves the overall quality of our test suite.

`PageFactory Design Pattern` - It is a design pattern in Selenium WebDriver that enables me to create object repositories for my web application's pages. Each page is represented by a Java class with elements and actions mapped using annotations. This design pattern makes it easier to access page objects and maintain my tests, and is highly optimized for use in Selenium WebDriver.

`Singleton Driver` - The Singleton Driver design pattern in Selenium uses a single instance of the WebDriver object that is shared between different classes in my test framework. This pattern helps improve test efficiency by avoiding the overhead of creating multiple WebDriver instances, and also makes it easier to manage the lifecycle of the WebDriver object. By using a Singleton Driver pattern, I can ensure that your tests are efficient, reliable, and easy to maintain.

`DriverManager` - By using DriverManager in the framework, I was able to save time on browser driver management and improve the reliability of my tests by ensuring that the correct driver version was used.

`Hooks` - In my framework, I've implemented Hook Classes which contain blocks of code that can be executed at various points in the Cucumber execution cycle. These blocks of code are commonly used for setting up the environment before each scenario runs, and tearing it down after each scenario completes. Hooks provide a convenient and efficient way to automate repetitive setup and teardown tasks, such as initializing test data, starting and stopping a web server, or cleaning up after a test run.

`Centralized Configuration Data` - I have implemented a Configuration file that stores important test data, such as usernames, passwords,endpoints and other configurations. The Configuration file provides a centralized location for storing and managing this data, making it easy to update and maintain. Storing test data in a Configuration file reduces the amount of hard-coded data in my test code, which improves readability and maintainability.

`Utilities` - I've created a utils package in my framework, which contains reusable classes like BrowserUtils. These classes provide common functionality that can be used across different parts of the framework, such as interacting with the browser . Using these Utilities helps reduce code duplication and improve the efficiency and maintainability of my tests.


Benefits
-------

1) Easy to maintain:

My framework uses the page object model, which simplifies maintenance. For instance, if I need to update any locator, I only need to make one code change. I also strive to make my tests independent from each other, so if I update one test, it will not impact others, and if one test fails, it will not affect the others.

2) Easy to extend:

I've implemented the page object model and utilities that can be reused across tests. Instead of repeating same lines of code in multiple tests, I store them as static methods in the BrowserUtils page, making them publicly accessible.

3) Multi browser testing:

My framework can run the same tests on different browsers with minimal code changes.

4) Types of tests:

My framework can test the UI of the application.

5) Packaging:

I have created different packages for different types of classes and logic. Each page package only contains classes with similar functionality.

6) Naming conventions:

I pay close attention to coding standards, especially naming conventions. Classes, methods, and variables are named according to their functionality and follow a standard.



