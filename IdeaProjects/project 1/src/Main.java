import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}

class Guest extends Person {
    public Guest(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Guest{" + "name='" + getName() + "', phoneNumber='" + getPhoneNumber() + "'}";
    }
}

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return roomNumber == room.roomNumber &&
                isAvailable == room.isAvailable &&
                Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, isAvailable);
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

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guest=" + guest +
                ", numberOfNights=" + numberOfNights +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking booking = (Booking) obj;
        return numberOfNights == booking.numberOfNights &&
                Objects.equals(room, booking.room) &&
                Objects.equals(guest, booking.guest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, guest, numberOfNights);
    }
}

class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
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

    public List<Booking> getBookingsByGuest(Guest guest) {
        List<Booking> guestBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getGuest().equals(guest)) {
                guestBookings.add(booking);
            }
        }
        return guestBookings;
    }

    public void sortRoomsByNumber() {
        rooms.sort((r1, r2) -> Integer.compare(r1.getRoomNumber(), r2.getRoomNumber()));
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" + rooms +
                ", guests=" + guests +
                ", bookings=" + bookings +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Room room1 = new Room(101, "Single", true);
        Room room2 = new Room(102, "Double", false);
        Room room3 = new Room(103, "Suite", true);

        Guest guest1 = new Guest("Alice", "123456789");
        Guest guest2 = new Guest("Bob", "987654321");

        Booking booking1 = new Booking(room1, guest1, 3);
        Booking booking2 = new Booking(room2, guest2, 5);

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        hotel.addGuest(guest1);
        hotel.addGuest(guest2);

        hotel.addBooking(booking1);
        hotel.addBooking(booking2);

        System.out.println("Все бронирования:");
        System.out.println(hotel);

        System.out.println("Доступные номера:");
        System.out.println(hotel.getAvailableRooms());

        System.out.println("Бронирования гостя Alice:");
        System.out.println(hotel.getBookingsByGuest(guest1));

        System.out.println("Номера до сортировки:");
        System.out.println(hotel.rooms);

        hotel.sortRoomsByNumber();

        System.out.println("Номера после сортировки:");
        System.out.println(hotel.rooms);
    }
}
