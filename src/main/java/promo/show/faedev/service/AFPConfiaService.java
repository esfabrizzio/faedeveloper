package promo.show.faedev.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import promo.show.faedev.bean.AFPConfiaData;

public class AFPConfiaService {

	String AFP_CONFIA					=		"https://www.confia.com.sv/confiaAppWEB/PROMOCION";
	String URL_IMG_CONFIA				=		"";
	
	public void parser(String[] args){
		
		int tiempoEspera = 30;
		List<AFPConfiaData> confiaNaranja = new ArrayList<AFPConfiaData>();
		List<AFPConfiaData> confiaPlatino = new ArrayList<AFPConfiaData>();
		List<AFPConfiaData> confiaDorada = new ArrayList<AFPConfiaData>();
		List<AFPConfiaData> confiaAzul = new ArrayList<AFPConfiaData>();
		try {
			Document doc1 = Jsoup.connect(AFP_CONFIA).timeout(1000*tiempoEspera).get();
			Document doc2 = null;
			char[] arrStr = {'n','p','d','a'};
			
			for(char s: arrStr){
				Elements doc = doc1.select("div#fc-boxes15-1"+s);
				Elements eleImg = doc.select("div#fc-13-content2-2-3 img[src]");
				Elements eleInf = doc.select("div#fc-13-content2-2-2 a[href]"); 
	
				for(int i=0;i<eleImg.size() && i<eleInf.size();i++){
					Element e = eleImg.get(i);
					Element in = eleInf.get(i);
					String nombreComercioHtml = e.attr("title")+i;
					String urlimg = e.attr("src");
					String urlDetalle = in.attr("href");
					String nombreComercio = WordUtils.capitalize(nombreComercioHtml.replace("-"," "));
					
					doc2 = Jsoup.connect(urlDetalle).timeout(1000*tiempoEspera).get();
					Elements eleDesc = doc2.select("div#fc-13-content2-2-1 h1");
					Elements eleDet = doc2.select("div#inner-ventana p");
					String porcentajeDesc = eleDesc.text();
					String condiciones = eleDet.text();
					
					switch(s){
					case 'n': confiaNaranja.add(new AFPConfiaData("",nombreComercio, URL_IMG_CONFIA+urlimg,porcentajeDesc,condiciones));
						break;
					case 'p': confiaPlatino.add(new AFPConfiaData("",nombreComercio, URL_IMG_CONFIA+urlimg,porcentajeDesc,condiciones));
						break;
					case 'd': confiaDorada.add(new AFPConfiaData("",nombreComercio, URL_IMG_CONFIA+urlimg,porcentajeDesc,condiciones));
						break;
					case 'a': confiaAzul.add(new AFPConfiaData("",nombreComercio, URL_IMG_CONFIA+urlimg,porcentajeDesc,condiciones));
					}
	
				}
			}
			
			/*for(AFPConfiaData d: confiaNaranja){
				System.out.println(d);
			}
			System.out.println("Fin Naranja---------***********************");
			for(AFPConfiaData d: confiaPlatino){
				System.out.println(d);
			}
			System.out.println("Fin platino---------***********************");
			for(AFPConfiaData d: confiaAzul){
				System.out.println(d);
			}
			System.out.println("fin azul---------***********************");
			for(AFPConfiaData d: confiaDorada){
				System.out.println(d);
			}
			System.out.println("fin dorada---------***********************");
			System.out.println("Fin de ejecucion...");*/
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		AFPConfiaService con = new AFPConfiaService();
		
		con.parser(args);
		
		//System.out.println(StringEscapeUtils. ("tony-roma&acute;s"));
		
	}
}

//https://www.confia.com.sv/block/resource/LTg2NzYzNDIwNA==/?2013878399
//https://www.confia.com.sv/block/resource/LTU3OTkyMzAz/?2077545091