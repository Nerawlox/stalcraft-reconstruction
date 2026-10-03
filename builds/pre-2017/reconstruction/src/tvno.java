/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Dimension;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH&\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;", "Lgloomyfolken/mods/effects/client/texture/IFrameContent;", "bindAsAttachment", "", "colorIndex", "", "bindAsTexture", "unit", "create", "getAntialiasingMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "getAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "getSize", "Ljava/awt/Dimension;", "release", "resize", "dimension", "setAntialiasing", "mode", "Companion", "minecraft"})
public interface tvno
extends nuau {
    public static final kjui _a = new kjui(null);

    @NotNull
    public fmfc _a();

    @Override
    public void _a(@NotNull Dimension var1);

    @Override
    @NotNull
    public Dimension _c();

    public void _a(@NotNull jhpr var1);

    @NotNull
    public jhpr _b();

    @Override
    public void _d();

    @NotNull
    public tvno _f();

    public void _a(int var1);

    public void _b(int var1);

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
    public static final class pidb {
        public static void _a(tvno tvno2) {
            kjui kjui2 = _a;
            int n = kjui2._b();
            kjui2._b(n + 1);
        }

        @NotNull
        public static tvno _b(tvno tvno2) {
            kjui kjui2 = _a;
            int n = kjui2._a();
            kjui2._a(n + 1);
            return tvno2;
        }

        public static /* synthetic */ void _a(tvno tvno2, int n, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAsAttachment");
            }
            if ((n2 & 1) != 0) {
                n = 0;
            }
            tvno2._a(n);
        }

        public static /* synthetic */ void _b(tvno tvno2, int n, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAsTexture");
            }
            if ((n2 & 1) != 0) {
                n = 0;
            }
            tvno2._b(n);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0014"}, d2={"Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment$Companion;", "", "()V", "attachmentBindTargetsCore", "", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "", "", "getAttachmentBindTargetsCore", "()Ljava/util/Map;", "attachmentBindTargetsEXT", "getAttachmentBindTargetsEXT", "createCount", "getCreateCount", "()I", "setCreateCount", "(I)V", "releaseCount", "getReleaseCount", "setReleaseCount", "minecraft"})
    public static final class kjui {
        private static int _a;
        private static int _b;
        @NotNull
        private static final Map<fmfc, Integer[]> _c;
        @NotNull
        private static final Map<fmfc, Integer[]> _d;

        public final int _a() {
            return _a;
        }

        public final void _a(int n) {
            _a = n;
        }

        public final int _b() {
            return _b;
        }

        public final void _b(int n) {
            _b = n;
        }

        @NotNull
        public final Map<fmfc, Integer[]> _c() {
            return _c;
        }

        @NotNull
        public final Map<fmfc, Integer[]> _d() {
            return _d;
        }

        private kjui() {
            Pair[] pairArray;
            Object[] objectArray = new Integer[]{36064};
            fmfc fmfc2 = fmfc._a;
            int n = 0;
            Pair[] pairArray2 = pairArray = new Pair[3];
            Object[] objectArray2 = objectArray;
            pairArray[n] = TuplesKt.to(fmfc2, objectArray2);
            objectArray = new Integer[]{36096};
            fmfc2 = fmfc._b;
            n = 1;
            pairArray = pairArray2;
            objectArray2 = objectArray;
            pairArray[n] = TuplesKt.to(fmfc2, objectArray2);
            objectArray = new Integer[]{33306};
            fmfc2 = fmfc._c;
            n = 2;
            pairArray = pairArray2;
            objectArray2 = objectArray;
            pairArray[n] = TuplesKt.to(fmfc2, objectArray2);
            _c = MapsKt.mapOf(pairArray2);
            objectArray = new Integer[]{36064};
            fmfc2 = fmfc._a;
            n = 0;
            pairArray2 = pairArray = new Pair[3];
            objectArray2 = objectArray;
            pairArray[n] = TuplesKt.to(fmfc2, objectArray2);
            objectArray = new Integer[]{36096};
            fmfc2 = fmfc._b;
            n = 1;
            pairArray = pairArray2;
            objectArray2 = objectArray;
            pairArray[n] = TuplesKt.to(fmfc2, objectArray2);
            objectArray = new Integer[]{36096, 36128};
            fmfc2 = fmfc._c;
            n = 2;
            pairArray = pairArray2;
            objectArray2 = objectArray;
            pairArray[n] = TuplesKt.to(fmfc2, objectArray2);
            _d = MapsKt.mapOf(pairArray2);
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

