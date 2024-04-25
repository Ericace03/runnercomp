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
}
