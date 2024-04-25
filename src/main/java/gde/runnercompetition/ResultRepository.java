package gde.runnercompetition;

import gde.runnercompetition.ResultEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
}
