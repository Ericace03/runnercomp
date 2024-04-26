package gde.runnercompetition;

import gde.runnercompetition.ResultEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

    @Query("SELECT r.runner.runnerName, r.timeInMinutes FROM ResultEntity r WHERE r.race.raceId = ?1 ORDER BY r.timeInMinutes")
    List<Object[]> findRunnerNamesAndResultsByRaceIdOrderByTimeInMinutesAsc(Long raceId);

    @Query("SELECT AVG(r.timeInMinutes) FROM ResultEntity r WHERE r.race.raceId = ?1")
    Double getAverageTimeByRace(Long raceId);

    @Query("SELECT r.race.raceName, r.runner.runnerName, r.timeInMinutes FROM ResultEntity r ORDER BY r.race.raceName, r.timeInMinutes")
    List<Object[]> findAllRunnerNamesAndResults();
}
