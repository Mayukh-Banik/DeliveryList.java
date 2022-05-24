import javax.annotation.processing.SupportedSourceVersion;

// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu CSE 214
public class DeliveryList
{
    private DeliveryListNode head;
    private DeliveryListNode tail;
    private DeliveryListNode cursor;
    private int counter;

    /**
     *sets all parameters to null
     */
    public DeliveryList()
    {
        head = null;
        tail = null;
        cursor = null;
        counter = 0;
    }

    /**
     * keeps track of the number of deliveries
     * @return number of deliveries
     */
    public int numDeliveries()
    {
        return counter;
    }

    /**
     * gets the value of the cursor
     * @return data of the cursor
     */
    public Delivery getCursor()
    {
        if (cursor == null)
        {
            System.out.println("Cursor is null.");
            return null;
        }
        return cursor.getData();
    }

    /**
     * places the cursor at the head of the list
     */
    public void resetCursorToHead()
    {
        cursor = head;
    }

    /**
     * puts the cursor at the tail
     */
    public void resetCursorToTail() throws EndOfListException
    {
        resetCursorToHead();
        for ( int counter = 1; counter < numDeliveries() - 1; counter++)
        {
            cursorForward();
        }
        cursor = tail;
        cursorBackward();
    }

    /**
     * pushes the cursor forward one
     * @throws EndOfListException in case the cursor is at the tail
     */
    public void cursorForward() throws EndOfListException
    {
        DeliveryListNode temp = cursor.getNext();
        if (cursor.equals(tail) || cursor.getNext().getNext() == null)
        {
            throw new EndOfListException("You're at end of the list. ");
        }
        cursor = temp;
    }

    /**
     * pushes the cursor back one
     * @throws EndOfListException in case the cursor is at the head
     */
    public void cursorBackward() throws EndOfListException
    {
        if (cursor.equals(head))
        {
            throw new EndOfListException("You're at the first delivery.");
        }
        DeliveryListNode temp = head;
        for (int counter = 0; counter < numDeliveries(); counter++)
        {
            if (temp.getNext() == cursor)
            {
                break;
            }
            temp = temp.getNext();
        }
        cursor = temp;
    }

    /**
     * places the new data entry of type delivery in the spot after the cursor
     * @param delivery the type of data that is being accepted
     */
    public void insertAfterCursor(Delivery delivery)
    {
        DeliveryListNode deliveryListNode = new DeliveryListNode(delivery);
        if (numDeliveries() == 0)
        {
            tail = deliveryListNode;
            head = deliveryListNode;
            cursor = deliveryListNode;
        }
        else
        {
            if(cursor == tail)
            {
                System.out.println("tail");
                appendToTail(delivery);
            }
            deliveryListNode.setPrev(cursor);
            deliveryListNode.setNext(cursor.getNext());
            cursor.setNext(deliveryListNode);
            if(deliveryListNode.getNext() != null)
            {
                deliveryListNode.getNext().setPrev(deliveryListNode);
            }
        }
        counter++;
    }

    /**
     * adds something to the tail of the list
     * @param newDelivery delivery being appended to the end
     * @throws IllegalArgumentException in case there's something wrong with the input
     */
    public void appendToTail(Delivery newDelivery) throws IllegalArgumentException
    {
        if (newDelivery == null)
        {
            throw new IllegalArgumentException("No inputted delivery.");
        }
        else
        {
            DeliveryListNode deliveryListNode = new DeliveryListNode(newDelivery);
            if (numDeliveries() == 0)
            {
                tail = deliveryListNode;
                head = deliveryListNode;
                cursor = deliveryListNode;
                tail.setNext(null);
            }
            else
            {
                deliveryListNode.setNext(null);
                tail.setNext(deliveryListNode);
                deliveryListNode.setPrev(tail);
                tail = deliveryListNode;
                tail.setNext(null);
            }
        }
    }

    /**
     * deletes the entry that the cursor is currently at
     * @return type delivery to be stored for future use
     * @throws EndOfListException for an error of where the cursor is located
     */
    public Delivery removeCursor() throws EndOfListException
    {
        Delivery delivery = getCursor();
        if (numDeliveries() != 0)
        {
            if (numDeliveries() == 1)
            {
                cursor = null;
                head = null;
                tail = null;
            }
            else if (numDeliveries() == 2)
            {
                if (cursor == head)
                {
                    tail.setPrev(null);
                    head = tail;
                    cursor = tail;
                }
                else
                {
                    head.setNext(null);
                    tail = head;
                    cursor = head;
                }
            }
            else if (cursor == head)
            {
                cursor.getNext().setPrev(null);
                cursor = cursor.getNext();
                cursor.setPrev(null);
            }
            else if (cursor.getData().toString().equalsIgnoreCase(tail.getData().toString()))
            {
                cursorBackward();
                tail = cursor;
            }
            else
            {
                cursor.getPrev().setNext(cursor.getNext());
                cursor.getNext().setPrev(cursor.getPrev());
                cursor = cursor.getNext();
            }
            counter--;
            return delivery;
        }
        else
        {
            throw new EndOfListException("Your cursor is empty!");
        }
    }

    /**
     * returns a string representation
     * @return string
     */
    public String toString()
    {
        String string = "";
        DeliveryListNode tempNode = head;
        if (numDeliveries() == 0)
        {
            string = "There are no deliveries in the list currently.";
        }
        else
        {
            for (int counter = 0; counter < numDeliveries(); counter++)
            {
                if (tempNode.equals(cursor))
                {
                    string = string + "\n" + "This next item is the cursor: \n";
                }
                string = string + "\n" + tempNode.getData().toString() + "\n";
                tempNode = tempNode.getNext();
            }
        }
        return string;
    }
}