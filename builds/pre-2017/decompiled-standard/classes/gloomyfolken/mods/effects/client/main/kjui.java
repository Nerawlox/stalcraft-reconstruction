/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0001H\u0016J\u0006\u0010\u0016\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000ej\b\u0012\u0004\u0012\u00020\u0007`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2={"Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "Lgloomyfolken/mods/effects/client/texture/IFrameContent;", "textures", "", "Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "([Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;)V", "<set-?>", "Lgloomyfolken/mods/effects/client/main/BackBufferSet$BufferedTexture;", "_sceneTexture", "get_sceneTexture", "()Lgloomyfolken/mods/effects/client/main/BackBufferSet$BufferedTexture;", "set_sceneTexture", "(Lgloomyfolken/mods/effects/client/main/BackBufferSet$BufferedTexture;)V", "availableTextureStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "backbuffers", "", "getTextures", "()[Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "[Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "create", "getSceneTexture", "getSize", "Ljava/awt/Dimension;", "pop", "release", "", "reset", "resize", "dimension", "BufferedTexture", "minecraft"})
public final class kjui
implements nuau {
    private final ArrayList<kjui> _a;
    private final List<kjui> _b;
    @Nullable
    private kjui _c;
    @NotNull
    private final uyuh[] _d;

    @Nullable
    public final kjui _a() {
        return this._c;
    }

    private final void _a(kjui kjui2) {
        this._c = kjui2;
    }

    @NotNull
    public final kjui _b() {
        kjui kjui2 = this._c;
        if (kjui2 == null) {
            kjui2 = this._f();
        }
        kjui2._b();
        return kjui2;
    }

    @Override
    public void _a(@NotNull Dimension dimension) {
        Intrinsics.checkParameterIsNotNull(dimension, "dimension");
        Object[] objectArray = this._d;
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            uyuh uyuh2 = (uyuh)object;
            uyuh2._a(dimension);
        }
    }

    @Override
    @NotNull
    public Dimension _c() {
        return this._d[0]._c();
    }

    @Override
    public void _d() {
        Object[] objectArray = this._d;
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            uyuh uyuh2 = (uyuh)object;
            uyuh2._d();
        }
    }

    @Override
    @NotNull
    public nuau _e() {
        Object[] objectArray = this._d;
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            uyuh uyuh2 = (uyuh)object;
            uyuh2._i();
        }
        return this;
    }

    @NotNull
    public final kjui _f() {
        if (this._a.isEmpty()) {
            throw (Throwable)new IllegalStateException("Screen buffer manager has run out of back-buffers, please provide" + " more than (" + ((Object[])this._d).length + ") off-screen buffers, or check if you forgot to free a texture buffer after usage.");
        }
        kjui kjui2 = this._a.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "availableTextureStack.removeAt(0)");
        return kjui2;
    }

    public final void _g() {
        this._a.clear();
        this._a.addAll((Collection<kjui>)this._b);
        this._c = null;
    }

    @NotNull
    public final uyuh[] _h() {
        return this._d;
    }

    public kjui(uyuh ... uyuhArray) {
        Collection<kjui> collection;
        Intrinsics.checkParameterIsNotNull(uyuhArray, "textures");
        this._d = uyuhArray;
        this._a = new ArrayList();
        Object[] objectArray = this._d;
        kjui kjui2 = this;
        Object[] objectArray2 = objectArray;
        Collection collection2 = new ArrayList(objectArray.length);
        for (int i = 0; i < objectArray2.length; ++i) {
            Object object = objectArray2[i];
            uyuh uyuh2 = (uyuh)object;
            collection = collection2;
            kjui kjui3 = new kjui(this, uyuh2);
            collection.add(kjui3);
        }
        collection = (List)collection2;
        kjui2._b = collection;
        this._g();
    }

    @Nullable
    public static final /* synthetic */ kjui _b(kjui kjui2) {
        return kjui2._c;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/effects/client/main/BackBufferSet$BufferedTexture;", "", "set", "Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "texture", "Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "(Lgloomyfolken/mods/effects/client/main/BackBufferSet;Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;)V", "getTexture", "()Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "free", "", "setAsScene", "returnPreviousToStack", "", "minecraft"})
    public static final class kjui {
        private final kjui _a;
        @NotNull
        private final uyuh _b;

        public final void _a() {
            if (!this._a._a.contains(this)) {
                this._a._a.add(this);
            }
        }

        public final void _b() {
            this._a(true);
        }

        public final void _a(boolean bl) {
            if (bl) {
                kjui kjui2 = this._a._a();
                if (kjui2 != null) {
                    kjui2._a();
                }
            }
            this._a._c = this;
            this._a._a.remove(this);
        }

        public static /* bridge */ /* synthetic */ void _a(kjui kjui2, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = true;
            }
            kjui2._a(bl);
        }

        @NotNull
        public final uyuh _c() {
            return this._b;
        }

        public kjui(@NotNull kjui kjui2, @NotNull uyuh uyuh2) {
            Intrinsics.checkParameterIsNotNull(kjui2, "set");
            Intrinsics.checkParameterIsNotNull(uyuh2, "texture");
            this._a = kjui2;
            this._b = uyuh2;
        }
    }
}

