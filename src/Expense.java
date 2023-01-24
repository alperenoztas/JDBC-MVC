import java.util.Date;


//This class is our model for storing Expense
public class Expense {
    private int expense_id;
    private int resident_id;
    private int assistant_id;
    private int controller_id;
    private Date date;
    private int type;

    public Expense(int expense_id, int resident_id, int assistant_id,int controller_id, Date date, int type) {
        this.expense_id = expense_id;
        this.resident_id = resident_id;
        this.assistant_id = assistant_id;
        this.controller_id = controller_id;
        this.date = date;
        this.type = type;
    }

	public int getExpenseId() {
		return expense_id;
	}

	public void setExpenseId(int expense_id) {
		this.expense_id = expense_id;
	}

	public int getResidentId() {
		return resident_id;
	}

	public void setResidentId(int resident_id) {
		this.resident_id = resident_id;
	}

	public int getAssistantId() {
		return assistant_id;
	}

	public void setAssistantId(int assistant_id) {
		this.assistant_id = assistant_id;
	}

	public int getControllerId() {
		return controller_id;
	}

	public void setControllerId(int controller_id) {
		this.controller_id = controller_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "expense_id" : return expense_id;
		case "resident_id" : return resident_id;
		case "assistant_id" : return assistant_id;
		case "controller_id" : return controller_id;
		case "date" : return date;
		case "type" : return type;
		default : return null;
		}
	}

	@Override
	public String toString() {
		return "Expense [expense_id=" + expense_id + ", resident_id=" + resident_id + ", assistant_id=" + assistant_id
				+ ", controller_id=" + controller_id + ", date=" + date + ", type=" + type + "]";
	}
    
	
}