package test_strut;

public class HelloWorld {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HELP");
		UserConnect a = new UserConnect();
		a.connectDB();
		String[] params = new String[2];
		params[0] = "kenny";
		params[1] = "password";
		
		a.validateUserNamePassword(params);

	}
	
}
