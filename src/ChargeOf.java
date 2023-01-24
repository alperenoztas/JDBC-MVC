

//This class is our model for storing Charge Of
public class ChargeOf {
    private int residentId;
    private int assistantId;

    public ChargeOf(int residentId, int assistantId) {
        this.residentId = residentId;
        this.assistantId = assistantId;
    }

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}

	public int getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(int assistantId) {
		this.assistantId = assistantId;
	}

	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "residentId" : return residentId;
		case "assistantId" : return assistantId;
		default : return null;
		}
	}

	@Override
	public String toString() {
		return "ChargeOf [residentId=" + residentId + ", assistantId=" + assistantId + "]";
	}
	
	
}

