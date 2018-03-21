package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.scheduler.EmailScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestSimpleEmailService {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {

        // Given
        Mail mail = new Mail("test@test.com", "", TrelloService.SUBJECT, "Test Message");
        MimeMessagePreparator mimeMailMessage = simpleEmailService.createMimeMessage(mail);

        // When
        javaMailSender.send(mimeMailMessage);

        // Then
        verify(javaMailSender, times(1)).send(mimeMailMessage);

    }

}