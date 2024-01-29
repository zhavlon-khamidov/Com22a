package kg.alatoo.helloworld.controllers;


import kg.alatoo.helloworld.entity.Task;
import kg.alatoo.helloworld.repositories.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

