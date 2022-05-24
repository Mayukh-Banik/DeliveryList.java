// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu CSE 214
public class EndOfListException extends Exception
{
    /**
     * a exception
     */
    public EndOfListException()
    {
        super("The end of the list has been reached. ");
    }

    /**
     * an exception with string input
     * @param string contains error message
     */
    public EndOfListException(String string)
    {
        super(string);
    }
}