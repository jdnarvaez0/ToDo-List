import axios from 'axios';

export interface Tarea {
    id: number;
    title: string;
}

const api = axios.create({
    baseURL: 'http://localhost:8080/api', // URL base de tu backend
});

export const getTareas = async () => {
    try {
        const response = await api.get('/tasks');
        return response.data;
    } catch (error) {
        console.error('Error al obtener las tareas:', error);
        throw error;
    }
};

export default api;
