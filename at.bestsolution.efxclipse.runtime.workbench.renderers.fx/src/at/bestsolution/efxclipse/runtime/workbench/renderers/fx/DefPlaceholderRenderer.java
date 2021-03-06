/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.efxclipse.runtime.workbench.renderers.fx;

import javafx.scene.Node;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;

import at.bestsolution.efxclipse.runtime.panels.FillLayoutPane;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.BasePlaceholderRenderer;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WLayoutedWidget;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WPlaceholderWidget;
import at.bestsolution.efxclipse.runtime.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

@SuppressWarnings("restriction")
public class DefPlaceholderRenderer extends BasePlaceholderRenderer<FillLayoutPane> {

	@Override
	protected Class<? extends WPlaceholderWidget> getWidgetClass(MPlaceholder placeholder) {
		return PlaceholderWidget.class;
	}
	
	static class PlaceholderWidget extends WLayoutedWidgetImpl<FillLayoutPane, FillLayoutPane, MPlaceholder> implements WPlaceholderWidget {

		@Override
		public void setContent(WLayoutedWidget<MUIElement> contentWidget) {
			if( contentWidget == null ) {
				getWidget().getChildren().clear();
			} else {
				getWidget().getChildren().setAll((Node)contentWidget.getStaticLayoutNode());
			}
		}

		@Override
		protected FillLayoutPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected FillLayoutPane createWidget() {
			FillLayoutPane pane = new FillLayoutPane();
			pane.setStyle("-fx-background-color: blue; -fx-padding: 10px;");
			return pane;
		}
		
	}
}