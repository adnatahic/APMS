package ba.unsa.etf.bp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.unsa.etf.bp.bll.MessageService;
import ba.unsa.etf.bp.dto.MessageModel;

@RestController
@RequestMapping("api/")
public class MessageController {
	@Autowired
	private MessageService _messageService;
	
	@CrossOrigin
	@RequestMapping(value="message", method=RequestMethod.GET)
	public MessageModel getLastMessageForNode(@RequestParam Long nodeId) {
		return this._messageService.getLastMessageFroNode(nodeId);
	}
	
	@CrossOrigin
	@RequestMapping(value="messages", method=RequestMethod.GET) 
	public List<MessageModel> getMessagesForNodeWithTimestamp(@RequestParam Long nodeId,
															  @RequestParam @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date from,
															  @RequestParam @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date to) {
		return this._messageService.getMessagesForNodeWithTimestapm(nodeId, from, to);
	}
	
}
