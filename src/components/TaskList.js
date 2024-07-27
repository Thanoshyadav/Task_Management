import React from 'react';
import './TaskList.css';
function TaskList({ tasks, updateTask }) {
    const handleComplete = (id) => {
        updateTask(id, { completed: true });
    };

    return (
        <ul>
            {tasks.map(task => (
                <li key={task.id}>
                    {task.title} - {task.completed ? 'Completed' : 'Pending'}
                    <button onClick={() => handleComplete(task.id)}>Complete</button>
                </li>
            ))}
        </ul>
    );
}

export default TaskList;
