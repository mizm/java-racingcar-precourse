package racingcar.controller.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserInputTest {

    @DisplayName("String null이거나 Empty 값이 나오면 IllegalException")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        UserInput userInput = UserInput.from(input, input);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            userInput.validate();
        });
    }
}