package com.vichamalab.api.producto.requests;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import com.vichamalab.api.producto.dto.ProductRequest;
import com.vichamalab.api.producto.dto.ProductResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIProducto {
	
	public static Response crearProducto(String ruta, RequestSpecification spec, ProductRequest request) {
		return	given()
				.spec(spec)
				.body(request)
			.when()
				.post(ruta)
			.then()
				.extract()
				.response();
	}
	
	public static Response crearProducto(String ruta, ProductRequest request) {
		return	given()
				.body(request)
			.when()
				.post(ruta)
			.then()
				.extract()
				.response();
	}
	
	public static Response actualizarProducto(String ruta, String sku, ProductRequest request) {
		String rutaCompleta = String.format("%s{sku_creado}/", ruta);
		return	given()
				.pathParam("sku_creado", sku)
				.body(request)
			.when()
				.put(rutaCompleta)
			.then()
				.extract()
				.response();
	}
	
	public static Response eliminarProducto(String ruta, String sku) {
	    String rutaCompleta = String.format("%s{sku_creado}/", ruta);
	    
	   
	    Response response = given()
	            .pathParam("sku_creado", sku)
	        .when()
	            .delete(rutaCompleta)
	        .then()
	            .extract()
	            .response();
	    
	    
	    if (response.getStatusCode() == HttpStatus.SC_NOT_FOUND) {
	        System.out.println("El producto no fue encontrado. Código de respuesta: 404");
	    } else if (response.getStatusCode() == HttpStatus.SC_OK) {
	        System.out.println("El producto fue eliminado con éxito. Código de respuesta: 200");
	    } else {
	        System.out.println("Ocurrió un error inesperado. Código de respuesta: " + response.getStatusCode());
	    }
	    
	    return response;
	}
	
	public static ProductResponse recuperarProducto(String ruta, String sku) {
		String rutaCompleta = String.format("%s{sku_creado}/", ruta);
	   	 return given()
	   			.pathParam("sku_creado", sku)
	   	.when()
	   		.get(rutaCompleta)
	   	.then()
	   		.statusCode(HttpStatus.SC_OK)
	   		.extract()
	   		.as(ProductResponse.class);
	}
	
}
