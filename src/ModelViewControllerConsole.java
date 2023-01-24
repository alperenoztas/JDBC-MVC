import java.util.*;


public class ModelViewControllerConsole {

	public static void main(String[] args) throws Exception {
		// Connect to database
		connectToDatabase();

		
		// Model View Controller (MVC)
		// Router knows all the controllers
		Map<String, Controller> router = new HashMap<>();		
		router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
		router.put("Resident", new Controller(new ResidentView(), new ResidentModel()));
		router.put("AssistantManager", new Controller(new AssistantManagerView(), new AssistantManagerModel()));
		router.put("ControllerDB", new Controller(new ControllerView(),new ControllerModel()));
		router.put("Expense", new Controller(new ExpenseView(),new ExpenseModel()));
		router.put("Manager", new Controller(new ManagerView(),new ManagerModel()));
		router.put("Role", new Controller(new RoleView(),new RoleModel()));
		router.put("ChargeOf", new Controller(new ChargeOfView(),new ChargeOfModel()));
		router.put("PaymentHistory", new Controller(new PaymentHistoryView(),new PaymentHistoryModel()));

		ViewData viewData = new ViewData("MainMenu", "");		
		do {
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);
			ModelData modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println();
		}
		while (viewData.functionName != null);
		
		System.out.println();
		System.out.println();
		System.out.println("Program is ended...");


		// Disconnect from database
		disconnectFromDatabase();
	}

	
	public static void connectToDatabase() {
		DatabaseUtilities.host = "DESKTOP-34RAON6:1433";
		DatabaseUtilities.databaseName = "PROJECT";
		
		try {
			DatabaseUtilities.getConnection();
		}
		catch(Exception e) {
			System.out.println("Exception occured : " + e);
			return;
		}		
	}
	
	public static void disconnectFromDatabase() {
		try {
			DatabaseUtilities.disconnect();
		}
		catch(Exception e) {
			System.out.println("Error disconnecting from database : " + e);
			return;
		}		
	}
	
}
