import java.util.Date;

//This class is our model for storing Payment
public class PaymentHistory {
    private int residentId;
    private Date payment_history;

    public PaymentHistory(int residentId, Date payment_history) {
        this.residentId = residentId;
        this.payment_history = payment_history;
    }

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}

	public Date getPayment_history() {
		return payment_history;
	}

	public void setPayment_history(Date payment_history) {
		this.payment_history = payment_history;
	}
	
	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "residentId" : return residentId;
		case "payment_history" : return payment_history;
		default : return null;
		}
	}

	@Override
	public String toString() {
		return "PaymentHistory [residentId=" + residentId + ", payment_history=" + payment_history + "]";
	}

    

}
