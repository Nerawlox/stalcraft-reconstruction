/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;

public class EntityNpcEnderchibi
extends EntityNPCInterface {
    public EntityNpcEnderchibi(ozlu ozlu2) {
        super(ozlu2);
        this.display.texture = "customnpcs:textures/entity/enderchibi/MrEnderchibi.png";
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(() -> NoppesUtil.spawnEnderchibi(this));
        }
    }
}

