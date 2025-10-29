package ar.com.unpaz.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Peleador;
import ar.com.unpaz.model.PeleadorExclusivo;
import ar.com.unpaz.model.PeleadorTemporal;

public class MyFileManager {

	private static final String FILE_PATH = "data/Peleadores.txt";
	
	public static List<Peleador> readFile(){
		
		
		List <Peleador> peleadores = new ArrayList<>();
		 File file = new File(FILE_PATH);

	        if (!file.exists()) {
	            System.out.println("El archivo no existe en la ruta esperada: " + file.getAbsolutePath());
	            return peleadores;
	        }
	
		try {
			
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String linea="";
			
			while((linea=reader.readLine())!=null) {
				
				String elements[]=linea.split(";");
				
				String nombre= elements[0];
				String dni= elements[1];
				String pais= elements[2];
				Double peso=Double.parseDouble( elements[3]);
				String categoria=elements[4];
				int puntos=Integer.parseInt(elements[5]);
				String tipoContrato=elements[6];
				
				if(tipoContrato.equalsIgnoreCase("exclusivo")) {
					
					PeleadorExclusivo sPeleador= new PeleadorExclusivo(nombre,dni,pais,peso,categoria,puntos,tipoContrato);
					peleadores.add(sPeleador);
					
				}else if(tipoContrato.equalsIgnoreCase("temporal")) {
					
					PeleadorTemporal sPeleador= new PeleadorTemporal(nombre,dni,pais,peso,categoria,puntos,tipoContrato);
					peleadores.add(sPeleador);
				}
				
				
			}
			System.out.println("Archivo cargado correctamente.");
			
		}catch(IOException e) {
			System.out.println("Error al leer el archivo: "+e);
		}
		
		return peleadores;
		
		
	}
	
	
	public static void saveFile(List <Peleador> peleadores){
		
		 File file = new File(FILE_PATH);

	        // Si la carpeta no existe, la crea
	     file.getParentFile().mkdirs();
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for(Peleador peleador:peleadores) {
				String linea=peleador.getNombre()+";"+
						peleador.getDni()+";"+
						peleador.getPais()+";"+
						peleador.getPeso()+";"+
						peleador.getCategoria()+";"+
						peleador.getPuntos()+";"+
						peleador.getTipoContrato();
				
				writer.write(linea);
				writer.newLine();
			}
		}catch(IOException e) {
			System.out.println("Error al guardar el archivo: "+e);
		}
		
	}
	
	
}
