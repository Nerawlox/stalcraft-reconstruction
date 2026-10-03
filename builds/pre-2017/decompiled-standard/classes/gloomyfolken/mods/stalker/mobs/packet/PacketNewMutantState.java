/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MoveTurnDirection;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationType;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;

public class PacketNewMutantState
extends zwat {
    public int mobId;
    public LogicState logicState;
    public MoveTurnDirection turnDirection;
    public qoac stateNbt;
    public AnimationType animationType;

    public PacketNewMutantState(EntityMutant entityMutant) {
        this.mobId = 0;
        this.logicState = LogicState.STAND;
        this.turnDirection = MoveTurnDirection.NONE;
        this.stateNbt = new qoac();
        this.animationType = null;
        this.logicState = entityMutant.getLogicState();
        this.turnDirection = entityMutant.getTurnDirection();
        this.mobId = entityMutant.field_70157_k;
        this.animationType = entityMutant.getState().getAnimationType();
        entityMutant.getState().writeNbt(this.stateNbt);
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity = xpzm._E()._r.func_73045_a(this.mobId);
        if (entity instanceof EntityMutant) {
            EntityMutant entityMutant = (EntityMutant)entity;
            entityMutant.setLogicState(this.logicState);
            entityMutant.setTurnDirection(this.turnDirection);
            AnimationState animationState = this.animationType.createState(entityMutant);
            animationState.readNbt(this.stateNbt);
            animationState.execute();
            entityMutant.setStateClient(animationState);
        }
    }

    public PacketNewMutantState() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.mobId = dataInput.readInt();
        this.logicState = LogicState.values()[dataInput.readInt()];
        this.turnDirection = MoveTurnDirection.values()[dataInput.readInt()];
        this.stateNbt = qlgf.readNBTTagCompound(dataInput);
        this.animationType = AnimationType.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.mobId);
        dataOutput.writeInt(this.logicState.ordinal());
        dataOutput.writeInt(this.turnDirection.ordinal());
        qlgf.writeNBTTagCompound(this.stateNbt, dataOutput);
        dataOutput.writeInt(this.animationType.ordinal());
    }
}

