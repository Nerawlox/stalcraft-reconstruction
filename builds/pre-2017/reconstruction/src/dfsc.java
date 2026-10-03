/*
 * Decompiled with CFR 0.152.
 */
import carpentersblocks.tileentity.TECarpentersBlock;
import gloomyfolken.mods.asm.Logger;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class dfsc {
    private boolean _a;

    public dfsc() {
        try {
            Class.forName("carpentersblocks.CarpentersBlocks");
            Logger.finest("CarpenterBlocks found!", new Object[0]);
            this._a = true;
        }
        catch (Exception exception) {
            Logger.finest("CarpenterBlocks not found!", new Object[0]);
        }
    }

    public short _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this._a) {
            return this._b(iBlockAccess, n, n2, n3);
        }
        return 0;
    }

    private short _b(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TileEntity tileEntity = iBlockAccess.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof TECarpentersBlock) {
            return ((TECarpentersBlock)tileEntity).cover[6];
        }
        return 0;
    }

    public int _a(short s) {
        return s & 0xFFF;
    }

    public int _b(short s) {
        return (s & 0xF000) >>> 12;
    }
}

