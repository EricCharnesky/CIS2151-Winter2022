package project1;

import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Player player = new Player();

        String action = "";

        System.out.println("Welcome to AnimalCraft!");
        while (!action.equalsIgnoreCase("quit")) {
            System.out.println("You are standing on "
                    + player.getCurrentSpace().getDescription());
            Tool tool = player.getCurrentSpace().getTool();
            if (tool != null) {
                System.out.println("There is a " + tool.getName());
            }

            System.out.println("What do you want to do?");
            action = keyboard.nextLine();

            if (action.equalsIgnoreCase("pickup")) {
                if (tool != null) {
                    player.addTool(player.getCurrentSpace().takeTool());
                } else {
                    System.out.println("There is no tool to pickup");
                }
            } else if (action.equalsIgnoreCase("go up")) {
                if (player.goUp()) {
                    System.out.println("You go up");
                } else {
                    System.out.println("You can't go up");
                }

            } else if (action.equalsIgnoreCase("go down")) {
                if (player.goDown()) {
                    System.out.println("You go down");
                } else {
                    System.out.println("You can't go down");
                }

            } else if (action.equalsIgnoreCase("go right")) {
                if (player.goRight()) {
                    System.out.println("You go right");
                } else {
                    System.out.println("You can't go right");
                }

            } else if (action.equalsIgnoreCase("go left")) {
                if (player.goLeft()) {
                    System.out.println("You go left");
                } else {
                    System.out.println("You can't go left");
                }

            } else if (action.equalsIgnoreCase("build")) {
                if (player.canBuildInCurrentSpace()) {
                    player.buildInCurrentSpace();
                    System.out.println("You built a fort");
                } else {
                    System.out.println("You can't build here");
                }
            } else if (action.equalsIgnoreCase("chop")) {
                if (player.canChopInCurrentSpace()) {
                    player.chopInCurrentSpace();
                    System.out.println("You chop down a tree");
                } else {
                    System.out.println("You can't chop here");
                }
            } else if (action.equalsIgnoreCase("dig")) {
                if (player.canDigInCurrentSpace()) {
                    player.digInCurrentSpace();
                    System.out.println("You dig a hole");
                } else {
                    System.out.println("You can't dig here");
                }
            } else if (action.equalsIgnoreCase("backpack")) {
                System.out.println("Your backpack has: ");
                for (Tool myTool : player.getTools()) {
                    System.out.println(myTool.getName());
                }
            } else if (action.equalsIgnoreCase("help")) {
                System.out.println("You can: quit, dig, chop, build, pickup,"
                        + " go up, go down, go left, go right, backpack");
            } else {
                if (!action.equalsIgnoreCase("quit")) {
                    System.out.println("You can't do that");
                }
            }

        }

    }
}
