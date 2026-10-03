/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class ujvt
implements Callable {
    public final /* synthetic */ TileEntity _a;

    public ujvt(TileEntity tileEntity) {
        this._a = tileEntity;
    }

    public String _a() {
        int n = this._a.worldObj.getBlockId(this._a.xCoord, this._a.yCoord, this._a.zCoord);
        try {
            return String.format("ID #%d (%s // %s)", n, Block.blocksList[n].getUnlocalizedName(), Block.blocksList[n].getClass().getCanonicalName());
        }
        catch (Throwable throwable) {
            return "ID #" + n;
        }
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

