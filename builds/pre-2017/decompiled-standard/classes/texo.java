/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.main.GloomyCore;

public class texo
extends GuiScreenAdvanced {
    private McButton _a;
    private int _b;

    public texo(gqjz gqjz2) {
        super(new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma11).create(), 400, 400, gqjz2);
        this.closeOnEsc = false;
        boolean bl = GloomyCore.mcconfig.get("general", "disclaimer_shown", false).getBoolean(false);
        this._b = bl ? 0 : 400;
    }

    @Override
    public void func_73866_w_() {
        GuiHelper.addBackground(this, false);
        String string = srxe._b("/assets/stalker/disclaimer.txt");
        McTextArea mcTextArea = new McTextArea(this, this.guiLeft + 20, this.guiTop + 20, 360, 360);
        mcTextArea.drawBackground = false;
        mcTextArea.isEditable = false;
        mcTextArea.setText(string);
        this.addElement(mcTextArea);
        this._a = new McButton((IAdvancedGui)this, this.guiLeft + 100, this.guiTop + 330, "\u041e\u041a").onClick(guiActionButtonClick -> this.closeScreen());
        this._a.setSize(new Dimension(200, 40));
        this._a.setEnabled(false);
        this.addElement(this._a);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this._b > 0) {
            --this._b;
            this._a.setEnabled(false);
            this._a.text = "OK (" + (this._b / 20 + 1) + ")";
            if (this._b == 0) {
                GloomyCore.mcconfig.get("general", "disclaimer_shown", false).set(true);
                GloomyCore.mcconfig.save();
            }
        } else {
            this._a.setEnabled(true);
            this._a.text = "\u041e\u041a";
        }
    }
}

