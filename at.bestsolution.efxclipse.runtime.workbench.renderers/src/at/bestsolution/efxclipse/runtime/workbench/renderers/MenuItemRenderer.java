package at.bestsolution.efxclipse.runtime.workbench.renderers;

import java.net.URL;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledItem;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.emf.common.util.URI;

@SuppressWarnings("restriction")
public class MenuItemRenderer extends ItemRenderer {

	@Inject
	IContributionFactory contributionFactory;

	@Override
	public Object createWidget(MUIElement element, Object parent) {
		if (parent != null && parent instanceof Menu && element instanceof MMenuItem) {
			MenuItem menuItem = new MenuItem();
			setItemText((MMenuItem) element, menuItem);
			return menuItem;
		}
		return null;
	}

	@Override
	public void processContents(MElementContainer<MUIElement> container) {
		super.processContents(container);

		if (container.getWidget() instanceof Menu) {
			Menu menu = (Menu) container.getWidget();
			for (MUIElement e : container.getChildren()) {
				menu.getItems().add((MenuItem) e.getWidget());
			}
		}
	}

	protected void setItemText(MMenuItem model, MenuItem item) {
		String text = model.getLocalizedLabel();
		if (model instanceof MHandledItem) {
			MHandledItem handledItem = (MHandledItem) model;
			generateParameterizedCommand(handledItem, context);
			ParameterizedCommand cmd = handledItem.getWbCommand();
			if (cmd != null && (text == null || text.length() == 0)) {
				try {
					text = cmd.getName();
				} catch (NotDefinedException e) {
					e.printStackTrace();
				}
			}
		}
		item.setMnemonicParsing(true);
		text = text.replaceAll("&", "_");
		item.setText(text);
		if (model.getIconURI() != null) {
			URL url = Util.convertToOSGiURL(URI.createURI(model.getIconURI()));
			Image img = new Image(url.toExternalForm());
			item.setGraphic(new ImageView(img));
		}
		// item.setAccelerator(new KeyCharacterCombination("k"));
	}

	@Override
	public void hookControllerLogic(MUIElement me) {
		if (me instanceof MDirectMenuItem) {
			final MDirectMenuItem item = (MDirectMenuItem) me;
			item.setObject(contributionFactory.create(item.getContributionURI(), getContext(item)));

			MenuItem menuItem = (MenuItem) item.getWidget();
			menuItem.setOnAction(createEventHandler(item));
		} else if (me instanceof MHandledMenuItem) {
			final MHandledMenuItem item = (MHandledMenuItem) me;
			MenuItem menuItem = (MenuItem) item.getWidget();
			menuItem.setOnAction(createParametrizedCommandEventHandler(item));
		}
	}
}
