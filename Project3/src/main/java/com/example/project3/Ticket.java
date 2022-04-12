package com.example.project3;

public class Ticket {
    private String guestName;
    private int ticketNumber;
    private int confirmationCode;

    public Ticket(String guestName, int ticketNumber) {
        this.guestName = guestName;
        this.ticketNumber = ticketNumber;
        confirmationCode = (int)(Math.random() * 900_000) + 100_000;
    }

    public Ticket(String guestName, int ticketNumber, int confirmationCode) {
        this.guestName = guestName;
        this.ticketNumber = ticketNumber;
        this.confirmationCode = confirmationCode;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getConfirmationCode() {
        return confirmationCode;
    }

    @Override
    public String toString(){
        return "Ticket Number: " + ticketNumber + " - Guest: " + guestName + " - Confirmation Code: " + confirmationCode;
    }
}
