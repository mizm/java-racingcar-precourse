package racingcar.service.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.dto.UserInput;

import static org.assertj.core.api.Assertions.assertThat;

class GameInformationTest {
    @DisplayName("getTime 는 RuleDto의 time을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"kay,may:3:3", "kay,may:6:6"}, delimiter = ':')
    void getTimeTest(String namesStr, Integer time, Integer expectTime) {
        GameInformation gameInformation = GameInformation.from(namesStr, time);

        assertThat(gameInformation.getTime()).isEqualTo(expectTime);
    }

    @DisplayName("create() 메서드는 정상적으로 GameInformation를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"kay,may:3:4:3", "kay,may:6:5:6"}, delimiter = ':')
    void getTimeTest(String namesStr, String time, Integer expectCount, Integer expectTime) {
        GameInformation gameInformation = GameInformation.from(namesStr, Integer.parseInt(time));

        assertThat(gameInformation.getTime()).isEqualTo(expectTime);

        gameInformation = GameInformation.from(UserInput.of(namesStr, time));

        assertThat(gameInformation.getTime()).isEqualTo(expectTime);
    }

}