package io.contentstack.webapp.models;

/**
 * The type News model.
 */
public class NewsModel {
	
	private String title;
	private String description;
	private String image;

	/**
	 * Instantiates a new News model.
	 *
	 * @param title       the title
	 * @param description the description
	 * @param imageURL    the image url
	 */
	public NewsModel(String title, String description, String imageURL) {
		super();
		this.title = title;
		this.description = description;
		this.image = imageURL;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets image.
	 *
	 * @param image the image
	 */
	public void setImage(String image) {
		this.image = image;
	}

}
