-- ==========================================
-- CREACIÓN DEL MODELO EN ESTRELLA
-- ==========================================

-- 1. TABLA DE DIMENSIÓN: Territorio

CREATE TABLE territorio (
    id SERIAL PRIMARY KEY,
    codigo_territorio VARCHAR (20) UNIQUE NOT NULL,
    descripcion_territorio VARCHAR (100) NOT NULL
);

-- 2. TABLA DE DIMENSIÓN: Sector Económico

CREATE TABLE sector(
   id SERIAL PRIMARY KEY,
   codigo_sector VARCHAR (20) UNIQUE NOT NULL,
   descripcion_sector VARCHAR (100) NOT NULL
);

-- 3. TABLA DE HECHOS: Registro de Empleo

CREATE TABLE registro_empleos (
  id BIGSERIAL PRIMARY KEY,
  id_territorio INTEGER NOT NULL REFERENCES territorio(id),
  id_sector INTEGER NOT NULL REFERENCES sector(id),
  año INTEGER NOT NULL,
  trimestre INTEGER NOT NULL CHECK (trimestre BETWEEN 1 AND 4),
  puestos NUMERIC(15, 2) NOT NULL,
  CONSTRAINT registro_empleos_unicos UNIQUE (id_territorio, id_sector, año, trimestre)
);

-- 4. ÍNDICES

CREATE INDEX idx_empleos_busqueda ON registro_empleos(id_sector, año, trimestre);
CREATE INDEX idx_empleos_temporal ON registro_empleos(año, trimestre);
