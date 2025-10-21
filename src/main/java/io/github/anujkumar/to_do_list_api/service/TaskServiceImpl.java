package io.github.anujkumar.to_do_list_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anujkumar.to_do_list_api.entity.Task;
import io.github.anujkumar.to_do_list_api.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository tr;

    @Override
    public Task createTask(Task task) {
        return tr.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return tr.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return tr.findTaskById(id);
    }

    @Override
    public boolean updateTask(Long id, Task task) {
        Task t = tr.findTaskById(id);
        if (t == null) {
            return false;
        }
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setStatus(task.getStatus());
        t.setPriority(task.getPriority());
        t.setTitle(task.getTitle());
        t.setDueDate(task.getDueDate());
        tr.save(t);
        return true;
    }

    @Override
    public boolean deleteTaskByID(Long id) {
        Optional<Task> t = tr.findById(id);
        if (t.isPresent()) {
            tr.delete(t.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllTask() {
        List<Task>t=tr.findAll();    
        if (t.isEmpty()) {
            return false;
        }
        tr.deleteAll(t);
        return true;
    }

}
