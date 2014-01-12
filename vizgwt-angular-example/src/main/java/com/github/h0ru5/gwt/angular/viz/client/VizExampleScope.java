package com.github.h0ru5.gwt.angular.viz.client;

import com.google.gwt.angular.client.Scope;

public interface VizExampleScope extends Scope<VizExampleScope> {
	String graphSource();
	VizExampleScope graphSource(String code);
	
	String otherSource();
	VizExampleScope otherSource(String code);
	
	boolean otherActive();
	VizExampleScope otherActive(boolean active);
	
	String example();
	VizExampleScope example(String example);
}
