package ba.unsa.etf.bp.model;

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
	
	private String description;
	
	@OneToMany(mappedBy="node", cascade=CascadeType.ALL)
	private List<IOBlock> IOBlocks;

	@OneToMany(mappedBy="node", cascade=CascadeType.ALL)
	private List<Message> messages;
	
	public String getDescription() {
		return description;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIOBlocks(List<IOBlock> iOBlocks) {
		IOBlocks = iOBlocks;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
