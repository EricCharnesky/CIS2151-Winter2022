package com.example.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button showAllTicketsButton;
    @FXML
    private Button buyTicketButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ticketNumberTextField;
    @FXML
    private Label allTicketsLabel;
    @FXML
    private Button returnTicketButton;

    private static String url = "jdbc:sqlite:project3.db";

    private ArrayList<Ticket> readTicketsFromDatabase() {
        ArrayList<Ticket> ticketArrayList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement statement = conn.createStatement();

                // select list of fields from tablename
                String query = "select guestName, ticketNumber, confirmationCode from ticket";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Ticket item = new Ticket(resultSet.getString("guestName"),
                            resultSet.getInt("ticketNumber"),
                            resultSet.getInt("confirmationCode"));
                    ticketArrayList.add(item);
                }

                statement.close();
            }

        } catch (SQLException e) {
            allTicketsLabel.setText(e.getMessage());
        }

        return ticketArrayList;
    }


    @FXML
    public void showAllTicketButtonClicked(ActionEvent actionEvent) {
        showTickets();
    }

    private void showTickets() {
        ArrayList<Ticket> tickets = readTicketsFromDatabase();

        if (tickets.size() == 0) {
            allTicketsLabel.setText("No tickets found");
        } else {
            allTicketsLabel.setText("");
            for (Ticket ticket : tickets) {
                allTicketsLabel.setText(allTicketsLabel.getText() + "\n" + ticket.toString());
            }
        }
    }

    @FXML
    public void buyTicketButtonClicked(ActionEvent actionEvent) {
        String guestName = nameTextField.getText();

        try {
            int ticketNumber = Integer.parseInt(ticketNumberTextField.getText());

            ArrayList<Ticket> tickets = readTicketsFromDatabase();

            boolean canSell = true;

            for (Ticket ticket : tickets) {
                if (ticket.getTicketNumber() == ticketNumber) {
                    ticketNumberTextField.setText("That ticket number has already been sold");
                    canSell = false;
                    break;
                }
            }

            if (canSell) {
                Ticket ticket = new Ticket(guestName, ticketNumber);
                addTicketToDatabase(ticket);
                showTickets();
            }

        } catch (NumberFormatException ex) {
            ticketNumberTextField.setText("Please enter a valid number");
        }
    }

    private void addTicketToDatabase(Ticket ticket) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                // prepared statements defend against sql injection attacks
                String preparedSql = "insert into ticket (guestName, ticketNumber, confirmationCode) values ( "
                        + " ?, ?, ? )";
                PreparedStatement statement = conn.prepareStatement(preparedSql);

                // index starts at 1 with prepared statements
                statement.setString(1, ticket.getGuestName());
                statement.setInt(2, ticket.getTicketNumber());
                statement.setInt(3, ticket.getConfirmationCode());

                statement.executeUpdate();

                statement.close();
            }

        } catch (SQLException e) {
            ticketNumberTextField.setText(e.getMessage());
        }
    }

    @FXML
    public void returnTicketButtonClicked(ActionEvent actionEvent) {
        try {
            int ticketNumber = Integer.parseInt(ticketNumberTextField.getText());

            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();

                    // prepared statements defend against sql injection attacks
                    String preparedSql = "delete from ticket where ticketNumber = ?";
                    PreparedStatement statement = conn.prepareStatement(preparedSql);

                    // index starts at 1 with prepared statements
                    statement.setInt(1, ticketNumber);

                    statement.executeUpdate();

                    statement.close();

                    showTickets();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (NumberFormatException ex) {
            ticketNumberTextField.setText("Please enter a valid number");
        }
    }
}