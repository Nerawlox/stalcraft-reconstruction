/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/ICorpseAnimationState;", "", "getRotation", "Lorg/lwjgl/util/vector/Quaternion;", "index", "", "getTranslation", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "interpolate", "", "partialTickTime", "", "minecraft"})
public interface ICorpseAnimationState {
    @NotNull
    public Vector3f getTranslation(int var1);

    @NotNull
    public Quaternion getRotation(int var1);

    public void interpolate(float var1);

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
    public static final class DefaultImpls {
        public static void interpolate(ICorpseAnimationState iCorpseAnimationState, float f) {
        }
    }
}

