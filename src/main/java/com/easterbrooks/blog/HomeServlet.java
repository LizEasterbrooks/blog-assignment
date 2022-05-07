package com.easterbrooks.blog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import java.io.PrintWriter;										
//import java.util.Date;											
import jakarta.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class HomeServlet
 */

@WebServlet(description = "Dynamic homepage for single-user blog",
urlPatterns = {"/home", "/"},
initParams = {@WebInitParam(name="title",value="Insert Your Title Here"),
		@WebInitParam(name="description",value="Write Your Blog Description Here")})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String HTML_START="<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\">";
	//TODO: INCLUDE CSS
	//TODO: INCLUDE JS(?)
	public static final String HTML_BODY= "<body>";
	public static final String HTML_END="</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 	
		ServletConfig configObj = getServletConfig(); // TODO this will likely pull on another object representing the USER?? saved somehow???
		//TODO: VISUAL: provide visual formatting for title
		//TODO: INTERACTIVE CONTENT: need a button or similar to access editing form/popup for blog title
		//TODO: INTERACTIVE CONTENT: need a form and a place to send it to to edit blog title
		String title = ""; // TODO: DYNAMIC CONTENT: PULL USER MADE TITLE FROM SAVED DATA (?how? DB? file? idk yet);
		if (title == "") {
			//if user has not specified a custom title, then use default
			title = title + configObj.getInitParameter("title"); 
		}		
		//Blog title displays as page title and header
		out.println(HTML_START + "<title>" + title + "</title>" + "<h1>" + title + "</h1>");	
		
		//Blog description
		String description = "";
		if (description == "") {
			//if user has not specified a description, then use default
			description = description + configObj.getInitParameter("description"); 
		}
		out.println("<h2>" + description + "</h2>");
		
		out.println("<body>" + "Eventually the body of this page will contain elements<br>"
				+ "that depict previous blog posts.<br>"
				+ "They will be either text snippets or tiles or somesuch.");
		
		//end of page
		out.println(HTML_END);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// TODO: FIGURE OUT IF I NEED THIS??? If not, can I get rid of it? Or is that bad form?
	}

}
