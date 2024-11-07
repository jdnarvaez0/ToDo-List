package com.todolist.crud.controller;

import com.todolist.crud.model.Task;
import com.todolist.crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    // Crear una nueva tarea
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Obtener todas las tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una tarea
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task taskDetails) {
        return taskRepository.findById(id)
            .map(task -> {
                task.setTitle(taskDetails.getTitle());
                task.setCompleted(taskDetails.isCompleted());
                Task updatedTask = taskRepository.save(task);
                return ResponseEntity.ok(updatedTask);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable String id) {
        return taskRepository.findById(id)
            .map(task -> {
                taskRepository.delete(task);
                return ResponseEntity.noContent().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
