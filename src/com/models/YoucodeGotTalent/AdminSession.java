package com.models.YoucodeGotTalent;

public class AdminSession {
	private long id;
	private long IdAdministrator;
	private boolean IsConnected;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdAdministrator() {
		return IdAdministrator;
	}

	public void setIdAdministrator(long idAdministrator) {
		IdAdministrator = idAdministrator;
	}

	public boolean isIsConnected() {
		return IsConnected;
	}

	public void setIsConnected(boolean isConnected) {
		IsConnected = isConnected;
	}

	@Override
	public String toString() {
		return "AdminSession [id=" + id + ", IdAdministrator=" + IdAdministrator + ", IsConnected=" + IsConnected + "]";
	}
	

}
