package com.safosamson.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

// the @RestController annotation tells Spring that this class will handle incoming HTTP requests, and
// the response will be sent back as JSON by default
@RestController
@RequestMapping("/api/runs") // the @RequestMapping annotation tells Spring that this class will handle requests for the /api/runs URL as as root URL
public class RunController {

    private final RunRepository runRepository;

    // the @Autowired annotation tells Spring to inject the RunRepository dependency into this class, its implicit now so
    // we can remove it
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // the @GetMapping annotation tells Spring that this method will handle GET requests for the root URL
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }
    // @PathVariable annotation tells Spring to bind the value of the id parameter in the URL to the id parameter in the method
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isPresent()) {
            return run.get();
        } else {
            throw new RunNotFoundException();
        }
    }
    // post method to create a new run
    @ResponseStatus(HttpStatus.CREATED) // the @ResponseStatus annotation tells Spring to return a 201 status code when this method is called
    @PostMapping("")
    void create(@RequestBody Run run) {
        runRepository.create(run);
    }
    // put method to update a run

    @ResponseStatus(HttpStatus.NO_CONTENT) // the @ResponseStatus annotation tells Spring to return a 204 status code , meaning the request was successful but no content is returned
    @PutMapping("/{id}")
    // the @Valid annotation tells Spring to validate the request body before calling this method
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }
    // delete method to delete a run
    @ResponseStatus(HttpStatus.NO_CONTENT) // the @ResponseStatus annotation tells Spring to return a 204 status code , meaning the request was successful but no content is returned
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

}
