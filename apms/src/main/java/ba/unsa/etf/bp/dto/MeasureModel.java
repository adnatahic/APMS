package ba.unsa.etf.bp.dto;

public class MeasureModel {
	private String measureName;
	private String unitCode;
	private Double value;
	public MeasureModel(String measureName, String unitCode, Double value) {
		this.measureName = measureName;
		this.unitCode = unitCode;
		this.value = value;
	}
	public String getMeasureName() {
		return measureName;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public Double getValue() {
		return value;
	}
	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public void setValue(Double value) {
		this.value = value;
	}
}
