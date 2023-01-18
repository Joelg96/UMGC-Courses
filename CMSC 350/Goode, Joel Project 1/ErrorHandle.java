/*
 * Joel Goode CMSC 350
 * This class is to handle exceptions and display a message.
 */

public class ErrorHandle extends Exception {

    public ErrorHandle() {
        super(">> Unfortunately, the Stack is Empty. Cannot pop from an empty Stack!");
    }
}
