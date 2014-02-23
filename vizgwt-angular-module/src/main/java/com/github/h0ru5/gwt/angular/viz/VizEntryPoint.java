package com.github.h0ru5.gwt.angular.viz;

import com.google.gwt.angular.client.AngularEntryPoint;
import com.google.gwt.angular.client.AngularModule;
import com.google.gwt.core.shared.GWT;

public class VizEntryPoint extends AngularEntryPoint {

	@Override
	protected AngularModule[] main() {
		return new AngularModule[] { GWT.create(VizModule.class)};
	}

}
