/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00070\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00070\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a2\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002H\u00130\u0015\u001aB\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002H\u00130\u0015\u001a1\u0010\u0018\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002H\u00130\u0015\u00a2\u0006\u0002\u0010\u001a\u001a2\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00130\u0015\u001aB\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00130\u0015\u001a9\u0010\u001d\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002H\u00130\u0015\u00a2\u0006\u0002\u0010\u001e\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00130\u0015\u001a4\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00130\"2\u0006\u0010#\u001a\u00020$\u00a8\u0006%"}, d2={"asPoint2D", "Ljava/awt/geom/Point2D$Double;", "Lcom/google/gson/JsonArray;", "getBoolean", "", "Lcom/google/gson/JsonObject;", "name", "", "def", "getDouble", "", "getFloat", "", "getInt", "", "getString", "kotlin.jvm.PlatformType", "parseList", "", "T", "mapper", "Lkotlin/Function1;", "Lcom/google/gson/JsonElement;", "parseListOrDefault", "parseObject", "parser", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "parseObjectList", "parseObjectListOrDefault", "parseOrDefault", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "parseStringList", "parseTypedList", "type", "Ljava/lang/Class;", "context", "Lcom/google/gson/JsonDeserializationContext;", "minecraft"})
public final class ofji {
    public static final <T> T _a(@NotNull JsonObject jsonObject, @NotNull String string, @NotNull Function1<? super JsonElement, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(function1, "parser");
        try {
            JsonElement jsonElement = jsonObject.get(string);
            if (jsonElement == null) {
                Intrinsics.throwNpe();
            }
            return function1.invoke(jsonElement);
        }
        catch (Exception exception) {
            throw (Throwable)new IllegalArgumentException("Parameter " + string + " is invalid: " + jsonObject.get(string), exception);
        }
    }

    public static final <T> T _a(@NotNull JsonObject jsonObject, @NotNull String string, T t, @NotNull Function1<? super JsonElement, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(function1, "parser");
        try {
            return ofji._a(jsonObject, string, function1);
        }
        catch (Exception exception) {
            return t;
        }
    }

