package trab_laboratorio;


public class Calls {
	
	private String numPhoneDestination;
	private String callType;
	private double callDuration;
	
	
	public Calls() {
		this.numPhoneDestination = null;
		this.callType = null;
		this.callDuration = 0.0;
	}
	
	
	public String getNumPhoneDestination() {
		return numPhoneDestination;
	}

	public void setNumPhoneDestination(String numPhoneDestination) {
		this.numPhoneDestination = numPhoneDestination;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public double getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(double callDuration) {
		this.callDuration = callDuration;
	}

	@Override
	public String toString() {
		return "\nNumPhoneDestination=" + numPhoneDestination + "; CallType=" + callType + "; CallDuration="
				+ callDuration + "min" + "\n";
	}
	
}
