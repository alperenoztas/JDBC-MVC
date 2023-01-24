public class Resident {
    private int residentId;
	private String firstName;
    private String lastName;
    private int D_No;
    private String contactInfo;
    private int controllerId;

    public Resident(int residentId, String firstName, String lastName, int D_No, String contactInfo, int controllerId) {
        this.residentId = residentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.D_No = D_No;
        this.contactInfo = contactInfo;
        this.controllerId = controllerId;
    }
    
    public Resident(String firstName, String lastName,int controller_id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.controllerId = controller_id;
	}

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
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

	public int getD_No() {
		return D_No;
	}

	public void setD_No(int d_No) {
		D_No = d_No;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public int getControllerId() {
		return controllerId;
	}

	public void setControllerId(int controllerId) {
		this.controllerId = controllerId;
	}
	
	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "residentId" : return residentId;
		case "firstName" : return firstName;
		case "lastName" : return lastName;
		case "D_No" : return D_No;
		case "contactInfo" : return contactInfo;
		case "controllerId" : return controllerId;
		default : return null;
		}
	}

	@Override
	public String toString() {
		return "Resident [residentId=" + residentId + ", firstName=" + firstName + ", lastName=" + lastName + ", D_No="
				+ D_No + ", contactInfo=" + contactInfo + ", controllerId=" + controllerId + "]";
	}
	
	
    
}

