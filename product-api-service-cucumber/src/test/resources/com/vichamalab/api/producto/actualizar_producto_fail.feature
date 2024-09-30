# language: es
@ActualizarFallo
Requisito: Fallo al intentar actualizar un producto con descripción vacía

  Esquema del escenario: Fallo al actualizar un producto con descripción vacía
  Dada un producto con nombre "Nombre original"
  * y la descripción "Descripción original"
  * y el precio 1500
  * previamente creado con exito usando la ruta "/api/v1/product/" y metodo "POST"
  Cuando se hace una petición "PUT" con el nombre "<nombre>"
  * y la descripción "<descripcion>"
  * y el precio <precio>
  * a la API
  Entonces se recibe una respuesta "fallida" con código <codigo>
  * y el mensaje "<mensaje>"

  @FalloDescripcionVacia
  Ejemplos: Descripción vacía
  |nombre      |descripcion|precio|codigo|mensaje|
  |Myphone 18  |            |999   |400   |La descripción del producto no fue proporcionada|
  |Myphone 19  |            |999   |400   |La descripción del producto no fue proporcionada|