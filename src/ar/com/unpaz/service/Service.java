package ar.com.unpaz.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.com.unpaz.model.Peleador;
import ar.com.unpaz.model.PeleadorExclusivo;
import ar.com.unpaz.model.PeleadorTemporal;


public class Service {

	public void mostrarTodosLosPeleadores(List<Peleador>peleadores) {
		
		System.out.println("-----TODOS LOS PELEADORES-----");
		peleadores.stream().forEach(p->System.out.println("-"+p.resumen()));
	}
	
	public void promedioRankingTipoDeContrato(List<Peleador>peleadores) {
		System.out.println("-----total promedio de ranking por tipo de contrato----");
		
		List <Peleador> peleadoresEx=peleadores.stream().filter(p->p.getTipoContrato().contentEquals("exclusivo")).collect(Collectors.toList());
		List <Peleador> peleadoresTemp=peleadores.stream().filter(p->p.getTipoContrato().contentEquals("temporal")).collect(Collectors.toList());
		
				
		Double puntosEx=peleadoresEx.stream().mapToDouble(p->p.getRanking()).sum();
		Double puntosTemp=peleadoresTemp.stream().mapToDouble(p->p.getRanking()).sum();
		
		
		System.out.println("Promedio de Ranking de peleadores Exclusivos: "+(puntosEx / peleadoresEx.size()));
		System.out.println("Promedio de Ranking de peleadores Temporales: "+(puntosTemp / peleadoresTemp.size()));
		

		
	}
	
	public void peleadorConMasPuntos(List<Peleador>peleadores) {
		
		System.out.println("-----PELEADOR CON MAS PUNTOS-----");
		peleadores.stream().max(Comparator.comparing(Peleador::getPuntos)).ifPresent(p->System.out.println("-"+p.resumen()));
		
		
	}
	
	public void peleadoresPorCategoria(List<Peleador>peleadores) {
		
		System.out.println("-----PELEADORES POR CATEGORIA-----");
		Set<String> categorias=peleadores.stream().map(p->p.getCategoria()).collect(Collectors.toSet());
		
		
		for(String categoria:categorias) {
			
			System.out.println("\nPeleadores de la categoria "+categoria+" :");	
			peleadores.stream().filter(p->p.getCategoria().equalsIgnoreCase(categoria)).forEach(p->System.out.println("-"+p.resumen()));
		}	
			
	}

	public void peleadoresPorPais(List<Peleador>peleadores) {
		
		System.out.println("-----PELEADORES POR PAIS----");
		Map<String, List<Peleador>> peleadoresXPais = peleadores.stream().collect(Collectors.groupingBy(Peleador::getPais));
		
		peleadoresXPais.forEach((pais,lista)->{
			
			System.out.println("Pais :"+pais);
			lista.forEach(p->System.out.println(p.resumen()));
			
			
		});
		
	}
	
	
	public void peleadoresElegiblesRenovacion(List<Peleador>peleadores) {

		System.out.println("-----PELEADORES ELEGIBLES PARAR RENOVACION----");
		
	    peleadores.stream()
        .filter(p -> p.esElegibleParaRenovacion())
        .forEach(p -> System.out.println("- " + p.resumen()));
		
		
	}
	
	
	
	public List<Peleador> crearPeleador(List<Peleador>peleadores) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese nombre del peleador: ");
		String nombre=sc.nextLine();
		System.out.println("Ingrese dni del peleador: ");
		String dni=sc.nextLine();
		System.out.println("Ingrese pais del peleador: ");
		String pais=sc.nextLine();
		System.out.println("Ingrese peso del peleador: ");
		Double peso=Double.parseDouble(sc.nextLine());
		System.out.println("Ingrese categoria del peleador: ");
		String categoria=sc.nextLine();
		System.out.println("Ingrese puntos del peleador: ");
		int puntos=Integer.parseInt(sc.nextLine());		
		
