package at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget;

import java.util.List;

import javafx.scene.Node;

import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;

@SuppressWarnings("restriction")
public interface WStack<N,I,IC> extends WWidget<MPartStack> {
	public interface WStackItem<I,IC> {
		public I getNativeItem();
		public void setDomElement(MStackElement domElement);
		public MStackElement getDomElement();
		public void setInitCallback(WCallback<WStackItem<I, IC>, IC> callback);
		public void setOnCloseCallback(WCallback<WStackItem<I, IC>, Boolean> callback);
	}
	
	public Class<? extends WStackItem<I, IC>> getStackItemClass();
	public void addItem(WStackItem<I, IC> item);
	public void addItems(List<WStackItem<I, IC>> items);
	public void addItems(int index, List<WStackItem<I, IC>> items);
	public void selectItem(int idx);
	public int indexOf(WStackItem<I, IC> item);
	public List<WStackItem<I, IC>> getItems();
	public void removeItems(List<WStackItem<I, IC>> items);
	
	public void setMouseSelectedItemCallback(WCallback<WStackItem<I, IC>, Void> selectedItemCallback);
	public void setKeySelectedItemCallback(WCallback<WStackItem<I, IC>, Void> selectedItemCallback);
	public int getItemCount();
	
}
