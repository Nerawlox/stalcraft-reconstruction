/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.client.CustomModLoadingErrorDisplayException;

public class GuiCustomModLoadingErrorScreen
extends hchw {
    private CustomModLoadingErrorDisplayException customException;

    public GuiCustomModLoadingErrorScreen(CustomModLoadingErrorDisplayException customModLoadingErrorDisplayException) {
        super(null, null);
        this.customException = customModLoadingErrorDisplayException;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.customException.initGui(this, this.field_73886_k);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.customException.drawScreen(this, this.field_73886_k, n, n2, f);
    }
}

