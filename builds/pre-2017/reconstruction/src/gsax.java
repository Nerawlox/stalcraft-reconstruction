/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import noppes.npcs.EntityNPCInterface;

public class gsax
extends cfum {
    private Entity _a;
    private Class<? extends Entity> _b;
    private int _c = -1;
    private String _d;

    private gsax() {
    }

    public static gsax _a() {
        return new gsax();
    }

    public gsax _a(Entity entity) {
        this._a = entity;
        return this;
    }

    public gsax _a(Class<? extends Entity> clazz) {
        this._b = clazz;
        return this;
    }

    public gsax _a(String string) {
        this._d = string;
        return this;
    }

    public gsax _a(int n) {
        this._c = n;
        return this;
    }

    public boolean _a(MovingObjectPosition movingObjectPosition) {
        pkix pkix2;
        if (movingObjectPosition == null) {
            return false;
        }
        if (movingObjectPosition._c == EnumMovingObjectType._b && movingObjectPosition._i != null) {
            if (this._d != null && movingObjectPosition._i instanceof EntityNPCInterface) {
                return movingObjectPosition._i.getEntityName().equals(this._d);
            }
            if (this._b != null && this._b.isInstance(movingObjectPosition._i)) {
                return true;
            }
            if (this._a != null && movingObjectPosition != null) {
                return this._a.entityId == movingObjectPosition._i.entityId;
            }
        } else if (movingObjectPosition._c == EnumMovingObjectType._a && (pkix2 = Minecraft._E()._r).getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f) == this._c) {
            return true;
        }
        return false;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new hebv.kjui(dzyj2){

            @Override
            public void _a(Entity entity) {
            }

            @Override
            public void _b(Entity entity) {
            }

            @Override
            public void _a(MovingObjectPosition movingObjectPosition) {
                if (gsax.this._a(movingObjectPosition)) {
                    gsax.this._a(gsax.this, this);
                }
            }
        };
        return this._i;
    }
}

