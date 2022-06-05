package Servlets;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  


@WebServlet(urlPatterns= {"/Logout"})

public class Logout extends HttpServlet {  
	
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
        	
            response.setContentType("text/html");  
          
              
            HttpSession session=request.getSession();  
            session.invalidate();  
              
            System.out.println("Logged out");
            request.getRequestDispatcher("index.jsp").forward(request, response);	
        
    }  
        
        @Override
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    	{   
    		doGet(request, response);
    	}
        
}  