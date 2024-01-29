package kg.alatoo.helloworld.controllers;


import kg.alatoo.helloworld.entity.Task;
import kg.alatoo.helloworld.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    private final TaskRepository taskRepo;

    public ApiController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("task")
    public Iterable<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @GetMapping("task/{id}")
    public Task getSingleTask(@PathVariable Long id) {
        return taskRepo.findById(id).orElseThrow();
    }

    @PostMapping("task")
    public Task createTask(@RequestBody Task task) {
        task.setId(null);
        return taskRepo.save(task);
    }

    @PutMapping("task/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id){
        if (taskRepo.existsById(id)) {
            task.setId(id);
            return taskRepo.save(task);
        } else {
            throw new NoSuchElementException();
        }
    }


    @DeleteMapping("task/{id}")
    public Task deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        taskRepo.deleteById(id);
        return optionalTask.orElseThrow();
    }
}

