# CSV Data-Driven Testing Guide

## Overview
This project now supports CSV-based data-driven testing for login scenarios. Test data is externalized in CSV files, making it easy to add, modify, or remove test cases without changing the code.

## Features Implemented

### 1. CSV Data File
**Location:** `src/test/resources/login_data.csv`

**Format:**
```csv
username,password,expectedResult
standard_user,secret_sauce,valid
locked_out_user,secret_sauce,locked
...
```

**Columns:**
- `username`: The username to test
- `password`: The password to test
- `expectedResult`: Expected outcome (`valid`, `invalid`, or `locked`)

### 2. CSV Reader Utility
**Location:** `src/test/java/utils/CSVReader.java`

**Methods:**
- `readCSV(String filePath)`: Reads entire CSV file and returns all data
- `readValidLoginData(String filePath)`: Returns only rows with `expectedResult = "valid"`
- `readInvalidLoginData(String filePath)`: Returns only rows with `expectedResult = "invalid"` or `"locked"`

### 3. Updated Test Class
**Location:** `src/test/java/tests/LoginTests.java`

**Changes:**
- Removed hardcoded credentials
- Added `@DataProvider` methods that read from CSV
- Tests now accept username and password as parameters
- Enhanced assertion messages with username context

## Test Scenarios Included

The `login_data.csv` file includes the following test scenarios:

1. **Valid Users:**
   - standard_user
   - problem_user
   - performance_glitch_user

2. **Invalid Scenarios:**
   - Locked out user
   - Wrong password
   - Invalid username
   - Empty username
   - Empty password
   - Both empty

## How to Add New Test Cases

1. Open `src/test/resources/login_data.csv`
2. Add a new row with the format: `username,password,expectedResult`
3. Save the file
4. Run tests - the new scenario will be automatically included

Example:
```csv
new_user,new_password,valid
```

## Running the Tests

### Run all login tests:
```bash
mvn test -Dtest=LoginTests
```

### Run only valid login tests:
```bash
mvn test -Dtest=LoginTests#validLoginTest
```

### Run only invalid login tests:
```bash
mvn test -Dtest=LoginTests#invalidLoginTest
```

### Run via TestNG XML:
```bash
mvn test
```

## Benefits

✅ **No Hardcoded Data**: All test data is externalized
✅ **Easy Maintenance**: Add/modify test cases by editing CSV file
✅ **Scalable**: Support for unlimited test scenarios
✅ **Clean Code**: Separation of test logic and test data
✅ **Reusable**: CSV utility can be used for other test classes

## Dependencies

- **OpenCSV 5.9**: Added to `pom.xml` for CSV parsing
- **TestNG**: For DataProvider functionality
- **Selenium**: For browser automation

## File Structure

```
Selenium Project 1/
├── src/
│   ├── main/java/
│   │   └── utils/
│   │       └── DriverFactory.java
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │   │   └── LoginTests.java
│       │   └── utils/
│       │       └── CSVReader.java
│       └── resources/
│           └── login_data.csv
├── pom.xml
└── testng.xml
```

## Troubleshooting

**Issue:** CSV file not found
- **Solution:** Ensure the file path is correct: `src/test/resources/login_data.csv`

**Issue:** Tests not picking up new data
- **Solution:** Run `mvn clean test` to ensure fresh build

**Issue:** CSV parsing errors
- **Solution:** Check CSV format - ensure no extra commas or quotes

## Future Enhancements

- Add support for multiple CSV files (checkout data, product data, etc.)
- Implement CSV validation before test execution
- Add support for expected error messages in CSV
- Create CSV templates for different test types
