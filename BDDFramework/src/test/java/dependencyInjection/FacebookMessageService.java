package dependencyInjection;

public class FacebookMessageService implements MessageService{

	@Override
	public void sendMessage(String message, String recipient) {
		System.out.println("Facebook Message recieved from user: "+recipient+"\n"
				+ "message: "+message);
		
	}

}
