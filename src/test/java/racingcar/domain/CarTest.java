package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Name name = Name.from("miz");

    @DisplayName("equalsPosition는 같은 위치의 차일 경우 true를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "1:0:false", "0:1:false"}, delimiter = ':')
    void getCountTest(Integer position1, Integer position2, boolean expect) {
        Car car1 = Car.from(name, Position.from(position1));
        Car car2 = Car.from(name, Position.from(position2));

        assertThat(car1.equalsPosition(car2)).isEqualTo(expect);
    }

    @DisplayName("MoveOrStop() strategy의 test의 결과가 true이면 position이 1 증가한다.")
    @Test
    void moveTest() {
        Integer expectNow = 1;
        MoveStrategy moveStrategy = () -> true;

        Car car = Car.fromWithDefaultPosition(name);
        car = car.moveOrStop(moveStrategy);

        Car expectCar = Car.from(name, Position.from(expectNow));
        assertThat(car.equalsPosition(expectCar)).isTrue();
    }

    @DisplayName("MoveOrStop() strategy의 test의 결과가 false이면 position은 변하지 않는다.")
    @Test
    void stopTest() {
        Integer expectNow = 0;
        MoveStrategy moveStrategy = () -> false;

        Car car = Car.fromWithDefaultPosition(name);
        car = car.moveOrStop(moveStrategy);

        Car expectCar = Car.from(name, Position.from(expectNow));
        assertThat(car.equalsPosition(expectCar)).isTrue();
    }

}