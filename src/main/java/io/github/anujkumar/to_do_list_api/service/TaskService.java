package io.github.anujkumar.to_do_list_api.service;

import java.util.List;

import io.github.anujkumar.to_do_list_api.entity.Task;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long id);
    boolean updateTask(Long id,Task task);
    boolean deleteTaskByID(Long id);
    boolean deleteAllTask();
}
