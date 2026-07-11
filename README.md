# 🚀 API Automation Framework | FakeRestAPI Authors

> A modular **API Automation Framework** built using **Java**, **Rest-Assured**, **TestNG**, **Maven**, **AssertJ**, and **Allure Reports** to automate testing of the **FakeRestAPI Authors** endpoints.

<p align="center">

![Java](https://img.shields.io/badge/Java-11+-blue?logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![RestAssured](https://img.shields.io/badge/RestAssured-API--Testing-yellowgreen)
![TestNG](https://img.shields.io/badge/TestNG-Framework-brightgreen)
![AssertJ](https://img.shields.io/badge/AssertJ-Assertions-orange)
![Allure](https://img.shields.io/badge/Allure-Reports-ff69b4)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-yellow)

</p>

---

# 🗂️ Overview

This repository contains a modular **API Automation Framework** developed for testing the **FakeRestAPI Authors** endpoints using **Java**, **Rest-Assured**, **TestNG**, and **Maven**.

The framework demonstrates industry-standard API automation practices, including **CRUD testing**, **reusable payload management**, **centralized assertions**, **JSON Schema validation**, **end-to-end workflow testing**, **logging**, and **Allure reporting**.

Designed with **clean architecture**, **reusability**, and **maintainability** in mind, this project serves as a practical reference for building scalable API automation frameworks.

---

# ✨ Key Features

- ✅ Complete CRUD API Automation
- ✅ Modular Framework Architecture
- ✅ Reusable Payload Management
- ✅ Centralized Assertion Utilities
- ✅ JSON Schema Validation
- ✅ End-to-End Workflow Testing
- ✅ TestNG Suite Execution
- ✅ Log4j2 Logging
- ✅ Rich Allure Reporting

---

# 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Java 11+ | Programming Language |
| Maven | Dependency & Build Management |
| Rest-Assured | API Automation |
| TestNG | Test Framework |
| AssertJ | Fluent Assertions |
| Log4j2 | Logging |
| Allure Reports | Test Reporting |
| IntelliJ IDEA | Development IDE |

---

# 🏗️ Project Structure

```text
API_Automation_Framework_FakeRestAPI_Authors/
│
├── .idea/                                                  # IntelliJ configuration
├── .mvn/                                                   # Maven wrapper files
├── allure-results/                                         # Allure execution results
├── logs/
│   └── test.log                                            # Test execution logs
│
├── pom.xml                                                 # Maven dependencies & build configuration
├── .gitignore
│
├── testng_*.xml                                            # TestNG suite files
│
├── src/
│   ├── main/
│   │   ├── java/com.avinashsinha/
│   │   │   ├── endpoints/
│   │   │   │   └── APIConstants.java                       # API endpoint constants
│   │   │   │
│   │   │   └── module/
│   │   │       └── PayloadManager.java                     # String-based payload manager
│   │   │
│   │   └── resources/
│   │       └── log4j2.xml                                  # Logging configuration
│   │
│   └── test/
│       ├── java/com.avinashsinha/
│       │   ├── asserts/
│       │   │   └── AssertActions.java                      # Assertion utilities
│       │   │
│       │   ├── base/
│       │   │   └── BaseTest.java                           # Base test configuration
│       │   │
│       │   └── tests/
│       │       ├── crud/                                   # CRUD test cases
│       │       │   ├── TestAuthorBookById.java
│       │       │   ├── TestAuthorsCreate.java
│       │       │   ├── TestAuthorsDelete.java
│       │       │   ├── TestAuthorsDetails.java
│       │       │   ├── TestAuthorsDetailsById.java
│       │       │   ├── TestAuthorsFullUpdate.java
│       │       │   └── TestJSONSchemaValidation.java
│       │       │
│       │       ├── integration/                            # End-to-end workflow tests
│       │       │   └── TestE2EFlow.java
│       │       │
│       │       └── sample/                                 # Sample test implementations
│       │           └── TestIntegrationSample.java
│       │
│       └── resources/
│           └── schemas/
│               └── author_create_schema.json               # JSON Schema validation
│
└── README.md
```

---

# 📦 Framework Components

| Component | Description |
|------------|-------------|
| **APIConstants** | Stores all API endpoint constants |
| **PayloadManager** | Generates reusable request payloads |
| **BaseTest** | Provides common test initialization and configuration |
| **AssertActions** | Contains centralized assertion utilities |
| **CRUD Tests** | Implements Create, Read, Update, and Delete API test scenarios |
| **Integration Tests** | Validates complete end-to-end API workflows |
| **Resources** | Stores Log4j2 configuration and JSON Schema files |

---

# 🌐 API Coverage

| Endpoint | Test Scenario |
|-----------|---------------|
| **POST** `/api/v1/Authors` | Create Author |
| **GET** `/api/v1/Authors` | Retrieve All Authors |
| **GET** `/api/v1/Authors/{id}` | Retrieve Author by ID |
| **PUT** `/api/v1/Authors/{id}` | Update Author |
| **DELETE** `/api/v1/Authors/{id}` | Delete Author |
| **GET** `/api/v1/Authors/authors/books/{id}` | Retrieve Author Books |
| Response Validation | JSON Schema Validation |
| Workflow | End-to-End Integration Testing |

---

# ▶️ Running Tests

Execute any TestNG suite using Maven.

### Example

```bash
mvn clean test -DsuiteXmlFile=testng_integration.xml
```

### Available Test Suites

| Suite | XML File |
|--------|----------|
| Create Author | `testng_createAuthors.xml` |
| Delete Author | `testng_deleteAuthors.xml` |
| Author Details | `testng_detailsAuthorById.xml` |
| Full Update | `testng_fullUpdate.xml` |
| Author Books | `testng_authorBookById.xml` |
| JSON Schema Validation | `testng_JSONSchemaValidation.xml` |
| Sample Tests | `testng_sample.xml` |
| End-to-End Flow | `testng_integration.xml` |

---

# 📊 Allure Reports

Generate and launch the Allure report using:

```bash
allure serve allure-results
```

<p align="center">
<img width="1100" src="https://github.com/user-attachments/assets/285180c9-fc54-45ec-9289-93075c9f199f" alt="Allure Report">
</p>

The command generates and opens an interactive **Allure dashboard** displaying execution results, logs, and test statistics.

---

# 📝 Sample Request Payload

```java
String payload = """
{
    "id": 15,
    "idBook": 5,
    "firstName": "Avinash",
    "lastName": "Sinha"
}
""";
```

---

# ⭐ Repository Highlights

- ✔ Modular API Automation Framework
- ✔ Industry-Standard Project Structure
- ✔ Complete CRUD API Testing
- ✔ Rest-Assured + TestNG
- ✔ Reusable Payload Management
- ✔ Centralized Assertions
- ✔ JSON Schema Validation
- ✔ End-to-End Integration Testing
- ✔ Log4j2 Logging
- ✔ Rich Allure Reporting

---

# 👨‍💻 Author

**Avinash Sinha**

If you found this repository useful, consider giving it a ⭐.

---

# 📄 License

This repository is intended for **educational** and **learning purposes**.
