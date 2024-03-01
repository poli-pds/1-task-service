package co.com.poli.task.mapper;

import co.com.poli.task.persistence.entity.Task;
import co.com.poli.task.persistence.entity.TaskStatus;
import co.com.poli.task.services.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task mapper(TaskInDTO in) {
        Task task = new Task();
        task.setName(in.getName());
        task.setDescription(in.getDescription());
        task.setCreateDate(LocalDate.now());
        task.setFinished(false);
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }
}
