package project1;

import java.util.ArrayList;

public class Island {

    ArrayList<ArrayList<Space>> spaces;

    public Island() {
        spaces = new ArrayList<>();

        for (int row = 0; row < 10; row++) {
            spaces.add(new ArrayList<Space>());
            for (int column = 0; column < 10; column++) {
                int randomNumber = (int) (Math.random() * 10);

                if (randomNumber == 1) {
                    spaces.get(row).add(new BuildableSpace());
                } else if (randomNumber == 2) {
                    spaces.get(row).add(new ChoppableSpace());
                } else if (randomNumber == 3) {
                    spaces.get(row).add(new DiggableSpace());
                } else {
                    spaces.get(row).add(new Space());
                }
            }
        }
    }

    public Space getSpace(int row, int column) {
        return spaces.get(row).get(column);
    }
    
    public int getTotalRows(){
        return spaces.size();
    }
    
    public int getRowSize(int row){
        return spaces.get(row).size();
    }
}
