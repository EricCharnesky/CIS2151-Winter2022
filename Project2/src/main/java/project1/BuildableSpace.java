package project1;

import java.io.Serializable;

public class BuildableSpace extends Space implements IsBuildable, Serializable {

    public BuildableSpace() {
        description = "There is a nice flat place to build a fort on this space";
        takeTool(); // remove any tool
    }

    @Override
    public void build() {
        description = "there is a fort built on this space";
    }
}
