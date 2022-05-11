package model;

public class BlogPost {
	private int id; 					//TODO: consider: how would we handle more than the max size of int posts?
	private int prev; 
	private int next; 
	private String dateTimePosted;		//TODO: split date and time and represent as date and time types in next version
	private String dateTimeUpdated;		//TODO: split date and time and represent as date and time types in future iteration
	private String content;  			//TODO: separate model to accommodate media or style in future iteration
	private Comment topComment;
	/*TOP_COMMENT REPRESENTATION OF ALL COMMENTS. As of right now  are intended to
	 * related to each other as  FIFO doubly-linked list, using the DB id primary keys
	 * as identifiers. Access to all other comments on a post will be handled by stepping through the
	 * list using the recent most comment (topComment) at the access point. This requires additional methods
	 * in future development to handle access, additions, and deletions of posts (including re-linking 
	 * after deletion which would be represented as set to NULL in db). 
	 * TODO consider better design to represent all comments on post.
	 * TODO also consider design to represent replies (additional linked list mechanics?)
	 */
	
	//Default constructor; create "blank" post
	public BlogPost() {
		id = 0;
		prev = 0;
		next = 0;
		dateTimePosted="";
		dateTimeUpdated="";
		content="";
		topComment=null;
	}
	
	//Overloaded constructor; requires args for all member fields
	public BlogPost(int id, int prev, int next, String dateTimePosted, String dateTimeUpdated, String content, Comment topComment) {
		this.id = id; 
		//TODO: figure out if the doubly-linked list implied by this is a good idea in practice --> this means that if post deletion is a thing, there will need to be a servlet that handles updating the prev/next ids in the DB
		this.prev = prev;
		this.next = next;
		this.dateTimePosted = dateTimePosted;
		this.dateTimeUpdated = dateTimeUpdated;
		this.content = content;
		this.topComment = topComment;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public String getDateTimePosted() {
		return dateTimePosted;
	}

	public void setDateTimePosted(String dateTimePosted) {
		this.dateTimePosted = dateTimePosted;
	}

	public String getDateTimeUpdated() {
		return dateTimeUpdated;
	}

	public void setDateTimeUpdated(String dateTimeUpdated) {
		this.dateTimeUpdated = dateTimeUpdated;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	/*note: this replaces any previous contents; logic for editing previous contents to be 
	 * implemented with both get/set in the controller(s).*/

	public Comment getTopComment() {
		return topComment;
	}

	public void setTopComment(Comment topComment) {
		this.topComment = topComment;
	}
}
