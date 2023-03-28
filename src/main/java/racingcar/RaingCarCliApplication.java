package racingcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import racingcar.controller.RacingCarController;
import racingcar.repository.CarsConsoleRepository;
import racingcar.repository.PlayResultCliRepository;
import racingcar.view.RacingInputCarView;

@Profile("!test")
@Component
public class RaingCarCliApplication implements CommandLineRunner {
    @Autowired
    CarsConsoleRepository carsConsoleRepository;

    @Autowired
    PlayResultCliRepository playResultCliRepository;

    @Override
    public void run(String... args) throws Exception {
        RacingCarController racingCarController = new RacingCarController(null, carsConsoleRepository, null,
                playResultCliRepository);

        while (true) {
            String carNames = RacingInputCarView.getCarNames();
            int targetDistance = RacingInputCarView.getTargetDistance();
            racingCarController.consoleRacingGame(carNames, targetDistance);
        }
    }

}