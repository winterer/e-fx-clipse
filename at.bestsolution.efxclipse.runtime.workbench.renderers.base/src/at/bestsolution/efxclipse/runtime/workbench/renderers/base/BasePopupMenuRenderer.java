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
package at.bestsolution.efxclipse.runtime.workbench.renderers.base;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;

import at.bestsolution.efxclipse.runtime.workbench.renderers.base.EventProcessor.ChildrenHandler;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WMenuElement;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WPopupMenu;

@SuppressWarnings("restriction")
public abstract class BasePopupMenuRenderer<N> extends BaseRenderer<MPopupMenu, WPopupMenu<N>> implements ChildrenHandler<MPopupMenu, MMenuElement> {
	@PostConstruct
	void init(IEventBroker eventBroker) {
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);
	}

	@Override
	protected void initWidget(final MPopupMenu element, WPopupMenu<N> widget) {
		super.initWidget(element, widget);
		widget.setShowingCallback(new Runnable() {

			@Override
			public void run() {
				handleShowing(element);
			}
		});
	}

	void handleShowing(MPopupMenu element) {
		for (MMenuElement e : element.getChildren()) {
			if (e.getRenderer() instanceof BaseItemRenderer) {
				@SuppressWarnings("unchecked")
				BaseItemRenderer<MMenuElement, ?> r = (BaseItemRenderer<MMenuElement, ?>) e.getRenderer();
				r.checkEnablement(e);
			}
		}
	}

	@Override
	public void doProcessContent(MPopupMenu element) {
		// TODO Should we do this creation lazy????
		WPopupMenu<N> menu = getWidget(element);
		for (MMenuElement e : element.getChildren()) {
			WMenuElement<MMenuElement> widget = engineCreateWidget(e);
			if (widget != null) {
				menu.addElement(widget);
			}
		}
	}

	public void handleChildRemove(MPopupMenu parent, MMenuElement element) {
		if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
			hideChild(parent, element);
		}
	}

	public void handleChildAddition(MPopupMenu parent, MMenuElement element) {
		if (element.isToBeRendered() && element.isVisible()) {
			if (element.getWidget() == null) {
				engineCreateWidget(element);
			} else {
				childRendered(parent, element);
			}
		}
	}

	@Override
	public void childRendered(MPopupMenu parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WPopupMenu<N> menu = getWidget(parentElement);
		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> menuElement = (WMenuElement<MMenuElement>) element.getWidget();
		menu.addElement(idx, menuElement);
	}

	@Override
	public void hideChild(MPopupMenu container, MUIElement changedObj) {
		WPopupMenu<N> menu = getWidget(container);

		if (menu == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> widget = (WMenuElement<MMenuElement>) changedObj.getWidget();
		if (widget != null) {
			menu.removeElement(widget);
		}
	}
}