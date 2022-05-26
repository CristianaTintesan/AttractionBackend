package disi2022.events.listeners;


import disi2022.events.ContactUsEvent;
import disi2022.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class ContactUsListener implements ApplicationListener<ContactUsEvent> {
    private final MailService mailService;

    @Override
    public void onApplicationEvent(ContactUsEvent event) {
        mailService.sendContactUsEmail(event.getMailDTO());

    }
}
