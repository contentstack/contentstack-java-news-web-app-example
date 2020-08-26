package io.contentstack.webapp;

public class NewsModel {
	
	private String title;
	private String description;
	private String image;


	public NewsModel() {

	}




	
	public NewsModel(String title, String description, String imageURL) {
		super();
		this.title = title;
		this.description = description;
		this.image = imageURL;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}
