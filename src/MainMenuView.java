import java.util.*;

class MainMenuView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		Integer choice;
		System.out.println("---------------");
		System.out.println("1. Resident");
		System.out.println("2. Assistant");
		System.out.println("3. Controller");
		System.out.println("4. Manager");
		System.out.println("5. Expense");
		System.out.println("---------------");
		choice = getInteger("Enter your choice : ", false);
		if(choice == 1) {
			do {
				System.out.println("/////////////////////////");
				System.out.println("1. Show all residents");
				System.out.println("2. Show residents");
				System.out.println("3. Add a resident");
				System.out.println("4. Update a resident");
				System.out.println("5. Delete a resident");
				System.out.println("6. Show roles");
				System.out.println("7. Payment Histories");
				System.out.println("8. Quit");
				System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

				choice = getInteger("Enter your choice : ", false);
			} 
			while (choice == null || choice < 1 || choice > 8);
			
			
			Map<String, Object> userInput = new HashMap<>();
			userInput.put("mainMenuChoice", choice);
			
			switch (choice.intValue()) {
			case 1: operationName = "select";		break;
			case 2: operationName = "select.gui";	break;
			case 3: operationName = "insert.gui";	break;
			case 4: operationName = "update.gui";	break;
			case 5: operationName = "delete.gui";	break;
			case 6: operationName = "select";       break;
			case 7: operationName = "select";       break;
			default: return new ViewData(null, null);
			}
			
			if(choice == 6) {
				return new ViewData("Role", operationName, new HashMap<>());
			}
			if(choice == 7) {
				return new ViewData("PaymentHistory",operationName,new HashMap<>());
			}
			return new ViewData("Resident", operationName, new HashMap<>());
		}
		else if(choice == 2) {
			do {
				System.out.println("1. Show all assistants");
				System.out.println("2. Show assistants");
				System.out.println("3. Add an assistant");
				System.out.println("4. Update an assistant");
				System.out.println("5. Delete an assistant");
				System.out.println("6. Show charges");
				System.out.println("7. Quit");
				System.out.println();

				choice = getInteger("Enter your choice : ", false);
			} 
			while (choice == null || choice < 1 || choice > 7);
			
			
			Map<String, Object> userInput = new HashMap<>();
			userInput.put("mainMenuChoice", choice);
			
			switch (choice.intValue()) {
			case 1: operationName = "select";		break;
			case 2: operationName = "select.gui";	break;
			case 3: operationName = "insert.gui";	break;
			case 4: operationName = "update.gui";	break;
			case 5: operationName = "delete.gui";	break;
			case 6: operationName = "select";    break;
			default: return new ViewData(null, null);
			}
			
			if(choice == 6) {
				return new ViewData("ChargeOf",operationName,new HashMap<>());
			}
			
			return new ViewData("AssistantManager", operationName, new HashMap<>());
		}
		else if(choice == 3) {
			do {
				System.out.println("1. Show all controllers");
				System.out.println("2. Show controllers");
				System.out.println("3. Add a controller");
				System.out.println("4. Update a controller");
				System.out.println("5. Delete a controller");
				System.out.println("6. Quit");
				System.out.println();

				choice = getInteger("Enter your choice : ", false);
			} 
			while (choice == null || choice < 1 || choice > 6);
			
			
			Map<String, Object> userInput = new HashMap<>();
			userInput.put("mainMenuChoice", choice);
			
			switch (choice.intValue()) {
			case 1: operationName = "select";		break;
			case 2: operationName = "select.gui";	break;
			case 3: operationName = "insert.gui";	break;
			case 4: operationName = "update.gui";	break;
			case 5: operationName = "delete.gui";	break;
			default: return new ViewData(null, null);
			}
			
			return new ViewData("ControllerDB", operationName, new HashMap<>());
		}
		else if (choice == 4) {
			do {
				System.out.println("1. Show all managers");
				System.out.println("2. Show managers");
				System.out.println("3. Add a manager");
				System.out.println("4. Update a manager");
				System.out.println("5. Delete a manager");
				System.out.println("6. Quit");
				System.out.println();

				choice = getInteger("Enter your choice : ", false);
			} 
			while (choice == null || choice < 1 || choice > 6);
			
			
			Map<String, Object> userInput = new HashMap<>();
			userInput.put("mainMenuChoice", choice);
			
			switch (choice.intValue()) {
			case 1: operationName = "select";		break;
			case 2: operationName = "select.gui";	break;
			case 3: operationName = "insert.gui";	break;
			case 4: operationName = "update.gui";	break;
			case 5: operationName = "delete.gui";	break;
			default: return new ViewData(null, null);
			}
			
			return new ViewData("Manager", operationName, new HashMap<>());
		}
		else if(choice == 5) {
			do {
				System.out.println("1. Show all expenses");
				System.out.println("2. Show expenses");
				System.out.println("3. Add an expense");
				System.out.println("4. Update an expense");
				System.out.println("5. Delete an expense");
				System.out.println("6. Quit");
				System.out.println();

				choice = getInteger("Enter your choice : ", false);
			} 
			while (choice == null || choice < 1 || choice > 6);
			
			
			Map<String, Object> userInput = new HashMap<>();
			userInput.put("mainMenuChoice", choice);
			
			switch (choice.intValue()) {
			case 1: operationName = "select";		break;
			case 2: operationName = "select.gui";	break;
			case 3: operationName = "insert.gui";	break;
			case 4: operationName = "update.gui";	break;
			case 5: operationName = "delete.gui";	break;
			default: return new ViewData(null, null);
			}
			
			return new ViewData("Expense", operationName, new HashMap<>());
		}
		
		
		return new ViewData(null, null, null);
			
	}
	@Override
	public String toString() {
		return "Main Menu View";
	}	
				
	
				
		
		

	
		
		
		
		
		
		
		
		
		
		
		
		
}
