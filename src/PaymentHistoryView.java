
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class PaymentHistoryView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column firstName
				int resident_id = resultSet.getInt("resident_id");
				Date payment_history = resultSet.getDate("payment_history");
				
				// Display values
				System.out.print(resident_id + "\t");
				System.out.println(payment_history);
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer resident_id = getInteger("Resident ID : ", true);
		Date payment_history = (Date) getDate("Payment History : ", true);
		
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (resident_id != null) whereParameters.put("resident_id", resident_id);
		if (payment_history != null) whereParameters.put("payment_history", payment_history);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("PaymentHistory", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "resident_id, payment_history");

		List<Object> rows = new ArrayList<>();
		
		Date payment_history;
		Integer resident_id ;
		do
		{
			System.out.println("Fields to insert:");
			resident_id = getInteger("Resident ID : ", true);
			payment_history = (Date) getDate("Payment History : ", true);
			System.out.println();
					
			if (resident_id != null && payment_history != null) {
				rows.add(new PaymentHistory(resident_id,payment_history));
			}
		}
		while (resident_id != null && payment_history != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("PaymentHistory", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		Integer assistant_id = getInteger("Assistant ID : ", true);
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		String contactInfo = getString("Contact Info : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (assistant_id != null) updateParameters.put("assistant_id", firstName);
		if (firstName != null) updateParameters.put("firstName", firstName);
		if (lastName != null) updateParameters.put("lastName", lastName);
		if (contactInfo != null) updateParameters.put("contactInfo", firstName);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("AssistantManager", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("AssistantManager", "delete", parameters);
	}
	

	@Override
	public String toString() {
		return "AssistantManager View";
		}	
	}