    @NotNull
    public static final <T> List<T> _b(@NotNull JsonObject jsonObject, @NotNull String string, final @NotNull Function1<? super JsonElement, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(function1, "mapper");
        return (List)ofji._a(jsonObject, string, new Function1<JsonElement, List<? extends T>>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((JsonElement)object);
            }

            @NotNull
            public final List<T> _a(@NotNull JsonElement jsonElement) {
                Intrinsics.checkParameterIsNotNull(jsonElement, "it");
                Iterable iterable = jsonElement.getAsJsonArray();
                Function1 function12 = function1;
                Iterable iterable2 = iterable;
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    collection.add(function12.invoke(t));
                }
                return (List)collection;
            }
        });
    }

    @NotNull
    public static final <T> List<T> _c(@NotNull JsonObject jsonObject, @NotNull String string, final @NotNull Function1<? super JsonObject, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(function1, "mapper");
        return (List)ofji._a(jsonObject, string, new Function1<JsonElement, List<? extends T>>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((JsonElement)object);
            }

            @NotNull
            public final List<T> _a(@NotNull JsonElement jsonElement) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(jsonElement, "it");
                Iterable iterable2 = iterable = (Iterable)jsonElement.getAsJsonArray();
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    JsonElement jsonElement2 = (JsonElement)t;
                    Collection collection2 = collection;
                    JsonObject jsonObject = jsonElement2.getAsJsonObject();
                    Intrinsics.checkExpressionValueIsNotNull(jsonObject, "it.asJsonObject");
                    Object r = function1.invoke(jsonObject);
                    collection2.add(r);
                }
                return (List)collection;
            }
        });
    }

    @NotNull
    public static final <T> List<T> _d(@NotNull JsonObject jsonObject, @NotNull String string, final @NotNull Function1<? super String, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(function1, "mapper");
        return (List)ofji._a(jsonObject, string, new Function1<JsonElement, List<? extends T>>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((JsonElement)object);
            }

            @NotNull
            public final List<T> _a(@NotNull JsonElement jsonElement) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(jsonElement, "it");
                Iterable iterable2 = iterable = (Iterable)jsonElement.getAsJsonArray();
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    JsonElement jsonElement2 = (JsonElement)t;
                    Collection collection2 = collection;
                    String string = jsonElement2.getAsString();
                    Intrinsics.checkExpressionValueIsNotNull(string, "it.asString");
                    Object r = function1.invoke(string);
                    collection2.add(r);
                }
                return (List)collection;
            }
        });
    }

    @NotNull
    public static final <T> List<T> _a(@NotNull JsonObject jsonObject, @NotNull String string, final @NotNull Class<T> clazz, final @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(clazz, "type");
        Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
        return ofji._b(jsonObject, string, new Function1<JsonElement, T>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((JsonElement)object);
            }

            public final T _a(@NotNull JsonElement jsonElement) {
                Intrinsics.checkParameterIsNotNull(jsonElement, "it");
                return jsonDeserializationContext.deserialize(jsonElement, clazz);
            }
        });
    }

    @NotNull
    public static final <T> List<T> _a(@NotNull JsonObject jsonObject, @NotNull String string, @NotNull List<? extends T> list, final @NotNull Function1<? super JsonElement, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(list, "def");
        Intrinsics.checkParameterIsNotNull(function1, "mapper");
        return ofji._a(jsonObject, string, list, (Function1)new Function1<JsonElement, List<? extends T>>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((JsonElement)object);
            }

            @NotNull
            public final List<T> _a(@NotNull JsonElement jsonElement) {
                Intrinsics.checkParameterIsNotNull(jsonElement, "it");
                Iterable iterable = jsonElement.getAsJsonArray();
                Function1 function12 = function1;
                Iterable iterable2 = iterable;
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    collection.add(function12.invoke(t));
                }
                return (List)collection;
            }
        });
    }

    @NotNull
    public static /* synthetic */ List _a(JsonObject jsonObject, String string, List list, Function1 function1, int n, Object object) {
        if ((n & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return ofji._a(jsonObject, string, list, function1);
    }

    @NotNull
    public static final <T> List<T> _b(@NotNull JsonObject jsonObject, @NotNull String string, @NotNull List<? extends T> list, final @NotNull Function1<? super JsonObject, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(list, "def");
        Intrinsics.checkParameterIsNotNull(function1, "mapper");
        return ofji._a(jsonObject, string, list, (Function1)new Function1<JsonElement, List<? extends T>>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((JsonElement)object);
            }

            @NotNull
            public final List<T> _a(@NotNull JsonElement jsonElement) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(jsonElement, "it");
                Iterable iterable2 = iterable = (Iterable)jsonElement.getAsJsonArray();
                Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object t : iterable2) {
                    JsonElement jsonElement2 = (JsonElement)t;
                    Collection collection2 = collection;
                    JsonObject jsonObject = jsonElement2.getAsJsonObject();
                    Intrinsics.checkExpressionValueIsNotNull(jsonObject, "it.asJsonObject");
                    Object r = function1.invoke(jsonObject);
                    collection2.add(r);
                }
                return (List)collection;
            }
        });
    }

    @NotNull
    public static /* synthetic */ List _b(JsonObject jsonObject, String string, List list, Function1 function1, int n, Object object) {
        if ((n & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return ofji._b(jsonObject, string, list, function1);
    }

    public static final String _a(@NotNull JsonObject jsonObject, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return (String)ofji._a(jsonObject, string, qlgf._a);
    }

    public static final int _b(@NotNull JsonObject jsonObject, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ((Number)ofji._a(jsonObject, string, jgro._a)).intValue();
    }

    public static final boolean _c(@NotNull JsonObject jsonObject, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return (Boolean)ofji._a(jsonObject, string, kjui._a);
    }

    public static final float _d(@NotNull JsonObject jsonObject, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ((Number)ofji._a(jsonObject, string, zwat._a)).floatValue();
    }

    public static final double _e(@NotNull JsonObject jsonObject, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ((Number)ofji._a(jsonObject, string, eidj._a)).doubleValue();
    }

    public static final String _a(@NotNull JsonObject jsonObject, @NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "def");
        return ofji._a(jsonObject, string, string2, (Function1)jxtc._a);
    }

    public static final int _a(@NotNull JsonObject jsonObject, @NotNull String string, int n) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ((Number)ofji._a(jsonObject, string, n, (Function1)tupg._a)).intValue();
    }

    public static final boolean _a(@NotNull JsonObject jsonObject, @NotNull String string, boolean bl) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ofji._a(jsonObject, string, bl, (Function1)pidb._a);
    }

    public static final float _a(@NotNull JsonObject jsonObject, @NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ((Number)ofji._a(jsonObject, string, Float.valueOf(f), (Function1)zwaw._a)).floatValue();
    }

    public static final double _a(@NotNull JsonObject jsonObject, @NotNull String string, double d) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return ((Number)ofji._a(jsonObject, string, d, (Function1)ezey._a)).doubleValue();
    }

    @NotNull
    public static final Point2D.Double _a(@NotNull JsonArray jsonArray) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        return new Point2D.Double(jsonArray.get(0).getAsDouble(), jsonArray.get(1).getAsDouble());
    }
}

