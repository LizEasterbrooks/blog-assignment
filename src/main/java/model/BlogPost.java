package model;

//TODO: IMPORT: import needed things...? (use Paul's example as a guide)
/*NOTE: as of right now I don't need anything...? Feels wrong. We almost
 * 		include libraries in C/C++... something... I'm sure I'll run into
 * 		something I need eventually.
 */

//TODO: USE THESE WITH COMMENT (?)
//import java.util.List;
//import java.util.ArrayList;


class BlogPost {
	private int id; //does this need to be an int? 16K+ possible id numbers. Will it matter? (what if they make more than that X_X?)
	private int prev; //this would more or less link posts as a doubly linked list; is that necessary?
	private int next; //this would more or less link posts as a doubly linked list; is that necessary?
	//TODO: should date/time be represented as a string? (as of right now use is just to display, not calculate so...?)
	private String dateTimePosted;
	//TODO: consider adding a field for LAST EDIT
	private String content; //for now, content is plain text; TODO: consider separate model to accommodate media, style, etc
	//TODO: COMMENTS: the below needs to be a List of Comment objects... import that (? but same package...?)
	//private ArrayList<String> comments; //since all Java objects are accessed by refs... is this not actually disgusting and horrible?
	
	//Default constructor; create "blank" post
	public BlogPost() {
		id = 0;
		prev = 0;
		next = 0;
		dateTimePosted="";
		content="";
		//WRONG: the below needs to be a List of Comment objects... import that (? but same package...?)
		//but... where does the DB come into play? Do we want move all the text of each comment held in
		//the database into an object the moment the page is accessed? The DB makes this complicated.
		//comments = new ArrayList<String>();
	}
	
	//Overloaded constructor; requires args for all member fields
	public BlogPost(int postID, int prevPostID, int nextPostID, String date, String postContent) {
		id = postID; 
		//TODO: figure out if the doubly-linked list implied by this is a good idea in practice --> this means that if post deletion is a thing, there will need to be a servlet that handles updating the prev/next ids in the DB
		prev = prevPostID;
		next = nextPostID;
		dateTimePosted = date;
		content = postContent;
		//WRONG: the below needs to be a List of Comment objects... import that (? but same package...?)
		//...or maybe a list of id#? Figure out after figuring out DB interaction
		//comments = newArrayList<String>();	
	}
	
	//TODO: consider other constructors as necessary
	
	//TODO: decide: should the set methods return a success code? (Is that a very Java thing to do?)
	public int getID() {
		return id;
	}
	
	public void setID(int idNum) {
		id = idNum;
	}
	
	public int getPrevPostID() {
		return prev;
	}
	
	public void setPrevPostID(int idNum) {
		prev=idNum;
	}
	
	public int getNextPostID( ){
		return next;
	}
	
	public void setNextPostID(int idNum) {
		next=idNum;
	}
	
	public void setDatePosted(String date) {
		dateTimePosted = date;
	}
	
	public String getdateTimePosted() {
		return dateTimePosted;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String newContent) {
		content = newContent;	
	}
	/*note: this replaces any previous contents; logic for editing previous contents to be 
	 * implemented with both get/set in the controller(s).*/
	
	//AFTER DEALING WITH THE COMMENT OBJECT AND THE DB ISSUES, TODO: make applicable methods
	//some sort of get for comments (?)
	//some sort of add for comments (?)
	
	
	
	
	
	
	
	

}
