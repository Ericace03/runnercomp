package gde.runnercompetition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

    @Entity
    public class RaceEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long raceId;
        private String raceName;
        private int raceDistance;

        public RaceEntity() {
        }

        public RaceEntity(String name, int distance) {
            this.raceName = name;
            this.raceDistance = distance;
        }
}
