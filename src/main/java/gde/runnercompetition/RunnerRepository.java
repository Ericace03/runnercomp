package gde.runnercompetition;

import gde.runnercompetition.RunnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<RunnerEntity, Long> {

}
