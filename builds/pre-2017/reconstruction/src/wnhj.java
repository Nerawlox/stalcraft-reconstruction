/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.main.pidb;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;

public class wnhj
extends mqld {
    public int _c;
    public static final int _d = 60;
    public int _e = -60;
    public ArrayList<jhcr> _f = new ArrayList();

    @ezey(_a={eidj.CLIENT})
    public void _a() {
        this.worldObj.playSound((float)this.xCoord + 0.5f, (float)this.yCoord + 0.5f, (float)this.zCoord + 0.5f, "anomalies:electra_hit", 1.0f, 1.0f, false);
        pidb._a(new bqmy(this));
        this._e = this._c;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void updateEntity() {
        super.updateEntity();
        ++this._c;
        Iterator<jhcr> iterator2 = this._f.iterator();
        while (iterator2.hasNext()) {
            jhcr jhcr2 = iterator2.next();
            if (jhcr2._g) {
                iterator2.remove();
                continue;
            }
            jhcr2._a();
        }
        if (this._c > this._e + 60 && this.worldObj.rand.nextFloat() < 0.2f) {
            ((mqip)this._c())._a();
            this._f.add(new jhcr(this));
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._c = nBTTagCompound._f("counter");
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("counter", this._c);
    }

    @Override
    protected Class<? extends iekw> _d() {
        return mqip.class;
    }

    @Override
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 3) {
            this._a();
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }
}

