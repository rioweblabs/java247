package projectfxml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class FileRead {
	
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    //Student attributes index
    private static final int VIN_IDX = 0;
    private static final int MAKE_IDX = 1;
    private static final int MODEL_IDX = 2;
    private static final int YEAR_IDX = 3; 
    private static final int TYPE_IDX = 4;
    private static final int STATUS_IDX = 5;
    private static final int PRICE_IDX = 6;
        
    public static ArrayList<Vehicle> findAll() {

        BufferedReader fileReader = null;
        ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
        
        try {
        	
            //Create a new list of student to be filled by CSV file data 
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("vehicles.csv"));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Vehicle v = new Vehicle(tokens[VIN_IDX], 
                                            tokens[MAKE_IDX], 
                                            tokens[MODEL_IDX], 
                                            Integer.parseInt(tokens[YEAR_IDX]), 
                                            tokens[TYPE_IDX], tokens[STATUS_IDX],
                                            Double.parseDouble(tokens[PRICE_IDX])
                    );
                    vlist.add(v);
                }
            }
            System.out.println(vlist);
            return (vlist);
        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static ArrayList<Vehicle> findVin(String inputVin) {

        ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
        BufferedReader fileReader = null;
     
        try {
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("vehicles.csv"));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Vehicle v = new Vehicle(tokens[VIN_IDX], 
                                            tokens[MAKE_IDX], 
                                            tokens[MODEL_IDX], 
                                            Integer.parseInt(tokens[YEAR_IDX]), 
                                            tokens[TYPE_IDX], tokens[STATUS_IDX],
                                            Double.parseDouble(tokens[PRICE_IDX])
                    );                    
                    if (tokens[VIN_IDX].equals(inputVin)) {
                        vlist.add(v);
                    }
                }
            }
            
            System.out.println(vlist);
            return (vlist);
        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static ArrayList<Vehicle> findStatus(String inputStatus) {

        ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
        BufferedReader fileReader = null;
     
        try {
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("vehicles.csv"));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Vehicle v = new Vehicle(tokens[VIN_IDX], 
                                            tokens[MAKE_IDX], 
                                            tokens[MODEL_IDX], 
                                            Integer.parseInt(tokens[YEAR_IDX]), 
                                            tokens[TYPE_IDX], tokens[STATUS_IDX],
                                            Double.parseDouble(tokens[PRICE_IDX])
                    );                   
                    if (tokens[STATUS_IDX].equals(inputStatus)) {
                        vlist.add(v);
                    }
                }
            }
            
            System.out.println(vlist);
            return (vlist);
        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static double getIncome() {
        
        double income = 0;
        ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
        BufferedReader fileReader = null;
     
        try {
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("vehicles.csv"));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Vehicle v = new Vehicle(tokens[VIN_IDX], 
                                            tokens[MAKE_IDX], 
                                            tokens[MODEL_IDX], 
                                            Integer.parseInt(tokens[YEAR_IDX]), 
                                            tokens[TYPE_IDX], tokens[STATUS_IDX],
                                            Double.parseDouble(tokens[PRICE_IDX])
                    );                   
                    income += Double.parseDouble(tokens[PRICE_IDX]);
                }
            }
            return (income);
        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return 0;
    }
}