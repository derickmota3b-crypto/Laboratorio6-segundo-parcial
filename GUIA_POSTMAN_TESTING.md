# Guía de Testing con Postman - Laboratorio VI (Segundo Parcial)

## Información General

Tienes 3 aplicaciones REST para probar:
- **Ejercicio 4**: Biblioteca (Gestión de Libros)
- **Ejercicio 5**: Universidad (Gestión de Cursos)
- **Ejercicio 6**: Hotel (Gestión de Reservas)

---

## ⚡ INICIAR LAS APLICACIONES

Abre 3 terminales PowerShell diferentes y ejecuta:

### Terminal 1 - Ejercicio 4 (Biblioteca)
```powershell
cd 'c:\Users\Derick Mota\LaboratorioVI-segundo-parcial\ejercicio4'
.\gradlew.bat bootRun
```
**Puerto**: 8080 (o el que asigne automáticamente)
**Base URL**: `http://localhost:8080`

### Terminal 2 - Ejercicio 5 (Universidad)
```powershell
cd 'c:\Users\Derick Mota\LaboratorioVI-segundo-parcial\ejercicio5'
.\gradlew.bat bootRun
```
**Puerto**: 8081 (o el que asigne automáticamente)
**Base URL**: `http://localhost:8081`

### Terminal 3 - Ejercicio 6 (Hotel)
```powershell
cd 'c:\Users\Derick Mota\LaboratorioVI-segundo-parcial\ejercicio6'
.\gradlew.bat bootRun
```
**Puerto**: 8082 (o el que asigne automáticamente)
**Base URL**: `http://localhost:8082`

---

## 📚 EJERCICIO 4 - BIBLIOTECA (5 Libros Inicializados)

### 1. GET - Listar todos los libros
```
Método: GET
URL: http://localhost:8080/libros
```

Respuesta esperada: Array con 5 libros (Cien años de soledad, Don Quijote, etc.)

### 2. GET - Buscar libro por título
```
Método: GET
URL: http://localhost:8080/libros?titulo=Quijote
```

### 3. POST - Crear nuevo libro
```
Método: POST
URL: http://localhost:8080/libros
Header: Content-Type: application/json

Body:
{
  "titulo": "La Metamorfosis",
  "autor": "Franz Kafka",
  "isbn": "978-8408013456",
  "anioPublicacion": 1915,
  "estado": "Disponible"
}
```

### 4. PUT - Actualizar libro
```
Método: PUT
URL: http://localhost:8080/libros/1
Header: Content-Type: application/json

Body:
{
  "titulo": "Cien años de soledad (Edición revisada)",
  "autor": "Gabriel García Márquez",
  "isbn": "978-8401405232",
  "anioPublicacion": 1967,
  "estado": "Prestado"
}
```

### 5. DELETE - Eliminar libro
```
Método: DELETE
URL: http://localhost:8080/libros/1
```

---

## 🎓 EJERCICIO 5 - UNIVERSIDAD (4 Cursos Inicializados)

### 1. GET - Listar todos los cursos
```
Método: GET
URL: http://localhost:8081/cursos
```

Respuesta: 4 cursos (Programación Java, Spring Boot, BD SQL, Estructuras de Datos)

### 2. GET - Obtener curso por código
```
Método: GET
URL: http://localhost:8081/cursos/JAVA101
```

### 3. POST - Crear nuevo curso
```
Método: POST
URL: http://localhost:8081/cursos
Header: Content-Type: application/json

Body:
{
  "nombre": "Programación Python",
  "codigo": "PYTHON101",
  "creditos": 4,
  "estado": "Activo"
}
```

### 4. PUT - Actualizar curso
```
Método: PUT
URL: http://localhost:8081/cursos/1
Header: Content-Type: application/json

Body:
{
  "nombre": "Programación Java Avanzada",
  "codigo": "JAVA201",
  "creditos": 4,
  "estado": "Activo"
}
```

### 5. DELETE - Eliminar curso
```
Método: DELETE
URL: http://localhost:8081/cursos/1
```

---

## 🏨 EJERCICIO 6 - HOTEL (5 Reservas Inicializadas)

### 1. GET - Listar todas las reservas
```
Método: GET
URL: http://localhost:8082/reservas
```

Respuesta: 5 reservas (Juan Pérez, María García, Carlos López, Ana Martínez, Roberto Sánchez)

### 2. GET - Obtener reserva por ID
```
Método: GET
URL: http://localhost:8082/reservas/1
```

### 3. POST - Crear nueva reserva
```
Método: POST
URL: http://localhost:8082/reservas
Header: Content-Type: application/json

Body:
{
  "nombreCliente": "Diego Rodríguez",
  "habitacion": "404",
  "fechaEntrada": "2026-10-10",
  "fechaSalida": "2026-10-15",
  "estado": "CONFIRMADA"
}
```

### 4. PUT - Actualizar reserva
```
Método: PUT
URL: http://localhost:8082/reservas/1
Header: Content-Type: application/json

Body:
{
  "nombreCliente": "Juan Pérez López",
  "habitacion": "105",
  "fechaEntrada": "2026-09-22",
  "fechaSalida": "2026-09-27",
  "estado": "CONFIRMADA"
}
```

### 5. PATCH - Cancelar reserva
```
Método: PATCH
URL: http://localhost:8082/reservas/4
```

Respuesta: Reserva con estado CANCELADA

---

## ✅ DATOS INICIALIZADOS

### Ejercicio 4 - Libros:
1. Cien años de soledad - Gabriel García Márquez (1967) - Disponible
2. Don Quijote de la Mancha - Miguel de Cervantes (1605) - Disponible
3. El Quijote Volumen 2 - Miguel de Cervantes (1615) - Prestado
4. Crimen y Castigo - Fiódor Dostoyevski (1866) - Disponible
5. Orgullo y Prejuicio - Jane Austen (1813) - Disponible

### Ejercicio 5 - Cursos:
1. Programación Java (JAVA101) - 4 créditos - Activo
2. Desarrollo Web con Spring Boot (SPRING201) - 4 créditos - Activo
3. Base de Datos SQL (BD301) - 3 créditos - Activo
4. Estructuras de Datos (EDAT401) - 4 créditos - Activo

### Ejercicio 6 - Reservas:
1. Juan Pérez - Habitación 101 - 22-25 Sep 2026 - CONFIRMADA
2. María García - Habitación 205 - 23-27 Sep 2026 - CONFIRMADA
3. Carlos López - Habitación 301 - 25 Sep-1 Oct 2026 - CONFIRMADA
4. Ana Martínez - Habitación 102 - 30 Sep-3 Oct 2026 - PENDIENTE
5. Roberto Sánchez - Habitación 303 - 5-8 Oct 2026 - CONFIRMADA