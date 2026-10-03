/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import kotlin.Metadata;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/hud/ThrowHudRenderer;", "", "()V", "shader", "Lgloomyfolken/mods/effects/client/main/Shader;", "renderHud", "", "partialTicks", "", "minecraft"})
public final class tupg {
    private static final jxtc _b;
    public static final tupg _a;

    public final void _a(float f) {
        xpzm xpzm2 = xpzm._E();
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        if (entityClientPlayerMP == null) {
            return;
        }
        EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
        IExtendedEntityProperties iExtendedEntityProperties = entityClientPlayerMP2.getExtendedProperties(gloomyfolken.mods.core.entity.jxtc._a._b());
        if (!(iExtendedEntityProperties instanceof gloomyfolken.mods.core.entity.jxtc)) {
            iExtendedEntityProperties = null;
        }
        gloomyfolken.mods.core.entity.jxtc jxtc2 = (gloomyfolken.mods.core.entity.jxtc)iExtendedEntityProperties;
        if (jxtc2 == null) {
            return;
        }
        gloomyfolken.mods.core.entity.jxtc jxtc3 = jxtc2;
        float f2 = owkq._b(jxtc3._b(f), 0.0f, 1.0f) + owkq._b(jxtc3._c(f), 0.0f, 1.0f);
        if (f2 > 0.0f) {
            _b._e();
            _b._a("progress", f2);
            int n = 200;
            int n2 = 200;
            hsmn._e();
            int n3 = xpzm2._n / 2 - n / 2;
            int n4 = xpzm2._o / 2 - n2 / 2;
            McExtensionsKt.drawScaledQuad$default(n3, n4, n, n2, 0.0f, 16, null);
            hsmn._f();
        }
        GL20.glUseProgram(0);
    }

    private tupg() {
        _a = this;
        _b = new jxtc("stalker", "throw");
    }

    static {
        new tupg();
    }
}

