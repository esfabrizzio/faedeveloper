package promo.show.faedev.bean;

public class AFPConfiaData {
	String categoria;
	String nombreComercio;
	String urlImagen;
	String condiciones;
	String porcDescuento;
	
	public AFPConfiaData() {
		
	}
	
	public AFPConfiaData(String categoria, String nombreComercio, String urlImagen, String condiciones,
			String porcDescuento) {
		super();
		this.categoria = categoria;
		this.nombreComercio = nombreComercio;
		this.urlImagen = urlImagen;
		this.condiciones = condiciones;
		this.porcDescuento = porcDescuento;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getPorcDescuento() {
		return porcDescuento;
	}

	public void setPorcDescuento(String porcDescuento) {
		this.porcDescuento = porcDescuento;
	}

	@Override
	public String toString() {
		return "AFPConfiaData [categoria=" + categoria + ", nombreComercio=" + nombreComercio + ", urlImagen="
				+ urlImagen + ", condiciones=" + condiciones + ", porcDescuento=" + porcDescuento + "]";
	}

}
