package de.johanneshund.gwt.vis.client.ui;

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

	public Graph() {
		initWidget(uiBinder.createAndBindUi(this));
	}

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
		if(src==null || src.isEmpty()) {
			target.setInnerHTML("");
		} else {
			target.setInnerHTML(doVis(src,format));
		}
	}

	private native String doVis(String graph, String format) /*-{
		return $wnd.Viz(graph, format)
	}-*/;

	@Override
	public String getText() {
		return src;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
