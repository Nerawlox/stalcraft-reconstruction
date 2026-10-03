/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationGroup;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "provideConfigInstance", "minecraft"})
public class ConfigurationDeserializer
implements JsonDeserializer<MutantConfiguration> {
    @NotNull
    public MutantConfiguration provideConfigInstance() {
        return new MutantConfiguration();
    }

    @Override
    @NotNull
    public MutantConfiguration deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "json");
        Intrinsics.checkParameterIsNotNull(type, "typeOfT");
        Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
        MutantConfiguration mutantConfiguration = this.provideConfigInstance();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Iterable iterable = jsonObject.entrySet();
        for (Object t : iterable) {
            Map.Entry entry = (Map.Entry)t;
            try {
                Object k = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(k, "it.key");
                ConfigurationGroup configurationGroup = mutantConfiguration.getDeserializeTarget$minecraft((String)k);
                if (configurationGroup == null) continue;
                Class<?> clazz = configurationGroup.getClass();
                InstanceCreator instanceCreator = new InstanceCreator<ConfigurationGroup>(configurationGroup){
                    final /* synthetic */ ConfigurationGroup $deserializeTarget;

                    @Nullable
                    public final ConfigurationGroup createInstance(Type type) {
                        return this.$deserializeTarget;
                    }
                    {
                        this.$deserializeTarget = configurationGroup;
                    }
                };
                Gson gson2 = new GsonBuilder().registerTypeAdapter(clazz, instanceCreator).create();
                gson2.fromJson((JsonElement)entry.getValue(), clazz);
            }
            catch (Exception exception) {
                Logger.warning("Invalid configuration group read for group '" + (String)entry.getKey() + "'! Json = '" + (JsonElement)entry.getValue() + "'.", new Object[0]);
                exception.printStackTrace();
            }
        }
        JsonObject jsonObject2 = jsonObject;
        Intrinsics.checkExpressionValueIsNotNull(jsonObject2, "root");
        mutantConfiguration.deserialize(jsonObject2, jsonDeserializationContext);
        return mutantConfiguration;
    }
}

