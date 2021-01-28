package main;

import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import main.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
    }

    @Autowired
    private TaskRepository taskRepository;

    //создание дела
    @PostMapping("/tasks")
    public int add(@RequestBody Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    //удаление дела
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ошибка! Не найде задача с номером " + id);
        } else
            taskRepository.deleteById(id);
        return new ResponseEntity(getAllTasks(), HttpStatus.OK);
    }

    //обновление дела
    @PutMapping("/tasks/{id}")
    public ResponseEntity updateTask(@RequestBody Task task) {
        Optional<Task> optionalTask = taskRepository.findById(task.getId());
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ошибка! Не найде задача с номером " + task.getId());
        } else
            taskRepository.save(task);
        return new ResponseEntity(getAllTasks(), HttpStatus.OK);
    }


    //получение списка дел
    @GetMapping("/tasks")
    public List<Task> tasks() {
        return getAllTasks();
    }

    //удаление всего списка дел
    @DeleteMapping("/tasks")
    public List<Task> clearAll() {
        taskRepository.deleteAll();
        return getAllTasks();
    }

    //получение отдельного дела
    @GetMapping("/tasks/{id}")
    public ResponseEntity getTask(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.map(value -> new ResponseEntity(value, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ошибка! Не найде задача с номером " + id));
    }

    //обновление некольких дел
    @PutMapping("/tasks")
    public ResponseEntity updateAll(@RequestBody Task... tasks) {
        int id;
        for (Task task : tasks) {
            id = task.getId();
            Optional<Task> optionalTask = taskRepository.findById(id);
            if (!optionalTask.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ошибка! Не найде задача с номером " + task.getId());
            } else
                taskRepository.save(task);
        }
        return new ResponseEntity(getAllTasks(), HttpStatus.OK);
    }

    private List<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }
}
