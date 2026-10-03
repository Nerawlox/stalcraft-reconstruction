/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.Resistances;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcSlider;
import noppes.npcs.client.gui.util.ISliderListener;
import noppes.npcs.client.gui.util.SubGuiInterface;

public class SubGuiNpcResistanceProperties
extends SubGuiInterface
implements ISliderListener {
    private Resistances resistances;

    public SubGuiNpcResistanceProperties(Resistances resistances) {
        this.resistances = resistances;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(1, "item.arrow.name", this.guiLeft + 4, this.guiTop + 37, 0x404040));
        this.addSlider(new GuiNpcSlider(this, 1, this.guiLeft + 94, this.guiTop + 32, null, (int)(this.resistances.arrow * 100.0f - 100.0f) + "%", this.resistances.arrow / 2.0f));
        this.addLabel(new GuiNpcLabel(2, "stats.melee", this.guiLeft + 4, this.guiTop + 59, 0x404040));
        this.addSlider(new GuiNpcSlider(this, 2, this.guiLeft + 94, this.guiTop + 54, null, (int)(this.resistances.playermelee * 100.0f - 100.0f) + "%", this.resistances.playermelee / 2.0f));
        this.addButton(new GuiNpcButton(66, this.guiLeft + 190, this.guiTop + 190, 60, 20, "gui.done"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 66) {
            this.close();
        }
    }

    @Override
    public void mouseDragged(GuiNpcSlider guiNpcSlider) {
        guiNpcSlider.field_73744_e = (int)(guiNpcSlider.field_73751_j * 200.0f - 100.0f) + "%";
    }

    @Override
    public void mousePressed(GuiNpcSlider guiNpcSlider) {
    }

    @Override
    public void mouseReleased(GuiNpcSlider guiNpcSlider) {
        if (guiNpcSlider.field_73741_f == 1) {
            this.resistances.arrow = guiNpcSlider.field_73751_j * 2.0f;
        }
        if (guiNpcSlider.field_73741_f == 2) {
            this.resistances.playermelee = guiNpcSlider.field_73751_j * 2.0f;
        }
    }
}

