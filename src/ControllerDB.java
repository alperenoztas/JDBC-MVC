
public class ControllerDB {
  private int controller_id;
  private String firstName;
  private String lastName;
  private String contactInfo;
  private int manager_id;

  public ControllerDB(int controller_id, String firstName, String lastName, String contactInfo, int manager_id) {
    this.controller_id = controller_id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.contactInfo = contactInfo;
    this.manager_id = manager_id;
  }
  
  public ControllerDB(int controller_id, String firstName, String lastName, String contactInfo) {
	    this.controller_id = controller_id;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.contactInfo = contactInfo;
	  }

  
  	public ControllerDB(String firstName, String lastName) {
  		this.firstName = firstName;
  		this.lastName = lastName;
  	}


	public ControllerDB(String firstName, String lastName, int controller_id) {
		this.firstName = firstName;
  		this.lastName = lastName;
		this.controller_id = controller_id;
	}


	public int getControllerId() {
	    return controller_id;
	}

	public void setControllerId(int controller_id) {
	    this.controller_id = controller_id;
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
	    return manager_id;
	}

	public void setManagerId(int manager_id) {
	    this.manager_id = manager_id;
	}
	
	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "controller_id" : return controller_id;
		case "firstName" : return firstName;
		case "lastName" : return lastName;
		case "contactInfo" : return contactInfo;
		case "manager_id" : return manager_id;
		default : return null;
		}
	}
		public String toString() {
			return "Controller [controller_id=" + controller_id + ", firstName=" + firstName + ", lastName=" + lastName 
					+ ", contactInfo=" + contactInfo + ",manager_id=" + manager_id + "]";
	}
	
	
  
}
