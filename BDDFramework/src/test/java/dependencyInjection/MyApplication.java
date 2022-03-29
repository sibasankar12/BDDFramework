package dependencyInjection;

import com.google.inject.Inject;

public class MyApplication {
	
	private MessageService messageService;
	
	@Inject
	public MyApplication(MessageService service) {
		this.messageService=service;
	}
	
	public void sendMessage(String msg,String rec) {
		messageService.sendMessage(msg, rec);
	}

}
