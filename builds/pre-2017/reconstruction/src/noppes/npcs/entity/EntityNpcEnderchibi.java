/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;

public class EntityNpcEnderchibi
extends EntityNPCInterface {
    public EntityNpcEnderchibi(World world) {
        super(world);
        this.display.texture = "customnpcs:textures/entity/enderchibi/MrEnderchibi.png";
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote) {
            InvokeSideOnly.client(() -> NoppesUtil.spawnEnderchibi(this));
        }
    }
}

