package ba.unsa.etf.bp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MESSAGE_ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NODE_ID")
	private Node node;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ENCODED_MESSAGE_ID")
	private EncodedMessage encodedMessage;
	
	public EncodedMessage getEncodedMessage() {
		return encodedMessage;
	}
	public Long getId() {
		return id;
	}
	public Node getNode() {
		return node;
	}
	public void setEncodedMessage(EncodedMessage encodedMessage) {
		this.encodedMessage = encodedMessage;
	}
	public void setNode(Node node) {
		this.node = node;
	}
}
