package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    private final List<Cars> history = new ArrayList<>();
    private Names winnerNames;

    public void save(Cars tempHistory) {
        history.add(tempHistory);
    }

    private Cars getTimeHistory(Integer time) {
        Cars log = history.get(time);
        if (log == null) {
            throw new IllegalArgumentException("history가 존재하지 않습니다.");
        }
        return log;
    }


    public void makeWinner(Integer lastTime) {
        Cars lastHistory = getTimeHistory(lastTime);

        this.winnerNames = lastHistory.winnerNames();
    }

    public List<Cars> getHistory() {
        return history;
    }

    public Names getWinnerNames() {
        return winnerNames;
    }

}