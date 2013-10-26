package de.johanneshund.gwt.vis.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class Graph extends Composite implements HasText {


	private String src;
	private static GraphUiBinder uiBinder = GWT.create(GraphUiBinder.class);

	interface GraphUiBinder extends UiBinder<Widget, Graph> {
	}

	public Graph() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Graph(String txtGraph) {
		initWidget(uiBinder.createAndBindUi(this));
		setText(txtGraph);
	}

	@UiField HTMLPanel target;

	@Override
	public String getText() {
		return src;
	}

	@Override
	public void setText(String text) {
		src=text;
		target.add(new HTML(doVis(text)));
	}

	private native String doVis(String graph) /*-{ return $wnd.Viz(graph,"svg") }-*/;
	

}
