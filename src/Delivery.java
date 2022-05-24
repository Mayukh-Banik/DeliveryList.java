// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu CSE 214
public class Delivery
{

    private String source;
    private String destination;
    private String instruction;

    /**
     * sets all parameters to null
     */
    public Delivery()
    {
        this.source = null;
        this.destination = null;
        this.instruction = null;
    }

    /**
     * sets all values
     * @param source source of delivery
     * @param destination of delivery
     * @param instruction of how to deliver
     */
    Delivery(String source, String destination, String instruction)
    {
        setSource(source);
        setInstruction(instruction);
        setDestination(destination);
    }

    /**
     * gets destination value
     * @return string
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * gets instruction value
     * @return string
     */
    public String getInstruction()
    {
        return instruction;
    }

    /**
     * gets value of source
     * @return string of source
     */
    public String getSource()
    {
        return source;
    }

    /**
     * sets destination value
     * @param destination string value
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    /**
     * sets instruction value
     * @param instruction string value
     */
    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    /**
     * sets source value
     * @param source string value
     */
    public void setSource(String source)
    {
        this.source = source;
    }

    /**
     * returns a string representation of delivery
     * @return string value of data
     */
    public String toString()
    {
        return "Source: " + source + " Destination: " + destination + "\nInstruction: " + instruction;
    }

    /**
     * checks if two deliveries are identical
     * @param object  delivery to be checked
     * @return t/f type is they are equal
     */
    public boolean equals(Object object)
    {
        if (object instanceof Delivery)
        {
            Delivery delivery = (Delivery) object;
            return getSource().equals(delivery.getSource()) && getDestination().equals(delivery.getDestination())
                    && getInstruction().equals(delivery.getInstruction());
        }
        return false;
    }
}