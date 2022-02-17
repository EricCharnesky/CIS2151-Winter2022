
package project1;

import java.util.ArrayList;

public class Island {
    ArrayList<ArrayList<Space>> spaces;
    
    public Space getSpace(int row, int column){
        return spaces.get(row).get(column);
    }
}
