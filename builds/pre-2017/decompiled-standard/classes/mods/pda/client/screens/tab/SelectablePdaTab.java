/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.screens.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;

public abstract class SelectablePdaTab
extends AbstractPdaTab {
    protected Map<String, Class<? extends SelectablePdaTab>> tabs = new LinkedHashMap<String, Class<? extends SelectablePdaTab>>();
    private Class<? extends SelectablePdaTab> currentTabClass;

    protected SelectablePdaTab(IAdvancedGui iAdvancedGui, Class<? extends SelectablePdaTab> clazz) {
        super(iAdvancedGui);
        this.currentTabClass = clazz;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.tabs.clear();
        this.registerVerticalTabs();
        this.createHorizontalTabs(this.tabs);
    }

    protected abstract void registerVerticalTabs();

    private void createHorizontalTabs(Map<String, Class<? extends SelectablePdaTab>> map) {
        int n = 0;
        GuiRenderer guiRenderer = this.pda.rendererWithFont(ExternalFont.tahoma11);
        ArrayList<String> arrayList = new ArrayList<String>(map.keySet());
        for (int i = 0; i < arrayList.size(); ++i) {
            String string = (String)arrayList.get(i);
            Class<? extends SelectablePdaTab> clazz = map.get(string);
            int n2 = guiRenderer.getStringWidth(string);
            McButton mcButton = GuiHelper.addButton(this.parent, this.pdaScreenStart.add(10 + n, 15), new Dimension(n2, 15), iedw._f, string);
            n += n2 + 10;
            mcButton.setRenderer(guiRenderer);
            mcButton.onClick(guiActionButtonClick -> this.openTab(clazz, this.pda));
            this.pda.addElement(mcButton);
            if (this.currentTabClass == clazz) {
                mcButton.textColor = 0x109101;
                this.pda.addElement(mcButton);
            } else {
                mcButton.mouseOverTextColor = 0xFFFFFF;
                mcButton.textColor = iedw._e.getRGB();
            }
            if (i == map.size() - 1) continue;
            this.pda.addElement(new McImage((IAdvancedGui)this.pda, mcButton.getLocation().add(n2, 0), new Point(84, 880), new Dimension(11, 13), iedw._a));
        }
    }

    private void openTab(Class<? extends SelectablePdaTab> clazz, GuiPda guiPda) {
        try {
            Constructor<? extends SelectablePdaTab> constructor = clazz.getConstructor(IAdvancedGui.class);
            constructor.setAccessible(true);
            guiPda.openTab(constructor.newInstance(guiPda));
        }
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
        }
    }
}

