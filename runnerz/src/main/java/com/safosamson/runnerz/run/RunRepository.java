package com.safosamson.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// the @Repository annotation tells Spring that this class will handle data access
@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(int id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run,Integer id){
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id){
      runs.removeIf(run -> run.id().equals(id));
    }

    // PostConstruct annotation is used to perform operations after dependency injection is done to perform any initialization.
    // particularly in this file, it is used to initialize the runs list with some data.
    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 3, Location.INDOOR));
        runs.add(new Run(3, "Afternoon Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 4, Location.OUTDOOR));
    }
}
