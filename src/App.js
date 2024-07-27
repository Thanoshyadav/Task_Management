import React, { useState, useEffect } from 'react';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';
import io from 'socket.io-client';
import './App.css';

const socket = io('http://localhost:4040/ws/tasks');

function App() {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetch('http://localhost:4040/api/tasks')
            .then(response => response.json())
            .then(data => setTasks(data));

        socket.on('task-update', (updatedTask) => {
            setTasks(prevTasks => {
                return prevTasks.map(task =>
                    task.id === updatedTask.id ? updatedTask : task
                );
            });
        });

        return () => {
            socket.off('task-update');
        };
    }, []);

    const addTask = (task) => {
        fetch('http://localhost:4040/api/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(task)
        })
        .then(response => response.json())
        .then(data => {
            setTasks(prevTasks => [...prevTasks, data]);
            socket.emit('task-update', data);
        });
    };

    const updateTask = (id, updates) => {
        fetch(`http://localhost:4040/api/tasks/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updates)
        })
        .then(response => response.json())
        .then(data => {
            setTasks(prevTasks => {
                return prevTasks.map(task =>
                    task.id === id ? data : task
                );
            });
            socket.emit('task-update', data);
        });
    };

    return (
        <div>
            <TaskForm addTask={addTask} />
            <TaskList tasks={tasks} updateTask={updateTask} />
        </div>
    );
}

export default App;
