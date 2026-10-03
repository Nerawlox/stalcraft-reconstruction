/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.awt.Point;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0016\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J0\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J\"\u0010\u0014\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/core/misc/EarTriangulation;", "", "()V", "exteriorProduct", "", "p0", "Ljava/awt/Point;", "p1", "isClockwise", "", "a", "b", "c", "points", "", "isEmptyTriangle", "list", "Lgloomyfolken/mods/core/misc/EarTriangulation$Link;", "clockwise", "polygonArea", "polygonToTriangles", "", "triangles", "", "Lgloomyfolken/mods/core/spawn/RegionTriangle;", "Link", "minecraft"})
public final class tupg {
    public static final tupg _a;

    private final double _a(List<? extends Point> list2) {
        double d = 0.0;
        int n = ((Collection)list2).size();
        for (int i = 0; i < n; ++i) {
            d += this._a(list2.get(i), list2.get((i + 1) % list2.size()));
        }
        return d * 0.5;
    }

    private final double _a(Point point, Point point2) {
        return point.x * point2.y - point2.x * point.y;
    }

    private final boolean _a(Point point, Point point2, Point point3, kjui kjui2, boolean bl) {
        kjui kjui3 = kjui2;
        do {
            Point point4;
            if (Intrinsics.areEqual(point4 = kjui3._i(), point) ^ true && Intrinsics.areEqual(point4, point2) ^ true && Intrinsics.areEqual(point4, point3) ^ true && this._a(point2, point, point4) != bl && this._a(point, point3, point4) != bl && this._a(point3, point2, point4) != bl) {
                return false;
            }
            if (kjui3._b() != null) continue;
            Intrinsics.throwNpe();
        } while (kjui3 != kjui2);
        return true;
    }

    private final boolean _a(Point point, Point point2, Point point3) {
        return 0 <= (point2.x - point.x) * (point3.y - point.y) - (point3.x - point.x) * (point2.y - point.y);
    }

    private final boolean _b(List<? extends Point> list2) {
        return 0.0 <= this._a(list2);
    }

    public final void _a(@NotNull List<? extends Point> list2, @NotNull List<kksf> list3) {
        kjui kjui2;
        Intrinsics.checkParameterIsNotNull(list2, "points");
        Intrinsics.checkParameterIsNotNull(list3, "triangles");
        boolean bl = this._b(list2);
        TreeSet<kjui> treeSet = new TreeSet<kjui>();
        kjui kjui3 = new kjui();
        Object object = this;
        tupg tupg2 = object;
        kjui kjui4 = kjui3;
        int n = ((Collection)list2).size();
        for (int i = 0; i < n; ++i) {
            int n2 = (i == 0 ? list2.size() : i) - 1;
            int n3 = (i + 1) % list2.size();
            kjui2 = new kjui();
            kjui4._b(kjui2);
            kjui2._a(kjui4);
            kjui2._h().setLocation(list2.get(n2));
            kjui2._i().setLocation(list2.get(i));
            kjui2._j().setLocation(list2.get(n3));
            if (kjui2._d() == bl) {
                treeSet.add(kjui2);
            }
            kjui4 = kjui2;
        }
        kjui4._b(kjui3._b());
        kjui kjui5 = kjui4._b();
        if (kjui5 == null) {
            Intrinsics.throwNpe();
        }
        kjui3 = kjui5;
        kjui3._a(kjui4);
        block1: while (!treeSet.isEmpty()) {
            object = treeSet.iterator();
            boolean bl2 = false;
            while (object.hasNext()) {
                kjui4 = (kjui)object.next();
                Point point = kjui4._h();
                Point point2 = kjui4._i();
                Point point3 = kjui4._j();
                kjui kjui6 = kjui4;
                Intrinsics.checkExpressionValueIsNotNull(kjui6, "link");
                if (!this._a(point, point2, point3, kjui6, bl)) continue;
                bl2 = true;
                object.remove();
                kjui kjui7 = kjui4._a();
                kjui2 = kjui4._b();
                Collection collection = treeSet;
                TypeIntrinsics.asMutableCollection(collection).remove(kjui7);
                collection = treeSet;
                TypeIntrinsics.asMutableCollection(collection).remove(kjui2);
                list3.add(new kksf(point, point2, point3));
                kjui kjui8 = kjui2;
                if (kjui8 == null) {
                    Intrinsics.throwNpe();
                }
                if (kjui8._b() == kjui7) break block1;
                kjui kjui9 = kjui7;
                if (kjui9 == null) {
                    Intrinsics.throwNpe();
                }
                kjui9._j().setLocation(point3);
                kjui7._a(-1);
                kjui2._h().setLocation(point);
                kjui2._a(-1);
                kjui7._b(kjui2);
                kjui2._a(kjui7);
                if (kjui7._d() == bl) {
                    treeSet.add(kjui7);
                }
                if (kjui2._d() != bl) break;
                treeSet.add(kjui2);
                break;
            }
            if (bl2) continue;
            throw (Throwable)new IllegalStateException("found == false");
        }
    }

    private tupg() {
        _a = this;
    }

    static {
        new tupg();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0000H\u0096\u0002R\u001c\u0010\u0004\u001a\u00020\u00058@X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0000X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0000X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/core/misc/EarTriangulation$Link;", "Lgloomyfolken/mods/core/spawn/RegionTriangle;", "", "()V", "distance", "", "getDistance$minecraft", "()I", "setDistance$minecraft", "(I)V", "isClockwise", "", "isClockwise$minecraft", "()Z", "next", "getNext$minecraft", "()Lgloomyfolken/mods/core/misc/EarTriangulation$Link;", "setNext$minecraft", "(Lgloomyfolken/mods/core/misc/EarTriangulation$Link;)V", "prev", "getPrev$minecraft", "setPrev$minecraft", "compareTo", "other", "minecraft"})
    private static final class kjui
    extends kksf
    implements Comparable<kjui> {
        @Nullable
        private kjui _a;
        @Nullable
        private kjui _b;
        private int _c = -1;

        @Nullable
        public final kjui _a() {
            return this._a;
        }

        public final void _a(@Nullable kjui kjui2) {
            this._a = kjui2;
        }

        @Nullable
        public final kjui _b() {
            return this._b;
        }

        public final void _b(@Nullable kjui kjui2) {
            this._b = kjui2;
        }

        public final int _c() {
            if (this._c == -1) {
                this._c = (int)this._h().distanceSq(this._j());
            }
            return this._c;
        }

        public final void _a(int n) {
            this._c = n;
        }

        public int _c(@NotNull kjui kjui2) {
            Intrinsics.checkParameterIsNotNull(kjui2, "other");
            if (this == kjui2) {
                return 0;
            }
            int n = this._c() - kjui2._c();
            return n != 0 ? n : this.hashCode() - kjui2.hashCode();
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this._c((kjui)object);
        }

        public final boolean _d() {
            return _a._a(this._h(), this._i(), this._j());
        }

        public kjui() {
            super(new Point(), new Point(), new Point());
        }
    }
}

