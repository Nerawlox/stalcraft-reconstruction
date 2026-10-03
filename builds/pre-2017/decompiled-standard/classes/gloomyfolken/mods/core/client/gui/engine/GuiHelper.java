/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTabButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPageButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPane;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class GuiHelper {
    public static final ResourceLocation widgets = new ResourceLocation("gloomycore", "textures/gui/widgets.png");
    public static final ResourceLocation mcButtons = new ResourceLocation("textures/gui/widgets.png");
    public static final ResourceLocation clanButtons = new ResourceLocation("gloomycore", "textures/gui/buttons.png");
    public static final GuiRenderer widgetsRenderer = new GuiRendererBuilder().setTextureSize(256, 256).create();
    public static final GuiRenderer mcWidgetsRenderer = new GuiRendererBuilder().create();
    public static final ComponentSliderBarStyle sliderStyle = (ComponentSliderBarStyle)ComponentStyle.VANILLA.getComponentStyle(McScrollBar.class);
    public static final ComponentScrollButtonStyle scrollButtonStyle = (ComponentScrollButtonStyle)ComponentStyle.VANILLA.getComponentStyle(McScrollButton.class);
    public static final ComponentButtonStyle mcButtonStyle = (ComponentButtonStyle)ComponentStyle.VANILLA.getComponentStyle(McButton.class);
    public static final ComponentButtonStyle tabStyle = (ComponentButtonStyle)ComponentStyle.VANILLA.getComponentStyle(McTabButton.class);
    public static final ComponentButtonStyle listStyle = new ComponentButtonStyle(){
        {
            this.setTexture(clanButtons);
            this.setSize(400, 26);
            this.setDefaultUv(0, 308);
            this.setMouseOverUv(0, 334);
            this.setActiveUv(0, 360);
        }
    };

    public static McScrollList addScrollList(IAdvancedGui iAdvancedGui, List<? extends vjsq> list2, Point point, Dimension dimension) {
        return GuiHelper.addScrollList(iAdvancedGui, list2, point, dimension, scrollButtonStyle.getTopArrowStyle(), scrollButtonStyle.getBottomArrowStyle());
    }

    public static McScrollList addScrollList(IAdvancedGui iAdvancedGui, List<? extends vjsq> list2, Point point, Dimension dimension, ComponentButtonStyle componentButtonStyle, ComponentButtonStyle componentButtonStyle2) {
        McScrollList<? extends vjsq> mcScrollList = new McScrollList<vjsq>(iAdvancedGui, listStyle, list2, point, dimension);
        mcScrollList.setRenderer(GuiComponent.hdRenderer);
        McScrollBar mcScrollBar = new McScrollBar(iAdvancedGui, mcScrollList, McScrollBar.ScrollBarType.VERTICAL, new Point(point.x + dimension.width, point.y + 14), dimension.height - 28, sliderStyle.getVerticalBarStyle());
        mcScrollList.setSlider(mcScrollBar);
        iAdvancedGui.getElementsList().addElement(mcScrollList);
        iAdvancedGui.getElementsList().addElement(mcScrollBar);
        iAdvancedGui.getElementsList().addElement(new McScrollButton(iAdvancedGui, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), componentButtonStyle));
        iAdvancedGui.getElementsList().addElement(new McScrollButton(iAdvancedGui, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), componentButtonStyle2));
        return mcScrollList;
    }

    public static McCheckBox createCheckBox(IAdvancedGui iAdvancedGui, Point point, String string) {
        ComponentCheckboxStyle componentCheckboxStyle = (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McCheckBox.class);
        if (componentCheckboxStyle == null) {
            // empty if block
        }
        McCheckBox mcCheckBox = new McCheckBox(iAdvancedGui, string, point, componentCheckboxStyle);
        mcCheckBox.setRenderer(widgetsRenderer);
        return mcCheckBox;
    }

    public static McNumberField createNumberField(IAdvancedGui iAdvancedGui, Point point, long l) {
        return GuiHelper.createNumberField(iAdvancedGui, point, l, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public static McNumberField createNumberField(IAdvancedGui iAdvancedGui, Point point, long l, long l2, long l3) {
        int n = (int)yfpk._b._a(String.valueOf(l2));
        Dimension dimension = new Dimension(n * 2, 20);
        return GuiHelper.createNumberField(iAdvancedGui, point, dimension, l, l2, l3);
    }

    public static McNumberField createNumberField(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, long l, long l2, long l3) {
        McNumberField mcNumberField = new McNumberField(iAdvancedGui, point, dimension);
        mcNumberField.setNumber(l);
        mcNumberField.setMinValue(l3);
        mcNumberField.setMaxValue(l2);
        return mcNumberField;
    }

    public static McRadioButton createRadioButton(McRadioGroup mcRadioGroup, Point point, String string) {
        ComponentCheckboxStyle componentCheckboxStyle = (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McRadioButton.class);
        if (componentCheckboxStyle == null) {
            // empty if block
        }
        McRadioButton mcRadioButton = new McRadioButton(mcRadioGroup, string, point, componentCheckboxStyle);
        mcRadioButton.setRenderer(widgetsRenderer);
        return mcRadioButton;
    }

    public static McScrollPane createScrollPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2, boolean bl) {
        McScrollPane mcScrollPane = GuiHelper.createScrollPane(iAdvancedGui, point, dimension, dimension2, bl, sliderStyle, scrollButtonStyle);
        if (mcScrollPane.getVerticalScrollBar() != null) {
            mcScrollPane.getVerticalScrollBar().setBackgroundImage(widgets, new Point(100, 26), new Dimension(13, 32));
        }
        if (mcScrollPane.getHorizontalScrollBar() != null) {
            mcScrollPane.getHorizontalScrollBar().setBackgroundImage(widgets, new Point(114, 26), new Dimension(32, 13));
        }
        mcScrollPane.setElementsRenderer(widgetsRenderer);
        return mcScrollPane;
    }

    public static McScrollPane createScrollPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2, boolean bl, ComponentSliderBarStyle componentSliderBarStyle, ComponentScrollButtonStyle componentScrollButtonStyle) {
        McScrollPane mcScrollPane = new McScrollPane(iAdvancedGui, point, dimension, dimension2, bl);
        mcScrollPane.setScrollBarStyle(componentSliderBarStyle);
        mcScrollPane.setScrollButtonStyle(componentScrollButtonStyle);
        mcScrollPane.initControls();
        return mcScrollPane;
    }

    public static McScrollPane createScrollPane(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, int n5, int n6) {
        return GuiHelper.createScrollPane(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), new Dimension(n5, n6), true);
    }

    public static McScrollPane addScrollPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2, boolean bl) {
        McScrollPane mcScrollPane = GuiHelper.createScrollPane(iAdvancedGui, point, dimension, dimension2, bl);
        iAdvancedGui.getElementsList().addElement(mcScrollPane);
        return mcScrollPane;
    }

    public static McScrollPane addScrollPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2) {
        McScrollPane mcScrollPane = GuiHelper.createScrollPane(iAdvancedGui, point, dimension, dimension2, true);
        iAdvancedGui.getElementsList().addElement(mcScrollPane);
        return mcScrollPane;
    }

    public static McScrollPane addScrollPane(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, int n5, int n6) {
        return GuiHelper.addScrollPane(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), new Dimension(n5, n6));
    }

    public static McButton createButton(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, String string) {
        return GuiHelper.createButton(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), string);
    }

    public static McButton createButton(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String string) {
        McButton mcButton = new McButton(iAdvancedGui, point, mcButtonStyle, string);
        mcButton.setSize(dimension);
        mcButton.setRenderer(mcWidgetsRenderer);
        return mcButton;
    }

    public static McButton addButton(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, String string) {
        return GuiHelper.addButton(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), string);
    }

    public static McButton addButton(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String string) {
        McButton mcButton = GuiHelper.createButton(iAdvancedGui, point, dimension, string);
        iAdvancedGui.getElementsList().addElement(mcButton);
        return mcButton;
    }

    public static McButton addButton(GuiComponentsList guiComponentsList, int n, int n2, int n3, int n4, String string) {
        return GuiHelper.addButton(guiComponentsList, new Point(n, n2), new Dimension(n3, n4), string);
    }

    public static McButton addButton(GuiComponentsList guiComponentsList, Point point, Dimension dimension, String string) {
        McButton mcButton = GuiHelper.createButton(guiComponentsList.parent, point, dimension, string);
        guiComponentsList.addElement(mcButton);
        return mcButton;
    }

    public static McButton addButton(GuiComponentsList guiComponentsList, Point point, Dimension dimension, ComponentButtonStyle componentButtonStyle, String string) {
        McButton mcButton = new McButton(guiComponentsList.parent, point, componentButtonStyle, string);
        mcButton.setSize(dimension);
        guiComponentsList.addElement(mcButton);
        return mcButton;
    }

    public static McButton addButton(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, ComponentButtonStyle componentButtonStyle, String string) {
        McButton mcButton = new McButton(iAdvancedGui, point, componentButtonStyle, string);
        mcButton.setSize(dimension);
        iAdvancedGui.getElementsList().addElement(mcButton);
        return mcButton;
    }

    public static McLabel addLabel(IAdvancedGui iAdvancedGui, String string, Point point, ComponentStyle componentStyle) {
        McLabel mcLabel = new McLabel(iAdvancedGui, string, point);
        mcLabel.setStyle(componentStyle);
        iAdvancedGui.getElementsList().addElement(mcLabel);
        return mcLabel;
    }

    public static McLabel addLabel(IAdvancedGui iAdvancedGui, String string, Point point) {
        McLabel mcLabel = new McLabel(iAdvancedGui, string, point);
        iAdvancedGui.getElementsList().addElement(mcLabel);
        return mcLabel;
    }

    public static McLabel addLabel(IAdvancedGui iAdvancedGui, String string, int n, int n2) {
        return GuiHelper.addLabel(iAdvancedGui, string, new Point(n, n2));
    }

    public static McLabel addLabel(IAdvancedGui iAdvancedGui, String string, Point point, int n) {
        McLabel mcLabel = GuiHelper.addLabel(iAdvancedGui, string, point);
        mcLabel.color = n;
        return mcLabel;
    }

    public static McDummySlot addSlot(GuiComponentsList guiComponentsList, cvzo cvzo2, Point point, float f) {
        int n;
        int n2;
        int n3;
        int n4 = 0;
        if (f == 1.0f) {
            n3 = 220;
            n2 = 36;
            n = 36;
        } else if (f == 2.0f) {
            n3 = 148;
            n2 = 72;
            n = 72;
        } else {
            throw new IllegalArgumentException("Unsupported slot size");
        }
        McImage mcImage = new McImage(guiComponentsList.parent, point.x, point.y, n3, n4, n2, n, widgets);
        mcImage.setRenderer(widgetsRenderer);
        guiComponentsList.addElement(mcImage);
        McDummySlot mcDummySlot = new McDummySlot(guiComponentsList.parent, cvzo2, point.x + (int)(2.0f * f), point.y + (int)(2.0f * f), f);
        guiComponentsList.addElement(mcDummySlot);
        return mcDummySlot;
    }

    public static McBackground createBackground(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl) {
        return (McBackground)new McBackground(iAdvancedGui, point, dimension).setTexture(widgets).setTextureCoords(new Point(128, 128)).setTextureSize(new Dimension(128, 128)).setHasBackground(bl).setResizeBorder(20).setRenderer(widgetsRenderer);
    }

    public static McBackground createBackground(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, boolean bl) {
        return GuiHelper.createBackground(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), bl);
    }

    public static McBackground addBackground(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl) {
        McBackground mcBackground = GuiHelper.createBackground(iAdvancedGui, point, dimension, bl);
        iAdvancedGui.getElementsList().addElement(mcBackground);
        return mcBackground;
    }

    public static McBackground addBackground(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, boolean bl) {
        return GuiHelper.addBackground(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4), bl);
    }

    public static McBackground addBackground(GuiScreenAdvanced guiScreenAdvanced, boolean bl) {
        return GuiHelper.addBackground(guiScreenAdvanced, guiScreenAdvanced.guiLeft, guiScreenAdvanced.guiTop, guiScreenAdvanced.guiWidth, guiScreenAdvanced.guiHeight, bl);
    }

    public static McTabPane createTabPane(IAdvancedGui iAdvancedGui, Point point, List<String> list2, boolean bl, final int n) {
        ComponentButtonStyle componentButtonStyle = new ComponentButtonStyle(){
            {
                this.setTexture(tabStyle.getResourceLocation());
                this.setSize(tabStyle.getSize());
                this.setDefaultUv(tabStyle.getDefaultUv());
                this.setActiveUv(tabStyle.getActiveUv());
                this.setDisabledUv(tabStyle.getDisabledUv());
                this.setMouseOverUv(tabStyle.getMouseOverUv());
                this.borderThickness = n;
            }
        };
        McTabPane mcTabPane = new McTabPane(iAdvancedGui, point);
        mcTabPane.setRenderer(widgetsRenderer);
        for (String string : list2) {
            McTabButton mcTabButton = new McTabButton(mcTabPane, string, componentButtonStyle);
            mcTabButton.setRenderer(widgetsRenderer);
            if (bl) {
                mcTabButton.textToWidth(n);
            }
            mcTabButton.textOffsetY = -4;
            mcTabPane.addTab(mcTabButton, true);
        }
        if (list2.size() > 0) {
            mcTabPane.setActiveTab(mcTabPane.getTab(0));
        }
        return mcTabPane;
    }

    public static McTabPane createScrollableTabPane(IAdvancedGui iAdvancedGui, Point point, List<String> list2, boolean bl, final int n, int n2) {
        McTabPane mcTabPane = GuiHelper.createTabPane(iAdvancedGui, point, list2, bl, n);
        ComponentButtonStyle componentButtonStyle = new ComponentButtonStyle(){
            {
                this.setTexture(tabStyle.getResourceLocation());
                this.setSize(tabStyle.getSize());
                this.setDefaultUv(tabStyle.getDefaultUv());
                this.setActiveUv(tabStyle.getActiveUv());
                this.setDisabledUv(tabStyle.getDisabledUv());
                this.setMouseOverUv(tabStyle.getMouseOverUv());
                this.borderThickness = n;
            }
        };
        McTabPageButton mcTabPageButton = new McTabPageButton(mcTabPane, componentButtonStyle, -1);
        McTabPageButton mcTabPageButton2 = new McTabPageButton(mcTabPane, componentButtonStyle, 1);
        mcTabPageButton.setSize(new Dimension(32, 38));
        mcTabPageButton2.setSize(new Dimension(32, 38));
        mcTabPageButton2.textOffsetY = -4;
        mcTabPageButton.textOffsetY = -4;
        mcTabPageButton.setRenderer(widgetsRenderer);
        mcTabPageButton2.setRenderer(widgetsRenderer);
        mcTabPane.setScrollable(mcTabPageButton, mcTabPageButton2, n2, bl, n);
        return mcTabPane;
    }

    public static Point getCursorPos(IAdvancedGui iAdvancedGui) {
        float f = iAdvancedGui.getRenderer().scale;
        int n = (int)((float)iAdvancedGui.getGui().field_73880_f / f);
        int n2 = (int)((float)iAdvancedGui.getGui().field_73881_g / f);
        int n3 = Mouse.getEventX() * n / xpzm._E()._n;
        int n4 = n2 - Mouse.getEventY() * n2 / xpzm._E()._o - 1;
        return new Point(n3, n4);
    }
}

