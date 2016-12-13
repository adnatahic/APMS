package ba.unsa.etf.bp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class IOType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String code;
	
	private String description;
	
	@OneToMany(mappedBy="type")
	private List<IOBlock> IOBlocks = new ArrayList<IOBlock>();
	
	public IOType(Long id, String code, String description, List<IOBlock> iOBlocks) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.IOBlocks = iOBlocks;
	}
	
	public IOType() {
		
	}
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public Long getId() {
		return id;
	}
	public List<IOBlock> getIOBlocks() {
		return IOBlocks;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setIOBlocks(List<IOBlock> iOBlocks) {
		IOBlocks = iOBlocks;
	}
}
