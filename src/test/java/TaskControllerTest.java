import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSaveATaskWithoutDescription() {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());

        try {
            taskController.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveATaskWithoutDate() {
        Task todo = new Task();
        todo.setTask("New Task");
        // todo.setDueDate(LocalDate.now());

        try {
            taskController.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveATaskWithPastDate() {
        Task todo = new Task();
        todo.setTask("New Task");
        todo.setDueDate(LocalDate.of(2020, 01, 01));

        try {
            taskController.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void shouldSaveATaskSuccessfully() throws ValidationException {
        Task todo = new Task();
        todo.setTask("New Task");
        todo.setDueDate(LocalDate.now());
        taskController.save(todo);
        
        Mockito.verify(taskRepo).save(todo);
    }
}
