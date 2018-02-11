package promo.show.faedev.bean;

public class AFPCrecerData {

	String categoria;
	String nombreComercio;
	String urlImagen;
	String condiciones;
	String porcDescuento;
	
	public AFPCrecerData() {}
	
	public AFPCrecerData(String nombreComercio,String urlimg, String condiciones) {
		this.nombreComercio = nombreComercio;
		this.urlImagen = urlimg;
		this.condiciones = condiciones;
	}
	public String getNombreComercio() {
		return nombreComercio;
	}
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	@Override
	public String toString() {
		return "CrecerData [nombreComercio=" + nombreComercio
				+ ", urlImagen=" + urlImagen + ", condiciones="
				+ condiciones + "]";
	}
}
