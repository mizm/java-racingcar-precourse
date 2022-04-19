package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("Position은 생성자로 입력된 값을 가지고 있는다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2"}, delimiter = ':')
    void createTest(Integer input, Integer expect) {
        Position actual = Position.from(input);

        assertThat(actual).isEqualTo(Position.from(expect));
    }

    @DisplayName("move가 호출 되면 position의 값이 1 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
    void moveTest(Integer input, Integer expect) {
        Position actual = Position.from(input);

        assertThat(actual.move()).isEqualTo(Position.from(expect));
    }

    @DisplayName("withDefaultPosition() 은 기본 값인 0 의 포지션을 반환한다.")
    @Test
    void withDefaultPositionTest() {
        Position position = Position.fromWithDefaultPosition();

        assertThat(position).isEqualTo(Position.from(0));
    }
}