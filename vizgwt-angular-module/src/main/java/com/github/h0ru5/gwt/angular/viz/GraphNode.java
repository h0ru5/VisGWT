package com.github.h0ru5.gwt.angular.viz;

import com.google.gwt.angular.client.Model;

public interface GraphNode extends Model<GraphNode> {
	String name();
	GraphNode name(String name);
	
	String shape();
	GraphNode shape(String shape);
}
