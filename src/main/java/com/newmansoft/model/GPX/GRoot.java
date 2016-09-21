package com.newmansoft.model.GPX;

/**
 * Created by anewman on 2016-09-20.
 */

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "gpx")
@JsonIgnoreProperties(ignoreUnknown=true)

public class GRoot {

	@JacksonXmlProperty(localName = "gpx")
	private List<Trk> gpx;

	public List<Trk> getGpx() {
		return gpx;
	}

	public void setGpx(final List<Trk> gpx) {
		this.gpx = gpx;
	}

	@JacksonXmlProperty(localName = "metadata")
	private Metadata metadata;
}

