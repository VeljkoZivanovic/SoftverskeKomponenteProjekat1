package exception;

public class NevalidanTerminException extends Exception{
        String message = "Nevalidan je termin, probajte drugi";

    @Override
    public String getMessage() {
        return message;
    }
}
