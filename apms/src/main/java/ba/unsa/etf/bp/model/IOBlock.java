package ba.unsa.etf.bp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IOBlock {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IOBLOCK_ID")
	private Long id;
	private String name;
	// ?
	private String encodedData;
	
	private Integer ordinal;
	
	private Double valueLower;
	
	private Double valueUpper;
	
	private Double physicalLower;
	
	private Double physicalUpper;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NODE_ID")
	private Node node;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DIRECTION_ID")
	private IODirection direction;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TYPE_ID")
	private IOType type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UNIT_ID")
	private Unit unit;
	
	public IOBlock(Long id, String name, String encodedData, Integer ordinal, Double valueLower, Double valueUpper,
			Double physicalLower, Double physicalUpper, Node node, IODirection direction, IOType type, Unit unit) {
		this.id = id;
		this.name = name;
		this.encodedData = encodedData;
		this.ordinal = ordinal;
		this.valueLower = valueLower;
		this.valueUpper = valueUpper;
		this.physicalLower = physicalLower;
		this.physicalUpper = physicalUpper;
		this.node = node;
		this.direction = direction;
		this.type = type;
		this.unit = unit;
	}
	
	public IOBlock() {
		
	}
	public IODirection getDirection() {
		return direction;
	}
	public String getEncodedData() {
		return encodedData;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Node getNode() {
		return node;
	}
	public Integer getOrdinal() {
		return ordinal;
	}
	public Double getPhysicalLower() {
		return physicalLower;
	}
	public Double getPhysicalUpper() {
		return physicalUpper;
	}
	public IOType getType() {
		return type;
	}
	public Unit getUnit() {
		return unit;
	}
	public Double getValueLower() {
		return valueLower;
	}
	public Double getValueUpper() {
		return valueUpper;
	}
	public void setDirection(IODirection direction) {
		this.direction = direction;
	}
	public void setEncodedData(String encodedData) {
		this.encodedData = encodedData;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}
	public void setPhysicalLower(Double physicalLower) {
		this.physicalLower = physicalLower;
	}
	public void setPhysicalUpper(Double physicalUpper) {
		this.physicalUpper = physicalUpper;
	}
	
	public void setType(IOType type) {
		this.type = type;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public void setValueLower(Double valueLower) {
		this.valueLower = valueLower;
	}
	public void setValueUpper(Double valueUpper) {
		this.valueUpper = valueUpper;
	}
}
