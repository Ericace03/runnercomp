package gde.runnercompetition;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class RunnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private int runnerAge;
    private String runnerGender;

    public RunnerEntity(String name, int age, String gender) {
        this.runnerName = name;
        this.runnerAge = age;
        this.runnerGender = gender;
    }
}