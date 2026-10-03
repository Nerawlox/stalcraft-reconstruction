/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.physics.core.client.PhysicsEntityContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH'J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\tH'J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH'J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u001bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/physics/core/EntityPhysicsState;", "Lnet/minecraftforge/common/IExtendedEntityProperties;", "()V", "_entity", "Lnet/minecraft/entity/Entity;", "entity", "getEntity", "()Lnet/minecraft/entity/Entity;", "getClientPhysicsContext", "Lgloomyfolken/mods/physics/core/client/PhysicsEntityContext;", "getOwnerEntity", "init", "", "world", "Lnet/minecraft/world/World;", "initClientPhysicsContext", "loadNBTData", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "onEntityJoinedWorld", "readSpawnData", "data", "Lcom/google/common/io/ByteArrayDataInput;", "saveNBTData", "setClientPhysicsContext", "ctx", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "Companion", "minecraft"})
public abstract class EntityPhysicsState
implements IExtendedEntityProperties {
    private Entity _entity;
    @NotNull
    private static final String ATTRIB = "ephysst_attrib";
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final Entity getEntity() {
        Entity entity = this._entity;
        if (entity == null) {
            throw (Throwable)new IllegalStateException("Accessed entity before EntityPhysicsState#init called");
        }
        return entity;
    }

    @Override
    public void init(@NotNull Entity entity, @NotNull World world) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(world, "world");
        this._entity = entity;
    }

    @NotNull
    public Entity getOwnerEntity() {
        return this.getEntity();
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public abstract PhysicsEntityContext initClientPhysicsContext();

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public abstract PhysicsEntityContext getClientPhysicsContext();

    @ezey(_a={eidj.CLIENT})
    public abstract void setClientPhysicsContext(@Nullable PhysicsEntityContext var1);

    public void onEntityJoinedWorld(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
    }

    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
    }

    public void readSpawnData(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
    }

    @Override
    public void saveNBTData(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "compound");
    }

    @Override
    public void loadNBTData(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "compound");
    }

    static {
        ATTRIB = ATTRIB;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/physics/core/EntityPhysicsState$Companion;", "", "()V", "ATTRIB", "", "getATTRIB", "()Ljava/lang/String;", "minecraft"})
    public static final class Companion {
        @NotNull
        public final String getATTRIB() {
            return ATTRIB;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

