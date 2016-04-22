package projectfxml;

public class Vehicle {
	
    // Data Fields
    String vin;
    private String make;
    private String model;
    private int year;
    private String type;
    private String status;
    private double price;

    // No-arg constructor
    public Vehicle(){}

    public Vehicle(String vin, String make, String model, int year, String type, String status, double price) {
        super();
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    // Getter
    public String getVin() {
        return vin;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getType() {
        return type;
    }
    public String getStatus() {
        return status;
    }
    public double getPrice() {
        return price;
    }

    // Setter
    public void setVin(String vin) {
        this.vin = vin;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "vin=" + vin + ", "+
        "make=" + make + ", "+
        "model=" + model + ", "+
        "year=" + year + ", "+
        "type=" + type + ", "+
        "status=" + status + ","+
        "price=" + price + "";
    }
}