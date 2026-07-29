# Análisis de la API del IECA (Puestos Asalariados)

## 1. Estructura del JSON
El JSON del gobierno no devuelve una lista simple, devuelve un "cubo de datos" con esta estructura:
- `metainfo`: Datos generales (título, fuente).
- `hierarchies`: Define las dimensiones (Tiempo, Territorio, Sector, Serie).
- `data`: Aquí vienen los datos reales. Es una lista enorme donde cada fila es un array de 5 elementos.

## 2. Anatomía de una fila de datos
Si cogemos un bloque de `data`, siempre tiene 5 posiciones exactas:
1. **Sector:** ej. `PA.01` (Agricultura)
2. **Tiempo:** ej. `20261` (Año 2026, Trimestre 1)
3. **Territorio:** ej. `C01` (Andalucía)
4. **Serie:** ej. `1` (Datos brutos)
5. **Valor:** ej. `223937.0` (Número de puestos asalariados)

## 3. Conclusiones para la Base de Datos (PostgreSQL)
- **Clave Única (Unique):** Una fila es única si juntamos Sector + Tiempo + Territorio. Si esos tres coinciden, es el mismo dato.
- **Inconsistencia a programar:** El tiempo viene todo junto (`20261`). Cuando hagamos el backend en Java, habrá que partir ese texto por la mitad para sacar el año y el trimestre.
- **Jerarquías:** Los sectores tienen niveles. `PA.04` es Servicios, pero `PA.04.01` es Comercio. Habrá que diseñar las tablas teniendo en cuenta sectores y subsectores.