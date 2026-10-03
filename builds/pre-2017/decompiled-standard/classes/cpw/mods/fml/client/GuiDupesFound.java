/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.DuplicateModsFoundException;
import cpw.mods.fml.common.ModContainer;
import java.io.File;
import java.util.Map;

public class GuiDupesFound
extends hchw {
    private DuplicateModsFoundException dupes;

    public GuiDupesFound(DuplicateModsFoundException duplicateModsFoundException) {
        super(null, null);
        this.dupes = duplicateModsFoundException;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = Math.max(85 - this.dupes.dupes.size() * 10, 10);
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader has found a problem with your minecraft installation", this.field_73880_f / 2, n3, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "You have mod sources that are duplicate within your system", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "Mod Id : File name", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (Map.Entry<ModContainer, File> entry : this.dupes.dupes.entries()) {
            this.func_73732_a(this.field_73886_k, String.format("%s : %s", entry.getKey().getModId(), entry.getValue().getName()), this.field_73880_f / 2, n3 += 10, 0xEEEEEE);
        }
    }
}

