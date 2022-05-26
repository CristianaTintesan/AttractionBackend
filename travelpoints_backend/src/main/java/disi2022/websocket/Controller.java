package disi2022.websocket;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {

    @SendTo("/topic/message")
    public MessageDTO broadcastMessage(@Payload MessageDTO messageDTO) {
        return messageDTO;
    }
}
