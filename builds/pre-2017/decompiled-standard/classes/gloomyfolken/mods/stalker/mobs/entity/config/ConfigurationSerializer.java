/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationGroup;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationSerializer;", "Lcom/google/gson/JsonSerializer;", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "minecraft"})
public final class ConfigurationSerializer
implements JsonSerializer<MutantConfiguration> {
    @Override
    @NotNull
    public JsonElement serialize(@NotNull MutantConfiguration mutantConfiguration, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "src");
        Intrinsics.checkParameterIsNotNull(type, "typeOfSrc");
        Intrinsics.checkParameterIsNotNull(jsonSerializationContext, "context");
        JsonObject jsonObject = new JsonObject();
        Iterable iterable = mutantConfiguration.getConfigurationGroups();
        for (Object t : iterable) {
            ConfigurationGroup configurationGroup = (ConfigurationGroup)t;
            jsonObject.add(configurationGroup.getGroupId(), jsonSerializationContext.serialize(configurationGroup));
        }
        mutantConfiguration.serialize(jsonObject, jsonSerializationContext);
        return jsonObject;
    }
}

