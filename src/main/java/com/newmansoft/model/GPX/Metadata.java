package com.newmansoft.model.GPX;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown=true)

public class Metadata {

	@JacksonXmlProperty(localName="time")
	private Date time;
	@JacksonXmlProperty(localName="link")
	private Link link;

	public Link getLink() {
		return link;
	}

	public void setLink(final Link link) {
		this.link = link;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(final Date time) {
		this.time = time;
	}
}
