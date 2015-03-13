package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Access(AccessType.PROPERTY)
public class Image {

	private byte[] data;
	private String mediaType;

	public Image() {
		super();
	}
	
	
	@Lob
	public byte[] getData() {
		return data;
	}



	public void setData(byte[] data) {
		this.data = data;
	}



	public String getMediaType() {
		return mediaType;
	}



	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}


}
