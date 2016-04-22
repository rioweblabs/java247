package projectfxml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWrite {
	
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    //CSV file header
    private static final String FILE_HEADER = "vin,make,model,year,type,status,price";
    
    public static void writeAppendSingle(ArrayList<Vehicle> vlist) {

        System.out.println(vlist);
        
        FileWriter fileWriter = null;
	
        try {
            fileWriter = new FileWriter("vehicles.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            int sz = vlist.size();
            
            for(int i = 0; i < sz; i++) {
                fileWriter.append(vlist.get(i).getVin());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(vlist.get(i).getMake());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(vlist.get(i).getModel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(vlist.get(i).getYear()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(vlist.get(i).getType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(vlist.get(i).getStatus());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(vlist.get(i).getPrice()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            
            System.out.println("CSV file was created successfully !!!");
			
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
			
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeAppendAll(Vehicle v) {

        FileWriter fileWriter = null;
				
        try {
            fileWriter = new FileWriter("vehicles.csv", true);

            //Write a new student object list to the CSV file
            fileWriter.append(v.getVin());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.getMake());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.getModel());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(v.getYear()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.getType());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.getStatus());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(NEW_LINE_SEPARATOR);
                        
            System.out.println("CSV file was created successfully !!!");
			
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
			
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}