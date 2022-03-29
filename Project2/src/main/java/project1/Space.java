package project1;

import java.io.Serializable;

public class Space  implements Serializable {

    private Tool tool;
    protected String description;

    public Space() {

        description = "an empty space";

        int randomNumber = (int) (Math.random() * 5);
        if (randomNumber == 2) {
            tool = new Tool("Hammer");
        } else if (randomNumber == 3) {
            tool = new Tool("Axe");
        } else if (randomNumber == 4) {
            tool = new Tool("Shovel");
        } else {
            tool = null;
        }
    }

    public String getDescription() {
        return description;
    }

    public Tool getTool() {
        return tool;
    }

    public Tool takeTool() {
        Tool toolToTake = tool;
        tool = null;
        return toolToTake;
    }

}
