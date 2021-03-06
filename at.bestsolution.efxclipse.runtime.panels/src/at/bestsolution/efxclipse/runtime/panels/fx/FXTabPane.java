/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package at.bestsolution.efxclipse.runtime.panels.fx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.DefaultProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.WritableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Side;
import javafx.scene.control.Control;
import javafx.scene.control.SingleSelectionModel;

import com.sun.javafx.css.StyleManager;
import com.sun.javafx.css.StyleableDoubleProperty;
import com.sun.javafx.css.StyleableProperty;
import com.sun.javafx.css.converters.SizeConverter;

/**
 * <p>A control that allows switching between a group of {@link FXTab Tabs}.  Only one tab
 * is visible at a time. Tabs are added to the TabPane by using the {@link #getTabs}.</p>
 *
 * <p>Tabs in a TabPane can be positioned at any of the four sides by specifying the
 * {@link Side}. </p>
 *
 * <p>A TabPane has two modes floating or recessed.  Applying the styleclass STYLE_CLASS_FLOATING
 * will change the TabPane mode to floating.</p>
 *
 * <p>The tabs width and height can be set to a specific size by
 * setting the min and max for height and width.  TabPane default width will be
 * determined by the largest content width in the TabPane.  This is the same for the height.
 * If a different size is desired the width and height of the TabPane can
 * be overridden by setting the min, pref and max size.</p>
 *
 * <p>When the number of tabs do not fit the TabPane a menu button will appear on the right.
 * The menu button is used to select the tabs that are currently not visible.
 * </p>
 *
 * <p>Example:</p>
 * <pre><code>
 * TabPane tabPane = new TabPane();
 * Tab tab = new Tab();
 * tab.setText("new tab");
 * tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
 * tabPane.getTabs().add(tab);
 * </code></pre>
 *
 * @see FXTab
 */
@DefaultProperty("tabs")
public class FXTabPane extends Control {
    private static final double DEFAULT_TAB_MIN_WIDTH = 0;

    private static final double DEFAULT_TAB_MAX_WIDTH = Double.MAX_VALUE;

    private static final double DEFAULT_TAB_MIN_HEIGHT = 0;

    private static final double DEFAULT_TAB_MAX_HEIGHT = Double.MAX_VALUE;

    public enum MinMaxState {
    	NONE,
		RESTORED,
		MINIMIZED,
		MAXIMIZED
	}
	
	private ObjectProperty<MinMaxState> minMaxState = new SimpleObjectProperty<FXTabPane.MinMaxState>(MinMaxState.NONE);

	public void setMinMaxState(MinMaxState minMaxState) {
		this.minMaxState.set(minMaxState);
	}
	
	public MinMaxState getMinMaxState() {
		return this.minMaxState.get();
	}
	
	public ObjectProperty<MinMaxState> minMaxStateProperty() {
		return minMaxState;
	}
    
    /**
     * TabPane mode will be changed to floating allowing the TabPane
     * to be placed alongside other control.
     */
    public static final String STYLE_CLASS_FLOATING = "floating";

    /**
     * Constructs a new TabPane.
     */
    public FXTabPane() {
        getStyleClass().setAll("tab-pane");
        setSelectionModel(new TabPaneSelectionModel(this));

        tabs.addListener(new ListChangeListener<FXTab>() {
            @Override public void onChanged(Change<? extends FXTab> c) {
                while (c.next()) {
                    for (FXTab tab : c.getRemoved()) {
                        if (tab != null && !getTabs().contains(tab)) {
                            tab.setTabPane(null);
                        }
                    }

                    for (FXTab tab : c.getAddedSubList()) {
                        if (tab != null) {
                            tab.setTabPane(FXTabPane.this);
                        }
                    }
                }
            }
        });
    }

    private ObservableList<FXTab> tabs = FXCollections.observableArrayList();

