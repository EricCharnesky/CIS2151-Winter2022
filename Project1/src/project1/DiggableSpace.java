package project1;

public class DiggableSpace extends Space implements IsDiggable {

    public DiggableSpace() {
        description = "There is a big pile of dirt on this space";
        takeTool(); // remove any tool
    }

    @Override
    public void dig() {
        description = "There is a big hole in the dirt on this space";
    }

}
