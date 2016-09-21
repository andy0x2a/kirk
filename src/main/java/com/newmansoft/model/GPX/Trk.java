package com.newmansoft.model.GPX;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Trk {

	@JacksonXmlProperty(localName="name")
	private String name;

	@JacksonXmlProperty(localName = "trkseg")
	private List<Trkpt> trkSeg;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Trkpt> getTrkSeg() {
		return trkSeg;
	}

	public void setTrkSeg(final List<Trkpt> trkSeg) {
		this.trkSeg = trkSeg;
	}
}
