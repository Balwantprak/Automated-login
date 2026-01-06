# Automated Login 🔐

Java + Selenium + TestNG project to automate web login functionality.

## Features
- Selenium WebDriver automation  
- TestNG framework support  
- Maven project (`pom.xml`)  
- Run using `testng.xml`

## Requirements
- Java 11+
- Maven
- ChromeDriver / GeckoDriver installed

## Setup
```bash
git clone https://github.com/Balwantprak/Automated-login.git
cd Automated-login
mvn clean compile
```

## Run Tests
```bash
mvn test
```
or
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Notes
- Update login URL, locators, and credentials in test files
- Do NOT commit real credentials

## License
MIT
