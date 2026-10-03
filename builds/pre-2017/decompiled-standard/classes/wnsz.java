/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
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
        this._a = entity.field_70157_k;
        this._b = (float)entity.field_70165_t;
        this._c = (float)entity.field_70163_u;
        this._d = (float)entity.field_70161_v;
        this._e = (float)entity.field_70159_w;
        this._f = (float)entity.field_70181_x;
        this._g = (float)entity.field_70179_y;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = xpzm._E()._r.func_73045_a(this._a);
        if (entity != null && entity instanceof EntityAdvancedThrowable) {
            ((EntityAdvancedThrowable)entity).synced = true;
            entity.func_70107_b(this._b, this._c, this._d);
            entity.field_70118_ct = (int)(this._b * 32.0f);
            entity.field_70117_cu = (int)(this._c * 32.0f);
            entity.field_70116_cv = (int)(this._d * 32.0f);
            entity.field_70159_w = this._e;
            entity.field_70181_x = this._f;
            entity.field_70179_y = this._g;
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

