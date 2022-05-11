package model;

public class Comment {
	private int id;
	private int prev;
	private int next;
	//TODO: add linked list logic to represent the idea of REPLIES in future iteration; int prevReply and int nextReply
	private String dateTimePosted;	//TODO: split date and time and represent as date and time types in future iteration
	//TODO: consider adding fields to represent date and time updated in future iteration
	private String commentText;		//TODO: separate model to accommodate media or style in future iteration
	
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
}
