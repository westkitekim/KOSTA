package org.kosta.myproject.model.domain;

public class PointVO {
	private String id;
	private int point;
	private String pointType;
	public PointVO() {
		super();
	}
	public PointVO(String id, int point, String pointType) {
		super();
		this.id = id;
		this.point = point;
		this.pointType = pointType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPointType() {
		return pointType;
	}
	public void setPointType(String pointType) {
		this.pointType = pointType;
	}
	@Override
	public String toString() {
		return "PointVO [id=" + id + ", point=" + point + ", pointType=" + pointType + "]";
	}
	
}
