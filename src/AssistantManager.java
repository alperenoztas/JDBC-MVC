

//This class is our model for storing Assistant Manager
public class AssistantManager {
    private int assistantId;
    private String firstName;
    private String lastName;
    private String contactInfo;
    private int managerId;

    public AssistantManager(int assistantId, String firstName, String lastName, String contactInfo, int managerId) {
        this.assistantId = assistantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.managerId = managerId;
    }
    
    public AssistantManager(int assistantId, String firstName, String lastName, String contactInfo) {
        this.assistantId = assistantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }

	public AssistantManager(String firstName, String lastName) {
		this.firstName = firstName ;
		this.lastName = lastName ;
	}

	public int getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(int assistantId) {
		this.assistantId = assistantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "assistantId" : return assistantId;
		case "firstName" : return firstName;
		case "lastName" : return lastName;
		case "contactInfo" : return contactInfo;
		case "managerId" : return managerId;
		default : return null;
		}
	}

	@Override
	public String toString() {
		return "AssistantManager [assistantId=" + assistantId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactInfo=" + contactInfo + ", managerId=" + managerId + "]";
	}

	

}
