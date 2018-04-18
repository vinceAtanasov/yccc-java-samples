package edu.yccc.java.samples.slack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yccc.cis174.slack.SlackService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSlackService 
{
	@Autowired
	SlackService slackService;
	
	private static List<String> randomMessage = new ArrayList<String>();
	static
	{
		randomMessage.add("Integration is fun!");
		randomMessage.add("Who's idea was this anyway?");
		randomMessage.add("Ok, enough is enough!");
	}
	
	private String getRandomMessage()
	{
		Random random = new Random();
		return randomMessage.get(random.nextInt(randomMessage.size()));
	}
	
	@Test
	public void testSendMessage()
	{
		slackService.sendMessage("#integration", "Webhook sample", getRandomMessage());
	}

}
