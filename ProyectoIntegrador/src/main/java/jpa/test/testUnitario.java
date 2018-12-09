package jpa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import entity.Empleado;
import entity.Producto;
import entity.Venta;
import managedbean.EmpleadoMB;
import managedbean.ProductoMB;
import managedbean.VentaMB;

public class testUnitario {

	public static void main(String[] args) {
		
		
		
		ListarProducto();
		//consultarEmpleadoPorUsuario();
		
	//	try {
		//	crearVentasparaPaoloGuerrero();
	//	} catch (ParseException e) {
		///	e.printStackTrace();
		//}
		
		//listarVentasPaolo();

	}
	
	private static void ListarProducto(){
		
		ProductoMB productomb=new ProductoMB();
		List<Producto> lstProducto=productomb.listaProducto();
		
		System.out.println("___________________");
		for(Producto producto:lstProducto){
			
			System.out.println("ID: "+producto.getId()+"  "+"Nombre: "+producto.getNombre()+"  "+"Presentacion: "
			+producto.getPresentacion().getPresentacion()+" "+"Marca: "+
			" "+producto.getMarca().getMarca()+"  Proveedor: "+producto.getProveedor().getProveedor()+" Zona :"+producto.getZona().getZona()+" "
			+"precio: "+" "+producto.getPrecio()+" "+"stock: "+producto.getStock());
		}
		
		
	}
	
	private static void crearEmpleados(){
		EmpleadoMB empleadoMb = new EmpleadoMB();
		//Inserta Empleado
		Empleado obj1 = new Empleado();
		obj1.setApellido("Guerrero");
		obj1.setNombre("Paolo");
		obj1.setDni("87654321");
		obj1.setUsuario("pguerrero");
		obj1.setClave("alondra");
		
		empleadoMb.insertar(obj1);
		
		Empleado obj2 = new Empleado();
		obj2.setApellido("Trauco");
		obj2.setNombre("Miguel");
		obj2.setDni("45553639");
		obj2.setUsuario("mtrauco");
		obj2.setClave("123");
		
		empleadoMb.insertar(obj2);
		
	}
	
	
	private static void consultarEmpleadoPorUsuario(){
		
		EmpleadoMB empleadoMb = new EmpleadoMB();
		
		 Empleado obj  = empleadoMb.getEmpleadoByUsuario("mtrauco");
		 System.out.println("Nombre:"+ obj.getNombre());
		 System.out.println("Apellido:"+ obj.getApellido());
		 System.out.println("DNI:"+ obj.getDni());
		 System.out.println("Usuario:"+ obj.getUsuario());
		 System.out.println("Clave:"+ obj.getClave());
	}
	
	
	
	
	private static void crearVentasparaPaoloGuerrero() throws ParseException{
		EmpleadoMB empleadoMb = new EmpleadoMB();
		VentaMB ventaMb = new VentaMB();
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

		
		Empleado objEmpleado = empleadoMb.getEmpleadoByUsuario("pguerrero");
		
		Venta objVenta1 = new Venta();
		objVenta1.setEmpleado(objEmpleado);
		objVenta1.setFecha(dateformat.parse("20/01/2017"));
		objVenta1.setMonto_total(1500);
		
		Venta objVenta2 = new Venta();
		objVenta2.setEmpleado(objEmpleado);
		objVenta2.setFecha(dateformat.parse("21/01/2017"));
		objVenta2.setMonto_total(2500);
		
		Venta objVenta3 = new Venta();
		objVenta3.setEmpleado(objEmpleado);
		objVenta3.setFecha(dateformat.parse("22/01/2017"));
		objVenta3.setMonto_total(3500);
		
		
		ventaMb.insertar(objVenta1);
		ventaMb.insertar(objVenta2);
		ventaMb.insertar(objVenta3);
	}
	
	
	private static void listarVentasPaolo(){
		EmpleadoMB empleadoMb = new EmpleadoMB();
		VentaMB ventaMb = new VentaMB();
		Empleado objEmpleado = empleadoMb.getEmpleadoByUsuario("pguerrero");
		
		List<Venta> lst = ventaMb.ventasByIdEmpleado(objEmpleado.getId());
		
		System.out.println("Ventas de "+objEmpleado.getNombre()+" "+objEmpleado.getApellido());
		System.out.println("----------------------------------------------");
		for(Venta objVenta : lst){
			System.out.println("Fecha: "+objVenta.getFecha()+" Monto: "+objVenta.getMonto_total());
		}
		
	}
	

}
