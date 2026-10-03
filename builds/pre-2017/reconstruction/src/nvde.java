/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntityChest;

public class nvde {
    public static nvde _a = new nvde();
    public TileEntityChest _b = new TileEntityChest(0);
    public TileEntityChest _c = new TileEntityChest(1);
    public gaqr _d = new gaqr();

    public void _a(Block block, int n, float f) {
        if (block.blockID == Block.enderChest.blockID) {
            TileEntityRenderer._b._a(this._d, 0.0, 0.0, 0.0, 0.0f);
        } else if (block.blockID == Block.chestTrapped.blockID) {
            TileEntityRenderer._b._a(this._c, 0.0, 0.0, 0.0, 0.0f);
        } else {
            TileEntityRenderer._b._a(this._b, 0.0, 0.0, 0.0, 0.0f);
        }
    }
}

