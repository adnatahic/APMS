package ba.unsa.etf.bp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EncodedMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ENCODED_MESSAGE_ID")
	private Long id;
	
	private Date creationTime;
	
	private Double lat;
	
	private Double lng;
	
	private String nodeId;
	
	private String gatewayIP;
	
	private String protocol;
	
	private String encodedData;
	
	@OneToOne(mappedBy="encodedMessage", fetch=FetchType.LAZY)
	private Message message;
	
	public Date getCreationTime() {
		return creationTime;
	}
	public String getEncodedData() {
		return encodedData;
	}
	public String getGatewayIP() {
		return gatewayIP;
	}
	public Long getId() {
		return id;
	}
	public Double getLat() {
		return lat;
	}
	public Double getLng() {
		return lng;
	}
	public Message getMessage() {
		return message;
	}
	public String getNodeId() {
		return nodeId;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public void setEncodedData(String encodedData) {
		this.encodedData = encodedData;
	}
	public void setGatewayIP(String gatewayIP) {
		this.gatewayIP = gatewayIP;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
}
