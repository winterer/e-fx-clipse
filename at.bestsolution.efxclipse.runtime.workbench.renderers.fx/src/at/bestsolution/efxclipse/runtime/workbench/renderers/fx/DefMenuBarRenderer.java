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

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

import at.bestsolution.efxclipse.runtime.workbench.renderers.base.BaseMenuBarRenderer;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WMenu;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WMenuBar;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WMenuElement;
import at.bestsolution.efxclipse.runtime.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

@SuppressWarnings("restriction")
public class DefMenuBarRenderer extends BaseMenuBarRenderer<MenuBar> {

	@Override
	protected Class<? extends WMenuBar<MenuBar>> getWidgetClass(MMenu menu) {
		return WMenuBarImpl.class;
	}
	
	public static class WMenuBarImpl extends WLayoutedWidgetImpl<MenuBar, MenuBar, MMenu> implements WMenuBar<MenuBar> {

		@Override
		protected MenuBar createWidget() {
			MenuBar b = new MenuBar();
			return b;
		}

		@Override
		protected MenuBar getWidgetNode() {
			return getWidget();
		}

		@Override
		public void addElement(WMenu<MMenuElement> widget) {
			getWidget().getMenus().add((Menu) widget.getWidget());
		}

		@Override
		public void addElement(int idx, WMenu<MMenuElement> widget) {
			getWidget().getMenus().add(idx, (Menu) widget.getWidget());
		}

		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			getWidget().getMenus().remove(widget.getWidget());
		}
	}
}
