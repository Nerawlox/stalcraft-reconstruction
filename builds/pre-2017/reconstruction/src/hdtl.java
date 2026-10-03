/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.tileentity.TileEntityDispenser;

public class hdtl
extends TileEntityDispenser {
    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._c : "container.dropper";
    }
}

