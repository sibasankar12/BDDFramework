package dependencyInjection;

public class EmailMessageService implements MessageService{

	@Override
	public void sendMessage(String message, String recipient) {
		System.out.println("Email Message recieved from user: "+recipient+"\n"
				+ "message: "+message);
		
	}

}
