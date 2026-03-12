import java.util.*;
import java.io.*;

public class BookMyStayApp {

    static HashMap<String, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        uc1_ApplicationStart();
        uc2_RoomInitialization();
        uc3_CentralizedInventory();
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
}
