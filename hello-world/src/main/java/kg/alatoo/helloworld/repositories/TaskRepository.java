package kg.alatoo.helloworld.repositories;

import kg.alatoo.helloworld.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TaskRepository extends CrudRepository<Task,Long> {

}
