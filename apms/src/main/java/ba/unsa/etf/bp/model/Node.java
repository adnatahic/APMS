package ba.unsa.etf.bp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Node {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NODE_ID")
	private Long id;

	private String name;
	
	private String nodeCodeId;
	
	@OneToMany(mappedBy="node", cascade=CascadeType.ALL)
	private List<IOBlock> IOBlocks = new ArrayList<IOBlock>();

	@OneToMany(mappedBy="node", cascade=CascadeType.ALL)
	private List<Message> messages = new ArrayList<Message>();

	public Node() {
		
	}
	
	public Node(Long id, String name, String nodeId, List<IOBlock> iOBlocks, List<Message> messages) {
		this.id = id;
		this.name = name;
		this.nodeCodeId = nodeId;
		this.IOBlocks = iOBlocks;
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}
	
	public List<IOBlock> getIOBlocks() {
		return IOBlocks;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public String getName() {
		return name;
	}

	public String getNodeId() {
		return nodeCodeId;
	}

	public void setIOBlocks(List<IOBlock> iOBlocks) {
		IOBlocks = iOBlocks;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNodeId(String nodeId) {
		this.nodeCodeId = nodeId;
	}
}