    /**
     * <p>The tabs to display in this TabPane. Changing this ObservableList will
     * immediately result in the TabPane updating to display the new contents
     * of this ObservableList.</p>
     *
     * <p>If the tabs ObservableList changes, the selected tab will remain the previously
     * selected tab, if it remains within this ObservableList. If the previously
     * selected tab is no longer in the tabs ObservableList, the selected tab will
     * become the first tab in the ObservableList.</p>
     */
    public final ObservableList<FXTab> getTabs() {
        return tabs;
    }

    private ObjectProperty<SingleSelectionModel<FXTab>> selectionModel = new SimpleObjectProperty<SingleSelectionModel<FXTab>>(this, "selectionModel");

    /**
     * <p>Sets the model used for tab selection.  By changing the model you can alter
     * how the tabs are selected and which tabs are first or last.</p>
     */
    public final void setSelectionModel(SingleSelectionModel<FXTab> value) { selectionModel.set(value); }

    /**
     * <p>Gets the model used for tab selection.</p>
     */
    public final SingleSelectionModel<FXTab> getSelectionModel() { return selectionModel.get(); }

    /**
     * The selection model used for selecting tabs.
     */
    public final ObjectProperty<SingleSelectionModel<FXTab>> selectionModelProperty() { return selectionModel; }

    private ObjectProperty<Side> side;

    /**
     * <p>The position to place the tabs in this TabPane. Whenever this changes
     * the TabPane will immediately update the location of the tabs to reflect
     * this.</p>
     *
     */
    public final void setSide(Side value) {
        sideProperty().set(value);
    }

    /**
     * The current position of the tabs in the TabPane.  The default position
     * for the tabs is Side.Top.
     *
     * @return The current position of the tabs in the TabPane.
     */
    public final Side getSide() {
        return side == null ? Side.TOP : side.get();
    }

    /**
     * The position of the tabs in the TabPane.
     */
    public final ObjectProperty<Side> sideProperty() {
        if (side == null) {
            side = new ObjectPropertyBase<Side>(Side.TOP) {
                private Side oldSide;
                @Override protected void invalidated() {
                    if (oldSide != null) {
                        impl_pseudoClassStateChanged(oldSide.name().toLowerCase());
                    }

                    oldSide = get();

                    if (get() != null) {
                        impl_pseudoClassStateChanged(get().name().toLowerCase());
                    }
                }

                @Override
                public Object getBean() {
                    return FXTabPane.this;
                }

                @Override
                public String getName() {
                    return "side";
                }
            };
        }
        return side;
    }

    private ObjectProperty<TabClosingPolicy> tabClosingPolicy;

    /**
     * <p>Specifies how the TabPane handles tab closing from an end-users
     * perspective. The options are:</p>
     *
     * <ul>
     *   <li> TabClosingPolicy.UNAVAILABLE: Tabs can not be closed by the user
     *   <li> TabClosingPolicy.SELECTED_TAB: Only the currently selected tab will
     *          have the option to be closed, with a graphic next to the tab
     *          text being shown. The graphic will disappear when a tab is no
     *          longer selected.
     *   <li> TabClosingPolicy.ALL_TABS: All tabs will have the option to be
     *          closed.
     * </ul>
     *
     * <p>Refer to the {@link TabClosingPolicy} enumeration for further details.</p>
     *
     * The default closing policy is TabClosingPolicy.SELECTED_TAB
     */
    public final void setTabClosingPolicy(TabClosingPolicy value) {
        tabClosingPolicyProperty().set(value);
    }

    /**
     * The closing policy for the tabs.
     *
     * @return The closing policy for the tabs.
     */
    public final TabClosingPolicy getTabClosingPolicy() {
        return tabClosingPolicy == null ? TabClosingPolicy.SELECTED_TAB : tabClosingPolicy.get();
    }

    /**
     * The closing policy for the tabs.
     */
    public final ObjectProperty<TabClosingPolicy> tabClosingPolicyProperty() {
        if (tabClosingPolicy == null) {
            tabClosingPolicy = new SimpleObjectProperty<TabClosingPolicy>(this, "tabClosingPolicy", TabClosingPolicy.SELECTED_TAB);
        }
        return tabClosingPolicy;
    }

