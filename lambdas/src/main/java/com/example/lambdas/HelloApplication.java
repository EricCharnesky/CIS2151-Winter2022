package com.example.lambdas;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HelloApplication extends Application {

    private Label label;
    private ArrayList<Contact> contacts;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane pane = new AnchorPane();

        contacts.add(new Contact("Eric Charnesky", "etcharn1@oaklandcc.edu", null));
        contacts.add(new Contact("Dr. JP Baugh", null, "248.522.3583"));
        contacts.add(new Contact("Ken Sigler", "kesigler@oaklandcc.edu", "248.232.4247"));

        //ArrayList<Contact> contactsWithoutPhone = getContactsWithoutPhone(contacts);

        // implicitly implements the TestContact interface
        // " contact -> contact.getEmail() == null "
        ArrayList<Contact> contactsWithoutEmail = filterContacts(contacts, contact -> contact.getEmail() == null);


        ArrayList<Contact> contactsWithoutPhone = filterContacts(contacts, contact -> contact.getPhone() == null);

        ArrayList<Contact> contactsWith248AreaCode = filterContacts(contacts, contact -> contact.getPhone() != null &&
                contact.getPhone().startsWith("248"));

        ArrayList<Contact> contactsWithOCCEmail = filterContacts(contacts, contact -> contact.getEmail() != null &&
                contact.getEmail().endsWith("@oaklandcc.edu"));

        // with Predicate, you don't need to write your own interface
        ArrayList<Contact> contactsWithNamesStartingWithE = filterContactsWithPredicate(contacts,
                contact -> contact.getName() != null &&
                        (contact.getName().startsWith("E") || contact.getName().startsWith("e")));

        processContact(contacts, contact -> contact.setName(contact.getName().toUpperCase()));

        ArrayList<String> contactPhoneNumbers = transformContacts(contacts,
                contact -> {
                    // condense if/else - if true you get the ?, false you get the :
                    String phone = (contact.getPhone() == null ) ? "n/a" : contact.getPhone();
                    return contact.getName() + ":  " + phone;
                });

        label = new Label();
        label.setText("Hello World!");

        VBox vbox = new VBox();
        vbox.getChildren().add(label);
        pane.getChildren().add(vbox);

        Button button = new Button();
        button.setText("click me! - private inner class");
        button.setOnAction(new ButtonHandler());
        vbox.getChildren().add(button);

        Button anotherButton = new Button();
        anotherButton.setText("Click me! - anonymous inner class");
        anotherButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("anonymous inner class handler here!");
            }
        });
        vbox.getChildren().add(anotherButton);

        Button buttonWithLambda = new Button();
        buttonWithLambda.setText("Click me, I run a lambda!");
        buttonWithLambda.setOnAction(event -> label.setText("lambda lambda lambda"));
        vbox.getChildren().add(buttonWithLambda);


        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private static ArrayList<Contact> filterContactsWithPredicate(ArrayList<Contact> contacts, Predicate<Contact> condition) {
        ArrayList<Contact> filteredContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (condition.test(contact)) {
                filteredContacts.add(contact);
            }
        }

        return filteredContacts;
    }

    // shameless copied from the book chapter 22
    private static ArrayList<Contact> filterContacts(ArrayList<Contact> contacts, TestContact condition) {
        ArrayList<Contact> filteredContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (condition.test(contact)) {
                filteredContacts.add(contact);
            }
        }

        return filteredContacts;
    }

    private static void processContact(ArrayList<Contact> contacts, Consumer<Contact> consumer) {
        for (Contact contact : contacts) {
            consumer.accept(contact);
        }
    }

    //      < type passing in, type returned out >
    //  Function<Contact, String>
    public static ArrayList<String> transformContacts(ArrayList<Contact> contacts, Function<Contact, String> function){
        ArrayList<String> strings = new ArrayList<>();
        for ( Contact contact : contacts ){
            strings.add(function.apply(contact));
        }
        return strings;
    }

    private static ArrayList<Contact> getContactsWithoutPhone(ArrayList<Contact> contacts) {
        ArrayList<Contact> contactsWithoutPhones = new ArrayList<Contact>();

        for (Contact contact : contacts) {
            if (contact.getPhone() == null) {
                contactsWithoutPhones.add(contact);
            }
        }
        return contactsWithoutPhones;
    }

    // as it's part of the class, it also has access to the class level variables
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            label.setText("You clicked the button!");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}