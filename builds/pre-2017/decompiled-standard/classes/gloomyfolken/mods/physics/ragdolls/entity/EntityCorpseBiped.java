/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import gloomyfolken.mods.stalker.player.tupg;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\b\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010(\u001a\u00020,H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006-"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBiped;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "armorStack", "Lnet/minecraft/item/ItemStack;", "getArmorStack", "()Lnet/minecraft/item/ItemStack;", "setArmorStack", "(Lnet/minecraft/item/ItemStack;)V", "bagSkinId", "", "getBagSkinId", "()I", "setBagSkinId", "(I)V", "skinName", "", "getSkinName", "()Ljava/lang/String;", "setSkinName", "(Ljava/lang/String;)V", "createAnimationContext", "Lgloomyfolken/mods/effects/common/mcsa/animation/IAnimation;", "getLeftoverRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "render", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "entity", "Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "getSkin", "Lnet/minecraft/util/ResourceLocation;", "killOwner", "", "onUpdate", "readEntityFromNBT", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "readSpawnDataInternal", "data", "Lcom/google/common/io/ByteArrayDataInput;", "writeEntityToNBT", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "minecraft"})
public abstract class EntityCorpseBiped
extends EntityRagdollCorpse {
    @Nullable
    private cvzo armorStack;
    private int bagSkinId;
    @NotNull
    private String skinName;

    @Nullable
    public final cvzo getArmorStack() {
        return this.armorStack;
    }

    public final void setArmorStack(@Nullable cvzo cvzo2) {
        this.armorStack = cvzo2;
    }

    public final int getBagSkinId() {
        return this.bagSkinId;
    }

    public final void setBagSkinId(int n) {
        this.bagSkinId = n;
    }

    @NotNull
    protected final String getSkinName() {
        return this.skinName;
    }

    protected final void setSkinName(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.skinName = string;
    }

    @Override
    public void killOwner() {
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K || this.field_70128_L) {
            // empty if block
        }
    }

    @Override
    public void func_70014_b(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.func_70014_b(qoac2);
        qoac2._a("skinName", this.skinName);
    }

    @Override
    public void func_70037_a(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.func_70037_a(qoac2);
        String string = qoac2._j("skinName");
        Intrinsics.checkExpressionValueIsNotNull(string, "tag.getString(\"skinName\")");
        this.skinName = string;
    }

    @Override
    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
        super.writeSpawnData(byteArrayDataOutput);
        byteArrayDataOutput.writeByte(this.bagSkinId);
        byteArrayDataOutput.writeUTF(this.skinName);
        cezg.func_73270_a(this.armorStack, byteArrayDataOutput);
    }

    @Override
    public void readSpawnDataInternal(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        super.readSpawnDataInternal(byteArrayDataInput);
        this.bagSkinId = byteArrayDataInput.readByte();
        String string = byteArrayDataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(string, "data.readUTF()");
        this.skinName = string;
        this.armorStack = cezg.func_73276_c(byteArrayDataInput);
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public final ResourceLocation getSkin() {
        CharSequence charSequence = this.skinName;
        if (charSequence.length() == 0) {
            ResourceLocation resourceLocation = AbstractClientPlayer.field_110314_b;
            Intrinsics.checkExpressionValueIsNotNull(resourceLocation, "AbstractClientPlayer.locationStevePng");
            return resourceLocation;
        }
        return new ResourceLocation(this.skinName);
    }

    @Override
    @NotNull
    public nuct createAnimationContext() {
        return new zxbe((jhuw)tupg._b, new iest[0]);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @NotNull
    public kjui getLeftoverRenderer(@NotNull RenderCorpseLeftovers renderCorpseLeftovers, @NotNull ILeftoversRenderInfo iLeftoversRenderInfo) {
        Intrinsics.checkParameterIsNotNull(renderCorpseLeftovers, "render");
        Intrinsics.checkParameterIsNotNull(iLeftoversRenderInfo, "entity");
        kjui kjui2 = renderCorpseLeftovers.getBipedLeftoversRenderer()._a("corpse_bag_" + this.bagSkinId % 9);
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "render.bipedLeftoversRen\u2026se_bag_${bagSkinId % 9}\")");
        return kjui2;
    }

    public EntityCorpseBiped(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        super(ozlu2);
        this.bagSkinId = ThreadLocalRandom.current().nextInt() % 9;
        this.skinName = "";
    }
}