    private BooleanProperty rotateGraphic;

    /**
     * <p>Specifies whether the graphic inside a Tab is rotated or not, such
     * that it is always upright, or rotated in the same way as the Tab text is.</p>
     *
     * <p>By default rotateGraphic is set to false, to represent the fact that
     * the graphic isn't rotated, resulting in it always appearing upright. If
     * rotateGraphic is set to {@code true}, the graphic will rotate such that it
     * rotates with the tab text.</p>
     *
     */
    public final void setRotateGraphic(boolean value) {
        rotateGraphicProperty().set(value);
    }

    /**
     * Returns {@code true} if the graphic inside a Tab is rotated. The
     * default is {@code false}
     *
     * @return the rotatedGraphic state.
     */
    public final boolean isRotateGraphic() {
        return rotateGraphic == null ? false : rotateGraphic.get();
    }

    /**
     * The rotatedGraphic state of the tabs in the TabPane.
     */
    public final BooleanProperty rotateGraphicProperty() {
        if (rotateGraphic == null) {
            rotateGraphic = new SimpleBooleanProperty(this, "rotateGraphic", false);
        }
        return rotateGraphic;
    }

    private DoubleProperty tabMinWidth;

    /**
     * <p>The minimum width of the tabs in the TabPane.  This can be used to limit
     * the length of text in tabs to prevent truncation.  Setting the min equal
     * to the max will fix the width of the tab.  By default the min equals to the max.
     *
     * This value can also be set via CSS using {@code -fx-tab-min-width}
     *
     * </p>
     */
    public final void setTabMinWidth(double value) {
        tabMinWidthProperty().setValue(value);
    }

    /**
     * The minimum width of the tabs in the TabPane.
     *
     * @return The minimum width of the tabs.
     */
    public final double getTabMinWidth() {
        return tabMinWidth == null ? DEFAULT_TAB_MIN_WIDTH : tabMinWidth.getValue();
    }

    /**
     * The minimum width of the tabs in the TabPane.
     */
    public final DoubleProperty tabMinWidthProperty() {
        if (tabMinWidth == null) {
            tabMinWidth = new StyleableDoubleProperty(DEFAULT_TAB_MIN_WIDTH) {

                @Override
                public StyleableProperty getStyleableProperty() {
                    return StyleableProperties.TAB_MIN_WIDTH;
                }

                @Override
                public Object getBean() {
                    return FXTabPane.this;
                }

                @Override
                public String getName() {
                    return "tabMinWidth";
                }
            };
        }
        return tabMinWidth;
    }

    /**
     * <p>Specifies the maximum width of a tab.  This can be used to limit
     * the length of text in tabs.  If the tab text is longer than the maximum
     * width the text will be truncated.  Setting the max equal
     * to the min will fix the width of the tab.  By default the min equals to the max
     *
     * This value can also be set via CSS using {@code -fx-tab-max-width}.</p>
     */
    private DoubleProperty tabMaxWidth;
    public final void setTabMaxWidth(double value) {
        tabMaxWidthProperty().setValue(value);
    }

    /**
     * The maximum width of the tabs in the TabPane.
     *
     * @return The maximum width of the tabs.
     */
    public final double getTabMaxWidth() {
        return tabMaxWidth == null ? DEFAULT_TAB_MAX_WIDTH : tabMaxWidth.getValue();
    }

    /**
     * The maximum width of the tabs in the TabPane.
     */
    public final DoubleProperty tabMaxWidthProperty() {
        if (tabMaxWidth == null) {
            tabMaxWidth = new StyleableDoubleProperty(DEFAULT_TAB_MAX_WIDTH) {

                @Override
                public StyleableProperty getStyleableProperty() {
                    return StyleableProperties.TAB_MAX_WIDTH;
                }

                @Override
                public Object getBean() {
                    return FXTabPane.this;
                }

                @Override
                public String getName() {
                    return "tabMaxWidth";
                }
            };
        }
        return tabMaxWidth;
    }

