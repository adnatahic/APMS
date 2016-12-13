package ba.unsa.etf.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.unsa.etf.bp.bll.EncodedMessageService;
import ba.unsa.etf.bp.dto.EncodedMessageModel;

@RestController
@RequestMapping("api/")
public class EncodedMessageController {
	//@Autowired
	//private EncodedMessageRepository _encodedMessageRepository;
	
	@Autowired
	private EncodedMessageService _encodedMessageService;
	
	@CrossOrigin
	@RequestMapping(value="encodedmessages", method=RequestMethod.GET)
	public List<EncodedMessageModel> list() {
		return this._encodedMessageService.getAll();
	}
}
