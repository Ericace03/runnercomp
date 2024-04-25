package gde.runnercompetition;

import gde.runnercompetition.RaceEntity;
import gde.runnercompetition.ResultEntity;
import gde.runnercompetition.RunnerEntity;
import gde.runnercompetition.RaceRepository;
import gde.runnercompetition.ResultRepository;
import gde.runnercompetition.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    @Override
    public void run(String... args) {

        RunnerEntity runner1 = new RunnerEntity("Aladár", 25, "férfi");
        RunnerEntity runner2 = new RunnerEntity("Béla", 30, "férfi");
        RunnerEntity runner3 = new RunnerEntity("Csilla", 28, "nő");
        RunnerEntity runner4 = new RunnerEntity("Dia", 27, "nő");

        runnerRepository.save(runner1);
        runnerRepository.save(runner2);
        runnerRepository.save(runner3);
        runnerRepository.save(runner4);

        RaceEntity race1 = new RaceEntity("Maraton", 42195);
        RaceEntity race2 = new RaceEntity("Félmaraton", 21097);

        raceRepository.save(race1);
        raceRepository.save(race2);

        ResultEntity result1 = new ResultEntity(runner1, race1, 261);
        ResultEntity result2 = new ResultEntity(runner1, race2, 120);
        ResultEntity result3 = new ResultEntity(runner2, race1, 270);
        ResultEntity result4 = new ResultEntity(runner3, race2, 134);

        resultRepository.save(result1);
        resultRepository.save(result2);
        resultRepository.save(result3);
        resultRepository.save(result4);

    }
}
