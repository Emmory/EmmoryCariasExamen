# 🏦 Sistema de Administración de Cuentas y Chequeras - CHN

Este proyecto es parte del Examen Práctico para el puesto de **Analista Programador** en el Crédito Hipotecario Nacional de Guatemala.

## 📌 Descripción

Sistema web completo para la gestión de:

- Clientes
- Cuentas de ahorro y monetarias
- Chequeras asociadas a cuentas monetarias
- Cheques (registro, estado, movimientos)

Incluye interfaz web (Vue.js), backend REST (Spring Boot), base de datos MySQL y contenedores Docker.

---

## 🚀 Tecnologías utilizadas

| Componente    | Tecnología               |
|---------------|---------------------------|
| Frontend      | Vue.js + Vite             |
| Backend       | Java 17 + Spring Boot 3   |
| Base de datos | MySQL 8                   |
| Gestión BD    | PhpMyAdmin                |
| Persistencia  | Spring Data JPA           |
| Contenedores  | Docker + Docker Compose   |
| Pruebas       | JUnit 5 + Mockito         |

---

## ⚙️ Estructura del proyecto

sistema-cuentas/ ├── backend/ # Spring Boot API ├── frontend/frontend-cuentas/ # Vue + Vite frontend ├── docker-compose.yml # Orquestación de servicios ├── README.md # Este archivo └── db/init.sql # Script inicial (opcional)



---

## 🐳 Cómo ejecutar el sistema con Docker

1. Clona este repositorio
2. Posiciónate en la carpeta raíz del proyecto
3. Ejecuta:

```bash
docker-compose up --build



Este comando levantará:

🔁 MySQL en localhost:3307

📊 PhpMyAdmin en http://localhost:8080

🧠 Backend Spring Boot en http://localhost:8081

🌐 Frontend Vue en http://localhost:5173

🧪 Pruebas unitarias
Se incluyen al menos 3 pruebas unitarias con JUnit 5 y Mockito:

ClienteServiceTest

CuentaServiceTest

ChequeServiceTest


🗂�?Script de base de datos
Se encuentra en la carpeta llamada script.sql o se puede encontrar en
\Documentos\sistema-cuentas\backend\cuentas\src\main\resources en esta ruta se genera automaticamente



🧭 Diagrama Entidad-Relación
se encuentra en documento word en la ruta
Documentos\Diagrama_Entidad_Relacion


👨‍�?Autor
Emmory Carias Gonzalez
Candidato al puesto de Analista Programador
Crédito Hipotecario Nacional de Guatemala


📬 Contacto
Correo de entrega:cariasemory@gmail.com


Repositorio Github
https://github.com/Emmory/EmmoryCariasExamen
