package jar.us.exceptions;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException() {
        super("No such element found");
    }
}
