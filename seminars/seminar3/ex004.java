package seminars.seminar3;

public class ex004 {
    public class DivisionByZeroException extends Exception {
        public DivisionByZeroException() {
            super("Division by zero!");
        }

        public DivisionByZeroException(String message) {
            super(message);
        }
    }
    public class EmptyArrayElementException extends Exception {

        public EmptyArrayElementException(String message) {
            super(message);
        }

        public EmptyArrayElementException(String message, Throwable cause) {
            super(message, cause);
        }

        public EmptyArrayElementException(Throwable cause) {
            super(cause);
        }
    }
    public class FileNotFoundException extends Exception {

        public FileNotFoundException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "File not found: " + super.getMessage();
        }
    }
}
