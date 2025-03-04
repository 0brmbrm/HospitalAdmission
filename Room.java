public class Room {
    private String type;
    private boolean isAvailable;

    public Room(String type) {
        this.type = type;
        this.isAvailable = true;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void assign() {
        isAvailable = false;
    }

    public void free() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return type + (isAvailable ? " (Available)" : " (Occupied)");
    }
}

