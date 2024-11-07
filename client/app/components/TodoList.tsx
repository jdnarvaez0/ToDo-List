'use client';

import React, { useEffect, useState } from 'react';
import { getTareas, Tarea } from '../../services/api';

const TodoList = () => {
    const [tareas, setTareas] = useState<Tarea[]>([]); 

    useEffect(() => {
        const fetchTareas = async () => {
            try {
                const tareasData = await getTareas(); 
                console.log("Tareas cargadas:", tareasData); // <--- Revisa las tareas cargadas
                setTareas(tareasData);
            } catch (error) {
                console.error('Error al cargar las tareas:', error);
            }
        };

        fetchTareas();
    }, []);

    return (
        <div>
            <h1>Lista de Tareas</h1>
            <ul>
                {tareas.map((tarea) => (
                    <li key={tarea.id}>{tarea.title}</li> 
                ))}
            </ul>
        </div>
    );
};

export default TodoList;
