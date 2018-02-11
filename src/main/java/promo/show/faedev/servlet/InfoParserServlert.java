package promo.show.faedev.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import promo.show.faedev.bean.AFPCrecerData;
import promo.show.faedev.bean.BancoAgricolaData;
import promo.show.faedev.service.AFPCrecerService;
import promo.show.faedev.service.BancoAgricolaService;


public class InfoParserServlert extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(InfoParserServlert.class.getName() );

	@Override
	public void init() throws ServletException {
		LOGGER.info("*****************************************");
		LOGGER.info("*** Iniciando Servlet InfoParserServlert");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoB = req.getParameter("tipoB");
		LOGGER.info("*****************************************");
		LOGGER.info("*** Iniciando busqueda, tpo busqueda: --->"+tipoB);
		
		if("A".equals(tipoB)){
			BancoAgricolaService basrv = new BancoAgricolaService();
			List<BancoAgricolaData> badata = basrv.parser(null);
			ObjectMapper mapper = new ObjectMapper();
			resp.getWriter().print(mapper.writeValueAsString(badata));
		}else if("C".equals(tipoB)){
			AFPCrecerService cresrv = new AFPCrecerService();
			List<AFPCrecerData> credata = cresrv.parser(null);
			ObjectMapper mapper = new ObjectMapper();
			resp.getWriter().print(mapper.writeValueAsString(credata));
		}else if("F".equals(tipoB)){
			
		}
	}
}
