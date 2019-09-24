package models;

import java.util.Date;

public class AgendamentoModel {
	
	private int schedulingID;
	private Date date;
	private int animalID;
	private String service;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getSchedulingID() {
		return schedulingID;
	}

	public void setSchedulingID(int schedulingID) {
		this.schedulingID = schedulingID;
	}
	
	@Override
	public String toString() {
		return ("Data do agendamento: " + date.toString() + "\nServiço: " + service);
	}
}
