**Selenium Automation Framework - OrangeHRM**
Overview:
    This project is a Test Automation Framework built using Selenium WebDriver, Java, and TestNG for the OrangeHRM application.
    It follows industry best practices like Page Object Model (POM), reusable utilities, and Extent Reports for reporting and supports scalable, maintainable automation.

Tech Stack:
    Java
    Selenium WebDriver
    TestNG
    Maven
    Log4j (Logging)
    Extent Reports
    Git

Framework Architecture
    Below is the high-level structure of the framework:
    SeleniumFramework
     ├── src
     │    ├── main/java
     │    │    ├── pages (Page Object classes)
     │    │    ├── factory (DriverManager)
     │    │    ├── utils (ExtentManager, ScreenshotUtils)
     │    │    ├── config (ConfigReader)
     │    │
     │    ├── test/java
     │    │    ├── base (BaseTest setup)
     │    │    ├── tests (Test classes)
     │    │    ├── dataproviders (Test data)
     │    │    ├── listeners (TestNG listeners)
     │
     ├── reports (Extent reports)
     ├── logs (Execution logs)
     ├── test-output (TestNG reports)
     ├── testng.xml (Test Execution)

Framework Features:
    Page Object Model (POM) design pattern
    Reusable utility methods
    Data-driven testing (TestNG DataProvider)    
    Extent Reports for detailed test reporting
    Log4j logging for debugging
    Screenshot capture on execution
    Cross-browser support (Chrome, Edge)
    Clean test structure and modular design
    Test execution using TestNG XML suite configuration

Test Scenarios Covered
    Login functionality(valid & invalid)
    Dashboard validation
    Employee Management:
        Add Employee
        Search Employee
    Logout functionality

Test Report (Extent Report):
    After execution, an Extent HTML report is generated.
    Path:
        /reports/extent-report.html
    Sample Report Screenshot:
    [Extent Report](images/extent-report.png)

How to Run the Project:
    Import the project into Eclipse
    File → Import → Existing Maven Project
    Right-click on testng.xml
    Select:
      Run As → TestNG Suite
      Tests will execute and results will be shown

Test Reports:
    Test execution reports are genrated using TestNG and Extent Reports

Author:
    Nanthini LJ
    Senior QA Engineer|Automation Enthusiast

Future Enhancements:
    Add CI/CD using Jenkins
    Parallel Execution
    Retry mechanism for failed tests
    API Testing using Rest Assured

