package promo.show.faedev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import promo.show.faedev.bean.AFPCrecerData;


public class AFPCrecerService {
	private static final Logger LOGGER = Logger.getLogger(AFPCrecerService.class.getName() );
	String AFP_CRECER					=		"https://www.crecer.com.sv/aspx/wfCupones.aspx";
	
	public List<AFPCrecerData> parser(String arg[]){
		
		int tiempoEspera = 30;
		List<AFPCrecerData> crecer = new ArrayList<AFPCrecerData>();
		try {
			Document doc = Jsoup.connect(AFP_CRECER).timeout(1000*tiempoEspera).get();
			
			Elements eleTitulo = doc.select("h3.couponsH3");
			Elements eleImg = doc.select("table.tblCoupons img[src]"); 
			Elements eleInf = doc.select("td.tblPromo p");
			
			for(int i=0;i<eleTitulo.size() && i<eleInf.size() && i<eleInf.size();i++){
				Element titulo = eleTitulo.get(i);
				Element img = eleImg.get(i);
				Element info = eleInf.get(i);
				
				
				String nombreComercio = titulo.text();
				String urlImg = img.attr("src");
				String condiciones = info.text();
				//System.out.println("-->Nombre="+nombreComercioHtml+",\t urlImg="+urlImg+",\t condiciones="+condiciones);
				crecer.add(new AFPCrecerData(nombreComercio,urlImg,condiciones));	
			}
			/*LOGGER.info("*.*.*.*.*.*.*.**.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*..*.*.*.");
			for(AFPCrecerData d: crecer){
				LOGGER.info(d.toString());
			}*/
			
			//System.out.println("Fin de ejecucion...");
			
			return crecer;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public static void main(String[] args) {
		AFPCrecerService con = new AFPCrecerService();
		
		con.parser(args);
		
		
	}

}
