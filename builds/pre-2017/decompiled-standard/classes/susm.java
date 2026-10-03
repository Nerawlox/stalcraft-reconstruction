/*
 * Decompiled with CFR 0.152.
 */
import java.net.SocketAddress;
import net.minecraft.entity.player.EntityPlayerMP;

public class susm
extends ozhc {
    public qoac _a;

    public susm(yfci yfci2) {
        super(yfci2);
        this._m = 10;
    }

    @Override
    public void _a(EntityPlayerMP entityPlayerMP) {
        if (entityPlayerMP.func_70005_c_().equals(this._b()._M())) {
            this._a = new qoac();
            entityPlayerMP.func_70109_d(this._a);
        }
        super._a(entityPlayerMP);
    }

    @Override
    public String _a(SocketAddress socketAddress, String string) {
        if (string.equalsIgnoreCase(this._b()._M())) {
            return "That name is already taken.";
        }
        return super._a(socketAddress, string);
    }

    public yfci _b() {
        return (yfci)super._g();
    }

    @Override
    public qoac _c() {
        return this._a;
    }

    @Override
    public /* synthetic */ dzfd _g() {
        return this._b();
    }
}

