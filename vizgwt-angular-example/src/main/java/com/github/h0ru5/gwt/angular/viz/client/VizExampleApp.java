package com.github.h0ru5.gwt.angular.viz.client;

import com.github.h0ru5.gwt.angular.viz.VizModule;
import com.google.gwt.angular.client.AngularApp;
import com.google.gwt.angular.client.AngularModule;
import com.google.gwt.core.shared.GWT;

public class VizExampleApp extends AngularApp {

	@Override
	protected AngularModule[] main() {
		return new AngularModule[] { GWT.create(VizExampleModule.class), GWT.create(VizModule.class) };
	}

}
