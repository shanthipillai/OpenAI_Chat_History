package spring.ai.rag.budgetlatest;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	
	private final ChatClient chatClient;

	public ChatController(ChatClient.Builder builder) {
		super();
		this.chatClient = builder
				.defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
				.build();
	}
	
	@GetMapping
	public String chat(@RequestParam String cht)
	{
		return chatClient
				.prompt()
				.user(cht)
				.call()
				.content();
	}
	
}
