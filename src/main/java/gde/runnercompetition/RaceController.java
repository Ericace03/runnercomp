package gde.runnercompetition;

import gde.runnercompetition.RaceEntity;
import gde.runnercompetition.RaceRepository;
import gde.runnercompetition.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class RaceController {

    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    @GetMapping("/races")
    public String listRaces(Model model) {
        var races = raceRepository.findAll();
        model.addAttribute("races", races);
        return "race-list";
    }

    @GetMapping("/addRace")
    public String getRaceForm(Model model) {
        model.addAttribute("raceData", new RaceEntity());
        return "new-race";
    }

    @PostMapping("/addRace")
    public String addRace(@RequestParam("raceName") String raceName, @RequestParam("raceDistance") int raceDistance) {
        var newRace = new RaceEntity(raceName, raceDistance);
        raceRepository.save(newRace);
        return "redirect:/races";
    }

    @GetMapping("/race-details")
    public String showAllRaceDetails(Model model) {
        var runnerDetails = resultRepository.findAllRunnerNamesAndResults();
        var races = raceRepository.findAll();
        model.addAttribute("runners", runnerDetails);
        model.addAttribute("race", races);
        return "race-details";
    }
}