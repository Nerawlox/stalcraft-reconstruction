/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.tileentity.TileEntity;

public class hurz
implements Callable {
    public final /* synthetic */ TileEntity _a;

    public hurz(TileEntity tileEntity) {
        this._a = tileEntity;
    }

    public String _a() {
        int n = this._a.worldObj.getBlockMetadata(this._a.xCoord, this._a.yCoord, this._a.zCoord);
        if (n < 0) {
            return "Unknown? (Got " + n + ")";
        }
        String string = String.format("%4s", Integer.toBinaryString(n)).replace(" ", "0");
        return String.format("%1$d / 0x%1$X / 0b%2$s", n, string);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

