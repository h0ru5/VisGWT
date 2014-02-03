package com.github.h0ru5.gwt.angular.viz.client;

import com.github.h0ru5.gwt.angular.viz.DotService;
import com.github.h0ru5.gwt.angular.viz.GraphEdge;
import com.google.gwt.angular.client.AngularController;
import com.google.gwt.angular.client.NgInject;
import com.google.gwt.angular.client.NgWatch;

import elemental.client.Browser;
import elemental.util.ArrayOf;

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

	private DotService dot;
	
	public void onInit(VizExampleScope scope, DotService dot) {	
		this.dot=dot;
		ArrayOf<GraphEdge> edges = dot.newEdgeArray();
		
		GraphEdge trans1 = dot.newEdge().start("red").end("redyellow");
		Browser.getWindow().getConsole().log("created trans1");
		edges.push(trans1);
		Browser.getWindow().getConsole().log("added trans1");
		
		edges.push(dot.newEdge().start("redyellow").end("green"));
		edges.push(dot.newEdge().start("green").end("yellow"));
		edges.push(dot.newEdge().start("yellow").end("red"));
		
		Browser.getWindow().getConsole().log("getting code");
		String code = dot.getCode(edges,dot.newNodeArray());
		scope.otherSource(code);
		scope.example(sampleGraph);
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
