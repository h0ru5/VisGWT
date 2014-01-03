package com.github.h0ru5.gwt.viz.client.ui.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface VizResources extends ClientBundle {
	VizResources INST = GWT.create(VizResources.class);
	
	@Source("viz.js")
	TextResource vizjs();
	
}
