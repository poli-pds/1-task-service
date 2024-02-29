package co.com.poli.task.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long taskID;
    private String name;
    private String description;
    @Column(name = "create_date")
    private LocalDate createDate;
    private boolean finished;
    private TaskStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskID, task.taskID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskID);
    }
}
