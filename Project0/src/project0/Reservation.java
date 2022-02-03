
package project0;

public class Reservation {
    private String guestName;
    private int confirmationCode;

    public Reservation() {
        this("", 0);
    }

    public Reservation(String guestName) {
        this(guestName, (int)(Math.random() * 90_000) + 10_000);
    }

    public Reservation(String guestName, int confirmationCode) {
        this.guestName = guestName;
        this.confirmationCode = confirmationCode;
    }
    
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(int confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
    
    
}
