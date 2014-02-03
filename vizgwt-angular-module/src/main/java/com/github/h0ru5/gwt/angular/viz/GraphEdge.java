package com.github.h0ru5.gwt.angular.viz;

import com.google.gwt.angular.client.Model;

public interface GraphEdge extends Model<GraphEdge> {
	String start();
	GraphEdge start(String start);
	
	String end();
	GraphEdge end(String end);
	
	String title();
	GraphEdge title(String title);
}
