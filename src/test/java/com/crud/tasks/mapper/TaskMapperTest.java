package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskMapperTest {
    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void mapToTask() throws Exception {
        // Given
        TaskDto taskDtoStub = new TaskDto(1L, "test task title", "test task content");

        // When
        Task fetchedTask = taskMapper.mapToTask(taskDtoStub);
        Long expectedId = 1L;


        //Then
        assertEquals(expectedId , fetchedTask.getId());
        assertEquals("test task title", fetchedTask.getTitle());
        assertEquals("test task content", fetchedTask.getContent());
    }

    @Test
    public void mapToTaskDto() throws Exception {
        // Given
        Task taskStub = new Task(1L, "test task title", "test task content");

        // When
        TaskDto fetchedTaskDto = taskMapper.mapToTaskDto(taskStub);
        Long expectedId = 1L;

        //Then
        assertEquals(expectedId , fetchedTaskDto.getId());
        assertEquals("test task title", fetchedTaskDto.getTitle());
        assertEquals("test task content", fetchedTaskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() throws Exception {
        // Given
        Task taskStub = new Task(1L, "test task title", "test task content");
        List<Task> taskListStub = new ArrayList<>();
        taskListStub.add(taskStub);

        // When
        List<TaskDto> fetchedTaskDtoList = taskMapper.mapToTaskDtoList(taskListStub);
        Long expectedId = 1L;
        List<TaskDto> fetchedEmptyTaskDtoList = taskMapper.mapToTaskDtoList(new ArrayList<>());

        //Then
        assertEquals(1 , fetchedTaskDtoList.size());
        assertEquals(expectedId, fetchedTaskDtoList.get(0).getId());
        assertEquals("test task title", fetchedTaskDtoList.get(0).getTitle());
        assertEquals("test task content", fetchedTaskDtoList.get(0).getContent());
        assertEquals(0, fetchedEmptyTaskDtoList.size());
    }
}