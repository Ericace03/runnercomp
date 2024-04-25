package gde.runnercompetition;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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

    public ResultEntity(RunnerEntity runner, RaceEntity race, int timeInMinutes) {
        this.runner = runner;
        this.race = race;
        this.timeInMinutes = timeInMinutes;
    }
}