package ar.com.unpaz.model;

public class PeleadorTemporal extends Peleador {
	public PeleadorTemporal(String nombre, String dni, String pais, Double peso, String categoria, int puntos,
			String tipoContrato) {
		super(nombre, dni, pais, peso, categoria, puntos, tipoContrato);
		// TODO Auto-generated constructor stub
	}

	
	public double getRanking() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return this.getIdentificador();
	}

	
	public boolean esElegibleParaRenovacion() {
		// TODO Auto-generated method stub
		return this.getPuntos()>80;
	}

	
	public double calcularRaking() {
		
		return this.getPuntos();
	}
}
