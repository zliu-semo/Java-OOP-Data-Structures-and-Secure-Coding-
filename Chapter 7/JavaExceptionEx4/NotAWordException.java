package resources;

import java.io.IOException;

@SuppressWarnings("serial")
public class NotAWordException extends IOException {

    public NotAWordException() {
        super();
    }

    public NotAWordException(String s) {
        super(s);
    }

    public NotAWordException(String s, Throwable cause) {
        super(s, cause);
    }

    @Override
    public String toString() {
        return "NotAWordException: Customized IOException when the input is not a word";
    }
}

