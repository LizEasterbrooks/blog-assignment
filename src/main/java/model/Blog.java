package model;

public class Blog {
	
	private String title;
	private String description;
	private BlogPost topPost;
	/*TOP_POST REPRESENTATION OF ALL BLOG POSTS. As of right now BlogPosts are intended to
	 * related to each other as a FILO doubly-linked list, using the DB id primary keys
	 * as identifiers. Access to all other blog posts will be handled by stepping through the
	 * list using the recent most post (topPost) at the access point. This requires additional methods
	 * in future development to handle access, additions, and deletions of posts (including re-linking 
	 * after deletion which would be represented as set to NULL in db). 
	 * TODO consider better ways to represent all blog posts a blog has without the overhead of loading 
	 * all posts into a blog object from db.
	 */
	
	//default constructor
	public Blog() {
		title = "";
		description = "";
		topPost = null;
	}
	
	//constructor with all args
	public Blog(String title, String description, BlogPost topPost) {
		this.title = title;
		this.description = description;
		this.topPost = topPost;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	/*note: this replaces any previous contents; logic for editing previous contents to be 
	 * implemented with both get/set in the controller(s).*/
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description =  description;
	}
	/*note: this replaces any previous contents; logic for editing previous contents to be 
	 * implemented with both get/set in the controller(s).*/
	
	public BlogPost getTopPost() {
		return topPost;
	}
	
	public void setTopPost(BlogPost topPost) {
		this.topPost =  topPost;
	}
	//note: logic for accessing all posts handled by control layer; see note on topPost declaration above.
}
