package disi2022.controllers;

import disi2022.dtos.MailDTO;
import disi2022.events.ContactUsEvent;
import disi2022.services.MailService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/mail")
public class MailController {

    private final MailService mailService;

    private final ApplicationEventPublisher applicationEventPublisher;

    public MailController(MailService mailService, ApplicationEventPublisher applicationEventPublisher) {
        this.mailService = mailService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping
    public ResponseEntity<MailDTO> sendEmail(@RequestBody MailDTO dto) {
        applicationEventPublisher.publishEvent(new ContactUsEvent(dto));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
