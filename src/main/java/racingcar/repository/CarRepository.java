package racingcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import racingcar.domain.Car;
import racingcar.domain.CarID;

public interface CarRepository extends JpaRepository<Car, CarID> {
    // Car move(Car car);

    Car save(Car car);

    Optional<Car> findByName(String name);

    List<Car> findAll();
}
