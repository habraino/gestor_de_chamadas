package trab_laboratorio;

import java.util.ArrayList;

public class Client {
	
	private String name;
	private int numClient;
	private String address;
	private String phoneNumber;
	private ArrayList<Calls> callsList = null;
	
	public Client() {
		callsList = new ArrayList<Calls>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Calls> getCallsList() {
		return callsList;
	}

	public void setCallsList(Calls call) {
		this.callsList.add(call);
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// method to calculate the call price
	public double calculatePrice() {
		double total = 0.0;
		for (Calls c: callsList) {
			if (c.getCallType().equalsIgnoreCase("F")) {
				total += c.getCallDuration() * 2.5;
			} 
			if (c.getCallType().equalsIgnoreCase("I")) {
				total += c.getCallDuration() * 10.4;
			}
			if (c.getCallType().equalsIgnoreCase("P")) {
				total += c.getCallDuration() * 1.25;
			}
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "**********************************\n" +
				"\tData of "+ this.getName() +
				"\n**********************************\n" +
				"Nome...............: " + this.getName() + 
				"\nNumber of Client...: " + this.getNumClient() + 
				"\nAddress............: " + this.getAddress() +
				"\nPhone Number.......: " + "+" + this.getPhoneNumber() +
				"\nCalls List.........: \n" + this.getCallsList();
	}
	
	

}
