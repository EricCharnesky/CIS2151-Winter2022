package databasesinintellij;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabasesInIntelliJ {


    private static String url = "jdbc:sqlite:intelijtest.db";

    // https://www.sqlitetutorial.net/sqlite-java/create-database/
    public static ArrayList<Item> getItemsFromDatabase() {
        ArrayList<Item> itemsList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                Statement statement = conn.createStatement();

                // select list of fields from tablename
                String query = "select name, price, quantity from item";
                ResultSet items = statement.executeQuery(query);

                while (items.next()) {
                    Item item = new Item(items.getString("name"),
                            items.getDouble("price"),
                            items.getInt("quantity"));
                    itemsList.add(item);
                }

                statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return itemsList;
    }

    public static void addItemToDatabase(Item item) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                // insert into tablename ( column list ) values ( values to insert list )
                // bad danger danger way - sql injection
                // String query = String.format(
                //         "insert into item (name, price, quantity) values ( "
                //         + " %s, %f, %d )", item.getName(), item.getPrice(), item.getQuantity() );

                // prepared statements defend against sql injection attacks
                String preparedSql = "insert into item (name, price, quantity) values ( "
                        + " ?, ?, ? )";
                PreparedStatement statement = conn.prepareStatement(preparedSql);

                // index starts at 1 with prepared statements
                statement.setString(1, item.getName());
                statement.setDouble(2, item.getPrice());
                statement.setInt(3, item.getQuantity());

                statement.executeUpdate();

                statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void updateItemInDatabase(Item item) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                // prepared statements defend against sql injection attacks
                String preparedSql = "update item set price = ?, quantity = ? where name = ?";
                PreparedStatement statement = conn.prepareStatement(preparedSql);

                // index starts at 1 with prepared statements
                statement.setDouble(1, item.getPrice());
                statement.setInt(2, item.getQuantity());
                statement.setString(3, item.getName());

                statement.executeUpdate();

                statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteItemInDatabase(Item item) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                // prepared statements defend against sql injection attacks
                String preparedSql = "delete from item where name = ?";
                PreparedStatement statement = conn.prepareStatement(preparedSql);

                // index starts at 1 with prepared statements
                statement.setString(1, item.getName());

                statement.executeUpdate();

                statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Item getItemDetailsFromUser() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of an item to sell");
        String name = keyboard.nextLine();

        System.out.println("Enter the price of them to sell");
        double price = Double.parseDouble(keyboard.nextLine());

        System.out.println("Enter the quantity");
        int quantity = Integer.parseInt(keyboard.nextLine());

        Item newItem = new Item(name, price, quantity);

        return newItem;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Item newItem = getItemDetailsFromUser();
        addItemToDatabase(newItem);

        System.out.println("Let's update an item, enter the name of an existing item");
        Item itemToUpdate = getItemDetailsFromUser();
        updateItemInDatabase(itemToUpdate);

        System.out.println("Let's delete an item, enter the name of an existing item");
        // we don't care about price and quantity, just the name matters for deleting
        Item itemToDelete = new Item(keyboard.nextLine(), 0, 0);
        deleteItemInDatabase(itemToDelete);

        ArrayList<Item> itemsList = getItemsFromDatabase();
        for (Item item : itemsList) {
            System.out.println("Name: " + item.getName() +
                    " - Price: " + item.getPrice() +
                    " - Quantity: " + item.getQuantity());
        }
    }
}
