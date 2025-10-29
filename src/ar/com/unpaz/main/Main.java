package ar.com.unpaz.main;

import java.util.List;
import java.util.Scanner;

import ar.com.unpaz.model.Peleador;
import ar.com.unpaz.repository.MyFileManager;
import ar.com.unpaz.service.Service;

public class Main {

	public static void main(String[] args) {

		Service logicaDeNegocio=new Service();
		List<Peleador> peleadores=MyFileManager.readFile();
		
		
		Scanner sc = new Scanner(System.in);
		
		int opcion=0;
		
		do {
			System.out.println("-----MENU DE PELEADORES-----");
			System.out.println("1-Mostrar todos los peleadores");
			System.out.println("2-Promedio de raking por tipo de contrato");
			System.out.println("3-Mostrar peleador con mas puntos");
			System.out.println("4-Peleadores por categoria");
			System.out.println("5-Peleadores por pais");
			System.out.println("6-Mostrar peleadoes elegibles para renovacion");
			System.out.println("7-Agregar nuevo peleador");
			System.out.println("8-Modificar un peleador");
			System.out.println("9-Eliminar un peleador");
			System.out.println("10-Guardar lista de peleadores");
			System.out.println("Seleccione una opcion: ");
			
			opcion=Integer.parseInt(sc.nextLine());
			
			
			switch(opcion) {
			
			case 1:
				logicaDeNegocio.mostrarTodosLosPeleadores(peleadores);
				break;
				
			case 2:
				logicaDeNegocio.promedioRankingTipoDeContrato(peleadores);
				break;
			case 3:
				logicaDeNegocio.peleadorConMasPuntos(peleadores);
				break;
				
			case 4:
				logicaDeNegocio.peleadoresPorCategoria(peleadores);
				break;
			case 5:
				logicaDeNegocio.peleadoresPorPais(peleadores);
				break;
			case 6:
				logicaDeNegocio.peleadoresElegiblesRenovacion(peleadores);
				break;
				
			case 7:
				
				logicaDeNegocio.crearPeleador(peleadores);
				break;
			case 8:
				System.out.println("Ingrese del DNI del peleador a modificar: ");
				String dniMod=sc.nextLine();
				logicaDeNegocio.modificarPeleador(peleadores, dniMod);
				break;
			case 9:
				System.out.println("Ingrese del DNI del peleador a eliminar: ");
				String dniDel=sc.nextLine();
				logicaDeNegocio.eliminarPeleador(peleadores, dniDel);
				
				break;
				
			case 10:
				MyFileManager.saveFile(peleadores);
				break;
			}
				
			
			
		}while(opcion!=0);
		
		
		
		
		
		
	}

}
