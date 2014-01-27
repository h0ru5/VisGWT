package com.github.h0ru5.gwt.angular.viz;

import com.github.h0ru5.gwt.viz.client.ui.Graph;
import com.google.gwt.angular.client.Directive;
import com.google.gwt.angular.client.NgDirective;
import com.google.gwt.angular.client.NgElement;
import com.google.gwt.angular.client.Scope;
import com.google.gwt.angular.client.WatchFunction;
import com.google.gwt.core.client.JavaScriptObject;

import elemental.dom.Element;
import elemental.dom.Node;

import com.google.gwt.user.client.ui.HTMLPanel;

import elemental.json.JsonObject;
import elemental.util.ArrayOf;

public class VizDirective implements Directive {

	private static final String GRAPH_SOURCE = "graphSource";

	@NgDirective("graphViz")
	public void graph(final Scope scope, final ArrayOf<NgElement> element,
			final JsonObject attrs) {

		//create Graph 
		final Graph myGraph = new Graph();

		//set default expression
		String srcExpr = "graphSource";
		
		//override default if attribute graph-source is given
		if(attrs.hasKey(GRAPH_SOURCE)) {
			srcExpr = attrs.get(GRAPH_SOURCE).asString();
		}

		//add graph to element
		element.get(0).appendChild((Node) myGraph.getElement());

		//setup $watch to bind graph's text property to the graph-source
		scope.$watch(srcExpr, new WatchFunction<String>() {
			@Override
			public void exec(String value) {
				myGraph.setText(value);
			}
		});
	}
}
