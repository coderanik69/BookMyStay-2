import java.util.*;
import java.io.*;

public class BookMyStayApp {

    static HashMap<String, Integer> inventory = new HashMap<>();
    static Queue<String> bookingQueue = new LinkedList<>();
    static Set<String> allocatedRooms = new HashSet<>();
    static Map<String, List<String>> addOnServices = new HashMap<>();

    public static void main(String[] args) {
        uc1_ApplicationStart();
        uc2_RoomInitialization();
        uc3_CentralizedInventory();
        uc4_RoomSearch();
        uc5_BookingRequestQueue();
        uc6_RoomAllocation();
        uc7_AddOnServices();
    }

    public static void uc1_ApplicationStart() {
        System.out.println("Welcome to Book My Stay");
        System.out.println("Hotel Booking System");
        System.out.println("Version 1.0");
        System.out.println("System Started Successfully\n");
    }

    static abstract class Room {
        String type;
        int price;

        Room(String type, int price) {
            this.type = type;
            this.price = price;
        }

        abstract void display();
    }

    static class SingleRoom extends Room {
        SingleRoom() {
            super("Single", 2000);
        }

        void display() {
            System.out.println("Single Room | Price : " + price);
        }
    }

    static class DoubleRoom extends Room {
        DoubleRoom() {
            super("Double", 3500);
        }

        void display() {
            System.out.println("Double Room | Price : " + price);
        }
    }

    static class SuiteRoom extends Room {
        SuiteRoom() {
            super("Suite", 6000);
        }

        void display() {
            System.out.println("Suite Room | Price : " + price);
        }
    }

    public static void uc2_RoomInitialization() {
        System.out.println("UC2 : Room Initialization");

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        r1.display();
        r2.display();
        r3.display();

        System.out.println();
    }

    public static void uc3_CentralizedInventory() {
        System.out.println("UC3 : Inventory Setup");

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        System.out.println("Inventory : " + inventory);
        System.out.println();
    }

    public static void uc4_RoomSearch() {
        System.out.println("UC4 : Room Search");

        for (String room : inventory.keySet()) {
            int count = inventory.get(room);

            if (count > 0) {
                System.out.println(room + " Available : " + count);
            }
        }

        System.out.println();
    }

    public static void uc5_BookingRequestQueue() {
        System.out.println("UC5 : Booking Requests");

        bookingQueue.add("Guest1 - Single");
        bookingQueue.add("Guest2 - Double");
        bookingQueue.add("Guest3 - Suite");

        System.out.println("Booking Queue : " + bookingQueue);
        System.out.println();
    }

    public static void uc6_RoomAllocation() {
        System.out.println("UC6 : Room Allocation");

        while (!bookingQueue.isEmpty()) {
            String request = bookingQueue.poll();

            String[] parts = request.split(" - ");
            String guest = parts[0];
            String type = parts[1];

            if (inventory.get(type) > 0) {
                String roomId = type + "-" + (allocatedRooms.size() + 1);

                allocatedRooms.add(roomId);
                inventory.put(type, inventory.get(type) - 1);

                System.out.println("Allocated " + roomId + " to " + guest);
            } else {
                System.out.println("No " + type + " rooms available for " + guest);
            }
        }

        System.out.println();
    }

    public static void uc7_AddOnServices() {
        System.out.println("UC7 : Add-On Services");

        List<String> services = new ArrayList<>();
        services.add("Breakfast");
        services.add("Airport Pickup");

        addOnServices.put("Single-1", services);

        System.out.println(addOnServices);
        System.out.println();
    }
}
