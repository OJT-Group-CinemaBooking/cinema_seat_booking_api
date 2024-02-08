package com.hostmdy.cinema.utility;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.hostmdy.cinema.domain.BoughtSeat;
import com.hostmdy.cinema.domain.Ticket;
import com.hostmdy.cinema.domain.UserPayment;

import jakarta.mail.internet.InternetAddress;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailConstructor {
	
	private final TemplateEngine templateEngine;
	private final ClassPathFileLoader classpathFileLoader;
	private final Environment env;
	
	public SimpleMailMessage constructSimpleMail(String subject,String message,String to,String from) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(subject);
		email.setText(message);
		return email;
	}
	
	public MimeMessagePreparator constructTemplateMail(String to,String subject,Ticket ticket , List<BoughtSeat> boughtSeats , UserPayment userpayment) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			Context context = new Context();
			context.setVariable("ticket", ticket);
			context.setVariable("boughtSeats", boughtSeats);
			context.setVariable("payment", userpayment);
			
			String text = templateEngine.process("ticket", context);
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,StandardCharsets.UTF_8.name());
			
			messageHelper.setFrom(env.getProperty("support.mail"));
			messageHelper.setTo(new InternetAddress(to));
			messageHelper.setSubject(subject);
			messageHelper.setText(text,true);
			
			String imagePath = "static/images/logo.png";
			
			// Add the image as an inline attachment
            ClassPathResource imageResource = new ClassPathResource(imagePath);
            messageHelper.addInline("imageId", imageResource);
            
//            for(final CartItem cartItem : order.getCartItems()) {
//            	Long productId = cartItem.getProduct().getId();
//            	messageHelper.addInline("product-"+productId,new ClassPathResource("static/images/product/"+productId+".jpg"));
//            }
		};
		
		return messagePreparator;
	}
	
	public MimeMessagePreparator constructAttachmentMail(String to,String subject,String filePath,String text) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
			messageHelper.setFrom(env.getProperty("support.mail"));
			messageHelper.setTo(new InternetAddress(to));
			messageHelper.setSubject(subject);
			messageHelper.setText(text);
			messageHelper.addAttachment("Attachment",new File(classpathFileLoader.getClassPathFileRelativePath(filePath)));
		};
		
		return messagePreparator;
	}

	
	
}

