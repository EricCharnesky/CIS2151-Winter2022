
package project1;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private Island island;
    private ArrayList<Tool> tools;
    private int currentRow;
    private int currentCol;

    public Player() {
        island = new Island();
        currentCol = 0;
        currentRow = 0;
        tools = new ArrayList<>();
    }

    public boolean canGoUp() {
        return (currentRow > 0);
    }

    public void goUp() {
        if (canGoUp()) {
            currentRow--;
        }
    }

    public boolean canGoDown() {
        return (currentRow < island.getTotalRows() - 1);
    }

    public void goDown() {
        if (canGoDown()) {
            currentRow++;
        }
    }

    public boolean canGoLeft() {
        return (currentCol > 0);
    }

    public void goLeft() {
        if (canGoLeft()) {
            currentCol--;
        }
    }

    public boolean canGoRight() {
        return (currentCol < island.getRowSize(currentRow) - 1);
    }

    public void goRight() {
        if (canGoRight()) {
            currentCol++;
        }
    }

    public void digInCurrentSpace() {
        if (canDigInCurrentSpace()) {
            IsDiggable diggableSpace = (IsDiggable) getCurrentSpace();
            diggableSpace.dig();
        }
    }

    public boolean canDigInCurrentSpace() {
        return getCurrentSpace() instanceof IsDiggable
                && hasTool("shovel");
    }

    public void chopInCurrentSpace() {
        if (canChopInCurrentSpace()) {
            IsChoppable choppableSpace = (IsChoppable) getCurrentSpace();
            choppableSpace.chop();
        }
    }

    public boolean canChopInCurrentSpace() {
        return getCurrentSpace() instanceof IsChoppable
                && hasTool("axe");
    }

    public void buildInCurrentSpace() {
        if (canBuildInCurrentSpace()) {
            IsBuildable buildableSpace = (IsBuildable) getCurrentSpace();
            buildableSpace.build();
        }
    }

    public boolean canBuildInCurrentSpace() {
        return getCurrentSpace() instanceof IsBuildable
                && hasTool("hammer");
    }

    public Space getCurrentSpace() {
        return island.getSpace(currentRow, currentCol);
    }

    public boolean hasTool(String toolName) {
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(toolName)) {
                return true;
            }
        }
        return false;
    }

    public void addTool(Tool tool) {
        tools.add(tool);
    }

    public ArrayList<Tool> getTools() {
        // be careful giving a reference - makes a copy instead
        return new ArrayList<Tool>(tools);
    }


}
