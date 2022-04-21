package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.dto.UserInput;
import racingcar.domain.Names;
import racingcar.service.dto.GameInformation;
import racingcar.util.ExceptionMessageUtil;

public class InputView {
    private final static String NUMBER_PATTERN = "\\d*$";
    private final static String NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private final static String NULL_EXCEPTION_MESSAGE = "입력 값이 없습니다.";
    private final static String NAMES_NOT_HAVE_COMMA_MESSAGE = "이름 값은 ,로 구분됩니다.";

    public GameInformation input() {
        Boolean checkInput = true;
        String names = null;
        String timeStr = null;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            names = Console.readLine();
            checkInput = isValidName(names);
        } while (checkInput);

        do {
            System.out.println("시도할 회수는 몇 회 인가요?");
            timeStr = Console.readLine();
            checkInput = isValidTime(timeStr);
        } while (checkInput);

        UserInput userInput = UserInput.of(names, timeStr);

        return GameInformation.from(userInput);
    }

    private Boolean isValidName(String names) {
        boolean checkInput = true;
        try {
            validateNullOrEmptyForString(names);
            validateExistComma(names);
            Names.from(names);
        } catch (IllegalArgumentException exception) {
            checkInput = false;
            System.out.println(exception.getMessage());
        }
        return checkInput;
    }

    private Boolean isValidTime(String timeStr) {
        boolean checkInput = true;
        try {
            validateNullOrEmptyForString(timeStr);
            validateNumberString(timeStr);
        } catch (IllegalArgumentException exception) {
            checkInput = false;
            System.out.println(exception.getMessage());
        }
        return checkInput;
    }

    private void validateNumberString(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessageUtil.errorMessage(NUMBER_EXCEPTION_MESSAGE));
        }
    }

    private void validateNullOrEmptyForString(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(ExceptionMessageUtil.errorMessage(NULL_EXCEPTION_MESSAGE));
        }
    }

    private void validateExistComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessageUtil.errorMessage(NAMES_NOT_HAVE_COMMA_MESSAGE));
        }
    }

}
