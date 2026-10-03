/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.player.zwat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.ModelRenderer;
import org.jetbrains.annotations.NotNull;

@ezey(_a={eidj.CLIENT})
@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/stalker/player/VanillaMeshRotation;", "Lgloomyfolken/mods/stalker/player/IMeshRotation;", "renderer", "Lnet/minecraft/client/model/ModelRenderer;", "(Lnet/minecraft/client/model/ModelRenderer;)V", "getRenderer", "()Lnet/minecraft/client/model/ModelRenderer;", "rotateAngleX", "", "rotateAngleY", "rotateAngleZ", "rotationPointX", "rotationPointY", "rotationPointZ", "minecraft"})
public final class jxsn
implements zwat {
    @NotNull
    private final ModelRenderer _a;

    @Override
    public float rotationPointX() {
        return this._a.field_78800_c;
    }

    @Override
    public float rotationPointY() {
        return this._a.field_78797_d;
    }

    @Override
    public float rotationPointZ() {
        return this._a.field_78798_e;
    }

    @Override
    public float rotateAngleX() {
        return this._a.field_78795_f;
    }

    @Override
    public float rotateAngleY() {
        return this._a.field_78796_g;
    }

    @Override
    public float rotateAngleZ() {
        return this._a.field_78808_h;
    }

    @NotNull
    public final ModelRenderer _a() {
        return this._a;
    }

    public jxsn(@NotNull ModelRenderer modelRenderer) {
        Intrinsics.checkParameterIsNotNull(modelRenderer, "renderer");
        this._a = modelRenderer;
    }
}

