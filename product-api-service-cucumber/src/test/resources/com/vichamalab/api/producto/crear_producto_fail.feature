# language: es
@CrearFallo
Requisito: Fallo al crear un producto sin nombre usando la api /api/v1/product

  Esquema del escenario: Fallo al intentar crear un producto sin nombre
  Dada una API válida con ruta "/api/v1/product/" y formato "application/json"
  Cuando se hace una petición "POST" con el nombre "<nombre>"
  * y la descripción "<descripcion>"
  * y el precio <precio>
  * a la API
  Entonces se recibe una respuesta "fallida" con código <codigo>
  * y el mensaje "<mensaje>"

  @FalloSinNombre
  Ejemplos: Fallo sin nombre
  |nombre|descripcion|precio|codigo|mensaje|
  ||Un smartphone MyPhone|1100|400|El nombre del producto no fue proporcionado|
  ||Un smartphone MyPhone|1900|400|El nombre del producto no fue proporcionado|
  ||Un smartphone MyPhone|2100|400|El nombre del producto no fue proporcionado|
  
  