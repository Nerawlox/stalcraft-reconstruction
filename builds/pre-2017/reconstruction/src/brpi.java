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
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

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

    public brpi(Entity entity, Vec3 vec3, Entity entity2, float f) {
        this._a = entity.dimension;
        this._b = (float)entity.posX;
        this._c = (float)entity.posY + entity.getEyeHeight();
        this._d = (float)entity.posZ;
        this._e = (float)vec3._c;
        this._f = (float)vec3._d;
        this._g = (float)vec3._e;
        this._h = true;
        this._i = entity2.entityId;
        this._m = f;
    }

    public brpi(Entity entity, Vec3 vec3, int n, byte by, float f) {
        this._a = entity.dimension;
        this._b = (float)entity.posX;
        this._c = (float)entity.posY + entity.getEyeHeight();
        this._d = (float)entity.posZ;
        this._e = (float)vec3._c;
        this._f = (float)vec3._d;
        this._g = (float)vec3._e;
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
        Minecraft minecraft = Minecraft._E();
        Vec3 vec3 = Vec3._a(this._b, this._c, this._d);
        Vec3 vec32 = Vec3._a(this._e, this._f, this._g);
        if (!this._l) {
            entity = new EntityBullet(minecraft._r, vec3, vec32);
            minecraft._r.spawnEntityInWorld(entity);
            pidb._a(vec3, vec32, this._m);
        }
        if (this._h) {
            entity = minecraft._r.getEntityByID(this._i);
            pidb._a(vec3, vec32, entity, this._l, this._m);
        } else {
            pidb._a(vec3, vec32, this._j, this._k, this._l, this._m);
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
        List list2 = MinecraftServer._I().__ag()._e;
        for (EntityPlayer entityPlayer : list2) {
            if (entityPlayer.dimension != this._a) continue;
            double d = this._d();
            double d2 = (double)this._b - entityPlayer.posX;
            double d3 = (double)this._c - entityPlayer.posY;
            double d4 = (double)this._d - entityPlayer.posZ;
            if (d2 * d2 < d && d3 * d3 < d && d4 * d4 < d) {
                PacketDispatcher.sendPacketToPlayer(fmco2, entityPlayer);
                continue;
            }
            d2 = (double)this._e - entityPlayer.posX;
            d3 = (double)this._f - entityPlayer.posY;
            d4 = (double)this._g - entityPlayer.posZ;
            if (!(d2 * d2 < d) || !(d3 * d3 < d) || !(d4 * d4 < d)) continue;
            PacketDispatcher.sendPacketToPlayer(fmco2, entityPlayer);
        }
    }
}

