# Modelo Relacional - Andalucia DataHub

## Tablas de Dimensiones (Categorías)

### 1. Tabla: `territory` (Territorio)
Guarda las regiones o provincias.
- `id` (PK, Serial)
- `code` (VARCHAR, Unique) -> ej. 'C01'
- `name` (VARCHAR) -> ej. 'Andalucía'

### 2. Tabla: `sector` (Sectores Económicos)
Guarda la jerarquía de sectores.
- `id` (PK, Serial)
- `code` (VARCHAR, Unique) -> ej. 'PA.04.01'
- `name` (VARCHAR) -> ej. 'Comercio, transporte y hostelería'
- `parent_id` (FK -> sector.id, Nullable) -> Permite anidar subsectores.

## Tabla de Hechos (Métricas)

### 3. Tabla: `employment_record` (Registro de Empleo)
Guarda el número real de puestos de trabajo.
- `id` (PK, Serial)
- `territory_id` (FK -> territory.id)
- `sector_id` (FK -> sector.id)
- `year` (INTEGER) -> ej. 2026
- `quarter` (INTEGER) -> ej. 1
- `puestos` (NUMERIC o DOUBLE) -> ej. 850585.0

## Auditoría Técnica del Modelo (Respuestas al Roadmap)

### 1. ¿Qué representa una fila?
Representa el volumen de puestos de trabajo asalariados medidos en un trimestre del año para un sector económico concreto en el territorio de Andalucía (Datos Brutos).

### 2. Definición de Unicidad
La unicidad está blindada mediante una constraint UNIQUE compuesta por: `territory_id` + `sector_id` + `year` + `quarter`. Es imposible tener dos registros para el mismo sector en el mismo trimestre y lugar.

### 3. Estrategia de Indexación para Consultas del Dashboard
Para garantizar respuestas en menos de 10ms desde la API REST, implementaremos los siguientes índices en PostgreSQL:

1. `idx_employment_lookup`: Compuesto por `(sector_id, year, quarter)`. Optimiza la consulta de líneas temporales para gráficos de Apache ECharts.
2. `idx_employment_temporal`: Sobre `(year, quarter)`. Optimiza las fotos fijas de tarta o barras para comparar todos los sectores en un trimestre concreto.