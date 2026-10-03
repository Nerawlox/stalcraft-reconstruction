/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.McExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectSystem;", "Lgloomyfolken/mods/effects/client/particle/ParticleEmitter;", "artefactItem", "Lnet/minecraft/entity/item/EntityItem;", "preset", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectPreset;", "(Lnet/minecraft/entity/item/EntityItem;Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectPreset;)V", "getArtefactItem", "()Lnet/minecraft/entity/item/EntityItem;", "editorTime", "", "getEditorTime", "()I", "setEditorTime", "(I)V", "particleEmitters", "", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ParticleEmitterArtefakt;", "getParticleEmitters", "()Ljava/util/List;", "getPreset", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectPreset;", "ignoreFrustrumTickCheck", "", "isValid", "tick", "", "updatePosToEntity", "minecraft"})
public final class oxkw
extends iekw {
    private int _a;
    @NotNull
    private final List<cuib> _b;
    @NotNull
    private final EntityItem _c;
    @NotNull
    private final zgiu _d;

    public final int _a() {
        return this._a;
    }

    public final void _a(int n) {
        this._a = n;
    }

    @NotNull
    public final List<cuib> _b() {
        return this._b;
    }

    private final void _e() {
        ofbx ofbx2 = McExtensionsKt.getPos(this._c);
        this.setCenter(ofbx2._c, ofbx2._d, ofbx2._e);
        this.setSize(10.0, 10.0, 10.0);
    }

    @Override
    public void tick() {
        super.tick();
        this._e();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean isValid() {
        boolean bl;
        if (this._a > 0) return true;
        if (!this._c.func_70089_S()) return false;
        Iterable iterable = this._b;
        Iterator iterator2 = iterable.iterator();
        do {
            if (!iterator2.hasNext()) return false;
            Object t = iterator2.next();
            cuib cuib2 = (cuib)t;
            if (cuib2._a()) return true;
            Collection collection = cuib2.particles;
            if (!collection.isEmpty()) {
                return true;
            }
            boolean bl2 = false;
            if (bl2) {
                return true;
            }
            bl = false;
        } while (!bl);
        return true;
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return true;
    }

    @NotNull
    public final EntityItem _c() {
        return this._c;
    }

    @NotNull
    public final zgiu _d() {
        return this._d;
    }

    public oxkw(@NotNull EntityItem entityItem, @NotNull zgiu zgiu2) {
        Collection<cuib> collection;
        Intrinsics.checkParameterIsNotNull(entityItem, "artefactItem");
        Intrinsics.checkParameterIsNotNull(zgiu2, "preset");
        super(entityItem.field_70170_p, null);
        this._c = entityItem;
        this._d = zgiu2;
        this._e();
        Iterable iterable = this._d._a();
        oxkw oxkw2 = this;
        Iterable iterable2 = iterable;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            ogjh ogjh2 = (ogjh)t;
            collection = collection2;
            cuib cuib2 = new cuib(this, ogjh2);
            collection.add(cuib2);
        }
        collection = (List)collection2;
        oxkw2._b = collection;
    }
}

