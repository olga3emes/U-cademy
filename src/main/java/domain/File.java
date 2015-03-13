package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)

public class File extends DomainEntity{
//Constructores
	public File(){
		super();
	}

	//Atributos
	private Date uploadMoment;
	private byte[] data;
	private String mediaType;

	
	
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
	
	public Date getUploadMoment() {
		return uploadMoment;
	}


	public void setUploadMoment(Date uploadMoment) {
		this.uploadMoment = uploadMoment;
	}
	
	//Relaciones
	private Folder folder;

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Folder getFolder() {
		return folder;
	}


	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	
}
