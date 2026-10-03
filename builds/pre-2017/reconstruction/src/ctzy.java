/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class ctzy
extends ytyx {
    private int _a;
    private float _b;
    private float _c;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        entity.rotationYaw = this._b;
        entity.rotationPitch = this._c;
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).rotationYawHead = this._b;
        }
    }

    public ctzy() {
    }

    public ctzy(int n, float f, float f2) {
        this._a = n;
        this._b = f;
        this._c = f2;
    }
}

