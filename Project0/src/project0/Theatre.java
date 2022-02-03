package project0;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Theatre {

    private String name;
    private int numberOfSeats;

    private Reservation[] reservations;

    public Theatre(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        reservations = new Reservation[numberOfSeats];

        File savedReservations = new File(name + ".bin");

        if (savedReservations.exists()) {

            try {
                DataInputStream binaryInput = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(savedReservations)));
                for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
                    String guestName = binaryInput.readUTF();
                    int confirmationCode = binaryInput.readInt();
                    reservations[seatNumber] = new Reservation(guestName, confirmationCode);
                }
                binaryInput.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else {
            for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
                {
                    reservations[seatNumber] = new Reservation();
                }
            }
            saveFile();
        }
    }

    public void saveFile() {
        try {
            DataOutputStream binaryOutputFile = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(name + ".bin")));
            for (Reservation reservation : reservations) {
                binaryOutputFile.writeUTF(reservation.getGuestName());
                binaryOutputFile.writeInt(reservation.getConfirmationCode());
            }
            binaryOutputFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isSeatAvailable(int seatNumber) {
        return reservations[seatNumber].getConfirmationCode() == 0;
    }

    public int reserveSeat(int seatNumber, String guestName) {
        if (isSeatAvailable(seatNumber)) {
            reservations[seatNumber] = new Reservation(guestName);
            saveFile();
            return reservations[seatNumber].getConfirmationCode();
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void printReport() {
        for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
            System.out.print("Seat Number: " + seatNumber);
            System.out.print(" Guest Name: " + reservations[seatNumber].getGuestName());
            System.out.println(" Confirmation Code: " + reservations[seatNumber].getConfirmationCode());
        }
    }

}
