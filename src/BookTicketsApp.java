import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class BookTicketsApp {

    Queue<String> queue = new LinkedList<>();
    String ticketName = "Burnaboy Madness Concert";
    int availableTickets = 5;

    public static void main(String[] args) {
        BookTicketsApp ticketApp = new BookTicketsApp();
        ticketApp.startApp();
    }

    public void startApp() {
        // Create frame for app
        JFrame frame = new JFrame("Book Tickets");
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Text Field & Button
        JTextField nameField = new JTextField("Enter name");
        JButton bookTicketButton = new JButton("Book");
        JButton printTicketsButton = new JButton("Print Tickets");
        JButton clearButton = new JButton("Clear Tickes");

        // Add fields to frame
        frame.add(nameField);
        frame.add(bookTicketButton);
        frame.add(printTicketsButton);
        frame.add(clearButton);

        // Create Button Functionalities

        // Book
        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a new booker to the queue
                if (availableTickets == 0) {
                    System.out.println("There are no more tickets left. Clear Bookers to restock on tickets");
                    return;
                }
                String name = nameField.getText();
                // Check that the user entered a name
                if (name.isEmpty() || name.equals("Enter name")) {
                    System.out.println("The field above cannot be empty");
                    return;
                }

                queue.add( name );
                availableTickets--;   // subtracting 1 from available tickets
                System.out.println(name + " Successfully booked a " + ticketName + " Ticket!");
                System.out.println("Tickets Left: " + availableTickets);
            }
        });

        // Print
        printTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                System.out.println("Bookers:");
                // Print all the bookers in our queue
                for (String name: queue) {
                    System.out.println(name);
                }
            }
        });

        // Clear Bookers
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Empty the Queue that contains people who have booked a ticket
                queue.clear();
                System.out.println("All the bookers have been removed");
                availableTickets = 5;
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
