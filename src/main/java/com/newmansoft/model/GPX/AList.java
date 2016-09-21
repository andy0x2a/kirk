package com.newmansoft.model.GPX;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by anewman on 2016-09-21.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AList extends ArrayList<Trk> {
	@JacksonXmlProperty(localName = "metadata")
	private Metadata metadata;
}
