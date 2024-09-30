# language: es
@EliminarFallo
Requisito: Fallo al intentar eliminar un producto

Esquema del escenario: Fallo al eliminar un producto
  Dada un producto con nombre "Nombre original"
  * y la descripción "Descripción original"
  * y el precio 1500
  * previamente creado con exito usando la ruta "/api/v1/product/" y metodo "POST"
  Cuando se hace una petición "DELETE" con el nombre "<nombre>"
  * a la API 
  Entonces se recibe una respuesta "fallida" con código <codigo>
  * y el mensaje "<mensaje>"

  @FalloEliminar
  Ejemplos: Fallos al eliminar un producto
  |nombre      |codigo|mensaje                        |
  |MyPhone 20  |404   |El producto no fue encontrado  |
  |MyPhone 21  |404   |El producto no fue encontrado  |
  |MyPhone 22  |404   |El producto no fue encontrado  |
