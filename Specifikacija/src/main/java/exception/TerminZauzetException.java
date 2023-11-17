package exception;

public class TerminZauzetException extends Exception{
    String message = "Termin je zauzet. Izvinjavamo se!";

    @Override
    public String getMessage() {
        return message;
    }
}

