package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;

@Controller
public class ProductoController {

	// creamos iProductoService de tipo IProductoService entonces va ala capa service
	// service
	@Autowired
	IProductoService iProductoService;
	// GETMAPPING HACE UNA ACCION CUANDO EL USUARIO SE LO PIDE
	// se llama al metodo obtenerproductonuevo Con el producto agregado
	// IproductoService
	@GetMapping("/producto")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return "producto";
	}
	// POSTMAPPING HACE UNA ACCION CUANDO EL USUARIO INGRESO LOS DATOS Y VA A MOSTRAR ALGO
	// Desde el html va a venir a llamar a guardarProducto, lo recibe a travez del
	// motodo String guar... la notacion @ModelAtt gestiona
	// unProducto(nuevoProducto) de tipo Producto entonces ahora unProducto se llama nuevoProducto
	//el ModelAttribute se conecta con la linea 25 "unProducto"
	@PostMapping("/producto")
	public String guardarNuevoProducto(@ModelAttribute("unProducto")Producto nuevoProducto, Model model) { 
		//lo maando a travez del service a guardar producto
		iProductoService.guardarProducto(nuevoProducto);
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return "resultado";
	}
	@GetMapping("/ultimo")
	public String ultimoProducto(Model model) {
		//estoy diciendo que vaya a obtenerUltimoproducto desde la capa service
		model.addAttribute("ultimoProducto", iProductoService.obtenerUltimoProducto());
		return("ultimo");
	}
	
	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		//model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return("redirect:/producto");
	}
}