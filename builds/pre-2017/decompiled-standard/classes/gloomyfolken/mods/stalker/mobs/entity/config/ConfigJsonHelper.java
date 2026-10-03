/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import gloomyfolken.mods.core.misc.uxqz;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationDeserializer;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationSerializer;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigJsonHelper;", "", "()V", "Companion", "minecraft"})
public final class ConfigJsonHelper {
    private static final JsonParser parser;
    private static final GsonBuilder configGsonBuilder;
    private static final Gson configGson;
    public static final Companion Companion;

    static {
        Companion = new Companion(null);
        parser = new JsonParser();
        configGsonBuilder = uxqz._a.registerTypeAdapter((Type)((Object)MutantConfiguration.class), new ConfigurationSerializer()).registerTypeAdapter((Type)((Object)MutantConfiguration.class), new ConfigurationDeserializer());
        configGson = Companion.getConfigGsonBuilder().create();
    }

    @JvmStatic
    public static final <T> T read(@NotNull String string, @NotNull Class<T> clazz) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        Intrinsics.checkParameterIsNotNull(clazz, "clz");
        return Companion.read(string, clazz);
    }

    @JvmStatic
    @NotNull
    public static final String write(@NotNull Object object) {
        Intrinsics.checkParameterIsNotNull(object, "object");
        return Companion.write(object);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015H\u0007\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0001H\u0007R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigJsonHelper$Companion;", "", "()V", "configGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getConfigGson", "()Lcom/google/gson/Gson;", "configGsonBuilder", "Lcom/google/gson/GsonBuilder;", "getConfigGsonBuilder", "()Lcom/google/gson/GsonBuilder;", "parser", "Lcom/google/gson/JsonParser;", "getParser", "()Lcom/google/gson/JsonParser;", "read", "T", "string", "", "clz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "write", "object", "minecraft"})
    public static final class Companion {
        private final JsonParser getParser() {
            return parser;
        }

        public final GsonBuilder getConfigGsonBuilder() {
            return configGsonBuilder;
        }

        public final Gson getConfigGson() {
            return configGson;
        }

        @JvmStatic
        public final <T> T read(@NotNull String string, @NotNull Class<T> clazz) {
            Intrinsics.checkParameterIsNotNull(string, "string");
            Intrinsics.checkParameterIsNotNull(clazz, "clz");
            return this.getConfigGson().fromJson(this.getParser().parse(string), clazz);
        }

        @JvmStatic
        @NotNull
        public final String write(@NotNull Object object) {
            Intrinsics.checkParameterIsNotNull(object, "object");
            String string = this.getConfigGson().toJson(object);
            Intrinsics.checkExpressionValueIsNotNull(string, "configGson.toJson(`object`)");
            return string;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

