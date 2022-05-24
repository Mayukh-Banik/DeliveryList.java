// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu CSE 214
public class DeliveryListNode
{
    private Delivery data;
    private DeliveryListNode next;
    private DeliveryListNode prev;

    /**
     * sets all parameters to null
     */
    DeliveryListNode()
    {
        data = null;
        next = null;
        prev = null;
    }

    /**
     * constructor initializing data of data
     * @param initData the data that data is being set to
     * @throws IllegalArgumentException in case the input is wrong
     */
    DeliveryListNode(Delivery initData) throws IllegalArgumentException
    {
        if (initData == null)
        {
            throw new IllegalArgumentException("Null argument.");
        }
        data = initData;
    }

    /**
     * sets the value of data
     * @param data wrapper for delivery
     */
    public void setData(Delivery data)
    {
        this.data = data;
    }

    /**
     * gets value of data
     * @return delivery type
     */
    public Delivery getData()
    {
        return data;
    }

    /**
     * gets the value of the next point
     * @return a wrapper for delivery
     */
    public DeliveryListNode getNext()
    {
        return next;
    }

    /**
     * gets the value of the previous data entry
     * @return wrapper for delivery
     */
    public DeliveryListNode getPrev()
    {
        return prev;
    }

    /**
     * sets value of next data entry
     * @param next value of next data entry
     */
    public void setNext(DeliveryListNode next)
    {
        this.next = next;
    }

    /**
     * sets value of prev data entry
     * @param prev value of previous data entry
     */
    public void setPrev(DeliveryListNode prev)
    {
        this.prev = prev;
    }

    /**
     * checks if the deliverylistnode is equal
     * @param object takes in input of deliverylist node type
     * @return if its the same or not
     */
    public boolean equals(Object object)
    {
        if (object instanceof DeliveryListNode)
        {
            DeliveryListNode deliveryListNode = (DeliveryListNode) object;
            return getData() == deliveryListNode.getData() && getNext() == deliveryListNode.getNext()
                    && getPrev() == deliveryListNode.getPrev();
        }
        return false;
    }
}