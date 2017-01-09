package ba.unsa.etf.bp.dto;

import java.util.Date;
import java.util.List;

public class NodeModel {
	private Long id;
	private String name;
	private Double currentLat;
	private Double currentLng;
	private List<Long> messages;
	private List<Long> IOBlocks;
	
	public NodeModel(Long id, String name, Double currentLat, Double currentLng) {
		this.id = id;
		this.name = name;
		this.currentLat = currentLat;
		this.currentLng = currentLng;
		this.messages = null;
		this.IOBlocks = null;
	}
	
	public NodeModel(Long id, String name, Double currentLat, Double currentLng, List<Long> messages,
			List<Long> iOBlocks) {
		this.id = id;
		this.name = name;
		this.currentLat = currentLat;
		this.currentLng = currentLng;
		this.messages = messages;
		this.IOBlocks = iOBlocks;
	}
	public Double getCurrentLat() {
		return currentLat;
	}
	public Double getCurrentLng() {
		return currentLng;
	}
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public List<Long> getIOBlocks() {
		return this.IOBlocks;
	}
	public List<Long> getMessages() {
		return this.messages;
	}
	public void setCurrentLat(Double currentLat) {
		this.currentLat = currentLat;
	}
	public void setCurrentLng(Double currentLng) {
		this.currentLng = currentLng;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIOBlocks(List<Long> iOBlocks) {
		this.IOBlocks = iOBlocks;
	}
	public void setMessages(List<Long> messages) {
		this.messages = messages;
	}
}
