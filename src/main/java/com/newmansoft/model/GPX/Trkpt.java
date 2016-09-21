package com.newmansoft.model.GPX;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Trkpt {

	@JacksonXmlProperty(isAttribute = true)
	private String lat;

	@JacksonXmlProperty(isAttribute = true)
	private String lon;

	private String ele;
	private Date time;

	public String getLat() {
		return lat;
	}

	public void setLat(final String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(final String lon) {
		this.lon = lon;
	}

	public String getEle() {
		return ele;
	}

	public void setEle(final String ele) {
		this.ele = ele;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(final Date time) {
		this.time = time;
	}
}
