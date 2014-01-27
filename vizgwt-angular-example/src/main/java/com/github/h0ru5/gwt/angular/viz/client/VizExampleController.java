package com.github.h0ru5.gwt.angular.viz.client;

import com.google.gwt.angular.client.AngularController;
import com.google.gwt.angular.client.NgInject;
import com.google.gwt.angular.client.NgWatch;

@NgInject(name="VizExampleCtrl")
public class VizExampleController extends AngularController<VizExampleScope>{

	private static final String sampleGraph = "digraph G {\r\n" + 
			"\r\n" + 
			"	subgraph cluster_0 {\r\n" + 
			"		style=filled;\r\n" + 
			"		color=lightgrey;\r\n" + 
			"		node [style=filled,color=white];\r\n" + 
			"		a0 -> a1 -> a2 -> a3;\r\n" + 
			"		label = \"process #1\";\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	subgraph cluster_1 {\r\n" + 
			"		node [style=filled];\r\n" + 
			"		b0 -> b1 -> b2 -> b3;\r\n" + 
			"		label = \"process #2\";\r\n" + 
			"		color=blue\r\n" + 
			"	}\r\n" + 
			"	start -> a0;\r\n" + 
			"	start -> b0;\r\n" + 
			"	a1 -> b3;\r\n" + 
			"	b2 -> a3;\r\n" + 
			"	a3 -> a0;\r\n" + 
			"	a3 -> end;\r\n" + 
			"	b3 -> end;\r\n" + 
			"\r\n" + 
			"	start [shape=Mdiamond];\r\n" + 
			"	end [shape=Msquare];\r\n" + 
			"}";
	
	private String initialOther = "digraph Example { \r\n state1 -> state2; \r\n state2 -> state3; \r\n state3 -> state1; }";
	
	public void onInit(VizExampleScope scope) {
		scope.example(sampleGraph);
		scope.otherSource(initialOther);
		scope.otherActive(true);
	}
	
	@NgWatch("otherActive")
	public void switchExample(boolean manTextState) {
		if(manTextState) {
			scope.graphSource(scope.otherSource());
		} else {
			scope.graphSource(scope.example());
		}
	}
	
	@NgWatch("otherSource")
	public void textChange(String manText) {
		if(scope.otherActive()) {
			scope.graphSource(scope.otherSource());
		} 
	}
	
}
