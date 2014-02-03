package com.github.h0ru5.gwt.angular.viz;

import com.google.gwt.angular.client.NgInject;
import com.google.gwt.angular.client.Util;
import com.google.gwt.core.client.GWT;

import elemental.js.util.JsArrayOf;
import elemental.util.ArrayOf;

@NgInject(name="dot")
public class DotService {

	/*private ArrayOf<GraphNode> nodes;
	private ArrayOf<GraphEdge> edges;
	
	public DotService() {
	}
	
	public void init() {
		nodes=JsArrayOf.<GraphNode>create();
		edges=JsArrayOf.<GraphEdge>create();
	}
	
	public void addNode(GraphNode node) {
		if(nodes==null)init();
		nodes.push(node);
	}

	public void addEdge(GraphEdge edge) {
		if(edges==null)init();
		edges.push(edge);
	}
*/
	public GraphEdge newEdge() {
		return Util.make(GWT.create(GraphEdge.class));
	}
	
	public GraphNode newNode() {
		return Util.make(GWT.create(GraphNode.class));
	}
	
	public ArrayOf<GraphNode> newNodeArray() {
		return JsArrayOf.<GraphNode>create();
	}

	public ArrayOf<GraphEdge> newEdgeArray() {
		return JsArrayOf.<GraphEdge>create();
	}
	
	public String getCode(ArrayOf<GraphEdge> edges,ArrayOf<GraphNode> nodes) {
		StringBuilder res = new StringBuilder();
		
		res.append("digraph G {\n");
		
		for(GraphNode node : Util.iterable(nodes)) {
			res.append(node.name());
		
			if(node.shape()!=null) {
				res.append("[");
				res.append("shape=");
				res.append(node.shape());
				res.append("]");
			}
				
			res.append(";\n");
		}
		
		for(GraphEdge edge : Util.iterable(edges)) {
			res.append(edge.start());
			res.append(" -> ");
			res.append(edge.end());
			res.append(";\n");
		}
				
		//end graph
		res.append("}");
		
		return res.toString();
	}
}
