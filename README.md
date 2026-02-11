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
