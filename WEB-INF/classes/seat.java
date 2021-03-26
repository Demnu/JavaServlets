public class seat {
    private String name = "";
    private boolean reserved = false; 

    seat(String name, boolean reserved){
        this.name=name;
        this.reserved = reserved;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getName() {
        return name;
    }

    public boolean getReserved() {
        return reserved;
    }
}
