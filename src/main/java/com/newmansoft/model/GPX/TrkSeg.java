package com.newmansoft.model.GPX;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TrkSeg {
	@JacksonXmlProperty(localName = "trkpt")
	private List<Trkpt> trkpts;

	public List<Trkpt> getTrkpts() {
		return trkpts;
	}

	public void setTrkpts(final List<Trkpt> trkpts) {
		this.trkpts = trkpts;
	}
}
