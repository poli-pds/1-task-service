package co.com.poli.task.controller;

import co.com.poli.task.persistence.entity.Task;
import co.com.poli.task.persistence.entity.TaskStatus;
import co.com.poli.task.services.TaskService;
import co.com.poli.task.services.dto.TaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return taskService.findAllByStatus(status);
    }

    @PostMapping()
    public Task create(@RequestBody TaskInDTO task){
        return taskService.create(task);
    }

    @PatchMapping("markTaskAsFinished/{taskId}")
    public Task markTaskAsFinished(@PathVariable ("taskId") Long taskId){
        return taskService.markTaskAsFinished(taskId);
    }

    @DeleteMapping("/{taskId}")
    public Task deleteTaskByTaskId(@PathVariable ("taskId") Long taskId){
        return taskService.deleteTaskById(taskId);
    }
}
