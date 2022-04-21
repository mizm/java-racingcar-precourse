package racingcar.util;

public class ErrorMessageUtil {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static String errorMessage(String message) {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}
