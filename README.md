# Todo List API con Spring Boot y Next.js

Este proyecto es una aplicación de **Lista de Tareas** que incluye un backend creado en **Spring Boot** y un frontend desarrollado en **Next.js**. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una lista de tareas, y el frontend proporciona una interfaz de usuario para interactuar con esta API.

## Estructura del Proyecto

La estructura del proyecto se divide en dos partes principales:

- **Backend (API)**: Construido en **Java** usando **Spring Boot**. Este servicio proporciona los endpoints RESTful para gestionar las tareas.
- **Frontend (Cliente)**: Desarrollado con **Next.js**. Este cliente consume la API y permite a los usuarios interactuar con las tareas.

```
├todolist
├── crud/                 # Backend: API con Spring Boot
└── client/               # Frontend: Cliente con Next.js
```

## Tecnologías Utilizadas

- **Backend**:

  - Java
  - Spring Boot (con Spring Data, Spring Web)
  - MongoDB como base de datos para almacenar las tareas
  - Control de CORS configurado para permitir el acceso desde el frontend

- **Frontend**:

  - Next.js con TypeScript
  - Axios para realizar peticiones HTTP al backend
  - Tailwind CSS para el diseño básico de la interfaz

## Características

1.  **API RESTful**: El backend expone una serie de endpoints para gestionar la lista de tareas:

    - `GET /api/tasks` - Obtiene todas las tareas
    - `POST /api/tasks` - Crea una nueva tarea
    - `PUT /api/tasks/{id}` - Actualiza una tarea existente
    - `DELETE /api/tasks/{id}` - Elimina una tarea específica

2.  **Interfaz de Usuario (UI)**: El frontend de Next.js muestra una lista de tareas, permite agregar nuevas tareas, y realizar operaciones de edición y eliminación.

## Configuración del Proyecto

### Backend (API)

1.  **Instalar dependencias**: Ve a la carpeta `crud` y ejecuta:

```bash
    mvn install
```

2.  **Configuración de MongoDB**: Asegúrate de que MongoDB esté instalado y ejecutándose en tu máquina, y que la URI de conexión esté definida en el archivo `.env` del proyecto backend:

```bash
    MONGODB_URI=mongodb://127.0.0.1:27017/db_todolist
```

3.  **Iniciar el servidor**: Ejecuta el backend desde la carpeta `crud` con:

```bash
    mvn spring-boot:run
```

    Esto iniciará la API en `http://localhost:8080`.

### Frontend (Cliente)

1.  **Instalar dependencias**: Ve a la carpeta `client` y ejecuta:

```bash
    npm install
```

2.  **Configurar Axios**: Asegúrate de que el cliente esté configurado para apuntar al backend:

```typescript
const api = axios.create({
  baseURL: "http://localhost:8080/api",
});
```

3.  **Iniciar el servidor de desarrollo**: Ejecuta el cliente desde la carpeta `client` con:

```bash
    npm run dev
```

    Esto iniciará el frontend en `http://localhost:3000`.

## Uso

1.  Visita `http://localhost:3000` en tu navegador para acceder a la aplicación de lista de tareas.
2.  Puedes agregar, editar y eliminar tareas desde la interfaz.
3.  Las operaciones de la interfaz realizarán llamadas a la API REST en el backend para actualizar el estado de las tareas en la base de datos.

## Próximas Mejoras

- Autenticación de usuario para mayor seguridad en la API.
- Paginación y búsqueda en la lista de tareas.
- Añadir notificaciones para confirmación de operaciones.

## Licencia

Este proyecto está bajo la licencia MIT.
