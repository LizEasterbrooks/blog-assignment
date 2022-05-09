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

//TODO: MODEL: create and import a class for BlogPost to hold post info

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
	
	//TODO: MODEL: (here?) create instance of blog post (or do it in the method...?) THINK. RESEARCH. DECIDE.
	//(cont.) consider that there will need to be error handling in the case that the requested entry does not
	//exist, like a "Sorry that blog post doesn't exist!" route, TBD when we know how separate posts will be accessed.
       
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
		PrintWriter out = response.getWriter(); 	
		ServletConfig configObj = getServletConfig(); // TODO this will likely pull on another object representing the USER?? saved somehow???
		
		//TODO: VISUAL: provide visual formatting for title
		String title = ""; // TODO: DYNAMIC CONTENT: populate with user defined TITLE (?how? DB? file? idk yet);
		if (title == "") {
			//if user has not specified a custom title, then use default
			title = title + configObj.getInitParameter("title"); 
		}		
		//Blog title displays as page title and header
		out.println(HTML_START + "<title>" + title + "</title>" + HTML_BODY + "<h1>" + title + "</h1>");	
		
		//Blog Entry Title
		String entryTitle = ""; //TODO: DYNAMIC CONTENT: populate with post title from DB
		//TODO: ERROR HANDLING: use try/catch block to ensure content arrives from DB
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
				+ "content being delivered via the DB.</p><p>Hopefully it will be cool :3</p>"); //TODO: REMOVE: temporary, for dev purposes
		
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
