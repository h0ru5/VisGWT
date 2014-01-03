package com.github.h0ru5.gwt.viz.client;

import com.github.h0ru5.gwt.viz.client.ui.resources.VizResources;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.TextResource;

public class VizGwt implements EntryPoint {

	@Override
	public void onModuleLoad() {
		injectScript(VizResources.INST.vizjs());
	}

	private void injectScript(TextResource jsResource) {
		ScriptInjector.fromString(jsResource.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}
	
}
