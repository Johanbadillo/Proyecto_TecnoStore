# TecnoStore - Sistema de Gestión de Tienda Tecnológica

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=Java&logoColor=white)
![Maven](https://img.shields.io/badge/Apache-C71A36?style=for-the-badge&logo=Apache&logoColor=white)

Un aplicativo en **Java** que implementa los principios **SOLID** y operaciones **CRUD** completas para las principales entidades de una tienda tecnológica.

## ✨ Características principales

- Arquitectura limpia siguiendo los **principios SOLID**
- Operaciones CRUD completas para todas las entidades principales
- Diseño orientado a objetos con buena separación de responsabilidades
- Capa de persistencia con scripts SQL listos para usar
- Proyecto gestionado con **Apache**

## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java 
- **Base de datos**: MySQL
- Principios de diseño: **SOLID** (Single Responsibility, Open-Closed, Liskov Substitution, Interface Segregation, Dependency Inversion)

## 📂 Estructura del proyecto

```
Proyecto_TecnoStore/
├── src/
│   └── main/
│       └── java/
│           ├──com/             <- El paquete de trabajo
│           ├── model/          <- Entidades 
│           ├── controlador/    <- Lógica de negocio
│           └── vista/          <- Visibilidad por parte del usuario
├── script.sql                  <- Script de creación de base de datos + datos de prueba
├── pom.xml                     <- Configuración de Maven
└── README.md
```

## 🚀 Instalación y ejecución

### 1. Requisitos previos

- Java 11 o superior
- Motor de base de datos MySQL

### 2. Pasos para ejecutar

- 1. Clonar el repositorio
```
git clone https://github.com/Johanbadillo/Proyecto_TecnoStore.git
cd Proyecto_TecnoStore
```

- 2. Crear la base de datos y tablas

Aqui copia y pega el contenido de [script.sql](script.sql)

- 3.  Ejecutar la aplicación En tu aplicacion o consola


## 📋 Entidades principales (CRUD implementado)

Celulares

Ventas

Clientes

Factura

Detalle de venta

Empleados

---

Crear (Create)

Leer (Read) – individual y listado

Actualizar (Update)

Eliminar (Delete)

## **👨‍💻 Autor** 
<div align="center">


**Hecho con 🍕 y ❤️ para la Pizzería Don Piccolo**

<div>
