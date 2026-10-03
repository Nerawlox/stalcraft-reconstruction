/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.client;

import atomicstryker.dynamiclights.client.IDynamicLightSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class DynamicLightSourceContainer {
    private final IDynamicLightSource lightSource;
    private int prevX;
    private int prevY;
    private int prevZ;
    private int x;
    private int y;
    private int z;

    public DynamicLightSourceContainer(IDynamicLightSource iDynamicLightSource) {
        this.lightSource = iDynamicLightSource;
        this.prevZ = 0;
        this.prevY = 0;
        this.prevX = 0;
        this.z = 0;
        this.y = 0;
        this.x = 0;
    }

    public boolean onUpdate() {
        Entity entity = this.lightSource.getAttachmentEntity();
        if (!entity.func_70089_S()) {
            return true;
        }
        if (this.hasEntityMoved(entity)) {
            entity.field_70170_p.func_72936_c(rrqi._b, this.x, this.y, this.z);
            entity.field_70170_p.func_72936_c(rrqi._b, this.prevX, this.prevY, this.prevZ);
        }
        return false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public IDynamicLightSource getLightSource() {
        return this.lightSource;
    }

    private boolean hasEntityMoved(Entity entity) {
        int n = sajh._c(entity.field_70165_t);
        int n2 = sajh._c(entity.field_70163_u);
        int n3 = sajh._c(entity.field_70161_v);
        if (n != this.x || n2 != this.y || n3 != this.z) {
            this.prevX = this.x;
            this.prevY = this.y;
            this.prevZ = this.z;
            this.x = n;
            this.y = n2;
            this.z = n3;
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object instanceof DynamicLightSourceContainer) {
            DynamicLightSourceContainer dynamicLightSourceContainer = (DynamicLightSourceContainer)object;
            if (dynamicLightSourceContainer.lightSource == this.lightSource) {
                return true;
            }
        }
        return false;
    }
}

