package com.expedia.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.expedia.business.HotelManagerService;
import com.expedia.business.ISearch;
import com.expedia.business.ISearchImpl;
import com.expedia.business.ResultsBean;
import com.expedia.model.Hotel;
import com.expedia.util.HttpConnection;
import com.expedia.util.InfoProps;


/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOST_URL = "JSON_INFO_HOST";
	
	private ISearch isearchService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String hostUrl = getHostUrl(getServletContext(), HOST_URL);
		String jsonResultsString = HttpConnection.getInstance().doGet(hostUrl);
		String searchByParam = request.getParameter("searchOption");
		String searchValue = request.getParameter("searchValue");
		
		HotelManagerService managerSerice = new HotelManagerService();
		List<Hotel> hotels =  managerSerice.getHotels(jsonResultsString);
		
		this.isearchService = new ISearchImpl(searchByParam,searchValue, hotels);
		ResultsBean results = this.isearchService.doSearch(); 

		
		
		/*response.getWriter().println(hostUrl);
		response.getWriter().println("Number of hotels " + hotels.size()
				);*/
		request.setAttribute("hotels", results.getHotels());
		request.setAttribute("resultNumber", results.getHotels().size());
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private String getHostUrl(ServletContext context,String key){
		
		String url= context.getRealPath("/");
		String fullUrl= null;		
        fullUrl = url.concat("WEB-INF/props/info.properties");
		File f = new File(fullUrl);
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(f);
			
			try {
				props.load(fis);
			    

			   

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty(key);
	}

}
