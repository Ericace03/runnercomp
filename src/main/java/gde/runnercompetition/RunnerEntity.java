package gde.runnercompetition;
import jakarta.persistence.*;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private int runnerAge;
    private String runnerGender;

    public RunnerEntity() {
    }

    public RunnerEntity(String name, int age, String gender) {
        this.runnerName = name;
        this.runnerAge = age;
        this.runnerGender = gender;
    }

    public Long getRunnerId() {return runnerId;}

    public void setRunnerId(long runnerId) {this.runnerId = runnerId;}

    public String getRunnerName() {return runnerName;}

    public void setRunnerName(String runnerName) {this.runnerName = runnerName;}

    public int getRunnerAge() {return runnerAge;}

    public void setRunnerAge(int runnerAge) {this.runnerAge = runnerAge;}

    public String getRunnerGender() {return runnerGender;}

    public void setRunnerGender(String runnerGender) {this.runnerGender = runnerGender;}

}