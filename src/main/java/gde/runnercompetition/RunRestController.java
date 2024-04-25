package gde.runnercompetition;

import gde.runnercompetition.RaceEntity;
import gde.runnercompetition.ResultEntity;
import gde.runnercompetition.RunnerEntity;
import gde.runnercompetition.RaceRepository;
import gde.runnercompetition.ResultRepository;
import gde.runnercompetition.RunnerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RunRestController {

    private final RunnerRepository runnerRepository;
    private final ResultRepository resultRepository;
    private final RaceRepository raceRepository;

    @GetMapping("/getRunners")
    public List<RunnerEntity> getRunners() {
        return runnerRepository.findAll();
    }

    @PostMapping("/addRunner")
    public ResponseEntity<String> addRunner(@RequestBody RunnerEntity runner) {
        try {
            runnerRepository.save(runner);
            return ResponseEntity.ok("Futó sikeresen hozzáadva!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hiba történt a futó hozzáadása közben!");
        }
    }

    @GetMapping("/getRaceRunners/{id}")
    public List<Object[]> getRaceRunnersById(@PathVariable Long id) {
        return resultRepository.findRunnerNamesAndResultsByRaceIdOrderByTimeInMinutesAsc(id);
    }

    @PostMapping("/updateRace")
    public ResponseEntity<String> updateRace(@RequestBody RaceUpdate raceUpdate) {
        var race = new RaceEntity();
        race.setRaceId(raceUpdate.raceId());
        race.setRaceName(raceUpdate.raceName());
        race.setRaceDistance(raceUpdate.raceDistance());
        raceRepository.save(race);
        return ResponseEntity.ok("A verseny sikeresen frissítve!");
    }

    @PostMapping("/addResult")
    public ResponseEntity<String> addResult(@RequestBody AddResultEntity resultData) {
        var runnerId = resultData.runnerId();
        var raceId = resultData.raceId();

        var runner = runnerRepository.findById(runnerId)
                .orElse(null);
        var race = raceRepository.findById(raceId)
                .orElse(null);

        var newResult = new ResultEntity();
        newResult.setRunner(runner);
        newResult.setRace(race);
        newResult.setTimeInMinutes(resultData.resultTimeInMinutes());

        resultRepository.save(newResult);
        return ResponseEntity.ok("Az új eredmény sikeresen hozzáadva!");
    }

    @GetMapping("/getAverageTime/{raceId}")
    public ResponseEntity<Double> getAverageTime(@PathVariable Long raceId) {
        var averageTime = resultRepository.getAverageTimeByRace(raceId);
        return ResponseEntity.ok(averageTime);
    }

    public record RaceUpdate(long raceId, String raceName, int raceDistance) {

    }

    public record AddResultEntity(long resultId, long raceId, long runnerId, int resultTimeInMinutes) {

    }

}
