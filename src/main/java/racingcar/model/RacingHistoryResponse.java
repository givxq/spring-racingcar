package racingcar.model;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.PlayResult;

public class RacingHistoryResponse {
    private List<PlayResult> racingHistories;

    public RacingHistoryResponse(List<PlayResult> racingHistories) {
        this.racingHistories = racingHistories;
    }

    public List<PlayResult> getHistories() {
        return racingHistories;
    }
}
