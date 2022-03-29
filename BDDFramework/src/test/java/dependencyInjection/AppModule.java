package dependencyInjection;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(MessageService.class).to(EmailMessageService.class);
	}

}
