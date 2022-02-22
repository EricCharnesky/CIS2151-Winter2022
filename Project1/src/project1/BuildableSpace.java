package project1;

public class BuildableSpace extends Space implements IsBuildable {

    public BuildableSpace() {
        description = "There is a nice flat place to build a fort on this space";
        takeTool(); // remove any tool
    }

    @Override
    public void build() {
        description = "there is a fort built on this space";
    }
}
