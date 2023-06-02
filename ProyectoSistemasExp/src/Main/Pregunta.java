package Main;

public class Pregunta {
	
	private String descripcion;
	private Inteligencia tipoInteligencia;

	
	public Pregunta(String descripcion) {
		super();
		this.descripcion=descripcion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Inteligencia getTipoInteligencia() {
		return tipoInteligencia;
	}


	public void setTipoInteligencia(Inteligencia tipoInteligencia) {
		this.tipoInteligencia = tipoInteligencia;
	}


	@Override
	public String toString() {
		return "Pregunta [descripcion=" + descripcion + ", tipoInteligencia=" + tipoInteligencia.getTipoInteligencia() + "]";
	}


	





	
}
