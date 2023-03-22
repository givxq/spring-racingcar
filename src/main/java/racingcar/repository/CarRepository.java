package racingcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import racingcar.domain.Car;

public interface CarRepository extends JpaRepository<Car, String> {
    // Car move(Car car);

    Car save(Car car);

    Optional<Car> findByName(String name);

    List<Car> findAll();
}