    private DoubleProperty tabMinHeight;

    /**
     * <p>The minimum height of the tabs in the TabPane.  This can be used to limit
     * the height in tabs. Setting the min equal to the max will fix the height
     * of the tab.  By default the min equals to the max.
     *
     * This value can also be set via CSS using {@code -fx-tab-min-height}
     * </p>
     */
    public final void setTabMinHeight(double value) {
        tabMinHeightProperty().setValue(value);
    }

    /**
     * The minimum height of the tabs in the TabPane.
     *
     * @return The minimum height of the tabs.
     */
    public final double getTabMinHeight() {
        return tabMinHeight == null ? DEFAULT_TAB_MIN_HEIGHT : tabMinHeight.getValue();
    }

    /**
     * The minimum height of the tab.
     */
    public final DoubleProperty tabMinHeightProperty() {
        if (tabMinHeight == null) {
            tabMinHeight = new StyleableDoubleProperty(DEFAULT_TAB_MIN_HEIGHT) {

                @Override
                public StyleableProperty getStyleableProperty() {
                    return StyleableProperties.TAB_MIN_HEIGHT;
                }

                @Override
                public Object getBean() {
                    return FXTabPane.this;
                }

                @Override
                public String getName() {
                    return "tabMinHeight";
                }
            };
        }
        return tabMinHeight;
    }

    /**
     * <p>The maximum height if the tabs in the TabPane.  This can be used to limit
     * the height in tabs. Setting the max equal to the min will fix the height
     * of the tab.  By default the min equals to the max.
     *
     * This value can also be set via CSS using -fx-tab-max-height
     * </p>
     */
    private DoubleProperty tabMaxHeight;
    public final void setTabMaxHeight(double value) {
        tabMaxHeightProperty().setValue(value);
    }

    /**
     * The maximum height of the tabs in the TabPane.
     *
     * @return The maximum height of the tabs.
     */
    public final double getTabMaxHeight() {
        return tabMaxHeight == null ? DEFAULT_TAB_MAX_HEIGHT : tabMaxHeight.getValue();
    }

    /**
     * <p>The maximum height of the tabs in the TabPane.</p>
     */
    public final DoubleProperty tabMaxHeightProperty() {
        if (tabMaxHeight == null) {
            tabMaxHeight = new StyleableDoubleProperty(DEFAULT_TAB_MAX_HEIGHT) {

                @Override
                public StyleableProperty getStyleableProperty() {
                    return StyleableProperties.TAB_MAX_HEIGHT;
                }

                @Override
                public Object getBean() {
                    return FXTabPane.this;
                }

                @Override
                public String getName() {
                    return "tabMaxHeight";
                }
            };
        }
        return tabMaxHeight;
    }

    /***************************************************************************
     *                                                                         *
     *                         Stylesheet Handling                             *
     *                                                                         *
     **************************************************************************/

    private static class StyleableProperties {
        private static final StyleableProperty<FXTabPane,Number> TAB_MIN_WIDTH =
                new StyleableProperty<FXTabPane,Number>("-fx-tab-min-width",
                SizeConverter.getInstance(), DEFAULT_TAB_MIN_WIDTH) {

            @Override
            public boolean isSettable(FXTabPane n) {
                return n.tabMinWidth == null || !n.tabMinWidth.isBound();
            }

            @Override
            public WritableValue<Number> getWritableValue(FXTabPane n) {
                return n.tabMinWidthProperty();
            }
        };

        private static final StyleableProperty<FXTabPane,Number> TAB_MAX_WIDTH =
                new StyleableProperty<FXTabPane,Number>("-fx-tab-max-width",
                SizeConverter.getInstance(), DEFAULT_TAB_MAX_WIDTH) {

            @Override
            public boolean isSettable(FXTabPane n) {
                return n.tabMaxWidth == null || !n.tabMaxWidth.isBound();
            }

            @Override
            public WritableValue<Number> getWritableValue(FXTabPane n) {
                return n.tabMaxWidthProperty();
            }
        };

