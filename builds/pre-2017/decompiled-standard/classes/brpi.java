/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.network.PacketDispatcher;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.entity.EntityBullet;
import gloomyfolken.mods.weapon.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;

public class brpi
extends ytyx {
    private int _a;
    private float _b;
    private float _c;
    private float _d;
    private float _e;
    private float _f;
    private float _g;
    private boolean _h;
    private int _i;
    private short _j;
    private byte _k;
    private boolean _l;
    private float _m;

    public brpi() {
    }

    public brpi(Entity entity, ofbx ofbx2, Entity entity2, float f) {
        this._a = entity.field_71093_bK;
        this._b = (float)entity.field_70165_t;
        this._c = (float)entity.field_70163_u + entity.func_70047_e();
        this._d = (float)entity.field_70161_v;
        this._e = (float)ofbx2._c;
        this._f = (float)ofbx2._d;
        this._g = (float)ofbx2._e;
        this._h = true;
        this._i = entity2.field_70157_k;
        this._m = f;
    }

    public brpi(Entity entity, ofbx ofbx2, int n, byte by, float f) {
        this._a = entity.field_71093_bK;
        this._b = (float)entity.field_70165_t;
        this._c = (float)entity.field_70163_u + entity.func_70047_e();
        this._d = (float)entity.field_70161_v;
        this._e = (float)ofbx2._c;
        this._f = (float)ofbx2._d;
        this._g = (float)ofbx2._e;
        this._h = false;
        this._j = (short)n;
        this._k = by;
        this._m = f;
    }

    public brpi _b() {
        this._l = true;
        return this;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._l);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
        dataOutput.writeFloat(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
        dataOutput.writeBoolean(this._h);
        dataOutput.writeFloat(this._m);
        if (this._h) {
            dataOutput.writeInt(this._i);
        } else {
            dataOutput.writeShort(this._j);
            dataOutput.writeByte(this._k);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._l = dataInput.readBoolean();
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
        this._d = dataInput.readFloat();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
        this._h = dataInput.readBoolean();
        this._m = dataInput.readFloat();
        if (this._h) {
            this._i = dataInput.readInt();
        } else {
            this._j = dataInput.readShort();
            this._k = dataInput.readByte();
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity;
        xpzm xpzm2 = xpzm._E();
        ofbx ofbx2 = ofbx._a(this._b, this._c, this._d);
        ofbx ofbx3 = ofbx._a(this._e, this._f, this._g);
        if (!this._l) {
            entity = new EntityBullet(xpzm2._r, ofbx2, ofbx3);
            xpzm2._r.func_72838_d(entity);
            pidb._a(ofbx2, ofbx3, this._m);
        }
        if (this._h) {
            entity = xpzm2._r.func_73045_a(this._i);
            pidb._a(ofbx2, ofbx3, entity, this._l, this._m);
        } else {
            pidb._a(ofbx2, ofbx3, this._j, this._k, this._l, this._m);
        }
    }

    private double _d() {
        if (this._l) {
            return 1024.0;
        }
        return 4096.0;
    }

    public void _c() {
        fmco fmco2 = new fmco(this);
        List list2 = dzfd._I().__ag()._e;
        for (EntityPlayer entityPlayer : list2) {
            if (entityPlayer.field_71093_bK != this._a) continue;
            double d = this._d();
            double d2 = (double)this._b - entityPlayer.field_70165_t;
            double d3 = (double)this._c - entityPlayer.field_70163_u;
            double d4 = (double)this._d - entityPlayer.field_70161_v;
            if (d2 * d2 < d && d3 * d3 < d && d4 * d4 < d) {
                PacketDispatcher.sendPacketToPlayer(fmco2, entityPlayer);
                continue;
            }
            d2 = (double)this._e - entityPlayer.field_70165_t;
            d3 = (double)this._f - entityPlayer.field_70163_u;
            d4 = (double)this._g - entityPlayer.field_70161_v;
            if (!(d2 * d2 < d) || !(d3 * d3 < d) || !(d4 * d4 < d)) continue;
            PacketDispatcher.sendPacketToPlayer(fmco2, entityPlayer);
        }
    }
}

