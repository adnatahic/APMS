package ba.unsa.etf.bp.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.unsa.etf.bp.dto.EncodedMessageModel;
import ba.unsa.etf.bp.model.EncodedMessage;
import ba.unsa.etf.bp.repository.EncodedMessageRepository;

@Service
public class EncodedMessageService {
	
	@Autowired
	private EncodedMessageRepository _encodedMessageRepository;
	
	public List<EncodedMessageModel> getAll() {
		List<EncodedMessage> em = this._encodedMessageRepository.findAll();
		List<EncodedMessageModel> emm = new ArrayList<EncodedMessageModel>();
		for (EncodedMessage message : em) {
			emm.add(new EncodedMessageModel(message));
		}
		
		return emm;
	}
}
