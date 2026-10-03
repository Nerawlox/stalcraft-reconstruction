/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class zgif
extends TileEntitySpecialRenderer {
    private kjui _a = new kjui("/assets/stalker/models/campfire.mcsa");

    private void _a(maao maao2, double d, double d2, double d3, float f) {
        ezfc._a();
        ezfc._a((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
        this._a._c.renderAll();
        ezfc._b();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((maao)tileEntity, d, d2, d3, f);
    }
}

