/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.client;

import atomicstryker.dynamiclights.client.IDynamicLightSource;

public class DynamicLightSourceContainer {
    private final IDynamicLightSource lightSource;
    private int prevX;
    private int prevY;
    private int prevZ;
    private int x;
    private int y;
    private int z;

    public DynamicLightSourceContainer(IDynamicLightSource light) {
        this.lightSource = light;
        this.prevZ = 0;
        this.prevY = 0;
        this.prevX = 0;
        this.z = 0;
        this.y = 0;
        this.x = 0;
    }

    public boolean onUpdate() {
        nn attachmentEntity = this.lightSource.getAttachmentEntity();
        if (!attachmentEntity.T()) {
            return true;
        }
        if (this.hasEntityMoved(attachmentEntity)) {
            attachmentEntity.q.c(ach.b, this.x, this.y, this.z);
            attachmentEntity.q.c(ach.b, this.prevX, this.prevY, this.prevZ);
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

    private boolean hasEntityMoved(nn ent) {
        int newX = ls.c(ent.u);
        int newY = ls.c(ent.v);
        int newZ = ls.c(ent.w);
        if (newX == this.x && newY == this.y && newZ == this.z) {
            return false;
        }
        this.prevX = this.x;
        this.prevY = this.y;
        this.prevZ = this.z;
        this.x = newX;
        this.y = newY;
        this.z = newZ;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof DynamicLightSourceContainer && ((DynamicLightSourceContainer)obj).lightSource == this.lightSource;
    }
}

