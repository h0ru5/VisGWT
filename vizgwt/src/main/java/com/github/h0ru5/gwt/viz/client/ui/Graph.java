package com.github.h0ru5.gwt.viz.client.ui;

import com.github.h0ru5.gwt.viz.client.ui.resources.VizResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * A GWT Component for UI Binder using die Viz.js library
 * 
 * Just set the dot source via setText
 * 
 * @author Johannes Hund <johannes.hund@gmail.com>
 *
 */
public class Graph extends Composite implements HasText {

	private String format = "svg";
	private String src;
	private static GraphUiBinder uiBinder = GWT.create(GraphUiBinder.class);

	@UiField
	DivElement target;
	

	interface GraphUiBinder extends UiBinder<Widget, Graph> {
	}

	/**
	 * Constructor for an empty Graph 
	*/
	public Graph() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	/**
	 * Constructor for Graph setting a dot source
	 * @param txtGraph String graph to be displayed, as String of dot source
	 */
	public Graph(String txtGraph) {
		initWidget(uiBinder.createAndBindUi(this));
		setText(txtGraph);
	}

	/** uses viz.js to render a svg-plot based on the passed graphviz-source 
	 * @see com.google.gwt.user.client.ui.HasText#setText(java.lang.String)
	 * @see https://github.com/mdaines/viz.js
	 */
	@Override
	public void setText(String text) {
		src = text;
		update();
	}

	private void update() {
		if(format==null || format.isEmpty())
			format="svg";
		
		if(src==null || src.isEmpty()) {
			target.setInnerHTML("");
		} else {
			target.setInnerHTML(doVis(src,format));
		}
	}

	private native String doVis(String graph, String format) /*-{
		return $wnd.Viz(graph, format)
	}-*/;

	/**
	 * Method getText returns the dot source currently displayed as graph
	 * @return String
	 * @see com.google.gwt.user.client.ui.HasText#getText()
	 */
	@Override
	public String getText() {
		return src;
	}

	/**
	 * Method getFormat, returns the format passed to viz.js, defaults to svg
	 * @return String
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Method setFormat, sts the format to be passed to viz.js
	 * @param format String
	 */
	public void setFormat(String format) {
		this.format = format;
		update();
	}

}
