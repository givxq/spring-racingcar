package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingInputCarView;
import racingcar.view.RacingResultView;

public class RacingCarService {
    public void startRacing(List<String> carNames, int targetDistance) {
        // make cars
        List<Car> cars = makeCars(carNames);

        // move cars
        RacingResultView.printStartRacing();
        moveCars(cars, targetDistance);

        // print winner
        RacingResultView.printResult(getWinnerNames(cars));
    }

    public void startRacing(String carNames, int targetDistance) {
        startRacing(RacingCarUtils.stringToList(carNames), targetDistance);
    }

    public String getWinnerNames(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winners = getWinnerCars(cars, maxDistance);

        return String.join(", ", winners);
    }

    public int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<String> getWinnerCars(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printCars(List<Car> cars) {
        cars.stream()
                .forEach(car -> RacingResultView.printNameAndDistance(car.getName(), car.getPosition()));
    }

    public List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars(List<Car> cars, int targetDistance) {
        for (int i = 0; i < targetDistance; i++) {
            moveCars(cars);
            printCars(cars);
            RacingResultView.printNewLine();

        }
    }

    public void moveCars(List<Car> cars) {
        cars.stream()
                .forEach(Car::move);
    }

}
