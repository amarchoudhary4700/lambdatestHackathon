# Lambdatest test ID: OAXKG-JAYXH-IKMPR-NQPGZ

---

# 🧪 Selenium Test Automation Framework

This is a Test Automation Framework built using **Java**, **Maven**, and **TestNG**. It supports execution on **local browsers** as well as on **LambdaTest** cloud grid, with configurable settings through a properties file.

---

## 🚀 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- LambdaTest (for cloud execution)
- Git & GitHub

---

## ⚙️ Configuration

All configurations are managed in `config.properties`.

### 🔧 config.properties

```properties
# Choose browser: chrome or edge
browser=chrome

# Set implicit and explicit timeout (in seconds)
timeout=30

# Set how many times failed tests re-execute
retry=2

# Set execution environment: lambdatest or locally
server=lambdatest

🧪 How to Run Tests

✅ Prerequisites
Java 11 or later
Maven
Internet connection (for LambdaTest)

🖥 Run Tests via Terminal
mvn clean test

You can override config properties at runtime:
mvn clean test -Dbrowser=edge -Dserver=local

🔁 Retry Logic
This framework uses TestNG’s IRetryAnalyzer to re-run failed tests automatically.
The number of retries is set in the config.properties:
retry=2

☁️ LambdaTest Integration
If you're using LambdaTest for cloud execution:
Set the server property to lambdatest.

📁 Project Structure
src
├── main
├── test
│   ├── java
│       ├── base          # Base classes and WebDriver setup
│       ├── tests         # TestNG test classes
│            
│  
└── config.properties
└── data.yaml

📊 Reports
By default, TestNG generates an index.html report under test-output.
Can be extended to support Allure or Extent Reports as needed.

🤝 Contributing
Feel free to fork this repo, raise issues, or submit pull requests to improve the framework.
