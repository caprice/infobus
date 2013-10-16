package com.gm.infobus.entity;

public class CemeteryZone {
	private int zoneId;
	private String ZoneCode;
	private String zoneName;
	private int rows;
	private int columns;
	private int positionX;
	private int positionY;
	private char initFlag;
	private int cemeteryPlotID;
	private int deftGraveGenreID;
	private String deftGraveGenreName;
	private char graveNameType;
	private char imageIndex;
	private int IsServe;
	private char SequenceType;
	private int State0;
	private String ZoneNamePY;

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneCode() {
		return ZoneCode;
	}

	public void setZoneCode(String zoneCode) {
		ZoneCode = zoneCode;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public char getInitFlag() {
		return initFlag;
	}

	public void setInitFlag(char initFlag) {
		this.initFlag = initFlag;
	}

	public int getCemeteryPlotID() {
		return cemeteryPlotID;
	}

	public void setCemeteryPlotID(int cemeteryPlotID) {
		this.cemeteryPlotID = cemeteryPlotID;
	}

	public int getDeftGraveGenreID() {
		return deftGraveGenreID;
	}

	public void setDeftGraveGenreID(int deftGraveGenreID) {
		this.deftGraveGenreID = deftGraveGenreID;
	}

	public String getDeftGraveGenreName() {
		return deftGraveGenreName;
	}

	public void setDeftGraveGenreName(String deftGraveGenreName) {
		this.deftGraveGenreName = deftGraveGenreName;
	}

	public char getGraveNameType() {
		return graveNameType;
	}

	public void setGraveNameType(char graveNameType) {
		this.graveNameType = graveNameType;
	}

	public char getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(char imageIndex) {
		this.imageIndex = imageIndex;
	}

	public int getIsServe() {
		return IsServe;
	}

	public void setIsServe(int isServe) {
		IsServe = isServe;
	}

	public char getSequenceType() {
		return SequenceType;
	}

	public void setSequenceType(char sequenceType) {
		SequenceType = sequenceType;
	}

	public int getState0() {
		return State0;
	}

	public void setState0(int state0) {
		State0 = state0;
	}

	public String getZoneNamePY() {
		return ZoneNamePY;
	}

	public void setZoneNamePY(String zoneNamePY) {
		ZoneNamePY = zoneNamePY;
	}
}
