/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.ArrayList;

/**
 *
 * @author EricC
 */
public class Player {
    private Island island;
    private ArrayList<Tool> tools;
    private int currentRow;
    private int currentCol;
    
    public Space getCurrentSpace(){
        return island.getSpace(currentRow, currentCol);
    }
    
    public void addTool(Tool tool){
        tools.add(tool);
    }
}
