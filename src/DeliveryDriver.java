// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu CSE 214
import java.util.*;
public class DeliveryDriver
{
    public static Delivery tempDelivery;

    /**
     * takes inputs and directs it to the methods to do the rest of the work
     * @param args default
     */
    public static void main(String[] args)
    {
        String[] strings = {"Biz Billy's Deliveries: ", "Money Mike's Deliveries:"};
        DeliveryList[] deliveryList = { new DeliveryList(), new DeliveryList() };
        System.out.println("Welcome to the Delinquent Dollar Delivery Scheduler.");
        initialOutput();
        while ( true )
        {
            String inputString = input().nextLine();
            switch (allToLowerCase(inputString))
            {
                case "a":
                    try
                    {
                        A(deliveryList[0]);
                    }
                    catch (IllegalArgumentException illegalArgumentException)
                    {
                        System.out.println("No delivery information was added.");
                    }
                    break;
                case "r":
                    try
                    {
                        R(deliveryList[0]);
                    }
                    catch (EndOfListException endOfListException)
                    {
                        System.out.println("There was nothing at the cursor");
                    }
                    break;
                case "x":
                    try
                    {
                        X(deliveryList[0]);
                    }
                    catch (EndOfListException endOfListException)
                    {
                        System.out.println("There was nothing at the cursor.");
                    }
                    break;
                case "v":
                    try
                    {
                        V(deliveryList[0]);
                    }
                    catch (IllegalArgumentException illegalArgumentException)
                    {
                        System.out.println("There was nothing to paste. ");
                    }
                    break;
                case "h":
                    H(deliveryList[0]);
                    break;
                case "t":
                    try
                    {
                        T(deliveryList[0]);
                    }
                    catch (EndOfListException endOfListException)
                    {
                        System.out.println("An error occured");
                    }
                    break;
                case "f":
                    try
                    {
                        F(deliveryList[0]);
                    }
                    catch (EndOfListException endOfListException)
                    {
                        System.out.println("The cursor could not be moved forward.");
                    }
                    break;
                case "b":
                    try
                    {
                        B(deliveryList[0]);
                    }
                    catch (EndOfListException endOfListException)
                    {
                        System.out.println("The cursor could not be moved backward.");
                    }
                    break;
                case "s":
                    S(deliveryList, strings);
                    break;
                case "p":
                    P(deliveryList[0], strings[0]);
                    break;
                case "q":
                    Q();
            }
            initialOutput();
        }
    }

    /**
     * initial output for the menu of the system.
     */
    public static void initialOutput()
    {
        System.out.println("\nMenu: \n\n" +
                "A) Add a Delivery After Cursor\n" +
                "R) Remove Delivery At Cursor\n" +
                "X) Cut Cursor\n" +
                "V) Paste After Cursor\n" +
                "H) Cursor to Head\n" +
                "T) Cursor to Tail\n" +
                "F) Cursor Forward\n" +
                "B) Cursor Backward\n" +
                "S) Switch Delivery Lists\n" +
                "P) Print current list\n" +
                "Q) Quit");
    }

    /**
     * input method for the class
     * @return type of scanner
     */
    public static Scanner input()
    {
        return new Scanner(System.in);
    }

    /**
     * makes the inputted string lowercase
     * @param string input string from other methods
     * @return string to be utilized by other methods
     */
    public static String allToLowerCase(String string)
    {
    string = string.toLowerCase(Locale.ROOT);
    return string;
}

    /**
     * adds an item after the cursor
     * @param deliveryList the delivery list being acted upon
     * @throws IllegalArgumentException in case something wrong was inputted
     */
    public static void A(DeliveryList deliveryList) throws IllegalArgumentException
    {
        System.out.println("Please enter a source: ");
        String source = input().nextLine();
        System.out.println("Please enter a destination: ");
        String destination = input().nextLine();
        System.out.println("Please enter any special instructions: ");
        String specialInstructions = input().nextLine();
        deliveryList.insertAfterCursor(new Delivery(source, destination, specialInstructions));
    }

    /**
     * just deletes the item at the cursor without saving it
     * @param deliveryList delivery list being acted upon
     * @throws EndOfListException in case an error occurs with there not being a value at cursor
     */
    public static void R(DeliveryList deliveryList) throws EndOfListException
    {
        deliveryList.removeCursor();
        System.out.println("The delivery at the cursor has been removed.");
    }

    /**
     * cuts out the data at the cursor and moves everything after it back one to eliminate the hole
     * @param deliveryList deliverylist where the item is being removed from
     * @throws EndOfListException in case an error occurs
     */
    public static void X(DeliveryList deliveryList) throws EndOfListException
    {
        tempDelivery = deliveryList.removeCursor();
        System.out.println("The delivery at the cursor has been removed, and stored for pasting.");
    }

    /**
     * pastes the previously deleted item in front of the cursor
     * @param deliveryList delivery list where the order is pasted to
     * @throws IllegalArgumentException leftover from adding data in
     */
    public static void V(DeliveryList deliveryList) throws IllegalArgumentException
    {
        if (tempDelivery == null)
        {
            throw new IllegalArgumentException();
        }
        deliveryList.insertAfterCursor(tempDelivery);
        System.out.println("The previously removed cursor has been pasted.");
    }

    /**
     * moves the cursor to the head
     * @param deliveryList delivery list where the cursor is being acted upon
     */
    public static void H(DeliveryList deliveryList)
    {
        deliveryList.resetCursorToHead();
        System.out.println("The cursor has been moved to the head, if there are any deliveries in the list.");
    }

    /**
     *moves the cursor to the end of the list
     * @param deliveryList the delivery list being acted upon
     */
    public static void T(DeliveryList deliveryList) throws EndOfListException
    {
        deliveryList.resetCursorToTail();
        System.out.println("The cursor has been moved to the tail, if there are any deliveries in the list.");
    }

    /**
     * moves the cursor forward one
     * @param deliveryList the list where the cursor is moving forward one
     * @throws EndOfListException if the cursor is at the tail
     */
    public static void F(DeliveryList deliveryList) throws EndOfListException
    {
        deliveryList.cursorForward();
        System.out.println("The cursor has been moved forward one.");
    }

    /**
     * Moves the cursor back one
     * @param deliveryList the delivery list where the cursor is being moved back
     * @throws EndOfListException if the cursor is at the head of the list
     */
    public static void B(DeliveryList deliveryList) throws EndOfListException
    {
        deliveryList.cursorBackward();
        System.out.println("The cursor has been moved backwards one.");
    }

    /**
     * Swaps the lists being acted upon
     * @param deliveryLists array where the delivery lists are located
     * @param strings name of the delivery list
     */
    public static void S(DeliveryList[] deliveryLists, String[] strings)
    {
        DeliveryList deliveryList= deliveryLists[0];
        deliveryLists[0] = deliveryLists[1];
        deliveryLists[1] = deliveryList;
        String string = strings[0];
        strings[0] = strings[1];
        strings[1] = string;
        System.out.println("You are now on the other delivery list.");
    }

    /**
     * Prints out the program
     * @param deliveryList to be printed
     * @param string of the name of the delivery list
     */
    public static void P(DeliveryList deliveryList, String string)
    {
        System.out.println(string);
        System.out.println("----------------------------------------------------------");
        System.out.println(deliveryList.toString());
    }

    /**
     * Terminates the program
     */
    public static void Q()
    {
        System.exit(0);
    }
}