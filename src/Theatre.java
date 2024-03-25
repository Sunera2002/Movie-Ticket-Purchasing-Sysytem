import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Theatre {
    private static final int[] row1 = new int[12];
    private static final int[] row2 = new int[16];
    private static final int[] row3 = new int[20];
    static ArrayList<Ticket> tickets = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        while(true) {
            System.out.println("Welcome to the New Theatre");
            System.out.println("-------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("     0) Quit");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            if (option == 0){
                break;
            } else if (option == 1) {
                buy_ticket();
            } else if (option == 2) {
                print_seating_area();
            } else if (option == 3) {
                cancel_ticket();
            } else if (option == 4) {
                show_available();
            } else if (option == 5) {
                save();
            } else if (option == 6) {
                load();
            } else if (option == 7) {
                show_tickets_info();
            } else if (option == 8) {
                sort_tickets();
            } else {
                System.out.println("Sorry! Invalid Operation");
            }
        }
    }

    public static void buy_ticket() {
        int row_no;
        int seat_no;
        while(true) {
            System.out.print("Enter a row number: ");
            row_no = scanner.nextInt();
            System.out.print("Enter a seat number: ");
            seat_no = scanner.nextInt();
            if (row_no > 0 && row_no < 4) {
                while (true) {
                    if (row_no == 1) {
                        if (seat_no > 0 && seat_no < 13) {
                            if (row1[seat_no - 1] == 1) {
                                System.out.println("Occupied");
                                break;
                            } else {
                                row1[seat_no - 1] = 1;
                            }
                        } else {
                            System.out.println("Sorry! Invalid seat number");
                        }
                    } else if (row_no == 2) {
                        if (seat_no > 0 && seat_no < 17) {
                            if (row2[seat_no - 1] == 1) {
                                System.out.println("Occupied");
                                break;
                            } else {
                                row2[seat_no - 1] = 1;
                            }
                        } else {
                            System.out.println("Sorry! Invalid seat number");
                        }
                    } else {
                        if (seat_no > 0 && seat_no < 21) {
                            if (row3[seat_no - 1] == 1) {
                                System.out.println("Occupied");
                                break;
                            } else {
                                row3[seat_no - 1] = 1;
                            }
                        } else {
                            System.out.println("Sorry! Invalid seat number");
                        }
                    }
                }
            } else {
                System.out.println("Sorry! Invalid row number");
                break;
            }
            System.out.println("Enter your name: ");
            String name = scanner.next();
            System.out.println("Enter your surname: ");
            String surname = scanner.next();
            System.out.print("Enter your email: ");
            String email = scanner.next();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            tickets.add(new Ticket(row_no, seat_no, price, new Person(name, surname, email)));
        }
    }

    public static void print_seating_area() {
        System.out.println("    ***********");
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********");
        System.out.print("    ");
        for (int i : row1) {
            if (i == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
        System.out.print("  ");
        for (int i : row2) {
            if (i == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
        for (int i : row3) {
            if (i == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
    }
    public static void cancel_ticket() {
        System.out.print("Enter a row number: ");
        int row_no = scanner.nextInt();
        System.out.print("Enter the seat number you want to cancel: ");
        int seat_no = scanner.nextInt();
        if (row_no == 1) {
            if (row1[seat_no-1] == 1){
                row1[seat_no-1] = 0;
                delete_ticket(row_no,seat_no);
                System.out.println("Successfully cancelled");
            } else if (row2[seat_no-1] == 1){
                row2[seat_no-1] = 0;
                delete_ticket(row_no,seat_no);
                System.out.println("Successfully cancelled");
            } else if (row3[seat_no-1] == 1){
                row3[seat_no-1] = 0;
                delete_ticket(row_no,seat_no);
                System.out.println("Successfully cancelled");
            } else {
                System.out.println("Already free seat");
            }
        }
    }

    public static void delete_ticket(int row,int seat){
        for (int i = 0; i<tickets.size(); i++){
            if(tickets.get(i).seat==seat&tickets.get(i).row==row){
                tickets.remove(i);
            }
        }

    }
    public static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row1.length; i++){
            if (row1[i] == 0) {
                System.out.print((i+1) + ", ");
            }
        }
        System.out.println("\b\b" + ".");
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row2.length; i++){
            if (row2[i] == 0) {
                System.out.print((i+1) + ", ");
            }
        }
        System.out.println("\b\b" + ".");
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row3.length; i++){
            if (row3[i] == 0) {
                System.out.print((i+1) + ", ");
            }
        }
        System.out.println("\b\b" + ".");
    }

    public static void save() {
        try {
            FileWriter myWriter = new FileWriter("text.txt");
            myWriter.write(Arrays.toString(row1).replace("[","").replace("]","")+ "\n");
            myWriter.write(Arrays.toString(row2).replace("[","").replace("]","") + "\n");
            myWriter.write(Arrays.toString(row3).replace("[","").replace("]","") + "\n");
            myWriter.close();
            System.out.println("Successfully written to the file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void load(){
        try {
            File myObj = new File("text.txt");
            Scanner myReader = new Scanner(myObj);
            int arrays[][] = {row1,row2,row3};
            while (myReader.hasNextLine()) {
                for (int i=0; i < arrays.length; i++) {
                    String temp = myReader.nextLine();
                    String[] tempArray = temp.split(", ");
                    for (int j = 0; j < tempArray.length; j++) {
                        arrays[i][j] = Integer.parseInt(tempArray[j]);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException  e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void show_tickets_info(){
        double total = 0;
        for (int i = 0; i < tickets.size(); i++) {
            tickets.get(i).print();
            total += tickets.get(i).price;
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Total price :" + total);
        System.out.println("-----------------------------------------------");
    }
    public static void sort_tickets(){
        ArrayList<Ticket> sortedArray = tickets;
        for (int i = 0; i < sortedArray.size(); i++) {
            for (int j = i + 1; j < sortedArray.size(); j++) {
                if (sortedArray.get(i).getPrice() > sortedArray.get(j).getPrice()) {
                    Ticket temp = sortedArray.get(i);
                    sortedArray.set(i, sortedArray.get(i));
                    sortedArray.set(j, temp);

                }
            }
        }
        for (Ticket ticket : sortedArray) {
            ticket.print();
        }
    }
}