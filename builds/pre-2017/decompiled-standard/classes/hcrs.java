/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.jxsn;
import net.minecraft.util.pibk;
import net.minecraft.util.sajz;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkEvent;

@SideOnly(value=Side.CLIENT)
public class hcrs
implements mccn {
    public ixzi _a;
    public pibk _b = new pibk();
    public List _c = new ArrayList();
    public ozlu _d;

    public hcrs(ozlu ozlu2) {
        this._a = new raqi(ozlu2, 0, 0);
        this._d = ozlu2;
    }

    @Override
    public boolean _c(int n, int n2) {
        return true;
    }

    public void _e(int n, int n2) {
        ixzi ixzi2 = this._b(n, n2);
        if (!ixzi2._i()) {
            ixzi2._g();
        }
        this._b._e(jjym._a(n, n2));
        this._c.remove(ixzi2);
    }

    @Override
    public ixzi _a(int n, int n2) {
        ixzi ixzi2 = new ixzi(this._d, n, n2);
        this._b._a(jjym._a(n, n2), ixzi2);
        MinecraftForge.EVENT_BUS.post(new ChunkEvent.Load(ixzi2));
        ixzi2._f = true;
        return ixzi2;
    }

    @Override
    public ixzi _b(int n, int n2) {
        ixzi ixzi2 = (ixzi)this._b._b(jjym._a(n, n2));
        return ixzi2 == null ? this._a : ixzi2;
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        return true;
    }

    @Override
    public void _a() {
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public boolean _c() {
        return false;
    }

    @Override
    public void _a(mccn mccn2, int n, int n2) {
    }

    @Override
    public String _d() {
        return "MultiplayerChunkCache: " + this._b._a();
    }

    @Override
    public List _a(jxsn jxsn2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public xtcd _a(ozlu ozlu2, String string, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int _e() {
        return this._c.size();
    }

    @Override
    public void _d(int n, int n2) {
    }
}

