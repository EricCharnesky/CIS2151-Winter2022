package project0;

import java.util.Scanner;

public class Project0 {

    public static void main(String[] args) {
        Theatre harryPotter = new Theatre("Harry Potter", 10);
        Theatre encanto = new Theatre("Encanto", 20);
        Theatre matrix = new Theatre("Matrix", 15);

        Scanner keyboard = new Scanner(System.in);

        String mode = "";
        while (!mode.equalsIgnoreCase("q")) {
            System.out.println("Do you want to (R)eserve seats or (P)rint reports or (Q)uit?");
            mode = keyboard.nextLine();

            if (mode.equalsIgnoreCase("r")) {
                System.out.println("What theatre? 1 - Harry Potter, 2 - Encanto, 3 - Matrix");
                String theatre = keyboard.nextLine();
                System.out.println("What's your name?");
                String name = keyboard.nextLine();
                if (theatre.equals("1")) {
                    reserveSeat(harryPotter, keyboard, name);
                } else if (theatre.equals("2")) {
                    reserveSeat(encanto, keyboard, name);
                } else if (theatre.equals("3")) {
                    reserveSeat(matrix, keyboard, name);
                } else {
                    System.out.println("I don't know that theatre");
                }
            } else if (mode.equalsIgnoreCase("p")) {
                System.out.println("What theatre? 1 - Harry Potter, 2 - Encanto, 3 - Matrix");
                String theatre = keyboard.nextLine();
                if (theatre.equals("1")) {
                    harryPotter.printReport();
                } else if (theatre.equals("2")) {
                    encanto.printReport();
                } else if (theatre.equals("3")) {
                    matrix.printReport();
                } else {
                    System.out.println("I don't know that theatre");
                }

            } else if (!mode.equalsIgnoreCase("q")) {
                System.out.println("I'm afraid I don't know what you want");
            }
        }
    }

    private static void reserveSeat(Theatre theatre, Scanner keyboard, String name) throws NumberFormatException {
        System.out.println("There are "
                + theatre.getNumberOfSeats() + "seats");
        System.out.println("What seat number?");
        int seatNumber = Integer.parseInt(keyboard.nextLine());
        if (theatre.isSeatAvailable(seatNumber)) {
            int code = theatre.reserveSeat(seatNumber, name);
            System.out.println("We reserved your seat, your code is: " + code);
        } else {
            System.out.println("that seat isn't available");
        }
    }
}