        private static final StyleableProperty<FXTabPane,Number> TAB_MIN_HEIGHT =
                new StyleableProperty<FXTabPane,Number>("-fx-tab-min-height",
                SizeConverter.getInstance(), DEFAULT_TAB_MIN_HEIGHT) {

            @Override
            public boolean isSettable(FXTabPane n) {
                return n.tabMinHeight == null || !n.tabMinHeight.isBound();
            }

            @Override
            public WritableValue<Number> getWritableValue(FXTabPane n) {
                return n.tabMinHeightProperty();
            }
        };

        private static final StyleableProperty<FXTabPane,Number> TAB_MAX_HEIGHT =
                new StyleableProperty<FXTabPane,Number>("-fx-tab-max-height",
                SizeConverter.getInstance(), DEFAULT_TAB_MAX_HEIGHT) {

            @Override
            public boolean isSettable(FXTabPane n) {
                return n.tabMaxHeight == null || !n.tabMaxHeight.isBound();
            }

            @Override
            public WritableValue<Number> getWritableValue(FXTabPane n) {
                return n.tabMaxHeightProperty();
            }
        };

        private static final List<StyleableProperty> STYLEABLES;
        static {
            final List<StyleableProperty> styleables =
                new ArrayList<StyleableProperty>(Control.impl_CSS_STYLEABLES());
            Collections.addAll(styleables,
                TAB_MIN_WIDTH,
                TAB_MAX_WIDTH,
                TAB_MIN_HEIGHT,
                TAB_MAX_HEIGHT
            );
            STYLEABLES = Collections.unmodifiableList(styleables);
        }
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    public static List<StyleableProperty> impl_CSS_STYLEABLES() {
        return FXTabPane.StyleableProperties.STYLEABLES;
    }

    /**
     * RT-19263
     * @treatAsPrivate implementation detail
     * @deprecated This is an experimental API that is not intended for general use and is subject to change in future versions
     */
    @Deprecated
    public List<StyleableProperty> impl_getStyleableProperties() {
        return impl_CSS_STYLEABLES();
    }

    // used in the impl_getPseudoClassState method below to improve performance
    private Side cachedSide;
    private String cachedSideString;

    private static final long TOP_PSEUDOCLASS_STATE = StyleManager.getInstance().getPseudoclassMask("top");
    private static final long BOTTOM_PSEUDOCLASS_STATE = StyleManager.getInstance().getPseudoclassMask("bottom");
    private static final long LEFT_PSEUDOCLASS_STATE = StyleManager.getInstance().getPseudoclassMask("left");
    private static final long RIGHT_PSEUDOCLASS_STATE = StyleManager.getInstance().getPseudoclassMask("right");

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated @Override public long impl_getPseudoClassState() {
        long mask = super.impl_getPseudoClassState();
        switch(getSide()) {
            case TOP:
                mask |= TOP_PSEUDOCLASS_STATE;
                break;
            case RIGHT:
                mask |= RIGHT_PSEUDOCLASS_STATE;
                break;
            case BOTTOM:
                mask |= BOTTOM_PSEUDOCLASS_STATE;
                break;
            case LEFT:
                mask |= LEFT_PSEUDOCLASS_STATE;
                break;
        }
        return mask;
    }


    static class TabPaneSelectionModel extends SingleSelectionModel<FXTab> {
        private final FXTabPane tabPane;

