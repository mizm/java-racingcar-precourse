package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(Names names) {
        return new Cars(names.defaultPositionCars());
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> moveCars = cars.stream().map(car -> car.moveOrStop(moveStrategy))
                .collect(Collectors.toList());

        return from(moveCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
