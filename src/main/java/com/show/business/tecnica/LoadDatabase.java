package com.show.business.tecnica;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.show.business.tecnica.model.Establecimiento;
import com.show.business.tecnica.model.Funcion;
import com.show.business.tecnica.model.PrecioSeccion;
import com.show.business.tecnica.model.Sala;
import com.show.business.tecnica.model.Seccion;
import com.show.business.tecnica.model.Show;
import com.show.business.tecnica.model.Ticket;
import com.show.business.tecnica.model.Usuario;
import com.show.business.tecnica.repository.EstablecimientoRepositorio;
import com.show.business.tecnica.repository.FuncionRepositorio;
import com.show.business.tecnica.repository.PrecioSeccionRepositorio;
import com.show.business.tecnica.repository.SalaRepositorio;
import com.show.business.tecnica.repository.SeccionRepositorio;
import com.show.business.tecnica.repository.ShowRepositorio;
import com.show.business.tecnica.repository.TicketRepositorio;


import lombok.NonNull;



@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  
  
  @Bean
  CommandLineRunner initDatabase(
		  EstablecimientoRepositorio establecimientoRepositorio,
		  FuncionRepositorio funcionRepositorio,
		  PrecioSeccionRepositorio precioSeccionRepositorio,
		  SalaRepositorio salaRepositorio,
		  SeccionRepositorio seccionRepositorio,
		  ShowRepositorio showRepositorio,
		  TicketRepositorio ticketRepositorio) {
	
    return args -> {
    	
    	System.out.println("LoadDatabase");

//    	System.out.println(LocalTime.now());
//    	Usuario usuario = new Usuario (); 
//    	usuario.setId(2L);
//
//    	
//		System.out.println(establecimientoRepositorio.findByUsuario(usuario));
//		System.out.println(LocalTime.now());
//		
//
//		System.out.println("-------Salas------------------");
//		System.out.println(LocalTime.now());
//		
//		Establecimiento establecimiento = new Establecimiento();
//		establecimiento.setId(1L);
//		salaRepositorio.findByEstablecimiento(establecimiento).forEach(e->{System.out.println(e);});
//		System.out.println(LocalTime.now());
//		
//		
//		System.out.println("-------Shows------------------");
//		System.out.println(LocalTime.now());
//		showRepositorio.findByUsuario(usuario).forEach(e->{System.out.println(e);});
//		System.out.println(LocalTime.now());
//		
		System.out.println("-------Funciones------------------");
		System.out.println(LocalTime.now());
		Example<Funcion> example = Example.of(new Funcion());
		
//		funcionRepositorio.findAllCustomer(
//				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2022-08-15 00:00:00.000"),
//				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2022-08-26 00:00:00.000"), 
//				1000D, 3300D,
//				new Long(2),example).forEach(e->{
//			System.out.println(e);
//			e.getPrecioSeccion().forEach(ep -> {System.out.println("	"+ep.getPrecio());});
//		});
		
//		funcionRepositorio.findByUsuario(usuario).forEach(e->{
//			System.out.println(e);
//			e.getPrecioSeccion().forEach(ep -> {System.out.println("	"+ep.getPrecio());});
//		});
//		System.out.println(LocalTime.now());
//		Funcion funcion = funcionRepositorio.findById(1L).get();
//		System.out.println(funcion);
//		FuncionRs f = UtilsMapper.INSTANCE.funcionToFuncionRs( funcion );
//    	System.out.println(f);
//		System.out.println("-------Tickets------------------");
//		System.out.println(LocalTime.now());
//    	Funcion funcion = new Funcion (); 
//		funcion.setId(2L);
//
//		Sala sala=new Sala();
//    	sala.setId(1L);
//    	funcion.setSala(sala);
//    	Ticket ticket = new Ticket();
//    	ticket.setFuncion(funcion);
//    	Example<Ticket> example = Example.of(ticket);
//		ticketRepositorio.findAll(example).forEach(e->{//System.out.println(e);
//			
//		});
//		
//		System.out.println(LocalTime.now());		

		
		
//		@NonNull
//		Show show = new Show();
//		show.setId(1L);
//		@NonNull
//		Sala sala = new Sala();
//		sala.setId(1L);
//		@NonNull
//		List<PrecioSeccion> precioSeccion = new ArrayList<>();
		
//		Funcion funcion = new Funcion(null, new Date(Date.UTC(2022-1900, 07, 10, 22, 0, 0)), show , establecimiento, sala , precioSeccion , usuario);
//		funcionRepositorio.save(funcion);
		

//		List <Seccion>secciones = seccionRepositorio.findAll();
//		
//		secciones.forEach(seccion->{
//			List <Butaca>butacas = new ArrayList<>();	
//			Butaca butaca = new Butaca();
//			for(int i = 1; i<50;i++) {
//				butaca = new Butaca();
//				butaca.setNombre("Butaca "+i);
//				butacas.add(butacaRepositorio.save(butaca));
//			}
//			
//			seccion.setButacas(butacas);
//			seccionRepositorio.save(seccion);
//		}); 
		
		
//    	categoriaRepository.save(Categoria.builder().nombre("fideos").porcentaje(25D).build());
//    	categoriaRepository.save(Categoria.builder().nombre("bebidas").porcentaje(35D).build());
//    	categoriaRepository.save(Categoria.builder().nombre("caramelos").porcentaje(15D).build());
//    	System.out.println("Insertando categoria");
//    	
//    	productoRepository.save(Producto.builder().nombre("maroleo").categoria("fideos").codigoBarra("7797470000977").valorCompra(200D).build());
//    	productoRepository.save(Producto.builder().nombre("capeleti").categoria("fideos").codigoBarra("7792390620748").valorCompra(300D).valorVenta(320D).build());
//    	productoRepository.save(Producto.builder().nombre("gelatina").categoria("caramelos").codigoBarra("7790070416780").valorCompra(10D).build());
//    	System.out.println("Insertando productos");
    };
  }
}