        public TabPaneSelectionModel(final FXTabPane t) {
            if (t == null) {
                throw new NullPointerException("TabPane can not be null");
            }
            this.tabPane = t;

            // watching for changes to the items list content
            final ListChangeListener<FXTab> itemsContentObserver = new ListChangeListener<FXTab>() {
                @Override public void onChanged(Change<? extends FXTab> c) {
                    while (c.next()) {
                        for (FXTab tab : c.getRemoved()) {
                            if (tab != null && !tabPane.getTabs().contains(tab)) {
                                if (getSelectedIndex() == 0 && tabPane.getTabs().size() > 0) {                                    
                                    clearAndSelect(0);
                                    tab.setSelected(false);
                                }
                                if (tab.isSelected()) {
                                    tab.setSelected(false);
                                    if (c.getFrom() == 0) {
                                        if (tabPane.getTabs().size() > 1) {
                                            clearSelection();
                                        }
                                    } else {
                                        selectPrevious();
                                    }
                                }
                            }
                        }
                        if (c.wasAdded() || c.wasRemoved()) {
                            // The selected tab index can be out of sync with the list of tab if
                            // we add or remove tabs before the selected tab.
                            if (getSelectedIndex() != tabPane.getTabs().indexOf(getSelectedItem())) {
                                clearAndSelect(tabPane.getTabs().indexOf(getSelectedItem()));
                            }
                        }
                    }
                    if (getSelectedIndex() == -1 && getSelectedItem() == null && tabPane.getTabs().size() > 0) {                        
                        selectFirst();
                    } else if (tabPane.getTabs().isEmpty()) {
                        clearSelection();
                    }
                }                
            };
            if (this.tabPane.getTabs() != null) {
                this.tabPane.getTabs().addListener(itemsContentObserver);
            }
        }

        // API Implementation
        @Override public void select(int index) {
            if (index < 0 || (getItemCount() > 0 && index >= getItemCount()) ||
                (index == getSelectedIndex() && getModelItem(index).isSelected())) {
                return;
            }
            
            // Unselect the old tab
            if (getSelectedIndex() >= 0 && getSelectedIndex() < tabPane.getTabs().size()) {
                tabPane.getTabs().get(getSelectedIndex()).setSelected(false);
            }

            setSelectedIndex(index);

            FXTab tab = getModelItem(index);            
            if (tab != null) {
                setSelectedItem(tab);
            }
            
            // Select the new tab
            if (getSelectedIndex() >= 0 && getSelectedIndex() < tabPane.getTabs().size()) {
                tabPane.getTabs().get(getSelectedIndex()).setSelected(true);
            }
        }

        @Override public void select(FXTab tab) {
            final int itemCount = getItemCount();

            for (int i = 0; i < itemCount; i++) {
                final FXTab value = getModelItem(i);
                if (value != null && value.equals(tab)) {
                    select(i);
                    return;
                }
            }
            if (tab != null) {
                setSelectedItem(tab);
            }
        }

        @Override protected FXTab getModelItem(int index) {
            final ObservableList<FXTab> items = tabPane.getTabs();
            if (items == null) return null;
            if (index < 0 || index >= items.size()) return null;
            return items.get(index);
        }

        @Override protected int getItemCount() {
            final ObservableList<FXTab> items = tabPane.getTabs();
            return items == null ? 0 : items.size();
        }
    }

    /**
     * <p>This specifies how the TabPane handles tab closing from an end-users
     * perspective. The options are:</p>
     *
     * <ul>
     *   <li> TabClosingPolicy.UNAVAILABLE: Tabs can not be closed by the user
     *   <li> TabClosingPolicy.SELECTED_TAB: Only the currently selected tab will
     *          have the option to be closed, with a graphic next to the tab
     *          text being shown. The graphic will disappear when a tab is no
     *          longer selected.
     *   <li> TabClosingPolicy.ALL_TABS: All tabs will have the option to be
     *          closed.
     * </ul>
     */
    public enum TabClosingPolicy {

        /**
         * Only the currently selected tab will have the option to be closed, with a
         * graphic next to the tab text being shown. The graphic will disappear when
         * a tab is no longer selected.
         */
        SELECTED_TAB,

        /**
         * All tabs will have the option to be closed.
         */
        ALL_TABS,

        /**
         * Tabs can not be closed by the user.
         */
        UNAVAILABLE
    }
}
