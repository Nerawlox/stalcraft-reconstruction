/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.tdpx;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/CustomEffectSettings;", "", "location", "Lnet/minecraft/util/ResourceLocation;", "(Lnet/minecraft/util/ResourceLocation;)V", "()V", "colorsLookup", "Ljava/util/HashMap;", "", "Lnet/minecraft/util/Vec3;", "Lkotlin/collections/HashMap;", "getColorsLookup", "()Ljava/util/HashMap;", "hashCode", "", "props", "Ljava/util/Properties;", "getProps", "()Ljava/util/Properties;", "equals", "", "other", "getColor", "name", "def", "getDouble", "", "getFloat", "", "getProperty", "init", "", "minecraft"})
public final class oxbc {
    @NotNull
    private final Properties _a;
    @NotNull
    private final HashMap<String, ofbx> _b;
    private int _c;
    private ResourceLocation _d;

    @NotNull
    public final Properties _a() {
        return this._a;
    }

    @NotNull
    public final HashMap<String, ofbx> _b() {
        return this._b;
    }

    private final void _c() {
        if (this._d != null) {
            this._a.load(new StringReader(tdpx._b(this._d)));
        }
        this._c = this._a.hashCode();
    }

    @NotNull
    public final String _a(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "def");
        String string3 = this._a.getProperty(string);
        if (string3 == null) {
            string3 = string2;
        }
        return string3;
    }

    public final float _a(@NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Object object = this._a.getProperty(string);
        return object != null && (object = StringsKt.toFloatOrNull((String)object)) != null ? ((Float)object).floatValue() : f;
    }

    public final double _a(@NotNull String string, double d) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Object object = this._a.getProperty(string);
        return object != null && (object = StringsKt.toDoubleOrNull((String)object)) != null ? (Double)object : d;
    }

    @NotNull
    public final ofbx _a(@NotNull String string, @NotNull ofbx ofbx2) {
        CharSequence charSequence;
        String string2;
        Object t;
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(ofbx2, "def");
        ofbx ofbx3 = this._b.get(string);
        if (ofbx3 != null) {
            return ofbx3;
        }
        String string3 = this._a.getProperty(string);
        if (string3 == null || (string3 = string3.toString()) == null) {
            return ofbx2;
        }
        String string4 = string3;
        Object object = string4;
        String string5 = object;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        Object object2 = object = (Iterable)StringsKt.split$default((CharSequence)((Object)StringsKt.trim((CharSequence)string5)).toString(), new String[]{" "}, false, 0, 6, null);
        Collection collection = new ArrayList();
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            t = iterator2.next();
            string2 = (String)t;
            charSequence = string2;
            if (!(charSequence.length() > 0)) continue;
            collection.add(t);
        }
        object = (List)collection;
        object2 = object;
        collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object, 10));
        iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            t = iterator2.next();
            string2 = (String)t;
            Collection collection2 = collection;
            CharSequence charSequence2 = charSequence = string2;
            if (charSequence2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            Double d = StringsKt.toDoubleOrNull(((Object)StringsKt.trim(charSequence2)).toString());
            collection2.add(d);
        }
        List list2 = (List)collection;
        if (list2.size() != 3 && this._d != null) {
            StringBuilder stringBuilder = new StringBuilder().append("Error while reading color in file '");
            Object object3 = this._d;
            if (object3 == null || (object3 = ((ResourceLocation)object3).func_110623_a()) == null) {
                object3 = "[dynamic_created_effecor]";
            }
            Logger.warning(stringBuilder.append((String)object3).append("' ").append("for attribute ").append(string).append(", value '").append(string4).append("' must containt exactly 3 color parts!").toString(), new Object[0]);
            return ofbx2;
        }
        Object e = list2.get(0);
        if (e == null) {
            Intrinsics.throwNpe();
        }
        double d = ((Number)e).doubleValue();
        Object e2 = list2.get(1);
        if (e2 == null) {
            Intrinsics.throwNpe();
        }
        double d2 = ((Number)e2).doubleValue();
        Object e3 = list2.get(2);
        if (e3 == null) {
            Intrinsics.throwNpe();
        }
        ofbx3 = VecExtensionsKt.vec3(d, d2, ((Number)e3).doubleValue());
        object = this._b;
        ofbx ofbx4 = ofbx3;
        Intrinsics.checkExpressionValueIsNotNull(ofbx4, "lookup");
        object2 = ofbx4;
        object.put(string, object2);
        return ofbx3;
    }

    public int hashCode() {
        return this._c;
    }

    public boolean equals(@Nullable Object object) {
        Object object2 = object;
        if (!(object2 instanceof oxbc)) {
            object2 = null;
        }
        oxbc oxbc2 = (oxbc)object2;
        if (oxbc2 == null) {
            return false;
        }
        oxbc oxbc3 = oxbc2;
        if (oxbc3._c != this._c) {
            return false;
        }
        return Intrinsics.areEqual(this._a, oxbc3._a);
    }

    public oxbc(@NotNull ResourceLocation resourceLocation) {
        Intrinsics.checkParameterIsNotNull(resourceLocation, "location");
        this._a = new Properties();
        oxbc oxbc2 = this;
        HashMap hashMap = new HashMap();
        oxbc2._b = hashMap;
        this._c = -1;
        this._d = resourceLocation;
        this._c();
    }

    public oxbc() {
        this._a = new Properties();
        oxbc oxbc2 = this;
        HashMap hashMap = new HashMap();
        oxbc2._b = hashMap;
        this._c = -1;
        this._c();
    }
}

