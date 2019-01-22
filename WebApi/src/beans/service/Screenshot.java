package beans.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_image")
public class Screenshot {
	private byte [] image;
	@Id
	private String imageName;
	private String imageTime;
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageTime() {
		return imageTime;
	}
	public void setImageTime(String imageTime) {
		this.imageTime = imageTime;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

	
}
