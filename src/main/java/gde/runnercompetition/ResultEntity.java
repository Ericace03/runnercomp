package gde.runnercompetition;
import jakarta.persistence.*;

@Entity
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    private RunnerEntity runner;

    @ManyToOne
    private RaceEntity race;

    private int timeInMinutes;

    public ResultEntity(){
    }

    public ResultEntity(RunnerEntity runner, RaceEntity race, int timeInMinutes) {
        this.runner = runner;
        this.race = race;
        this.timeInMinutes = timeInMinutes;
    }
}