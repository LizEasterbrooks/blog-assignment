package model;

//TODO: IMPORT: import needed things...? (use Paul's example as a guide)

class Blog {
	//TODO: CREATE MORE STUBS TO OUTLINE THE FIELDS AND METHODS OF THIS CLASS - in progress
	
	private String title;
	private String description;
	/*REPRESENTATION OF COLLECTIVE BLOG POSTS. Should I just have the integer "id" for the top post
	 * since they are all going to be linked by their ids in the database? Something else?
	 * TODO decide how to represent all the blog posts the blog has.
	 */
	
	//TODO: fill out the methods - in progress
	//default constructor
	public Blog() {
		title = "";
		description = "";
	}
	
	//constructor with all args
	public Blog(String title, String description) {
		this.title = title;
		this.description = description;
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
	
	//TODO: BLOG POST: A get and a set for whatever form the blog posts take.... more?
	

}
