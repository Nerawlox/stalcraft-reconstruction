/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class wnsz
extends ytyx {
    private int _a;
    private float _b;
    private float _c;
    private float _d;
    private float _e;
    private float _f;
    private float _g;

    public wnsz() {
    }

    public wnsz(Entity entity) {
        this._a = entity.entityId;
        this._b = (float)entity.posX;
        this._c = (float)entity.posY;
        this._d = (float)entity.posZ;
        this._e = (float)entity.motionX;
        this._f = (float)entity.motionY;
        this._g = (float)entity.motionZ;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        if (entity != null && entity instanceof EntityAdvancedThrowable) {
            ((EntityAdvancedThrowable)entity).synced = true;
            entity.setPosition(this._b, this._c, this._d);
            entity.serverPosX = (int)(this._b * 32.0f);
            entity.serverPosY = (int)(this._c * 32.0f);
            entity.serverPosZ = (int)(this._d * 32.0f);
            entity.motionX = this._e;
            entity.motionY = this._f;
            entity.motionZ = this._g;
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
        this._d = dataInput.readFloat();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
        dataOutput.writeFloat(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
    }
}

