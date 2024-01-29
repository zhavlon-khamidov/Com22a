package kg.alatoo.helloworld.repositories;

import kg.alatoo.helloworld.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {

}
