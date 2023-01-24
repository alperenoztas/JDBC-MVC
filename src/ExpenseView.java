
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ExpenseView implements ViewInterface {

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
				int expense_id = resultSet.getInt("expense_id");
				int resident_id = resultSet.getInt("resident_id");
				int assistant_id = resultSet.getInt("assistant_id");
				int controller_id = resultSet.getInt("controller_id");
				Date date = resultSet.getDate("date");
				int type = resultSet.getInt("type");
				
				// Display values
				System.out.print(expense_id + "\t");
				System.out.print(resident_id + "\t");
				System.out.print(assistant_id + "\t");
				System.out.print(controller_id + "\t");
				System.out.print(date + "\t");
				System.out.println(type);
				
				
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
		Integer expense_id = getInteger("Expense ID : ", true);
		Integer resident_id = getInteger("Resident ID : ", true);
		Integer assistant_id = getInteger("Assistant ID : ", true);
		Integer type = getInteger("Type (1/0) : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (expense_id != null) whereParameters.put("expense_id", expense_id);
		if (resident_id != null) whereParameters.put("resident_id", resident_id);
		if (assistant_id != null) whereParameters.put("LastName", assistant_id);
		if (type != null) whereParameters.put("type", type);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Expense", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		
		
		parameters.put("fieldNames", "expense_id, resident_id, assistant_id, controller_id, date, type ");

		List<Object> rows = new ArrayList<>();
		
		Integer expense_id, resident_id, assistant_id, controller_id, type;
		Date date;
		do
		{
			System.out.println("Fields to insert:");
			expense_id = getInteger("Expense ID : ", true);
			resident_id = getInteger("Resident ID : ", true);
			assistant_id = getInteger("Assistant ID : ", true);
			controller_id = getInteger("Controller ID : ", true);
			date = getDate("Date : ", true);
			type = getInteger("Resident ID : ", true);
			System.out.println();
					
			if (expense_id != null && resident_id != null && assistant_id != null && controller_id != null && date != null && type != null) {
				rows.add(new Expense(expense_id, resident_id, assistant_id, controller_id, date, type));
			}
		}
		while (expense_id != null && resident_id != null && assistant_id != null && controller_id != null && date != null && type != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("ControllerDB", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		Integer expense_id = getInteger("expense_id", true);
		Integer resident_id = getInteger("resident_id", true);
		Integer assistant_id = getInteger("assistant_id", true);
		Integer controller_id = getInteger("controller_id", true);
		Date date = getDate("Date : ", true);
		Integer type = getInteger("Type : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (expense_id != null) updateParameters.put("expense_id", expense_id);
		if (resident_id != null) updateParameters.put("resident_id", resident_id);
		if (assistant_id != null) updateParameters.put("assistant_id", assistant_id);
		if (controller_id != null) updateParameters.put("controller_id", controller_id);
		if (date != null) updateParameters.put("date", date);
		if (type != null) updateParameters.put("type", type);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Expense", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Expense", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Expense View";
	}		
}
