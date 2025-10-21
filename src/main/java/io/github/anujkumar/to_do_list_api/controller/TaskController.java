package io.github.anujkumar.to_do_list_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anujkumar.to_do_list_api.entity.Task;
import io.github.anujkumar.to_do_list_api.service.TaskService;

@RestController
@RequestMapping("/todo")
public class TaskController {
    @Autowired
    private TaskService ts;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            if (task != null) {
                Task t = ts.createTask(task);
                return new ResponseEntity<>(t, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTask() {
        try {
            List<Task> t = ts.getAllTask();
            if (!t.isEmpty()) {
                return new ResponseEntity<>(t, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTask/{id}")
    public ResponseEntity<Task> getMethodName(@PathVariable Long id) {
        try {
            Task t = ts.getTaskById(id);
            if (t != null) {
                return new ResponseEntity<Task>(t, HttpStatus.FOUND);
            }
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("upd/{id}")
    public ResponseEntity<?> updTask(@PathVariable Long id, @RequestBody Task t) {
        try {
            if (ts.updateTask(id, t)) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteTaskByID(@PathVariable Long id) {
        try {
            if (ts.deleteTaskByID(id)) {
                return ResponseEntity.noContent().build(); // 204 No Content
            } else {
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
    @DeleteMapping("/delAll")
    public ResponseEntity<Void> deleteAllTask() {
        try {
            if (ts.deleteAllTask()) {
                return ResponseEntity.noContent().build(); // 204 No Content
            } else {
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

}