		String tipoContrato="";
		
		do {
			System.out.println("Ingrese tipo de contrato del peleador(Solo será valido 'exclusivo' o 'temporal'): ");
			tipoContrato=sc.nextLine();
		}while(!tipoContrato.equalsIgnoreCase("exclusivo")&&tipoContrato.equalsIgnoreCase("temporal"));
		
		
		
		Peleador sPeleador=null;
		
		if(tipoContrato.equalsIgnoreCase("exclusivo")) {
			
			sPeleador= new PeleadorExclusivo(nombre,dni,pais,peso,categoria,puntos,tipoContrato);
			
			
		}else if(tipoContrato.equalsIgnoreCase("temporal")) {
			
			sPeleador= new PeleadorTemporal(nombre,dni,pais,peso,categoria,puntos,tipoContrato);
			
		}
		
		peleadores.add(sPeleador);
		System.out.println("Peleador "+sPeleador.resumen()+" agregado correctamente.");
		return peleadores;	
		
	}
	
	public void eliminarPeleador(List<Peleador>peleadores,String dni) {
		
		
		Peleador peleadorAEliminar=null;
		
		for(Peleador peleador:peleadores) {
			
			if(peleador.getDni().equalsIgnoreCase(dni)) {
				peleadorAEliminar=peleador;
				break;
			}			
			
		}
		if(peleadorAEliminar!=null) {
			
			peleadores.remove(peleadorAEliminar);
			System.out.println("Peleador eliminado");
		}else {
			System.out.println("No se ha encontrado un peleador con el dni ingresado");
		}	
		
		
		
	}
	
	public List<Peleador> modificarPeleador(List<Peleador>peleadores,String dniModificar) {
		Peleador peleadorAModificar=null;
		
		for(Peleador peleador:peleadores) {
			
			if(peleador.getDni().equalsIgnoreCase(dniModificar)) {
				peleadorAModificar=peleador;
				break;
			}
			
			
		}
		if(peleadorAModificar!=null) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println( "Peleador a modifcar: " +peleadorAModificar.resumen());
			System.out.println("Ingrese nuevo nombre del peleador: ");
			String nombre=sc.nextLine();
			System.out.println("Ingrese nuevo dni del peleador: ");
			String dni=sc.nextLine();
			System.out.println("Ingrese nuevo pais del peleador: ");
			String pais=sc.nextLine();
			System.out.println("Ingrese nuevo peso del peleador: ");
			Double peso=Double.parseDouble(sc.nextLine());
			System.out.println("Ingrese nueva categoria del peleador: ");
			String categoria=sc.nextLine();
			System.out.println("Ingrese nuevos puntos del peleador: ");
			int puntos=Integer.parseInt(sc.nextLine());		
			
			String tipoContrato="";
			
			do {
				System.out.println("Ingrese nuevo tipo de contrato del peleador(Solo será valido 'exclusivo' o 'temporal'): ");
				tipoContrato=sc.nextLine();
			}while(!tipoContrato.equalsIgnoreCase("exclusivo")&&tipoContrato.equalsIgnoreCase("temporal"));
			
			
			Peleador peleadorNuevo=null;
			
			if(tipoContrato.equalsIgnoreCase("exclusivo")) {
				
				peleadorNuevo= new PeleadorExclusivo(nombre,dni,pais,peso,categoria,puntos,tipoContrato);
				
				
			}else if(tipoContrato.equalsIgnoreCase("temporal")) {
				
				peleadorNuevo= new PeleadorTemporal(nombre,dni,pais,peso,categoria,puntos,tipoContrato);
				
			}	
				
			
			peleadores.remove(peleadorAModificar);
			peleadores.add(peleadorNuevo);
			
			System.out.println("Peleador modificado");
		}else {
			System.out.println("No se ha encontrado un peleador con el dni ingresado");
		}
		
		return peleadores;
	}
	
	
}

	
	
	

