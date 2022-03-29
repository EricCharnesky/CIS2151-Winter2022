package project1;

import java.io.Serializable;

public class ChoppableSpace extends Space implements IsChoppable , Serializable {

    public ChoppableSpace() {
        description = "There is a big tree on this space";
        takeTool(); // remove any tool
    }

    @Override
    public void chop() {
        description = "There is a tree stump on this space";
    }

}
