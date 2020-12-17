package com.models.YoucodeGotTalent;

import java.sql.Timestamp;

public class Participation {
	private long idUser;
	private long idCategory;
	private String description;
	private Timestamp ShowStartTime;
	private Timestamp ShowEndTime;
	private String attachedFile;
	private boolean is_accepted;
	
public Participation(long idUser, long idCategory, String description, Timestamp showStartTime,
			Timestamp showEndTime, String attachedFile, boolean is_accepted) {
		this.idUser = idUser;
		this.idCategory = idCategory;
		this.description = description;
		this.ShowStartTime = showStartTime;
		this.ShowEndTime = showEndTime;
		this.attachedFile = attachedFile;
		this.is_accepted = is_accepted;
	}

	//getters and setters 
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public long getIdCategory() {
		return idCategory;
	}

	

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public Timestamp getShowStartTime() {
		return ShowStartTime;
	}

	public void setShowStartTime(Timestamp showStartTime) {
		ShowStartTime = showStartTime;
	}

	public Timestamp getShowEndTime() {
		return ShowEndTime;
	}
	public void setShowEndTime(Timestamp showEndTime) {
		ShowEndTime = showEndTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}

	public boolean isIs_accepted() {
		return is_accepted;
	}

	public void setIs_accepted(boolean is_accepted) {
		this.is_accepted = is_accepted;
	}

	@Override
	public String toString() {
		return "Participation [idUser=" + idUser + ", idCategory=" + idCategory + ", description=" + description
				+ ", ShowStartTime=" + ShowStartTime + ", ShowEndTime=" + ShowEndTime + ", attachedFile=" + attachedFile
				+ ", is_accepted=" + is_accepted + "]";
	}

	
	
}
