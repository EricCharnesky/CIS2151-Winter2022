package checkingforinterfaces;

public class Event implements Logger {

    private String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void logMessage(String message) {
        System.out.println(name + ": " + message);
    }

}
