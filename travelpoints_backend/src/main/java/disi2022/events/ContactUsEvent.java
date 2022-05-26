package disi2022.events;

import disi2022.dtos.MailDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class ContactUsEvent  extends ApplicationEvent {

    private MailDTO mailDTO;
    public ContactUsEvent(MailDTO mailDTO) {
        super(mailDTO);
        this.mailDTO = mailDTO;
    }
}
