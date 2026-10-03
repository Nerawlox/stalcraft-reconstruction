/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.LinkedHashSet;
import java.util.Set;
import mods.pda.client.component.option.PdaNumberPicker;
import mods.pda.client.component.option.PdaSelection;
import mods.pda.client.component.option.PdaToggle;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;

public class PdaOptions
extends AbstractPdaTab {
    static Dimension OPTION_CONTROLLER_SIZE = new Dimension(100, 23);
    public static Set<anpn> options = new LinkedHashSet<anpn>();

    public PdaOptions(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        Dimension dimension = this.pdaScreen.add(-10, -35);
        McScrollPane mcScrollPane = GuiPda.createScrollPane(this.pda, this.pdaScreenStart.add(0, 35), dimension, new Dimension(this.pdaScreen.width, options.size() * 30));
        mcScrollPane.getVerticalScrollBar().setLocation(new Point(dimension.width - 7, 0));
        mcScrollPane.getVerticalScrollBar().setLength(dimension.height - 28);
        mcScrollPane.getTopButton().setLocation(new Point(dimension.width - 7, -15));
        mcScrollPane.getBottomButton().setLocation(new Point(dimension.width - 7, dimension.height - 26));
        this.pda.addElement(mcScrollPane);
        int n = 0;
        for (anpn anpn2 : options) {
            OptionComponent optionComponent = new OptionComponent(this.pda, new Point(0, 33 * n), new Dimension(this.pdaScreen.width - 20, 30), anpn2);
            mcScrollPane.getViewport().addElement(optionComponent);
            optionComponent.init(mcScrollPane.getViewport());
            ++n;
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    public static <T extends anpn> T registerOption(T t) {
        options.add(t);
        return t;
    }

    @Override
    public void onScreenClose() {
        for (anpn anpn2 : options) {
            anpn2.save(GloomyCore.mcconfig);
        }
        GloomyCore.mcconfig.save();
    }

    private class OptionComponent
    extends GuiComponentsList {
        private anpn option;

        protected OptionComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, anpn anpn2) {
            super(iAdvancedGui, point, dimension);
            this.option = anpn2;
        }

        public void init(GuiComponentsList guiComponentsList) {
            Point point = this.getLocation().add(this.getSize().width - PdaOptions.OPTION_CONTROLLER_SIZE.width - 30, 6);
            if (this.option instanceof sbcg) {
                sbcg sbcg2 = (sbcg)this.option;
                PdaToggle pdaToggle2 = new PdaToggle(this.parent, point, OPTION_CONTROLLER_SIZE, sbcg2.enabled);
                pdaToggle2.onToggle(pdaToggle -> {
                    sbcg2.enabled = pdaToggle.getActive();
                    sbcg2.onChanged(false);
                });
                guiComponentsList.addElement(pdaToggle2);
            } else if (this.option instanceof jykp) {
                jykp jykp2 = (jykp)this.option;
                PdaSelection pdaSelection = new PdaSelection(this.parent, point, OPTION_CONTROLLER_SIZE, jykp2.getValueNames(), jykp2.value);
                pdaSelection.onSelected(pdaSelection2 -> {
                    jykp2.value = pdaSelection.getIndex();
                });
                guiComponentsList.addElement(pdaSelection);
            } else if (this.option instanceof xqrx) {
                xqrx xqrx2 = (xqrx)this.option;
                PdaNumberPicker pdaNumberPicker2 = new PdaNumberPicker(this.parent, point, OPTION_CONTROLLER_SIZE, xqrx2.value, xqrx2.getMinValue(), xqrx2.getMaxValue(), xqrx2.getChangeStep());
                pdaNumberPicker2.onChange(pdaNumberPicker -> {
                    xqrx2.value = pdaNumberPicker.getValue();
                });
                guiComponentsList.addElement(pdaNumberPicker2);
            }
            guiComponentsList.addElement(new McLabel(this.parent, this.option.getOptionName(), this.getLocation().add(25, this.getSize().height / 3), 0x939393));
        }

        @Override
        public void drawComponent(Point point, float f) {
            this.renderer.bindTexture(iedw._a);
            this.renderer.drawTiledRect(this.getLocation().add(10, 5), new Point(64, 768), new Dimension(this.getSize().width - 13, 27), new Dimension(64, 27), 23, 0);
            super.drawComponent(point, f);
        }
    }
}

