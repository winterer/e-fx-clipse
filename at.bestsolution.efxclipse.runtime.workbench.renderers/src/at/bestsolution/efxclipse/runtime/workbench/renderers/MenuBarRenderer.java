package at.bestsolution.efxclipse.runtime.workbench.renderers;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;

@SuppressWarnings("restriction")
public class MenuBarRenderer extends JFXRenderer {

	@Override
	public Object createWidget(MUIElement element, Object parent) {
		if (!(element instanceof MMenu)) {
			return null;
		}

		if (parent != null) {
			String label = ((MUILabel) element).getLocalizedLabel();
			label = label.replaceAll("&", "_"); // JavaFX Mnemonics
			Menu menu = new Menu(label);
			menu.setMnemonicParsing(true);
			return menu;
		}

		// No parent means the main menu bar
		MenuBar menuBar = new MenuBar();
		return menuBar;
	}

	@Override
	public void processContents(MElementContainer<MUIElement> container) {
		super.processContents(container);

		if (container.getWidget() instanceof MenuBar) {
			MenuBar menuBar = (MenuBar) container.getWidget();
			for (MUIElement e : container.getChildren()) {
				menuBar.getMenus().add((Menu) e.getWidget());
			}
		} else if (container.getWidget() instanceof Menu) {
			Menu menu = (Menu) container.getWidget();
			for (MUIElement e : container.getChildren()) {
				menu.getItems().add((MenuItem) e.getWidget());
			}
		}

	}
}
