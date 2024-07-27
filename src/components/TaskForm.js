import React, { useState } from 'react';
import './TaskForm.css';

function TaskForm({ addTask }) {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [deadline, setDeadline] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        addTask({ title, description, deadline });
        setTitle('');
        setDescription('');
        setDeadline('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Title"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                required
            />
            <textarea
                placeholder="Description"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                required
            />
            <input
                type="datetime-local"
                value={deadline}
                onChange={(e) => setDeadline(e.target.value)}
                required
            />
            <button type="submit">Add Task</button>
        </form>
    );
}

export default TaskForm;
