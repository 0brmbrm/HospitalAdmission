import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms;

    public RoomManager() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 0; i < 4; i++) rooms.add(new Room("Ward"));
        for (int i = 0; i < 3; i++) rooms.add(new Room("ICU"));
        for (int i = 0; i < 2; i++) rooms.add(new Room("Private Room"));
        rooms.add(new Room("Deluxe Suite"));
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void assignRoom(Room room) {
        room.assign();
    }
}