package ba.unsa.etf.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.unsa.etf.bp.model.EncodedMessage;
import ba.unsa.etf.bp.repository.EncodedMessageRepository;

@RestController
//@RequestMapping("api/")
public class EncodedMessageController {
	@Autowired
	private EncodedMessageRepository _encodedMessageRepository;
	
	@RequestMapping(value="encodedmessages", method=RequestMethod.GET)
	public List<EncodedMessage> list() {
		return this._encodedMessageRepository.findAll();
	}
}
