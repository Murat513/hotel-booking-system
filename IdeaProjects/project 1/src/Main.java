class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

class Guest {
    private String name;
    private String phoneNumber;

    public Guest(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

class Booking {
    private Room room;
    private Guest guest;
    private int numberOfNights;

    public Booking(Room room, Guest guest, int numberOfNights) {
        this.room = room;
        this.guest = guest;
        this.numberOfNights = numberOfNights;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guest=" + guest +
                ", numberOfNights=" + numberOfNights +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(101, "Single", true);
        Room room2 = new Room(102, "Double", false);

        Guest guest1 = new Guest("Alice", "123456789");
        Guest guest2 = new Guest("Bob", "987654321");

        Booking booking1 = new Booking(room1, guest1, 3);
        Booking booking2 = new Booking(room2, guest2, 5);

        System.out.println(booking1);
        System.out.println(booking2);

        System.out.println(room1.isAvailable());
        room1.setAvailable(false);
        System.out.println(room1.isAvailable());
    }
}
