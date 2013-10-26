package de.johanneshund.gwt.vis.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

import de.johanneshund.gwt.vis.client.ui.Graph;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VisGWTExample implements EntryPoint {

	private Graph g;

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
	
	@Override
	public void onModuleLoad() {
		g = new Graph();
		RootPanel panel = RootPanel.get();
		panel.add(g);
		g.setText(sampleGraph);
		panel.add(new HTML("<pre>" + sampleGraph + "</pre>"));
	}
	
}
