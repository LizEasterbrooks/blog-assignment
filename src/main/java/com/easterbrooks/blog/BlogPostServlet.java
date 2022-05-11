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

import java.sql.Connection;
import java.sql.DriverManager;

import model.*;

/**
 * Servlet implementation class BlogPostServlet
 */
//TODO: DYNAMIC SERVER: URL Patterns to reflect the post being accessed(?) adding the tag/number for the post to end?
@WebServlet(description = "Template page to serve unique post content",
urlPatterns = {"/blogPost"},
initParams = {@WebInitParam(name="title",value="Untitled Blog")})
public class BlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String HTML_START="<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\">";
	//TODO: STYLE: line to import from .css (?)
	//TODO: UI: line to import from .js (?)
	public static final String HTML_BODY= "<body>";
	public static final String HTML_END="</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogPostServlet() {
        super();
        //Auto-generated constructor stub
        //TODO - Customize?
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO: OOP BEST PRACICES: BREAK SELECT SECTIONS OF THE BELOW OUT INTO ADDITIONAL METHODS
		
		//~~~~~~~~~~~~~~~~~~~~~Servlet Setup~~~~~~~~~~~~~~~~~~~~~//
		PrintWriter out = response.getWriter(); 	
		ServletConfig configObj = getServletConfig(); // TODO this will likely pull on another object representing the USER?? saved somehow???
		
		
		//~~~~~~~~~~~~~~~~~~~~~JDBC Setup~~~~~~~~~~~~~~~~~~~~~//
		String JdbcURL = "jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&useSSL=false";
	    String Username = "Liz";
	    String password = "W!05twb22s?";
	    Connection connection = null;
	    
	    //Loading the JDBC driver; throws "driver not found" exception if not included
	    System.out.println("Loading driver...");
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("Driver loaded successfully.");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("Cannot find the driver in the classpath.", e);
	    }
	    
	    //TODO: TRACE STATEMENTS: delete or comment out (?)
	    try {
	       System.out.println("Connecting to database: "+JdbcURL);
	       connection = DriverManager.getConnection(JdbcURL, Username, password);
	       System.out.println("Connection successful.");
	    }
	    catch(Exception e) {
	       e.printStackTrace();
	    }
	    
	    
	    //~~~~~~~~~~~~~~~~~~~~~MODELS~~~~~~~~~~~~~~~~~~~~~//	    
		BlogPost post = new BlogPost();
		post.setTopComment(new Comment());
		Blog blog = new Blog();	
		//TODO: IN FINAL VERSION OF THIS SERVLET, IDS TO BLOG AND POST TO BE SENT VIA GET REQUEST
		
		//~~~~~~~~~~~~~~~~~~~~~Populate Object Fields from DB~~~~~~~~~~~~~~~~~~~~~//	
		
		//(NOTE: the below TODO statements reflect 5/11/22  demo objectives)
		//TODO: POPULATE BLOG TITLE FROM DB HERE 
		//TODO: POPULATE POST TITLE FROM DB HERE
		//TODO: POPULATE POST CONTENT FROM DB HERE
		//TODO: POPULATE COMMENT TITLE
		//TODO: POPULATE COMMENT TEXT
		/*TODO: DYNAMIC CONTENT: in future iterations this will use ID refs from 
		 * GET request to access specific blog, post, and comments.
		 * Any current (draft) queries do not represent final queries; to match
		 * content to be served in PAGE VIEW. 
		 */	
		
		//~~~~~~~~~~~~~~~~~~~~~PAGE VIEW~~~~~~~~~~~~~~~~~~~~~//
		
		//TODO: STYLE: provide visual formatting for title
		String blogTitle = ""; // TODO: REPLACE: DYNAMIC CONTENT: populate with user defined BLOG TITLE (?how? DB? file? idk yet);
	   	
		if (blogTitle == "") {
			//if user has not specified a custom title, then use default
			blogTitle = blogTitle + configObj.getInitParameter("title"); 
		}		
		//Blog title displays as page title and header
		out.println(HTML_START + "<title>" + blogTitle + "</title>" + HTML_BODY + "<h1>" + blogTitle + "</h1>");	
		
		//Blog Entry Title
		String entryTitle = ""; //TODO: DYNAMIC CONTENT: populate with post title from DB
		//TODO: NO CONTENT HANDLING: consider using try/catch (?) instead of if block
		/*if (entryTitle == "") {
			//if user has not specified a title....
			/*TODO: BLOG LOGIC: decide how to handle a lack of title --> just don't have one? display a default?
			 * (If the decision is to not show any title, maybe place print stmt inside if block)
		}*/
		entryTitle = entryTitle + "This Is A Blog Post"; //TODO: REMOVE: temporary, for dev purposes only
		out.println("<h2>" + entryTitle + "</h2>"); //TODO: REMOVE: temporary, for dev purposes only
		
		// Blog Entry Content 
		//TODO: DYNAMIC CONTENT: populate with post content from DB
		//TODO: ERROR HANDLING: use try/catch block to ensure content arrives from DB
		//TODO: NO CONTENT HANDLING: consider using try/catch (?) rather than an if block
		//TODO: BLOG LOGIC: there should not be empty content sections, this should be caught at the time a post is created/edited (separate servlet).
		out.println("<p>This is a stub for actual blog content. Eventually, there will be"
				+ "content being delivered via the DB.</p><p>In later versions content "
				+ "could also include media, style, and take on more complex representation "
				+ "in code.</p>"); //TODO: REMOVE: temporary, for dev purposes
		
		//TODO: STYLE: a visual break from the end of the entry content to start the comment section
		out.println("<hr />"); //TODO: REMOVE: temporary for dev purposes only
		
		//TODO: UI: Comment section
		out.println("<h3>Comments</h3><p>Eventually there will be form here to leave comments</p>"); //TODO: REMOVE: temporary for dev purposes only
		
		//end of page
		out.println(HTML_END);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
