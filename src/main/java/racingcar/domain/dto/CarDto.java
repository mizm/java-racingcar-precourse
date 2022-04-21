package racingcar.domain.dto;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.Objects;

public class CarDto {

    private final Name name;
    private final Position position;

    private CarDto(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto of(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDto carDto = (CarDto) o;
        return Objects.equals(name, carDto.name) && Objects.equals(position, carDto.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}

