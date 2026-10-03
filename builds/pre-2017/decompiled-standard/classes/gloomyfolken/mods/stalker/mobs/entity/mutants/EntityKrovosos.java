/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantSkin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.MinecraftForgeClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u0012\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\u0015H\u0014J\b\u0010(\u001a\u00020\u0015H\u0016J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\fJ\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006."}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityKrovosos;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "disableChameleonTicksLeft", "", "getDisableChameleonTicksLeft", "()I", "setDisableChameleonTicksLeft", "(I)V", "prevRenderChameleon", "", "getPrevRenderChameleon", "()D", "setPrevRenderChameleon", "(D)V", "renderChameleon", "getRenderChameleon", "setRenderChameleon", "addInactiveChameleonTime", "", "ticks", "reset", "", "applyEntityAttributes", "canEnterChameleon", "getChameleon", "getEntityName", "", "", "partial", "getRenderSkin", "Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "onAttackEnd", "target", "Lnet/minecraft/entity/EntityLivingBase;", "onAttackStart", "onUpdate", "registerBehaviors", "serverUpdate", "setChameleon", "newChameleon", "shouldRenderInPass", "pass", "Companion", "minecraft"})
public final class EntityKrovosos
extends EntityMutant {
    private int disableChameleonTicksLeft;
    private double renderChameleon;
    private double prevRenderChameleon;
    private static final MutantSkin invisSkin;
    private static final MutantSkin invisSkinDistorted;
    private static final neqj attrChameleon;
    public static final Companion Companion;

    public final int getDisableChameleonTicksLeft() {
        return this.disableChameleonTicksLeft;
    }

    public final void setDisableChameleonTicksLeft(int n) {
        this.disableChameleonTicksLeft = n;
    }

    public final double getRenderChameleon() {
        return this.renderChameleon;
    }

    public final void setRenderChameleon(double d) {
        this.renderChameleon = d;
    }

    public final double getPrevRenderChameleon() {
        return this.prevRenderChameleon;
    }

    public final void setPrevRenderChameleon(double d) {
        this.prevRenderChameleon = d;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.prevRenderChameleon = this.renderChameleon;
            if (this.renderChameleon != this.getChameleon()) {
                double d = (this.getChameleon() - this.renderChameleon) * (double)0.1f;
                if (owkq._e(d) < 0.1) {
                    d *= 0.1 / owkq._e(d);
                }
                this.renderChameleon = owkq._e(this.renderChameleon - this.getChameleon()) <= 0.1 ? this.getChameleon() : (this.renderChameleon += d);
            }
        }
    }

    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT()._b(EntityKrovosos.Companion.getAttrChameleon());
    }

    public final void addInactiveChameleonTime(int n, boolean bl) {
        this.disableChameleonTicksLeft = bl ? n : (this.disableChameleonTicksLeft += n);
    }

    public static /* synthetic */ void addInactiveChameleonTime$default(EntityKrovosos entityKrovosos, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        entityKrovosos.addInactiveChameleonTime(n, bl);
    }

    public final boolean canEnterChameleon() {
        return this.func_110143_aJ() / this.func_110138_aP() > this.getProperties().getKrovosos().getChameleonHpThresold();
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        if ((double)EntityKrovosos.getRenderChameleon$default(this, 0.0f, 1, null) > 0.0) {
            return n > 0;
        }
        return n == 0;
    }

    @Override
    @NotNull
    public MutantSkin getRenderSkin() {
        if (EntityKrovosos.getRenderChameleon$default(this, 0.0f, 1, null) > 0.0f && MinecraftForgeClient.getRenderPass() > 0) {
            if (MinecraftForgeClient.getRenderPass() == 2) {
                return EntityKrovosos.Companion.getInvisSkinDistorted();
            }
            return EntityKrovosos.Companion.getInvisSkin();
        }
        return super.getSkin();
    }

    @Override
    public void onAttackStart(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "target");
        super.onAttackStart(entityLivingBase);
        this.addInactiveChameleonTime(100, true);
    }

    @Override
    public void onAttackEnd(@Nullable EntityLivingBase entityLivingBase) {
        super.onAttackEnd(entityLivingBase);
        this.addInactiveChameleonTime(10, true);
    }

    public final boolean setChameleon(double d) {
        if (owkq._e(this.getChameleon() - d) < 1.0E-4) {
            return false;
        }
        this.func_110148_a(EntityKrovosos.Companion.getAttrChameleon())._a(d);
        if (!this.field_70170_p.field_72995_K) {
            if (this.getChameleon() < 1.0) {
                this.playSpecialSound("special_invisible_off");
            } else {
                this.playSpecialSound("special_invisible_on");
            }
        }
        return true;
    }

    public final double getChameleon() {
        return this.func_110148_a(EntityKrovosos.Companion.getAttrChameleon())._e();
    }

    public final float getRenderChameleon(float f) {
        return owkq._c(f, (float)this.prevRenderChameleon, (float)this.renderChameleon);
    }

    public static /* synthetic */ float getRenderChameleon$default(EntityKrovosos entityKrovosos, float f, int n, Object object) {
        if ((n & 1) != 0) {
            f = 0.0f;
        }
        return entityKrovosos.getRenderChameleon(f);
    }

    @Override
    @NotNull
    public String func_70023_ak() {
        return "\u041a\u0440\u043e\u0432\u043e\u0441\u043e\u0441";
    }

    public EntityKrovosos(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        super(ozlu2);
        this.func_70105_a(0.8f, 1.8f);
    }

    static {
        Companion = new Companion(null);
        invisSkin = new MutantSkin("krovososinvis", 0.0f);
        invisSkinDistorted = new MutantSkin("krovososinvisdistort", 0.0f);
        attrChameleon = new bbnt("chameleon", 0.0, 0.0, 1.0)._a(true);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityKrovosos$Companion;", "", "()V", "attrChameleon", "Lnet/minecraft/entity/ai/attributes/BaseAttribute;", "kotlin.jvm.PlatformType", "getAttrChameleon", "()Lnet/minecraft/entity/ai/attributes/BaseAttribute;", "invisSkin", "Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "getInvisSkin", "()Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "invisSkinDistorted", "getInvisSkinDistorted", "minecraft"})
    public static final class Companion {
        private final MutantSkin getInvisSkin() {
            return invisSkin;
        }

        private final MutantSkin getInvisSkinDistorted() {
            return invisSkinDistorted;
        }

        private final neqj getAttrChameleon() {
            return attrChameleon;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

