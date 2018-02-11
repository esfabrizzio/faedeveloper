package promo.show.faedev.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import promo.show.faedev.bean.BancoAgricolaData;


public class BancoAgricolaService {
	private static final Logger LOGGER = Logger.getLogger(BancoAgricolaService.class.getName() );
	
	public List<BancoAgricolaData> parser(String[] arg){
		String AdsUrl = "http://www.bancoagricola.com/promociones-comercios/article/programa-descuentos.htm";
		String imgUrl = "http://www.bancoagricola.com/promociones-comercios-e/article/";
		
		List<BancoAgricolaData> badata = new ArrayList<BancoAgricolaData>();
		Document doc= null;
		Connection con=null;
		
		try{
			
			con = Jsoup.connect(AdsUrl);
			con.timeout(10000);
			con.method(Connection.Method.GET);
			con.userAgent("Mozilla/5.0 (Macintosh; U; PPC Mac OS X 10.4; es-ES; rv:1.9.2.23) Gecko/20110920 Firefox/3.6.23");
			doc = con.get();
			
			Elements titulosCategoria = doc.select("div.titulo_acordion.agencias_titulo");
			Elements detalleCategoria = doc.select("div.descripcion_acordion.agencias_detalles");
			
			Iterator<Element> itCat = titulosCategoria.iterator();
			Iterator<Element> itDet = detalleCategoria.iterator();
			
			while(itCat.hasNext() && itDet.hasNext()){
				//LOGGER.info("************************************************");
				Element eCat = itCat.next();
				//LOGGER.info(eCat.text());
				
				Element eDet = itDet.next();
				Elements tabla = eDet.select("table"); 
				for(Element row : tabla.select("tr")) {
		            for(Element tds : row.select("td")){
		            	if( tds.select("img").size() == 0 ) continue;
		            	String nombre = tds.select("img").attr("title");
		            	String imagen = tds.select("img").attr("src");
		            	//LOGGER.info("-->"+nombre);
		            	//LOGGER.info("-->"+imgUrl+imagen);
		            	badata.add(new BancoAgricolaData(eCat.text(),nombre,imgUrl+imagen,"",""));
		            }
		        }
			}
			return badata;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
