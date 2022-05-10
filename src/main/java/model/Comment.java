package model;

//TODO: IMPORT: import needed things...? (use Paul's example as a guide)

class Comment {
	//TODO: CREATE MORE STUBS TO OUTLINE THE FIELDS AND METHODS OF THIS CLASS
	private int id;
	private int prev;						//there is a prev(ious) comment if this is a reply
	private int next;						//there is next comment if there is a reply to this
	//TODO: should date/time be represented as a string? (as of right now use is just to display, not calculate so...?)
	private String dateTimePosted;
	private String commentText;				//TODO: consider separate model to accomodate media or style (?) 
	
	//TODO: ALL BELOW - in progress
	
	//Default constructor; create "blank" comment
	public Comment() {
		id = 0;
		prev = 0;
		next = 0;
		dateTimePosted = "";
		commentText="";		
	}
	
	//Overloaded constructor; requires args for all member fields
	public Comment(int id, int prev, int next, String dateTimePosted, String commentText) {
		this.id = id;
		this.prev = prev;
		this.next = next;
		this.dateTimePosted = dateTimePosted;
		this.commentText = commentText;
	}
	//TODO: get and set for all fields - in progress
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
	
	public String getCommentText() {
		return commentText;
	}
	
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	/*note: this replaces any previous contents; logic for editing previous contents to be 
	 * implemented with both get/set in the controller(s).*/
	
	//TODO: ? more ?
	
}
