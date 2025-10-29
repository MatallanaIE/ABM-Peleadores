package ar.com.unpaz.model;

public abstract class Peleador implements Rankeable,Identificable, Contratable{

	private String nombre;
	private String dni;
	private String pais;
	private Double peso;
	private String categoria;
	private int puntos;
	private String tipoContrato;
	
	public Peleador(String nombre, String dni, String pais,Double peso ,String categoria, int puntos, String tipoContrato) {
		this.setNombre(nombre);
		this.setDni(dni);
		this.setPais(pais);
		this.setPeso(peso);
		this.setCategoria(categoria);
		this.setPuntos(puntos);
		this.setTipoContrato(tipoContrato);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	public abstract double calcularRaking();
	
	public String resumen() {
		return "Nombre: "+this.getNombre()+", Dni: "+this.getDni()+", Pais: "+this.getPais()+", Peso: "+this.getPeso()+", Categoria: "+this.getCategoria()+", Puntos: "+this.getPuntos()+", Tipo contrato: "+this.getTipoContrato();
	}
	
	
	
	
}
