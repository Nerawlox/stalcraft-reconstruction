/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.client.xpzm;

public class GuiOptionButton
extends baxz {
    public GuiOptionButton(int n, int n2, int n3, String string) {
        super(n, n2, n3, string);
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        return this.field_73748_h && n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
    }
}

