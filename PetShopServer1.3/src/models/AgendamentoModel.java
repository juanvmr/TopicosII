package models;

public class AgendamentoModel {
	
	private int schedulingID;
	private String date;
	private String animal;
	private String service;
	
	public AgendamentoModel() {
		
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
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
