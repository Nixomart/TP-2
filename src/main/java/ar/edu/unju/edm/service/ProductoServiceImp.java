package ar.edu.unju.edm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public class ProductoServiceImp implements IProductoService{


	@Autowired
	Producto unProducto;
	
	ArrayList<Producto> listaDeProductos=new ArrayList<Producto>();
	
	@Override
	public void guardarProducto(Producto unProducto) {
		System.out.println(unProducto.getNombre());
		listaDeProductos.add(unProducto);
		System.out.println(listaDeProductos.size());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProducto(Producto productoAModificar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto(Producto eliminarUnProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerUnProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return listaDeProductos;
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		int i = listaDeProductos.size() - 1;
		return listaDeProductos.get(i);
	}



}
