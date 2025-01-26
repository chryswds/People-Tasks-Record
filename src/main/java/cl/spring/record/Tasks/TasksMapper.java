package cl.spring.record.Tasks;

public class TasksMapper {

    public TasksMapper map(TasksDTO tasksDTO) {
        TasksMapper tasksMapper = new TasksMapper();
        tasksMapper.setId(tasksDTO.getId());
        tasksMapper.setName(tasksDTO.getName());
        tasksMapper.setTime_requested(tasksDTO.getTime_requested());
        tasksMapper.setPerson(tasksDTO.getPerson());
        return tasksMapper;
    }

    public TasksDTO map(TasksMapper tasksMapper) {
        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setId(tasksMapper.getId());
        tasksDTO.setName(tasksMapper.getName());
        tasksDTO.setTime_requested(tasksMapper.getTime_requested());
        tasksDTO.setPerson(tasksMapper.getPerson());
        return tasksDTO;
    }
}
