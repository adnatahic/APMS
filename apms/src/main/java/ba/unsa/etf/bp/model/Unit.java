package ba.unsa.etf.bp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Unit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String code;
	
	@OneToMany(mappedBy="unit")
	private List<IOBlock> IOBlocks;
	
	public String getCode() {
		return code;
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
	public void setIOBlocks(List<IOBlock> iOBlocks) {
		IOBlocks = iOBlocks;
	}
}
