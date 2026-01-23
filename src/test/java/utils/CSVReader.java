package utils;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {

    /**
     * Reads CSV file and returns data as Object[][] for TestNG DataProvider
     * @param filePath - path to CSV file relative to project root
     * @return Object[][] containing CSV data (excluding header row)
     */
    public static Object[][] readCSV(String filePath) {
        try {
            // Read CSV file
            com.opencsv.CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                    .withSkipLines(1) // Skip header row
                    .build();
            
            List<String[]> allData = reader.readAll();
            reader.close();

            // Convert List to Object[][]
            Object[][] data = new Object[allData.size()][];
            for (int i = 0; i < allData.size(); i++) {
                data[i] = allData.get(i);
            }

            return data;

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + filePath);
            e.printStackTrace();
            return new Object[0][0];
        } catch (CsvException e) {
            System.err.println("Error parsing CSV file: " + filePath);
            e.printStackTrace();
            return new Object[0][0];
        }
    }

    /**
     * Reads CSV file and returns only valid login data
     * @param filePath - path to CSV file
     * @return Object[][] containing only rows where expectedResult is "valid"
     */
    public static Object[][] readValidLoginData(String filePath) {
        Object[][] allData = readCSV(filePath);
        
        // Count valid rows
        int validCount = 0;
        for (Object[] row : allData) {
            if (row.length >= 3 && "valid".equalsIgnoreCase(row[2].toString())) {
                validCount++;
            }
        }

        // Create array with only valid data
        Object[][] validData = new Object[validCount][2];
        int index = 0;
        for (Object[] row : allData) {
            if (row.length >= 3 && "valid".equalsIgnoreCase(row[2].toString())) {
                validData[index][0] = row[0]; // username
                validData[index][1] = row[1]; // password
                index++;
            }
        }

        return validData;
    }

    /**
     * Reads CSV file and returns only invalid login data
     * @param filePath - path to CSV file
     * @return Object[][] containing only rows where expectedResult is "invalid" or "locked"
     */
    public static Object[][] readInvalidLoginData(String filePath) {
        Object[][] allData = readCSV(filePath);
        
        // Count invalid rows
        int invalidCount = 0;
        for (Object[] row : allData) {
            if (row.length >= 3 && 
                ("invalid".equalsIgnoreCase(row[2].toString()) || 
                 "locked".equalsIgnoreCase(row[2].toString()))) {
                invalidCount++;
            }
        }

        // Create array with only invalid data
        Object[][] invalidData = new Object[invalidCount][2];
        int index = 0;
        for (Object[] row : allData) {
            if (row.length >= 3 && 
                ("invalid".equalsIgnoreCase(row[2].toString()) || 
                 "locked".equalsIgnoreCase(row[2].toString()))) {
                invalidData[index][0] = row[0]; // username
                invalidData[index][1] = row[1]; // password
                index++;
            }
        }

        return invalidData;
    }
}
