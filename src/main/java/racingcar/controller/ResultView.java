package racingcar.controller;

import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.domain.dto.GameHistoryDto;
import racingcar.domain.dto.Winners;

import java.util.List;

public class ResultView {

    private final GameHistoryDto gameHistoryDto;

    private ResultView(GameHistoryDto gameHistoryDto) {
        this.gameHistoryDto = gameHistoryDto;
    }

    public static ResultView from(GameHistoryDto gameHistoryDto) {
        return new ResultView(gameHistoryDto);
    }

    public void view() {
        System.out.println("실행 결과");
        printHistory();
        printWinner();
    }

    private void printWinner() {
        Winners winners = gameHistoryDto.getWinners();
        System.out.println("최종 우승자: " + getWinnerView(winners));
    }

    private String getWinnerView(Winners winners) {
        return winners.getWinnersString();
    }

    private void printHistory() {
        List<CarsDto> history = gameHistoryDto.getHistory();

        for (CarsDto carsDto : history) {
            printCars(carsDto);
        }
    }

    private void printCars(CarsDto carsDto) {
        for (CarDto car : carsDto.getCarDtos()) {
            String positionView = getPositionView(car);
            System.out.println(car.getName() + " : " + positionView);
        }
        System.out.println();
    }

    private String getPositionView(CarDto car) {
        Integer now = car.getPosition();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < now; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}