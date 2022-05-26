package disi2022.services;

import disi2022.dtos.MailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class MailService {
    private final JavaMailSender mailSender;
    private final String contactUsTemplate="src/main/resources/templates/contact-us.txt";
    public MailService(JavaMailSender mailSender)
    {
        this.mailSender=mailSender;
    }
    public void sendContactUsEmail(MailDTO mailDTO) {
        sendMessage( mailDTO.getSubject(), generateBody(mailDTO,contactUsTemplate));
    }

    public void sendMessage(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("travel.disi2022@gmail.com");
        message.setFrom("noreply.traveldisi@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }


    private String generateBody(Object templateContext, String template) {

        try {
            String text = new String(Files.readAllBytes(Paths.get(template)));
            Expression expression = new SpelExpressionParser().parseExpression(text, new TemplateParserContext());
            return (String) expression.getValue(new StandardEvaluationContext(templateContext));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
