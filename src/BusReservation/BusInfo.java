package BusReservation;

public class BusInfo {
    private int busNo;
    private boolean ac;
    private int capacity;
    private String isAc;

    // Constructor
    BusInfo(int no, boolean ac, int cap) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
        this.isAc = ac ? "Available    " : "Not Available"; // set when object is created
    }

    // Getters
    public int getBusNo() {
        return busNo;
    }
    public boolean isAC() {
        return ac;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getIsAc() {
        return isAc;
    }
    

    // Setters
    public void setCapacity(int cap) {
        this.capacity = cap;
    }
    public void setAc(boolean ac) {
        this.ac = ac;
        this.isAc = ac ? "Available    " : "Not Available"; // update string accordingly
    }

    // Display method
    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo +
                           " | AC: " + isAc +
                           " | Total Capacity: " + capacity);
    }
}
