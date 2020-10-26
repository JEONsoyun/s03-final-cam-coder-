package com.coder.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.coder.demo.dao.MessageDAO;
import com.coder.demo.vo.Message;

@SpringBootApplication
public class CamcoderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(CamcoderApplication.class, args);
		
		/*MessageDAO medao = context.getBean(MessageDAO.class);
		
		medao.save(new Message("receiver", 1, 2));
		
		Message message = medao.findByMessageCode(3);
		System.out.println(message.toString());
		message = medao.findByMessageCode(4);
		System.out.println(message.toString());*/
	}

}
