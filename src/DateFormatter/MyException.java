package DateFormatter;

public class MyException extends Exception {
    int temperature;
    String lastName;
    String nurse;

    public MyException(int temperature) {
        this.temperature = temperature;
    }

    public MyException(String message, int temperature) {
        super(message);
        this.temperature = temperature;
    }

    public MyException(String message, Throwable cause, int temperature) {
        super(message, cause);
        this.temperature = temperature;
    }

    public MyException(Throwable cause, int temperature) {
        super(cause);
        this.temperature = temperature;
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int temperature) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.temperature = temperature;
    }

    MyException (int temperature, String lastName, String nurse, String message) {
        super(message);
        this.temperature = temperature;
        this.lastName = lastName;
        this.nurse = nurse;

    }

}

class One{
    int a;

    public One(int a) {
        this.a = a;
    }
}