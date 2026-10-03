/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.io.CountingInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\t\u00a8\u0006&"}, d2={"Lgloomyfolken/mods/effects/client/texture/ol/OlHeader;", "", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "_bytesRead", "", "bytesRead", "getBytesRead", "()I", "format", "Lgloomyfolken/mods/effects/client/texture/TextureFormat;", "getFormat", "()Lgloomyfolken/mods/effects/client/texture/TextureFormat;", "height", "getHeight", "isCubemapTexture", "", "()Z", "levels", "getLevels", "md5", "", "getMd5", "()Ljava/lang/String;", "packedLevelLengths", "", "getPackedLevelLengths", "()[I", "unpackedLevelLengths", "getUnpackedLevelLengths", "width", "getWidth", "getNumFaces", "readFormat", "bin", "Ljava/io/DataInputStream;", "Companion", "minecraft"})
public final class wnyq {
    private final int _c;
    private final int _d;
    private final int _e;
    @NotNull
    private final qmig _f;
    private final boolean _g;
    @NotNull
    private final String _h;
    @NotNull
    private final int[] _i;
    @NotNull
    private final int[] _j;
    private int _k;
    @JvmField
    public static final int _a = 177546237;
    public static final kjui _b = new kjui(null);

    public final int _a() {
        return this._c;
    }

    public final int _b() {
        return this._d;
    }

    public final int _c() {
        return this._e;
    }

    @NotNull
    public final qmig _d() {
        return this._f;
    }

    public final boolean _e() {
        return this._g;
    }

    @NotNull
    public final String _f() {
        return this._h;
    }

    @NotNull
    public final int[] _g() {
        return this._i;
    }

    @NotNull
    public final int[] _h() {
        return this._j;
    }

    public final int _i() {
        return this._k;
    }

    private final int _j() {
        return this._g ? 6 : 1;
    }

    private final qmig _a(DataInputStream dataInputStream) {
        int n = 0;
        Object object = new IntRange(n, 15);
        Iterable iterable = object;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object, 10));
        Iterator iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            int n2;
            int n3 = n2 = ((IntIterator)iterator2).nextInt();
            Collection collection2 = collection;
            Character c = Character.valueOf(_b._a(dataInputStream.readByte()));
            collection2.add(c);
        }
        Object object2 = object = CollectionsKt.joinToString$default((List)collection, "", null, null, 0, null, null, 62, null);
        if (object2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ((Object)StringsKt.trim((CharSequence)object2)).toString();
        try {
            Object object3 = object = string;
            if (object3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string2 = ((String)object3).toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).toUpperCase()");
            return qmig.valueOf(string2);
        }
        catch (Exception exception) {
            throw (Throwable)new IllegalStateException("Unsupported .ol internal texture format: " + string);
        }
    }

    public wnyq(@NotNull InputStream inputStream) {
        int n;
        int[] nArray;
        int n2;
        int n3;
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        DataInputStream dataInputStream = new DataInputStream(countingInputStream);
        if (dataInputStream.readInt() != _a) {
            throw (Throwable)new IllegalStateException("Not an .ol format!");
        }
        this._c = dataInputStream.readInt();
        this._d = dataInputStream.readInt();
        this._e = dataInputStream.readInt();
        this._f = this._a(dataInputStream);
        this._g = dataInputStream.readBoolean();
        int n4 = this._e * this._j();
        wnyq wnyq2 = this;
        int[] nArray2 = new int[n4];
        int n5 = 0;
        int n6 = n4 - 1;
        if (n5 <= n6) {
            do {
                n3 = ++n5;
                n2 = n5;
                nArray = nArray2;
                nArray[n2] = n = dataInputStream.readInt();
            } while (n5 != n6);
        }
        nArray = nArray2;
        wnyq2._i = nArray;
        n4 = this._e * this._j();
        wnyq2 = this;
        nArray2 = new int[n4];
        n5 = 0;
        n6 = n4 - 1;
        if (n5 <= n6) {
            do {
                n3 = ++n5;
                n2 = n5;
                nArray = nArray2;
                nArray[n2] = n = dataInputStream.readInt();
            } while (n5 != n6);
        }
        nArray = nArray2;
        wnyq2._j = nArray;
        this._h = "";
        this._k = (int)countingInputStream.getCount();
    }

    static {
        _a = 177546237;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/effects/client/texture/ol/OlHeader$Companion;", "", "()V", "HEADER", "", "byteToChar", "", "byte", "", "charToInt", "char", "minecraft"})
    public static final class kjui {
        public final int _a(char c) {
            return (int)((long)((byte)c) ^ 0x2412312435467867L);
        }

        public final char _a(byte by) {
            return (char)((long)by ^ 0x2412312435467867L);
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

