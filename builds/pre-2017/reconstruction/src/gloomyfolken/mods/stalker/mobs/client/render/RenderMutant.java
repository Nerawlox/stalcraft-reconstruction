/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render;

import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.mobs.client.StalkerMobsClient;
import gloomyfolken.mods.stalker.mobs.client.render.DebugDrawInfo;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.stalker.mobs.player.PlayerSoundSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 +*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0005J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J<\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\tH\u0014J5\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0004\u00a2\u0006\u0002\u0010 J;\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0002\u0010#J-\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0014\u00a2\u0006\u0002\u0010)J-\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0014\u00a2\u0006\u0002\u0010)\u00a8\u0006,"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/RenderMutant;", "T", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lnet/minecraft/client/renderer/entity/Render;", "Lgloomyfolken/mods/core/client/render/IDelayedEntityRenderer;", "()V", "doRender", "", "entity", "Lnet/minecraft/entity/Entity;", "translateX", "", "translateY", "translateZ", "f", "", "frame", "drawCone", "startAngle", "endAngle", "length", "height", "inColor", "", "outColor", "getEntityTexture", "Lnet/minecraft/util/ResourceLocation;", "renderDebugInfo", "mutant", "x", "y", "z", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;DDDF)V", "renderMob", "mob", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;DDDFF)V", "renderMutant", "mcsaRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "pass", "", "(Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;FI)V", "renderMutantPost", "Companion", "minecraft"})
public class RenderMutant<T extends EntityMutant>
extends Render
implements uyjm {
    @NotNull
    private static final HashMap<Class<? extends Entity>, kjui> mobToRendererMap;
    @NotNull
    private static final HashMap<String, iefv> cachedRenderers;
    public static final Companion Companion;

    protected void renderMutant(@NotNull kjui kjui2, @NotNull T t, float f, int n) {
        Intrinsics.checkParameterIsNotNull(kjui2, "mcsaRenderer");
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        kjui2._c.renderAll(((EntityMutant)t).getAnimationHandler().ctx);
    }

    protected void renderMutantPost(@NotNull kjui kjui2, @NotNull T t, float f, int n) {
        Intrinsics.checkParameterIsNotNull(kjui2, "mcsaRenderer");
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        MinecraftForge.EVENT_BUS.post(wnts._b((EntityLivingBase)t, f));
    }

    public final void renderMob(@NotNull T t, double d, double d2, double d3, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(t, "mob");
        String string = MutantRegistry.INSTANCE.getRegisteredMobsInv().get(t.getClass());
        if (string == null) {
            Intrinsics.throwNpe();
        }
        String string2 = string;
        Class<?> clazz = t.getClass();
        String string3 = string2;
        Intrinsics.checkExpressionValueIsNotNull(string3, "renderid");
        kjui kjui2 = Companion.getCachedRenderer(clazz, string3, ((EntityMutant)t).getRenderSkin().getSkinName());
        if (kjui2 == null) {
            return;
        }
        kjui kjui3 = kjui2;
        if (((Entity)t).isDead) {
            return;
        }
        ezfc._a();
        if (kjui3._i() && ((EntityMutant)t).getAnimationHandler().ctx._u_() != null) {
            float f3 = owxf._a(((EntityLivingBase)t).prevRenderYawOffset, ((EntityLivingBase)t).renderYawOffset, f2);
            float f4 = owxf._a(((Entity)t).prevRotationPitch, ((Entity)t).rotationPitch, f2);
            ezfc._a((float)d, (float)d2, (float)d3);
            ezfc._a(-f3, 0.0f, 1.0f, 0.0f);
            ezfc._b(((EntityMutant)t).getScale(), ((EntityMutant)t).getScale(), ((EntityMutant)t).getScale());
            int n = MinecraftForgeClient.getRenderPass();
            this.renderMutant(kjui3, t, f2, n);
            this.renderMutantPost(kjui3, t, f2, n);
            if (n == 0) {
                this.renderDebugInfo(t, d, d2, d3, f2);
            }
        }
        ezfc._b();
    }

    private final void drawCone(double d, double d2, double d3, double d4, float[] fArray, float[] fArray2) {
        int n = 16;
        GL11.glBegin(4);
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            while (true) {
                double d5 = d2 + (d - d2) * (double)(owkq._n(n2) / owkq._n(n));
                double d6 = d2 + (d - d2) * (double)((owkq._n(n2) + 1.0f) / owkq._n(n));
                GL11.glColor4f(fArray[0], fArray[1], fArray[2], fArray[3]);
                GL11.glVertex3d(0.0, d4, 0.0);
                GL11.glColor4f(fArray2[0], fArray2[1], fArray2[2], fArray2[3]);
                GL11.glVertex3d(d3 * McExtensionsKt.cos(d5), d4, d3 * McExtensionsKt.sin(d5));
                GL11.glVertex3d(d3 * McExtensionsKt.cos(d6), d4, d3 * McExtensionsKt.sin(d6));
                if (n2 == n3) break;
                ++n2;
            }
        }
        GL11.glEnd();
        GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
    }

    static /* synthetic */ void drawCone$default(RenderMutant renderMutant, double d, double d2, double d3, double d4, float[] fArray, float[] fArray2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCone");
        }
        if ((n & 0x10) != 0) {
            fArray = new float[]{1.0f, 0.0f, 0.0f, 0.5f};
        }
        if ((n & 0x20) != 0) {
            fArray2 = fArray;
        }
        renderMutant.drawCone(d, d2, d3, d4, fArray, fArray2);
    }

    protected final void renderDebugInfo(@NotNull T t, double d, double d2, double d3, float f) {
        float f2;
        DebugDrawInfo debugDrawInfo;
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glTranslated(d, d2, d3);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 0.0f, 0.5f);
        DebugDrawInfo debugDrawInfo2 = debugDrawInfo = StalkerMobsClient.Companion.getInstance().getDebugInfo();
        double d4 = owkq._r(owkq._a());
        double d5 = -owkq._r(owkq._a());
        if (debugDrawInfo2.getDrawAttackAabb()) {
            GL11.glTranslated(-VecExtensionsKt.getX(McExtensionsKt.getPos((Entity)t)), -VecExtensionsKt.getY(McExtensionsKt.getPos((Entity)t)), -VecExtensionsKt.getZ(McExtensionsKt.getPos((Entity)t)));
            Render.renderAABB(((EntityMutant)t).getAttackAabb());
            GL11.glTranslated(VecExtensionsKt.getX(McExtensionsKt.getPos((Entity)t)), VecExtensionsKt.getY(McExtensionsKt.getPos((Entity)t)), VecExtensionsKt.getZ(McExtensionsKt.getPos((Entity)t)));
        }
        if (debugDrawInfo2.getDrawSightCone()) {
            f2 = ((EntityMutant)t).getProperties().getAi().getEyeRange();
            double d6 = ((EntityMutant)t).getProperties().getAi().getEyeFov() / (double)2;
            double d7 = Math.toRadians((double)((Entity)t).rotationYaw + d6 + (double)90.0f);
            double d8 = Math.toRadians((double)((Entity)t).rotationYaw - d6 + (double)90.0f);
            RenderMutant.drawCone$default(this, d8, d7, owkq._r(f2), 0.005, new float[]{1.0f, 0.0f, 0.0f, 0.5f}, null, 32, null);
            EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
            if (entityClientPlayerMP == null) {
                Intrinsics.throwNpe();
            }
            EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
            Vec3 vec3 = VecExtensionsKt.minus(McExtensionsKt.getPos(entityClientPlayerMP2), McExtensionsKt.getPos((Entity)t));
            double d9 = Math.toRadians((double)((Entity)t).rotationYaw + 90.0);
            double d10 = d9 - 0.015;
            double d11 = d9 + 0.015;
            RenderMutant.drawCone$default(this, d10, d11, owkq._r(f2), 0.006, new float[]{1.0f, 1.0f, 0.0f, 0.5f}, null, 32, null);
        }
        if (debugDrawInfo2.getDrawHearRun()) {
            f2 = (PlayerSoundSource.NOISE_AMOUNT_RUN - ((EntityMutant)t).getProperties().getAi().getSoundAmountThresold()) / ((EntityMutant)t).getProperties().getAi().getSoundLossPerBlock();
            this.drawCone(d5, d4, owkq._r(f2), 0.002, new float[]{0.0f, 0.5f, 0.5f, 0.5f}, new float[]{0.0f, 1.0f, 0.0f, 0.15f});
        }
        if (debugDrawInfo2.getDrawHearWalk()) {
            f2 = (PlayerSoundSource.NOISE_AMOUNT_WALK - ((EntityMutant)t).getProperties().getAi().getSoundAmountThresold()) / ((EntityMutant)t).getProperties().getAi().getSoundLossPerBlock();
            this.drawCone(d5, d4, owkq._r(f2), 0.0021, new float[]{0.0f, 0.75f, 0.75f, 0.5f}, new float[]{0.0f, 1.0f, 0.0f, 0.15f});
        }
        if (debugDrawInfo2.getDrawHearLie()) {
            f2 = (PlayerSoundSource.NOISE_AMOUNT_LIE - ((EntityMutant)t).getProperties().getAi().getSoundAmountThresold()) / ((EntityMutant)t).getProperties().getAi().getSoundLossPerBlock();
            this.drawCone(d5, d4, owkq._r(f2), 0.0022, new float[]{0.0f, 1.0f, 1.0f, 0.5f}, new float[]{0.0f, 1.0f, 0.0f, 0.15f});
        }
        if (debugDrawInfo2.getDrawAttackCone()) {
            double d12 = ((EntityMutant)t).getProperties().getAttack().getAttackAabbWidth() + (double)(((Entity)t).width / (float)2) + ((EntityMutant)t).getProperties().getAttack().getAttackDist();
            RenderMutant.drawCone$default(this, d5, d4, d12, 0.007, new float[]{0.0f, 0.0f, 1.0f, 0.5f}, null, 32, null);
        }
        if (debugDrawInfo2.getDrawCrit()) {
            RenderMutant.drawCone$default(this, d5, d4, ((EntityMutant)t).getProperties().getAi().getShortReach(), 0.008, new float[]{1.0f, 0.0f, 1.0f, 0.5f}, null, 32, null);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glShadeModel(7424);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(@NotNull Entity entity, double d, double d2, double d3, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Entity entity2 = entity;
        if (!(entity2 instanceof EntityMutant)) {
            entity2 = null;
        }
        EntityMutant entityMutant = (EntityMutant)entity2;
        if (entityMutant == null) {
            throw (Throwable)new IllegalArgumentException("Passed illegal entity type '" + entity + "' to" + " RenderMutant#doRender! The entity must be an instance of EntityMutant, while it's not.");
        }
        this.renderMob(entityMutant, d, d2, d3, f, f2);
    }

    @Override
    @Nullable
    protected ResourceLocation getEntityTexture(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return null;
    }

    static {
        Companion = new Companion(null);
        mobToRendererMap = new HashMap();
        cachedRenderers = new HashMap();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u000b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u000bR-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR=\u0010\n\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\u0004j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/RenderMutant$Companion;", "", "()V", "cachedRenderers", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/core/client/render/RenderCustomMaterial;", "Lkotlin/collections/HashMap;", "getCachedRenderers", "()Ljava/util/HashMap;", "mobToRendererMap", "Ljava/lang/Class;", "Lnet/minecraft/entity/Entity;", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "getMobToRendererMap", "getCachedRenderer", "mobClass", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "renderid", "skinName", "getGenericRenderer", "minecraft"})
    public static final class Companion {
        @NotNull
        public final HashMap<Class<? extends Entity>, kjui> getMobToRendererMap() {
            return mobToRendererMap;
        }

        @NotNull
        public final HashMap<String, iefv> getCachedRenderers() {
            return cachedRenderers;
        }

        @Nullable
        public final kjui getGenericRenderer(@NotNull Class<? extends EntityMutant> clazz) {
            Intrinsics.checkParameterIsNotNull(clazz, "mobClass");
            kjui kjui2 = this.getMobToRendererMap().get(clazz);
            if (kjui2 == null) {
                Intrinsics.throwNpe();
            }
            return kjui2;
        }

        @Nullable
        public final kjui getCachedRenderer(@NotNull Class<? extends EntityMutant> clazz, @NotNull String string, @NotNull String string2) {
            Intrinsics.checkParameterIsNotNull(clazz, "mobClass");
            Intrinsics.checkParameterIsNotNull(string, "renderid");
            Intrinsics.checkParameterIsNotNull(string2, "skinName");
            iefv iefv2 = this.getCachedRenderers().get(string);
            kjui kjui2 = this.getMobToRendererMap().get(clazz);
            if (kjui2 == null) {
                Intrinsics.throwNpe();
            }
            kjui kjui3 = kjui2;
            jxtc jxtc2 = kjui3._a();
            if (iefv2 == null && jxtc2 != null) {
                iefv2 = new iefv(jxtc2.location, null);
                Map map = this.getCachedRenderers();
                iefv iefv3 = iefv2;
                map.put(string, iefv3);
            }
            iefv iefv4 = iefv2;
            return iefv4 != null ? iefv4._a(owkq._a(string2)) : null;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

