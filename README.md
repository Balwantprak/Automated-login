# Automated Login 🔐

Java + Selenium + TestNG project to automate web login functionality with CSV-based data-driven testing.

## Features
- ✅ Selenium WebDriver automation  
- ✅ TestNG framework with DataProvider support  
- ✅ **CSV Data-Driven Testing** - Externalized test data
- ✅ Page Object Model (POM) design pattern
- ✅ Maven project management
- ✅ Cross-browser testing support
- ✅ Comprehensive test reporting

## Requirements
- Java 11+
- Maven 3.6+
- ChromeDriver / GeckoDriver (managed by WebDriverManager)

## Setup
```bash
git clone https://github.com/Balwantprak/Automated-login.git
cd Automated-login
mvn clean install
```

## Run Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTests

# Run with specific browser
mvn test -Dbrowser=chrome
```

## CSV Data-Driven Testing 📊

This project uses CSV files to manage test data, making it easy to add or modify test scenarios without changing code.

### Quick Start
1. Test data is stored in: `src/test/resources/login_data.csv`
2. Add new test cases by adding rows to the CSV file
3. Tests automatically pick up new data on next run

### CSV Format
```csv
username,password,expectedResult
standard_user,secret_sauce,valid
locked_out_user,secret_sauce,locked
invalid_user,wrong_pass,invalid
```

### Example: Adding a New Test Case
Simply add a new row to `login_data.csv`:
```csv
new_test_user,test_password,valid
```

For detailed documentation, see [CSV_TESTING_GUIDE.md](CSV_TESTING_GUIDE.md)

## Project Structure
```
Selenium Project 1/
├── src/
│   ├── main/java/
│   │   ├── pages/          # Page Object classes
│   │   └── utils/          # Utility classes (DriverFactory, CSVReader)
│   └── test/
│       ├── java/
│       │   ├── base/       # Base test class
│       │   └── tests/      # Test classes
│       └── resources/
│           └── login_data.csv  # Test data
├── pom.xml
├── testng.xml
└── CSV_TESTING_GUIDE.md
```

## Key Components

### CSVReader Utility
Located at `src/test/java/utils/CSVReader.java`
- Reads CSV files and provides data to TestNG DataProviders
- Filters data based on expected results (valid/invalid)
- Handles file parsing and error management

### LoginTests
Located at `src/test/java/tests/LoginTests.java`
- Uses `@DataProvider` to fetch data from CSV
- Supports multiple test scenarios
- No hardcoded credentials

## Dependencies
- Selenium WebDriver 4.25.0
- TestNG 7.10.2
- WebDriverManager 5.9.2
- OpenCSV 5.9

## Notes
- ⚠️ Do NOT commit real credentials to the repository
- Test data is managed in CSV files for easy maintenance
- All browsers are managed automatically by WebDriverManager
- Tests run against https://www.saucedemo.com/

## Contributing
1. Fork the repository
2. Create a feature branch
3. Add your test scenarios to the CSV file
4. Submit a pull request

## License
MIT
