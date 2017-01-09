package ba.unsa.etf.bp.bll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Member;

import ba.unsa.etf.bp.dto.MeasureModel;
import ba.unsa.etf.bp.dto.MessageModel;
import ba.unsa.etf.bp.model.EncodedMessage;
import ba.unsa.etf.bp.model.IOBlock;
import ba.unsa.etf.bp.repository.EncodedMessageRepository;
import ba.unsa.etf.bp.repository.IOBlockRepository;

@Service
public class MessageService {
	@Autowired
	private EncodedMessageRepository _encodedMessageRepository;
	
	@Autowired
	private IOBlockRepository _IOBlockRepository;
	
	public MessageModel getLastMessageFroNode(Long nodeId) {
		EncodedMessage em = this._encodedMessageRepository.queryLastEncodedMessageByNode(nodeId, new PageRequest(0, 1)).get(0);
		List<IOBlock> ioBlocks = this._IOBlockRepository.queryIOBlocksByNodeId(nodeId);
		
		MessageModel message = new MessageModel(em.getId(), em.getCreationTime(), em.getLat(), em.getLng(), em.getGatewayIP(), em.getProtocol());
		double[] data =  Arrays.stream(em.getEncodedData().split("\\s*,\\s*")).mapToDouble(Double::parseDouble).toArray();
		
		List<MeasureModel> measurements = new ArrayList<MeasureModel>();
		for(int i = 0; i < ioBlocks.size(); i++) {
			MeasureModel mm = new MeasureModel();
			mm.setMeasureName(ioBlocks.get(i).getName());
			mm.setUnitCode(ioBlocks.get(i).getUnit().getCode());
			Double value = (data[i] - ioBlocks.get(i).getValueLower()) 
							* (ioBlocks.get(i).getPhysicalUpper() - ioBlocks.get(i).getPhysicalLower()) 
							/ (ioBlocks.get(i).getValueUpper() - ioBlocks.get(i).getValueLower()) 
							+ ioBlocks.get(i).getPhysicalLower();
			mm.setValue(value);
			measurements.add(mm);
		}
	
		message.setMeasurements(measurements);
		return message;
	}

	public List<MessageModel> getMessagesForNodeWithTimestapm(Long nodeId, Date from, Date to) {
		List<EncodedMessage> ems = this._encodedMessageRepository.queryEncodedMessagesByNodeWithTimestamp(nodeId, from, to);
		List<IOBlock> ioBlocks = this._IOBlockRepository.queryIOBlocksByNodeId(nodeId);
		
		List<MessageModel> messages = new ArrayList<MessageModel>();
		
		for(EncodedMessage em : ems) {
			MessageModel message = new MessageModel(em.getId(), em.getCreationTime(), em.getLat(), em.getLng(), em.getGatewayIP(), em.getProtocol());
			double[] data =  Arrays.stream(em.getEncodedData().split("\\s*,\\s*")).mapToDouble(Double::parseDouble).toArray();
			
			List<MeasureModel> measurements = new ArrayList<MeasureModel>();
			for(int i = 0; i < ioBlocks.size(); i++) {
				MeasureModel mm = new MeasureModel();
				mm.setMeasureName(ioBlocks.get(i).getName());
				mm.setUnitCode(ioBlocks.get(i).getUnit().getCode());
				Double value = (data[i] - ioBlocks.get(i).getValueLower()) 
								* (ioBlocks.get(i).getPhysicalUpper() - ioBlocks.get(i).getPhysicalLower()) 
								/ (ioBlocks.get(i).getValueUpper() - ioBlocks.get(i).getValueLower()) 
								+ ioBlocks.get(i).getPhysicalLower();
				mm.setValue(value);
				measurements.add(mm);
			}
		
			message.setMeasurements(measurements);
			messages.add(message);
		}
		
		return messages;
	}
	}
