/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.misc.ezey;
import gloomyfolken.mods.core.misc.pzde;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.stalker.mobs.entity.MutantSkin;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigJsonHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationDeserializer;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationGroup;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration$WhenMappings;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.util.jxtc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u00f2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 t2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001tB\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0000J\u0006\u0010O\u001a\u00020\u0000J\u0016\u0010P\u001a\u00020M2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020MJ\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00180WJ\u000e\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[J\u0017\u0010\\\u001a\u0004\u0018\u00010\u00182\u0006\u0010]\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\b^J\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020`0W2\u0006\u0010a\u001a\u00020\u0003J\u0006\u0010b\u001a\u00020\u0017J\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010WJ\u0016\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010W2\u0006\u0010e\u001a\u00020\u0017J\u0012\u0010f\u001a\u0004\u0018\u00010\u00032\u0006\u0010g\u001a\u00020hH\u0016J\u001f\u0010i\u001a\u0002Hj\"\b\b\u0000\u0010j*\u00020\u00182\u0006\u0010k\u001a\u0002HjH\u0002\u00a2\u0006\u0002\u0010lJ\u0016\u0010m\u001a\u00020M2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020nJ\u0010\u0010o\u001a\u00020.2\b\u0010N\u001a\u0004\u0018\u00010\u0000J\u0006\u0010p\u001a\u00020\u0017J\u000e\u0010q\u001a\u00020.2\u0006\u0010r\u001a\u00020sR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u001bj\b\u0012\u0004\u0012\u00020\u0018`\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R-\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020.0\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020.`\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u000202\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000206\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020:\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R(\u0010?\u001a\u0004\u0018\u00010\u00172\b\u0010>\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020E\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020I\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010K\u00a8\u0006u"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "", "Lgloomyfolken/mods/core/spawn/IEntitySpawnProvider;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "()V", "agro", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Agression;", "getAgro", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Agression;", "ai", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Ai;", "getAi", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Ai;", "attack", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Attack;", "getAttack", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Attack;", "common", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Common;", "getCommon", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Common;", "configGroupClassMap", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "Lkotlin/collections/HashMap;", "configGroups", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fear", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Fear;", "getFear", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Fear;", "giant", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Pseudogiant;", "getGiant", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Pseudogiant;", "health", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Health;", "getHealth", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Health;", "immunity", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Immunities;", "getImmunity", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Immunities;", "inheritField", "", "getInheritField", "()Ljava/util/HashMap;", "jumpAttacker", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$JumpAttacker;", "getJumpAttacker", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$JumpAttacker;", "krovosos", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Krovosos;", "getKrovosos", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Krovosos;", "movement", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Movement;", "getMovement", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Movement;", "parentConfiguration", "<set-?>", "parentConfigurationName", "getParentConfigurationName", "()Ljava/lang/String;", "setParentConfigurationName", "(Ljava/lang/String;)V", "psidog", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Psidog;", "getPsidog", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Psidog;", "turn", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Turn;", "getTurn", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Turn;", "cloneFrom", "", "mutantConfiguration", "cloned", "deserialize", "root", "Lcom/google/gson/JsonObject;", "context", "Lcom/google/gson/JsonDeserializationContext;", "extractInheritedValues", "getConfigurationGroups", "", "getDamageFactor", "", "damageSource", "Lnet/minecraft/util/DamageSource;", "getDeserializeTarget", "groupId", "getDeserializeTarget$minecraft", "getDroppedStuff", "Lnet/minecraft/item/ItemStack;", "mutant", "getName", "getOverrideSkins", "Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "skinsStr", "instantiateEntity", "world", "Lnet/minecraft/world/World;", "register", "T", "configurationGroup", "(Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;)Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "serialize", "Lcom/google/gson/JsonSerializationContext;", "setParentConfiguration", "toJson", "useFieldInheritance", "field", "Ljava/lang/reflect/Field;", "Companion", "minecraft"})
public final class MutantConfiguration
implements Cloneable,
uyqc<EntityMutant> {
    private final ArrayList<ConfigurationGroup> configGroups;
    private final HashMap<String, ConfigurationGroup> configGroupClassMap;
    @NotNull
    private final HashMap<String, Boolean> inheritField;
    @Nullable
    private String parentConfigurationName;
    private transient MutantConfiguration parentConfiguration;
    @NotNull
    private final Companion.Common common;
    @NotNull
    private final Companion.Turn turn;
    @NotNull
    private final Companion.Movement movement;
    @NotNull
    private final Companion.Attack attack;
    @NotNull
    private final Companion.Health health;
    @NotNull
    private final Companion.Ai ai;
    @NotNull
    private final Companion.Fear fear;
    @NotNull
    private final Companion.Agression agro;
    @NotNull
    private final Companion.Immunities immunity;
    @NotNull
    private final Companion.Psidog psidog;
    @NotNull
    private final Companion.JumpAttacker jumpAttacker;
    @NotNull
    private final Companion.Krovosos krovosos;
    @NotNull
    private final Companion.Pseudogiant giant;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final HashMap<String, Boolean> getInheritField() {
        return this.inheritField;
    }

    @Nullable
    public final String getParentConfigurationName() {
        return this.parentConfigurationName;
    }

    private final void setParentConfigurationName(String string) {
        this.parentConfigurationName = string;
    }

    @NotNull
    public final Companion.Common getCommon() {
        return this.common;
    }

    @NotNull
    public final Companion.Turn getTurn() {
        return this.turn;
    }

    @NotNull
    public final Companion.Movement getMovement() {
        return this.movement;
    }

    @NotNull
    public final Companion.Attack getAttack() {
        return this.attack;
    }

    @NotNull
    public final Companion.Health getHealth() {
        return this.health;
    }

    @NotNull
    public final Companion.Ai getAi() {
        return this.ai;
    }

    @NotNull
    public final Companion.Fear getFear() {
        return this.fear;
    }

    @NotNull
    public final Companion.Agression getAgro() {
        return this.agro;
    }

    @NotNull
    public final Companion.Immunities getImmunity() {
        return this.immunity;
    }

    @NotNull
    public final Companion.Psidog getPsidog() {
        return this.psidog;
    }

    @NotNull
    public final Companion.JumpAttacker getJumpAttacker() {
        return this.jumpAttacker;
    }

    @NotNull
    public final Companion.Krovosos getKrovosos() {
        return this.krovosos;
    }

    @NotNull
    public final Companion.Pseudogiant getGiant() {
        return this.giant;
    }

    public final void extractInheritedValues() {
        Map map;
        if (this.parentConfigurationName == null) {
            return;
        }
        MutantConfiguration mutantConfiguration = this.parentConfiguration;
        if (mutantConfiguration == null) {
            Intrinsics.throwNpe();
        }
        MutantConfiguration mutantConfiguration2 = mutantConfiguration;
        Map map2 = map = (Map)this.configGroupClassMap;
        Iterator iterator2 = map2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Field field;
            Object object;
            Object object2;
            Map.Entry entry;
            Map.Entry entry2 = entry = iterator2.next();
            String string = (String)entry2.getKey();
            ConfigurationGroup configurationGroup = (ConfigurationGroup)entry2.getValue();
            ConfigurationGroup configurationGroup2 = mutantConfiguration2.configGroupClassMap.get(string);
            Object object3 = object2 = (Object[])configurationGroup.getClass().getDeclaredFields();
            Collection collection = new ArrayList();
            for (int i = 0; i < ((Object[])object3).length; ++i) {
                object = object3[i];
                field = (Field)object;
                field.setAccessible(true);
                if (!true) continue;
                collection.add(object);
            }
            List list2 = (List)collection;
            object3 = object2 = (Iterable)list2;
            collection = new ArrayList();
            Object object4 = object3.iterator();
            while (object4.hasNext()) {
                object = object4.next();
                Field field2 = field = (Field)object;
                Intrinsics.checkExpressionValueIsNotNull(field2, "it");
                if (!this.useFieldInheritance(field2)) continue;
                collection.add(object);
            }
            object2 = (List)collection;
            object3 = object2.iterator();
            while (object3.hasNext()) {
                collection = object3.next();
                object4 = (Field)((Object)collection);
                ((Field)object4).set(configurationGroup, ((Field)object4).get(configurationGroup2));
            }
        }
    }

    public final boolean useFieldInheritance(@NotNull Field field) {
        Object object;
        Object object2;
        Object object3;
        block4: {
            Intrinsics.checkParameterIsNotNull(field, "field");
            object3 = field.getAnnotations();
            for (int i = 0; i < ((Object[])object3).length; ++i) {
                Object object4 = object3[i];
                Annotation annotation = (Annotation)object4;
                if (!(annotation instanceof SerializedName)) continue;
                object2 = object4;
                break block4;
            }
            object2 = object = null;
        }
        if (!(object2 instanceof SerializedName)) {
            object = null;
        }
        SerializedName serializedName = (SerializedName)object;
        if (serializedName == null) {
            return false;
        }
        SerializedName serializedName2 = serializedName;
        object3 = serializedName2.value();
        if (Intrinsics.areEqual(object3, "name")) {
            return false;
        }
        this.inheritField.putIfAbsent((String)object3, false);
        Boolean bl = this.inheritField.get(object3);
        return bl != null ? bl : false;
    }

    private final <T extends ConfigurationGroup> T register(T t) {
        Object object = this.configGroups;
        object.add(t);
        object = this.configGroupClassMap;
        Pair<String, T> pair = TuplesKt.to(t.getGroupId(), t);
        object.put(pair.getFirst(), pair.getSecond());
        return t;
    }

    @Nullable
    public final ConfigurationGroup getDeserializeTarget$minecraft(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "groupId");
        return this.configGroupClassMap.get(string);
    }

    public final void serialize(@NotNull JsonObject jsonObject, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "root");
        Intrinsics.checkParameterIsNotNull(jsonSerializationContext, "context");
        jsonObject.add("inheritField", jsonSerializationContext.serialize(this.inheritField));
        jsonObject.add("parentConfigurationName", jsonSerializationContext.serialize(this.parentConfigurationName));
    }

    public final void deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "root");
        Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
        this.inheritField.clear();
        if (jsonObject.has("inheritField")) {
            Collection collection;
            Iterable iterable = jsonObject.get("inheritField").getAsJsonObject().entrySet();
            Map map = this.inheritField;
            Iterable iterable2 = iterable;
            Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object t : iterable2) {
                Map.Entry entry = (Map.Entry)t;
                collection = collection2;
                Pair pair = TuplesKt.to(entry.getKey(), ((JsonElement)entry.getValue()).getAsBoolean());
                collection.add(pair);
            }
            collection = (List)collection2;
            MapsKt.putAll(map, collection);
        }
        if (jsonObject.has("parentConfigurationName")) {
            String string = this.parentConfigurationName = jsonObject.get("parentConfigurationName").getAsString();
            if (string == null) {
                Intrinsics.throwNpe();
            }
            this.setParentConfiguration(MutantConfigHelper.SERVER.getMobConfiguration(string));
        }
    }

    public final boolean setParentConfiguration(@Nullable MutantConfiguration mutantConfiguration) {
        if (mutantConfiguration == null || Intrinsics.areEqual(mutantConfiguration.parentConfiguration, this)) {
            return false;
        }
        this.parentConfigurationName = mutantConfiguration.getName();
        this.parentConfiguration = mutantConfiguration;
        this.extractInheritedValues();
        return true;
    }

    @NotNull
    public final String getName() {
        return this.common.getName();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final double getDamageFactor(@NotNull jxtc jxtc2) {
        double d;
        Companion.Immunities immunities;
        Intrinsics.checkParameterIsNotNull(jxtc2, "damageSource");
        Companion.Immunities immunities2 = immunities = this.immunity;
        jxtc jxtc3 = jxtc2;
        if (Intrinsics.areEqual(jxtc3, ezey._n)) {
            d = immunities2.getTelepaticImmunity();
            return d;
        } else {
            if (jxtc3 instanceof ezey) {
                ezey.kjui kjui2 = ((ezey)jxtc2)._k;
                if (kjui2 == null) return 1.0;
                switch (MutantConfiguration$WhenMappings.$EnumSwitchMapping$0[kjui2.ordinal()]) {
                    case 1: {
                        double d2 = immunities2.getWoundImmunity();
                        return d2;
                    }
                    case 2: {
                        double d2 = immunities2.getFireWoundImmunity();
                        return d2;
                    }
                    case 3: {
                        double d2 = immunities2.getBurnImmunity();
                        return d2;
                    }
                    case 4: {
                        double d2 = immunities2.getChemicalBurnImmunity();
                        return d2;
                    }
                    case 5: {
                        double d2 = immunities2.getRadiationImmunity();
                        return d2;
                    }
                    case 6: {
                        double d2 = immunities2.getShockImmunity();
                        return d2;
                    }
                    case 7: {
                        double d2 = immunities2.getExplosionImmunity();
                        return d2;
                    }
                    case 8: {
                        double d2 = immunities2.getStrikeImmunity();
                        return d2;
                    }
                    default: {
                        return 1.0;
                    }
                }
            }
            if (!(jxtc3 instanceof pzde)) return 1.0;
            d = immunities2.getStrikeImmunity();
        }
        return d;
    }

    @NotNull
    public final List<ConfigurationGroup> getConfigurationGroups() {
        return this.configGroups;
    }

    @Nullable
    public final List<MutantSkin> getOverrideSkins() {
        return this.getOverrideSkins(this.common.getSkinSet());
    }

    @Nullable
    public final List<MutantSkin> getOverrideSkins(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "skinsStr");
        Object object = string;
        object = ((Object)StringsKt.trim((CharSequence)object)).toString();
        if (object.length() == 0) {
            return null;
        }
        object = new Regex("([a-zA-Z0-9_]+)\\s*:\\s*(\\d+\\.?\\d*)");
        Object object2 = object;
        String string2 = string;
        String string3 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
        List<MutantSkin> list2 = SequencesKt.toList(SequencesKt.map(Regex.findAll$default((Regex)object2, string3, 0, 2, null), getOverrideSkins.skins.1.INSTANCE));
        if (list2.isEmpty()) {
            return null;
        }
        return list2;
    }

    @NotNull
    public final List<cvzo> getDroppedStuff(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "mutant");
        if (entityMutant.getPreventDrop()) {
            return CollectionsKt.emptyList();
        }
        return ArraysKt.toList((Object[])this.common.getLootConfig()._c());
    }

    @Override
    @Nullable
    public EntityMutant instantiateEntity(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        try {
            Class<? extends EntityMutant> clazz = MutantRegistry.INSTANCE.getRegisteredMobs().get(this.common.getEntityClass());
            if (clazz == null || (clazz = clazz.getConstructor(ozlu.class)) == null || (clazz = (EntityMutant)((Constructor)((Object)clazz)).newInstance(ozlu2)) == null) {
                throw (Throwable)new IllegalArgumentException("No registered mob found for id " + this.common + ".entityClass! Failed to instantiate given monster.");
            }
            Class<? extends EntityMutant> clazz2 = clazz;
            ((EntityMutant)((Object)clazz2)).setConfiguration(this);
            return clazz2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final String toJson() {
        return ConfigJsonHelper.Companion.write(this);
    }

    public final void cloneFrom(@NotNull MutantConfiguration mutantConfiguration) {
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "mutantConfiguration");
        Gson gson2 = new GsonBuilder().registerTypeAdapter((Type)((Object)MutantConfiguration.class), new ConfigurationDeserializer(this){
            final /* synthetic */ MutantConfiguration this$0;

            @NotNull
            public MutantConfiguration provideConfigInstance() {
                return this.this$0;
            }
            {
                this.this$0 = mutantConfiguration;
            }
        }).create();
        gson2.fromJson(mutantConfiguration.toJson(), MutantConfiguration.class);
    }

    @NotNull
    public final MutantConfiguration cloned() {
        return ConfigJsonHelper.Companion.read(this.toJson(), MutantConfiguration.class);
    }

    public MutantConfiguration() {
        MutantConfiguration mutantConfiguration = this;
        Cloneable cloneable = new ArrayList();
        mutantConfiguration.configGroups = cloneable;
        mutantConfiguration = this;
        cloneable = new HashMap();
        mutantConfiguration.configGroupClassMap = cloneable;
        mutantConfiguration = this;
        cloneable = new HashMap();
        mutantConfiguration.inheritField = cloneable;
        this.common = (Companion.Common)this.register((ConfigurationGroup)new Companion.Common());
        this.turn = (Companion.Turn)this.register((ConfigurationGroup)new Companion.Turn());
        this.movement = (Companion.Movement)this.register((ConfigurationGroup)new Companion.Movement());
        this.attack = (Companion.Attack)this.register((ConfigurationGroup)new Companion.Attack());
        this.health = (Companion.Health)this.register((ConfigurationGroup)new Companion.Health());
        this.ai = (Companion.Ai)this.register((ConfigurationGroup)new Companion.Ai());
        this.fear = (Companion.Fear)this.register((ConfigurationGroup)new Companion.Fear());
        this.agro = (Companion.Agression)this.register((ConfigurationGroup)new Companion.Agression());
        this.immunity = (Companion.Immunities)this.register((ConfigurationGroup)new Companion.Immunities());
        this.psidog = (Companion.Psidog)this.register((ConfigurationGroup)new Companion.Psidog());
        this.jumpAttacker = (Companion.JumpAttacker)this.register((ConfigurationGroup)new Companion.JumpAttacker());
        this.krovosos = (Companion.Krovosos)this.register((ConfigurationGroup)new Companion.Krovosos());
        this.giant = (Companion.Pseudogiant)this.register((ConfigurationGroup)new Companion.Pseudogiant());
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion;", "", "()V", "Agression", "Ai", "Attack", "Common", "Fear", "Health", "Immunities", "JumpAttacker", "Krovosos", "Movement", "Pseudogiant", "Psidog", "Turn", "minecraft"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b\u00a8\u0006\u001e"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Common;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "entityClass", "", "getEntityClass", "()Ljava/lang/String;", "setEntityClass", "(Ljava/lang/String;)V", "lootConfig", "Lgloomyfolken/bundle/common/utils/randomloot/RandomLoot;", "getLootConfig", "()Lgloomyfolken/bundle/common/utils/randomloot/RandomLoot;", "setLootConfig", "(Lgloomyfolken/bundle/common/utils/randomloot/RandomLoot;)V", "name", "getName", "setName", "questid", "getQuestid", "setQuestid", "scale", "", "getScale", "()F", "setScale", "(F)V", "skinSet", "getSkinSet", "setSkinSet", "minecraft"})
        public static final class Common
        extends ConfigurationGroup {
            @SerializedName(value="entityClass")
            @EditorProperty(name="\u041a\u043b\u0430\u0441\u0441 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0438", special="mobclass")
            @NotNull
            private String entityClass = "dog";
            @SerializedName(value="name")
            @NotNull
            private String name = "";
            @SerializedName(value="questid")
            @EditorProperty(name="\u041a\u0432\u0435\u0441\u0442\u043e\u0432\u044b\u0439 \u0438\u0434")
            @NotNull
            private String questid = "";
            @SerializedName(value="scale")
            @EditorProperty(name="\u0420\u0430\u0437\u043c\u0435\u0440", min="0.15", max="6.0")
            private float scale = 1.0f;
            @SerializedName(value="loot")
            @NotNull
            private satl lootConfig = new satl();
            @SerializedName(value="skinSet")
            @EditorProperty(name="\u041f\u043e\u043b\u044c\u0437.\u0441\u043f\u0438\u0441\u043e\u043a \u0441\u043a\u0438\u043d\u043e\u0432")
            @NotNull
            private String skinSet = "";

            @NotNull
            public final String getEntityClass() {
                return this.entityClass;
            }

            public final void setEntityClass(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "<set-?>");
                this.entityClass = string;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            public final void setName(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "<set-?>");
                this.name = string;
            }

            @NotNull
            public final String getQuestid() {
                return this.questid;
            }

            public final void setQuestid(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "<set-?>");
                this.questid = string;
            }

            public final float getScale() {
                return this.scale;
            }

            public final void setScale(float f) {
                this.scale = f;
            }

            @NotNull
            public final satl getLootConfig() {
                return this.lootConfig;
            }

            public final void setLootConfig(@NotNull satl satl2) {
                Intrinsics.checkParameterIsNotNull(satl2, "<set-?>");
                this.lootConfig = satl2;
            }

            @NotNull
            public final String getSkinSet() {
                return this.skinSet;
            }

            public final void setSkinSet(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "<set-?>");
                this.skinSet = string;
            }

            public Common() {
                super("common", "\u041e\u0431\u0449\u0435\u0435");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Turn;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "standTurnFactor", "", "getStandTurnFactor", "()F", "setStandTurnFactor", "(F)V", "turnSpeed", "getTurnSpeed", "setTurnSpeed", "walkTurnFactor", "getWalkTurnFactor", "setWalkTurnFactor", "minecraft"})
        public static final class Turn
        extends ConfigurationGroup {
            @SerializedName(value="turnSpeed")
            @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430 (\u0431\u0435\u0433) (\u0433\u0440\u0430\u0434)", min="0.0", max="90")
            private float turnSpeed = 10.0f;
            @SerializedName(value="standTurnFactor")
            @EditorProperty(name="\u041c\u043e\u0434.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430 (\u0441\u0442\u043e\u044f)", min="0.0", max="6.0")
            private float standTurnFactor = 0.3f;
            @SerializedName(value="walkTurnFactor")
            @EditorProperty(name="\u041c\u043e\u0434.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430 (\u0445\u043e\u0434\u044c\u0431\u0430)", min="0.0", max="6.0")
            private float walkTurnFactor = 0.5f;

            public final float getTurnSpeed() {
                return this.turnSpeed;
            }

            public final void setTurnSpeed(float f) {
                this.turnSpeed = f;
            }

            public final float getStandTurnFactor() {
                return this.standTurnFactor;
            }

            public final void setStandTurnFactor(float f) {
                this.standTurnFactor = f;
            }

            public final float getWalkTurnFactor() {
                return this.walkTurnFactor;
            }

            public final void setWalkTurnFactor(float f) {
                this.walkTurnFactor = f;
            }

            public Turn() {
                super("turn", "\u041f\u043e\u0432\u043e\u0440\u043e\u0442");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Movement;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "crawlSpeedFactor", "", "getCrawlSpeedFactor", "()F", "setCrawlSpeedFactor", "(F)V", "damagedSpeedFactor", "getDamagedSpeedFactor", "setDamagedSpeedFactor", "movementSpeed", "getMovementSpeed", "setMovementSpeed", "runSpeedFactor", "getRunSpeedFactor", "setRunSpeedFactor", "slowdownHpThresold", "getSlowdownHpThresold", "setSlowdownHpThresold", "walkBackSpeedFactor", "getWalkBackSpeedFactor", "setWalkBackSpeedFactor", "minecraft"})
        public static final class Movement
        extends ConfigurationGroup {
            @SerializedName(value="movementSpeed")
            @EditorProperty(name="\u0411\u0430\u0437\u043e\u0432\u0430\u044f \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c", min="0.0", max="0.3")
            private float movementSpeed = 0.05f;
            @SerializedName(value="damagedSpeedFactor")
            @EditorProperty(name="\u041c\u043e\u0434.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 \u043f\u0440\u0438 \u0440\u0430\u043d\u0435\u043d\u0438\u0438", min="0.0", max="1.0")
            private float damagedSpeedFactor = 0.7f;
            @SerializedName(value="slowdownHpThresold")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433 %\u0445\u043f \u0434\u043b\u044f \u0437\u0430\u043c\u0435\u0434\u043b\u0435\u043d\u0438\u044f", min="0.0", max="1.0")
            private float slowdownHpThresold = 0.5f;
            @SerializedName(value="runSpeedFactor")
            @EditorProperty(name="\u041c\u043e\u0434.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 (\u0431\u0435\u0433)", min="0.0", max="6.0")
            private float runSpeedFactor = 2.5f;
            @SerializedName(value="crawlSpeedFactor")
            @EditorProperty(name="\u041c\u043e\u0434.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 (\u043a\u0440\u0430\u0434\u044f\u0441\u044c)", min="0.0", max="6.0")
            private float crawlSpeedFactor = 0.5f;
            @SerializedName(value="walkBackSpeedFactor")
            @EditorProperty(name="\u041c\u043e\u0434.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 (\u0437\u0430\u0434\u043e\u043c)", min="0.0", max="6.0")
            private float walkBackSpeedFactor = 0.2f;

            public final float getMovementSpeed() {
                return this.movementSpeed;
            }

            public final void setMovementSpeed(float f) {
                this.movementSpeed = f;
            }

            public final float getDamagedSpeedFactor() {
                return this.damagedSpeedFactor;
            }

            public final void setDamagedSpeedFactor(float f) {
                this.damagedSpeedFactor = f;
            }

            public final float getSlowdownHpThresold() {
                return this.slowdownHpThresold;
            }

            public final void setSlowdownHpThresold(float f) {
                this.slowdownHpThresold = f;
            }

            public final float getRunSpeedFactor() {
                return this.runSpeedFactor;
            }

            public final void setRunSpeedFactor(float f) {
                this.runSpeedFactor = f;
            }

            public final float getCrawlSpeedFactor() {
                return this.crawlSpeedFactor;
            }

            public final void setCrawlSpeedFactor(float f) {
                this.crawlSpeedFactor = f;
            }

            public final float getWalkBackSpeedFactor() {
                return this.walkBackSpeedFactor;
            }

            public final void setWalkBackSpeedFactor(float f) {
                this.walkBackSpeedFactor = f;
            }

            public Movement() {
                super("movement", "\u0414\u0432\u0438\u0436\u0435\u043d\u0438\u0435");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b\u00a8\u0006!"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Attack;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "attackAabbHeight", "", "getAttackAabbHeight", "()D", "setAttackAabbHeight", "(D)V", "attackAabbWidth", "getAttackAabbWidth", "setAttackAabbWidth", "attackCooldown", "", "getAttackCooldown", "()I", "setAttackCooldown", "(I)V", "attackDist", "getAttackDist", "setAttackDist", "attackStrength", "", "getAttackStrength", "()F", "setAttackStrength", "(F)V", "critChance", "getCritChance", "setCritChance", "critStrength", "getCritStrength", "setCritStrength", "minecraft"})
        public static final class Attack
        extends ConfigurationGroup {
            private int attackCooldown = 20;
            @SerializedName(value="attackStrength")
            @EditorProperty(name="\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438", min="0.0", max="200.0")
            private float attackStrength = 3.0f;
            @SerializedName(value="critChance")
            @EditorProperty(name="\u0428\u0430\u043d\u0441 \u043a\u0440\u0438\u0442.\u0443\u0434\u0430\u0440\u0430", min="0.0", max="1.0")
            private double critChance = 0.1;
            @SerializedName(value="critStrength")
            @EditorProperty(name="\u041c\u043e\u0434.\u043a\u0440\u0438\u0442.\u0443\u0434\u0430\u0440\u0430", min="0.0", max="99.0")
            private double critStrength = 2.5;
            @SerializedName(value="attackDist")
            @EditorProperty(name="\u0414\u0438\u0441\u0442. \u0434\u043e \u0446\u0435\u043d\u0442\u0440\u0430 \u0430\u0430\u0431\u0431 \u0430\u0442\u0430\u043a\u0438", min="-10.0", max="10.0")
            private double attackDist = 1.0;
            @SerializedName(value="attackAabbWidth")
            @EditorProperty(name="\u0428\u0438\u0440\u0438\u043d\u0430 \u0430\u0430\u0431\u0431 \u0430\u0442\u0430\u043a\u0438", min="0.0", max="10.0")
            private double attackAabbWidth = 0.65;
            @SerializedName(value="attackAabbHeight")
            @EditorProperty(name="\u0412\u044b\u0441\u043e\u0442\u0430 \u0430\u0430\u0431\u0431 \u0430\u0442\u0430\u043a\u0438", min="0.0", max="10.0")
            private double attackAabbHeight = 0.5;

            public final int getAttackCooldown() {
                return this.attackCooldown;
            }

            public final void setAttackCooldown(int n) {
                this.attackCooldown = n;
            }

            public final float getAttackStrength() {
                return this.attackStrength;
            }

            public final void setAttackStrength(float f) {
                this.attackStrength = f;
            }

            public final double getCritChance() {
                return this.critChance;
            }

            public final void setCritChance(double d) {
                this.critChance = d;
            }

            public final double getCritStrength() {
                return this.critStrength;
            }

            public final void setCritStrength(double d) {
                this.critStrength = d;
            }

            public final double getAttackDist() {
                return this.attackDist;
            }

            public final void setAttackDist(double d) {
                this.attackDist = d;
            }

            public final double getAttackAabbWidth() {
                return this.attackAabbWidth;
            }

            public final void setAttackAabbWidth(double d) {
                this.attackAabbWidth = d;
            }

            public final double getAttackAabbHeight() {
                return this.attackAabbHeight;
            }

            public final void setAttackAabbHeight(double d) {
                this.attackAabbHeight = d;
            }

            public Attack() {
                super("attack", "\u0410\u0442\u0430\u043a\u0430");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Health;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "escapeHealthThresold", "", "getEscapeHealthThresold", "()F", "setEscapeHealthThresold", "(F)V", "maxHealthPoints", "getMaxHealthPoints", "setMaxHealthPoints", "regenRate", "getRegenRate", "setRegenRate", "ultraRegenRateMod", "getUltraRegenRateMod", "setUltraRegenRateMod", "ultraRegenThresold", "getUltraRegenThresold", "setUltraRegenThresold", "minecraft"})
        public static final class Health
        extends ConfigurationGroup {
            @SerializedName(value="maxHealthPoints")
            @EditorProperty(name="\u041c\u0430\u043a\u0441. \u0436\u0438\u0437\u043d\u0435\u0439 (\u043f\u0442.)", min="0.0", max="999999")
            private float maxHealthPoints = 20.0f;
            @SerializedName(value="escapeHealthThresold")
            @EditorProperty(name="\u0411\u0435\u0433\u0441\u0442\u0432\u043e \u043f\u0440\u0438 \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435 (%) <", min="0.0", max="1.0")
            private float escapeHealthThresold = 0.25f;
            @SerializedName(value="regenRate")
            @EditorProperty(name="\u0420\u0435\u0433\u0435\u043d.\u0445\u043f (.\u043f\u0442/\u0442\u0438\u043a)", min="0.0", max="999999")
            private float regenRate = 0.05f;
            @SerializedName(value="ultraRegenThresold")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433 \u043f\u043e\u0432\u044b\u0448.\u0440\u0435\u0433\u0435\u043d.\u0445\u043f (% \u043e\u0442 \u043c\u0430\u043a\u0441.\u0445\u043f) <", min="0.0", max="1")
            private float ultraRegenThresold;
            @SerializedName(value="ultraRegenRateMod")
            @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u043e\u0432\u044b\u0448.\u0440\u0435\u0433\u0435\u043d. (\u043e\u0442 \u0431\u0430\u0437\u044b)", min="0.0", max="999999")
            private float ultraRegenRateMod = 2.0f;

            public final float getMaxHealthPoints() {
                return this.maxHealthPoints;
            }

            public final void setMaxHealthPoints(float f) {
                this.maxHealthPoints = f;
            }

            public final float getEscapeHealthThresold() {
                return this.escapeHealthThresold;
            }

            public final void setEscapeHealthThresold(float f) {
                this.escapeHealthThresold = f;
            }

            public final float getRegenRate() {
                return this.regenRate;
            }

            public final void setRegenRate(float f) {
                this.regenRate = f;
            }

            public final float getUltraRegenThresold() {
                return this.ultraRegenThresold;
            }

            public final void setUltraRegenThresold(float f) {
                this.ultraRegenThresold = f;
            }

            public final float getUltraRegenRateMod() {
                return this.ultraRegenRateMod;
            }

            public final void setUltraRegenRateMod(float f) {
                this.ultraRegenRateMod = f;
            }

            public Health() {
                super("health", "\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Agression;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "agroRatingCurve", "", "getAgroRatingCurve", "()F", "setAgroRatingCurve", "(F)V", "damageRatingMod", "", "getDamageRatingMod", "()D", "setDamageRatingMod", "(D)V", "distanceRatingMod", "getDistanceRatingMod", "setDistanceRatingMod", "enableCreativeAgro", "", "getEnableCreativeAgro", "()Z", "setEnableCreativeAgro", "(Z)V", "reagroThresold", "getReagroThresold", "setReagroThresold", "minecraft"})
        public static final class Agression
        extends ConfigurationGroup {
            @SerializedName(value="reagroThresold")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433.\u043f\u0435\u0440\u0435\u0430\u0433\u0440\u0430 (\u0447\u0435\u043c >, \u0442\u0435\u043c \u0440\u0435\u0436\u0435 \u043f\u0435\u0440\u0435\u0430\u0433\u0440)", min="1.0", max="10.0")
            private float reagroThresold = 1.15f;
            @SerializedName(value="damageRatingMod")
            @EditorProperty(name="\u041c\u043e\u0434.\u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0430 \u043f\u0440\u0438 \u0443\u0440\u043e\u043d\u0435", min="0.0", max="1000.0")
            private double damageRatingMod = 5.0;
            @SerializedName(value="distanceRatingMod")
            @EditorProperty(name="\u041c\u043e\u0434.\u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0430 \u043e\u0442 \u0440\u0430\u0441\u0441\u0442. \u0434\u043e \u0446\u0435\u043b\u0438", min="0.0", max="50.0")
            private double distanceRatingMod = 1.85;
            @SerializedName(value="agroRatingCurve")
            @EditorProperty(name="\u041a\u0440\u0438\u0432\u0430\u044f \u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0430", min="0.0", max="0.99")
            private float agroRatingCurve = 0.973f;
            @SerializedName(value="enableCreativeAgro")
            @EditorProperty(name="\u0410\u0433\u0440 \u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u0432 \u043a\u0440\u0435\u0430\u0442\u0438\u0432\u0435")
            private boolean enableCreativeAgro;

            public final float getReagroThresold() {
                return this.reagroThresold;
            }

            public final void setReagroThresold(float f) {
                this.reagroThresold = f;
            }

            public final double getDamageRatingMod() {
                return this.damageRatingMod;
            }

            public final void setDamageRatingMod(double d) {
                this.damageRatingMod = d;
            }

            public final double getDistanceRatingMod() {
                return this.distanceRatingMod;
            }

            public final void setDistanceRatingMod(double d) {
                this.distanceRatingMod = d;
            }

            public final float getAgroRatingCurve() {
                return this.agroRatingCurve;
            }

            public final void setAgroRatingCurve(float f) {
                this.agroRatingCurve = f;
            }

            public final boolean getEnableCreativeAgro() {
                return this.enableCreativeAgro;
            }

            public final void setEnableCreativeAgro(boolean bl) {
                this.enableCreativeAgro = bl;
            }

            public Agression() {
                super("agro", "\u0410\u0433\u0440\u0435\u0441\u0441\u0438\u044f");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Fear;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "braveryPerAlly", "", "getBraveryPerAlly", "()D", "setBraveryPerAlly", "(D)V", "braveryPerAttack", "getBraveryPerAttack", "setBraveryPerAttack", "fearDecay", "getFearDecay", "setFearDecay", "fearDisableThresold", "getFearDisableThresold", "setFearDisableThresold", "fearEnabled", "", "getFearEnabled", "()Z", "setFearEnabled", "(Z)V", "fearOnScared", "getFearOnScared", "setFearOnScared", "fearPerDamage", "getFearPerDamage", "setFearPerDamage", "fleeFearThresold", "getFleeFearThresold", "setFleeFearThresold", "fleeFearThresoldPeace", "getFleeFearThresoldPeace", "setFleeFearThresoldPeace", "scaledHpFear", "getScaledHpFear", "setScaledHpFear", "minecraft"})
        public static final class Fear
        extends ConfigurationGroup {
            @SerializedName(value="fearEnabled")
            @EditorProperty(name="\u0421\u0442\u0440\u0430\u0445")
            private boolean fearEnabled = true;
            @SerializedName(value="fearPerDamage")
            @EditorProperty(name="\u0421\u0442\u0440\u0430\u0445\u0430 / \u0443\u0440\u043e\u043d (\u043f\u0440\u0438 \u043c\u0438\u043d.\u0445\u043f)", min="0.0", max="1500.0")
            private double fearPerDamage = 2.0;
            @SerializedName(value="scaledHpFear")
            @EditorProperty(name="\u041a\u0440\u0438\u0432\u0430\u044f \u0441\u0442\u0440\u0430\u0445\u0430 \u0434\u043b\u044f % \u0445\u043f (0 = \u043a\u043e\u043d\u0441\u0442\u0430\u043d\u0442\u0430)")
            private double scaledHpFear;
            @SerializedName(value="fearDecay")
            @EditorProperty(name="\u041a\u043e\u044d\u0444.\u0437\u0430\u0442\u0443\u0445\u0430\u043d\u0438\u044f \u0441\u0442\u0440\u0430\u0445\u0430", min="0.0", max="1.0")
            private double fearDecay = 0.98;
            @SerializedName(value="fleeFearThresold")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433 \u0432\u0445\u043e\u0434\u0430 \u0432 \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 \u0441\u0442\u0440\u0430\u0445\u0430", min="0.0", max="1500.0")
            private double fleeFearThresold = 50.0;
            @SerializedName(value="fleeFearThresoldPeace")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433 \u0432\u0445\u043e\u0434\u0430 \u0432 \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 \u0441\u0442\u0440\u0430\u0445\u0430 (\u0432 \u043f\u043e\u043a\u043e\u0435)", min="0.0", max="1500.0")
            private double fleeFearThresoldPeace = 8.0;
            @SerializedName(value="fearDisableThresold")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433 \u0432\u044b\u0445\u043e\u0434\u0430 \u0438\u0437 \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u044f \u0441\u0442\u0440\u0430\u0445\u0430", min="0.0", max="1500.0")
            private double fearDisableThresold = 4.0;
            @SerializedName(value="braveryPerAlly")
            @EditorProperty(name="\u0421\u043d\u0438\u0436\u0435\u043d\u0438\u0435 \u0441\u0442\u0440\u0430\u0445\u0430 / \u0441\u043e\u044e\u0437\u043d\u0438\u043a (\u0432 \u0441\u0435\u043a)", max="1500.0")
            private double braveryPerAlly = 10.0;
            @SerializedName(value="braveryPerAttack")
            @EditorProperty(name="\u0421\u043d\u0438\u0436\u0435\u043d\u0438\u0435 \u0441\u0442\u0440\u0430\u0445\u0430 \u0437\u0430 \u0443\u0434\u0430\u0447\u043d.\u0430\u0442\u0430\u043a\u0443", max="1500.0")
            private double braveryPerAttack = 15.0;
            @SerializedName(value="fearOnScared")
            @EditorProperty(name="\u0414\u043e\u043f.\u0441\u0442\u0440\u0430\u0445\u0430 \u043f\u0440\u0438 \u0438\u0441\u043f\u0443\u0433\u0435", max="1500.0")
            private double fearOnScared = 50.0;

            public final boolean getFearEnabled() {
                return this.fearEnabled;
            }

            public final void setFearEnabled(boolean bl) {
                this.fearEnabled = bl;
            }

            public final double getFearPerDamage() {
                return this.fearPerDamage;
            }

            public final void setFearPerDamage(double d) {
                this.fearPerDamage = d;
            }

            public final double getScaledHpFear() {
                return this.scaledHpFear;
            }

            public final void setScaledHpFear(double d) {
                this.scaledHpFear = d;
            }

            public final double getFearDecay() {
                return this.fearDecay;
            }

            public final void setFearDecay(double d) {
                this.fearDecay = d;
            }

            public final double getFleeFearThresold() {
                return this.fleeFearThresold;
            }

            public final void setFleeFearThresold(double d) {
                this.fleeFearThresold = d;
            }

            public final double getFleeFearThresoldPeace() {
                return this.fleeFearThresoldPeace;
            }

            public final void setFleeFearThresoldPeace(double d) {
                this.fleeFearThresoldPeace = d;
            }

            public final double getFearDisableThresold() {
                return this.fearDisableThresold;
            }

            public final void setFearDisableThresold(double d) {
                this.fearDisableThresold = d;
            }

            public final double getBraveryPerAlly() {
                return this.braveryPerAlly;
            }

            public final void setBraveryPerAlly(double d) {
                this.braveryPerAlly = d;
            }

            public final double getBraveryPerAttack() {
                return this.braveryPerAttack;
            }

            public final void setBraveryPerAttack(double d) {
                this.braveryPerAttack = d;
            }

            public final double getFearOnScared() {
                return this.fearOnScared;
            }

            public final void setFearOnScared(double d) {
                this.fearOnScared = d;
            }

            public Fear() {
                super("fear", "\u0421\u0442\u0440\u0430\u0445");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b,\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001e\u00109\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R\u001e\u0010B\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010!\"\u0004\bD\u0010#R\u001e\u0010E\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010\u000eR\u001e\u0010H\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000e\u00a8\u0006K"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Ai;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "agroDistance", "", "getAgroDistance", "()D", "setAgroDistance", "(D)V", "attackRunaway", "", "getAttackRunaway", "()Z", "setAttackRunaway", "(Z)V", "attacksBeforeRun", "", "getAttacksBeforeRun", "()I", "setAttacksBeforeRun", "(I)V", "avoidsWater", "getAvoidsWater", "setAvoidsWater", "disableAgro", "getDisableAgro", "setDisableAgro", "eyeFov", "getEyeFov", "setEyeFov", "eyeRange", "", "getEyeRange", "()F", "setEyeRange", "(F)V", "failedAttackRunaway", "getFailedAttackRunaway", "setFailedAttackRunaway", "fleeDistance", "getFleeDistance", "setFleeDistance", "followRange", "getFollowRange", "setFollowRange", "hasEyes", "getHasEyes", "setHasEyes", "hasHear", "getHasHear", "setHasHear", "packSearchDistance", "getPackSearchDistance", "setPackSearchDistance", "retreatAllyThresold", "getRetreatAllyThresold", "setRetreatAllyThresold", "runawayRange", "getRunawayRange", "setRunawayRange", "shortReach", "getShortReach", "setShortReach", "soundAmountThresold", "getSoundAmountThresold", "setSoundAmountThresold", "soundLossPerBlock", "getSoundLossPerBlock", "setSoundLossPerBlock", "sticksToPack", "getSticksToPack", "setSticksToPack", "threatens", "getThreatens", "setThreatens", "minecraft"})
        public static final class Ai
        extends ConfigurationGroup {
            @SerializedName(value="disableAgro")
            @EditorProperty(name="\u041e\u0442\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0430\u0433\u0440\u0435\u0441\u0441\u0438\u044e")
            private boolean disableAgro;
            @SerializedName(value="hasEyes")
            @EditorProperty(name="\u0417\u0440\u044f\u0447\u0438\u0439")
            private boolean hasEyes = true;
            @SerializedName(value="hasHear")
            @EditorProperty(name="\u0418\u043c\u0435\u0435\u0442 \u0441\u043b\u0443\u0445")
            private boolean hasHear = true;
            @SerializedName(value="soundAmountThresold")
            @EditorProperty(name="\u041f\u043e\u0440\u043e\u0433.\u0433\u0440\u043e\u043c\u043a\u043e\u0441\u0442\u0438 \u0437\u0432\u0443\u043a\u0430 \u0434\u043b\u044f \u043e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u0438\u044f", min="0", max="999")
            private float soundAmountThresold = 5.0f;
            @SerializedName(value="soundLossPerBlock")
            @EditorProperty(name="\u041f\u043e\u0442\u0435\u0440\u044f \u043a\u043e\u043b-\u0432\u0430 \u0437\u0432\u0443\u043a\u0430 / \u0431\u043b\u043e\u043a", min="0", max="20")
            private float soundLossPerBlock = 0.8f;
            @SerializedName(value="eyeFov")
            @EditorProperty(name="\u0423\u0433\u043e\u043b \u043e\u0431\u0437\u043e\u0440\u0430", min="0", max="360")
            private double eyeFov = 360.0;
            @SerializedName(value="eyeRange")
            @EditorProperty(name="\u0414\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043e\u0431\u0437\u043e\u0440\u0430", min="0", max="64")
            private float eyeRange = 20.0f;
            @SerializedName(value="followRange")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u043f\u0440\u0435\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u043d\u0438\u044f (\u0431\u043b.)", min="0.0", max="64")
            private double followRange = 32.0;
            @SerializedName(value="agroDistance")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0433\u0440\u0435\u0441\u0441\u0438\u0438 (\u0431\u043b.)", min="0.0", max="64")
            private double agroDistance = 32.0;
            @SerializedName(value="packSearchDistance")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u043f\u043e\u0438\u0441\u043a\u0430 \u0441\u0442\u0430\u0438 (\u0431\u043b.)", min="0.0", max="64")
            private double packSearchDistance = 32.0;
            @SerializedName(value="fleeDistance")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u0438\u043d\u0438\u0446\u0438\u0430\u0446\u0438\u0438 \u0431\u0435\u0433\u0441\u0442\u0432\u0430 (\u0431\u043b.)", min="0.0", max="64")
            private double fleeDistance = 32.0;
            @SerializedName(value="threatens")
            @EditorProperty(name="\u041f\u0440\u043e\u0438\u0433\u0440.\u0430\u043d\u0438\u043c\u0430\u0446\u0438\u044e \u0443\u0433\u0440\u043e\u0437\u044b")
            private boolean threatens = true;
            @SerializedName(value="sticksToPack")
            @EditorProperty(name="\u0414\u0435\u0440\u0436\u0438\u0442\u0441\u044f \u0441\u0442\u0430\u0438 (\u0432\u043d\u0435 \u0431\u043e\u044f)")
            private boolean sticksToPack = true;
            @SerializedName(value="avoidsWater")
            @EditorProperty(name="\u0418\u0437\u0431\u0435\u0433\u0430\u0435\u0442 \u0432\u043e\u0434\u044b")
            private boolean avoidsWater = true;
            @SerializedName(value="moveAfterAttack")
            @EditorProperty(name="\u041e\u0442\u0431\u0435\u0433\u0430\u0435\u0442 \u043f\u043e\u0441\u043b\u0435 \u0430\u0442\u0430\u043a\u0438 (\u043c\u0430\u043d\u0435\u0432\u0440)")
            private boolean attackRunaway;
            @SerializedName(value="moveAfterFailedAttack")
            @EditorProperty(name="\u041e\u0442\u0431\u0435\u0433\u0430\u0435\u0442 \u043f\u043e\u0441\u043b\u0435 \u043d\u0435\u0443\u0434\u0430\u0447\u043d\u043e\u0439 \u0430\u0442\u0430\u043a\u0438")
            private boolean failedAttackRunaway;
            @SerializedName(value="shortReach")
            @EditorProperty(name="\u0420\u0430\u0441\u0441\u0442. \u043a\u043e\u0440\u043e\u0442\u043a\u043e\u0439 \u0430\u0442\u0430\u043a\u0438", min="0.0", max="5.0")
            private double shortReach = 2.25;
            @SerializedName(value="runawayRange")
            @EditorProperty(name="\u041e\u0442\u0431\u0435\u0433\u0430\u0442\u044c (\u043f\u043e\u0441\u043b\u0435 \u0430\u0442\u0430\u043a\u0438) \u043d\u0430 (.\u0431\u043b)", min="1", max="16")
            private int runawayRange = 7;
            @SerializedName(value="attacksBeforeRun")
            @EditorProperty(name="\u0423\u0434\u0430\u0447\u043d\u044b\u0445 \u0430\u0442\u0430\u043a \u0434\u043e \u043c\u0430\u043d\u0435\u0432\u0440\u0430", min="1", max="16")
            private int attacksBeforeRun = 2;
            @SerializedName(value="retreatAllyThresold")
            @EditorProperty(name="\u0411\u0435\u0433\u0441\u0442\u0432\u043e, \u0435\u0441\u043b\u0438 \u0441\u043e\u044e\u0437\u043d\u0438\u043a\u043e\u0432 <", min="0", max="10")
            private int retreatAllyThresold;

            public final boolean getDisableAgro() {
                return this.disableAgro;
            }

            public final void setDisableAgro(boolean bl) {
                this.disableAgro = bl;
            }

            public final boolean getHasEyes() {
                return this.hasEyes;
            }

            public final void setHasEyes(boolean bl) {
                this.hasEyes = bl;
            }

            public final boolean getHasHear() {
                return this.hasHear;
            }

            public final void setHasHear(boolean bl) {
                this.hasHear = bl;
            }

            public final float getSoundAmountThresold() {
                return this.soundAmountThresold;
            }

            public final void setSoundAmountThresold(float f) {
                this.soundAmountThresold = f;
            }

            public final float getSoundLossPerBlock() {
                return this.soundLossPerBlock;
            }

            public final void setSoundLossPerBlock(float f) {
                this.soundLossPerBlock = f;
            }

            public final double getEyeFov() {
                return this.eyeFov;
            }

            public final void setEyeFov(double d) {
                this.eyeFov = d;
            }

            public final float getEyeRange() {
                return this.eyeRange;
            }

            public final void setEyeRange(float f) {
                this.eyeRange = f;
            }

            public final double getFollowRange() {
                return this.followRange;
            }

            public final void setFollowRange(double d) {
                this.followRange = d;
            }

            public final double getAgroDistance() {
                return this.agroDistance;
            }

            public final void setAgroDistance(double d) {
                this.agroDistance = d;
            }

            public final double getPackSearchDistance() {
                return this.packSearchDistance;
            }

            public final void setPackSearchDistance(double d) {
                this.packSearchDistance = d;
            }

            public final double getFleeDistance() {
                return this.fleeDistance;
            }

            public final void setFleeDistance(double d) {
                this.fleeDistance = d;
            }

            public final boolean getThreatens() {
                return this.threatens;
            }

            public final void setThreatens(boolean bl) {
                this.threatens = bl;
            }

            public final boolean getSticksToPack() {
                return this.sticksToPack;
            }

            public final void setSticksToPack(boolean bl) {
                this.sticksToPack = bl;
            }

            public final boolean getAvoidsWater() {
                return this.avoidsWater;
            }

            public final void setAvoidsWater(boolean bl) {
                this.avoidsWater = bl;
            }

            public final boolean getAttackRunaway() {
                return this.attackRunaway;
            }

            public final void setAttackRunaway(boolean bl) {
                this.attackRunaway = bl;
            }

            public final boolean getFailedAttackRunaway() {
                return this.failedAttackRunaway;
            }

            public final void setFailedAttackRunaway(boolean bl) {
                this.failedAttackRunaway = bl;
            }

            public final double getShortReach() {
                return this.shortReach;
            }

            public final void setShortReach(double d) {
                this.shortReach = d;
            }

            public final int getRunawayRange() {
                return this.runawayRange;
            }

            public final void setRunawayRange(int n) {
                this.runawayRange = n;
            }

            public final int getAttacksBeforeRun() {
                return this.attacksBeforeRun;
            }

            public final void setAttacksBeforeRun(int n) {
                this.attacksBeforeRun = n;
            }

            public final int getRetreatAllyThresold() {
                return this.retreatAllyThresold;
            }

            public final void setRetreatAllyThresold(int n) {
                this.retreatAllyThresold = n;
            }

            public Ai() {
                super("ai", "\u0418\u0418");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b\u00a8\u0006!"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Immunities;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "burnImmunity", "", "getBurnImmunity", "()D", "setBurnImmunity", "(D)V", "chemicalBurnImmunity", "getChemicalBurnImmunity", "setChemicalBurnImmunity", "explosionImmunity", "getExplosionImmunity", "setExplosionImmunity", "fireWoundImmunity", "getFireWoundImmunity", "setFireWoundImmunity", "radiationImmunity", "getRadiationImmunity", "setRadiationImmunity", "shockImmunity", "getShockImmunity", "setShockImmunity", "strikeImmunity", "getStrikeImmunity", "setStrikeImmunity", "telepaticImmunity", "getTelepaticImmunity", "setTelepaticImmunity", "woundImmunity", "getWoundImmunity", "setWoundImmunity", "minecraft"})
        public static final class Immunities
        extends ConfigurationGroup {
            @SerializedName(value="burnImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u043e\u0436\u043e\u0433\u0430", min="0", max="10")
            private double burnImmunity = 1.0;
            @SerializedName(value="strikeImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0443\u0434\u0430\u0440\u0430", min="0", max="10")
            private double strikeImmunity = 1.0;
            @SerializedName(value="shockImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0448\u043e\u043a\u0430", min="0", max="10")
            private double shockImmunity = 1.0;
            @SerializedName(value="woundImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0443\u043a\u0443\u0441\u043e\u0432", min="0", max="10")
            private double woundImmunity = 1.0;
            @SerializedName(value="radiationImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438", min="0", max="10")
            private double radiationImmunity = 1.0;
            @SerializedName(value="telepaticImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u043f\u0441\u0438-\u0432\u043e\u0437\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f", min="0", max="10")
            private double telepaticImmunity = 1.0;
            @SerializedName(value="chemicalBurnImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0445\u0438\u043c.\u043e\u0436\u043e\u0433\u0430", min="0", max="10")
            private double chemicalBurnImmunity = 1.0;
            @SerializedName(value="explosionImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0432\u0437\u0440\u044b\u0432\u0430", min="0", max="10")
            private double explosionImmunity = 1.0;
            @SerializedName(value="fireWoundImmunity")
            @EditorProperty(name="\u0421\u043e\u0442\u043d\u0438 % \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u043f\u0443\u043b\u044c", min="0", max="10")
            private double fireWoundImmunity = 1.0;

            public final double getBurnImmunity() {
                return this.burnImmunity;
            }

            public final void setBurnImmunity(double d) {
                this.burnImmunity = d;
            }

            public final double getStrikeImmunity() {
                return this.strikeImmunity;
            }

            public final void setStrikeImmunity(double d) {
                this.strikeImmunity = d;
            }

            public final double getShockImmunity() {
                return this.shockImmunity;
            }

            public final void setShockImmunity(double d) {
                this.shockImmunity = d;
            }

            public final double getWoundImmunity() {
                return this.woundImmunity;
            }

            public final void setWoundImmunity(double d) {
                this.woundImmunity = d;
            }

            public final double getRadiationImmunity() {
                return this.radiationImmunity;
            }

            public final void setRadiationImmunity(double d) {
                this.radiationImmunity = d;
            }

            public final double getTelepaticImmunity() {
                return this.telepaticImmunity;
            }

            public final void setTelepaticImmunity(double d) {
                this.telepaticImmunity = d;
            }

            public final double getChemicalBurnImmunity() {
                return this.chemicalBurnImmunity;
            }

            public final void setChemicalBurnImmunity(double d) {
                this.chemicalBurnImmunity = d;
            }

            public final double getExplosionImmunity() {
                return this.explosionImmunity;
            }

            public final void setExplosionImmunity(double d) {
                this.explosionImmunity = d;
            }

            public final double getFireWoundImmunity() {
                return this.fireWoundImmunity;
            }

            public final void setFireWoundImmunity(double d) {
                this.fireWoundImmunity = d;
            }

            public Immunities() {
                super("immunities", "\u0421\u043e\u043f\u0440\u043e\u0442\u0438\u0432\u043b\u0435\u043d\u0438\u044f");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006/"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Psidog;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "cloneConfig", "", "getCloneConfig", "()Ljava/lang/String;", "setCloneConfig", "(Ljava/lang/String;)V", "cloneRespawnCooldown", "", "getCloneRespawnCooldown", "()I", "setCloneRespawnCooldown", "(I)V", "cloneRespawnCooldownVar", "getCloneRespawnCooldownVar", "setCloneRespawnCooldownVar", "cloneSpawnRange", "getCloneSpawnRange", "setCloneSpawnRange", "cloneSpawnRangeVar", "getCloneSpawnRangeVar", "setCloneSpawnRangeVar", "maxCloneCount", "getMaxCloneCount", "setMaxCloneCount", "needsEyeContact", "", "getNeedsEyeContact", "()Z", "setNeedsEyeContact", "(Z)V", "psiDistance", "", "getPsiDistance", "()D", "setPsiDistance", "(D)V", "psiPower", "", "getPsiPower", "()F", "setPsiPower", "(F)V", "filterEditorGroup", "mobType", "minecraft"})
        public static final class Psidog
        extends ConfigurationGroup {
            @SerializedName(value="cloneConfig")
            @EditorProperty(name="\u041a\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044f \u0438\u043b\u043b\u044e\u0437\u0438\u0438", special="mobconfig")
            @NotNull
            private String cloneConfig = "psidog_clone";
            @SerializedName(value="maxCloneCount")
            @EditorProperty(name="\u041c\u0430\u043a\u0441. \u043a\u043b\u043e\u043d\u043e\u0432", min="0", max="10")
            private int maxCloneCount = 3;
            @SerializedName(value="cloneRespawnCooldown")
            @EditorProperty(name="\u041c\u0438\u043d.\u0432\u0440\u0435\u043c\u044f \u0434\u043e \u043d\u043e\u0432\u043e\u0433\u043e \u043a\u043b\u043e\u043d\u0430 (\u0442\u0438\u043a)", min="0", max="999999999")
            private int cloneRespawnCooldown = 20;
            @SerializedName(value="cloneRespawnCooldownVar")
            @EditorProperty(name="\u0420\u0430\u0437\u0431\u0440\u043e\u0441 \u0432\u0440\u0435\u043c\u0435\u043d\u0438 \u0434\u043e \u043d\u043e\u0432\u043e\u0433\u043e \u043a\u043b\u043e\u043d\u0430 (\u0442\u0438\u043a)", min="0", max="999999999")
            private int cloneRespawnCooldownVar = 80;
            @SerializedName(value="cloneSpawnRange")
            @EditorProperty(name="\u0423\u0434\u0430\u043b\u0435\u043d\u043d\u043e\u0441\u0442\u044c \u0441\u043f\u0430\u0432\u043d\u0430 \u043a\u043b\u043e\u043d\u043e\u0432 (\u0431\u043b.)", min="0", max="32")
            private int cloneSpawnRange = 4;
            @SerializedName(value="cloneSpawnRangeVar")
            @EditorProperty(name="\u0420\u0430\u0437\u0431\u0440\u043e\u0441 \u0443\u0434\u0430\u043b\u0435\u043d\u043d\u043e\u0441\u0442\u0438 \u0441\u043f\u0430\u0432\u043d\u0430 \u043a\u043b\u043e\u043d\u043e\u0432 (\u0431\u043b.)", min="0", max="32")
            private int cloneSpawnRangeVar = 3;
            @SerializedName(value="needsEyeContact")
            @EditorProperty(name="\u0422\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044f \u0437\u0440\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u043a\u043e\u043d\u0442\u0430\u043a\u0442")
            private boolean needsEyeContact;
            @SerializedName(value="psiDistance")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f \u043f\u0441\u0438-\u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f", min="0.01", max="16.0")
            private double psiDistance = 3.25;
            @SerializedName(value="psiPower")
            @EditorProperty(name="\u0421\u0438\u043b\u0430 \u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f \u043f\u0441\u0438-\u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f", min="0.0", max="5000.0")
            private float psiPower;

            @NotNull
            public final String getCloneConfig() {
                return this.cloneConfig;
            }

            public final void setCloneConfig(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "<set-?>");
                this.cloneConfig = string;
            }

            public final int getMaxCloneCount() {
                return this.maxCloneCount;
            }

            public final void setMaxCloneCount(int n) {
                this.maxCloneCount = n;
            }

            public final int getCloneRespawnCooldown() {
                return this.cloneRespawnCooldown;
            }

            public final void setCloneRespawnCooldown(int n) {
                this.cloneRespawnCooldown = n;
            }

            public final int getCloneRespawnCooldownVar() {
                return this.cloneRespawnCooldownVar;
            }

            public final void setCloneRespawnCooldownVar(int n) {
                this.cloneRespawnCooldownVar = n;
            }

            public final int getCloneSpawnRange() {
                return this.cloneSpawnRange;
            }

            public final void setCloneSpawnRange(int n) {
                this.cloneSpawnRange = n;
            }

            public final int getCloneSpawnRangeVar() {
                return this.cloneSpawnRangeVar;
            }

            public final void setCloneSpawnRangeVar(int n) {
                this.cloneSpawnRangeVar = n;
            }

            public final boolean getNeedsEyeContact() {
                return this.needsEyeContact;
            }

            public final void setNeedsEyeContact(boolean bl) {
                this.needsEyeContact = bl;
            }

            public final double getPsiDistance() {
                return this.psiDistance;
            }

            public final void setPsiDistance(double d) {
                this.psiDistance = d;
            }

            public final float getPsiPower() {
                return this.psiPower;
            }

            public final void setPsiPower(float f) {
                this.psiPower = f;
            }

            @Override
            public boolean filterEditorGroup(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "mobType");
                return Intrinsics.areEqual(string, "psidog") || Intrinsics.areEqual(string, "psidog_clone");
            }

            public Psidog() {
                super("psidog", "\u041f\u0441\u0438\u0441\u043e\u0431\u0430\u043a\u0430");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$JumpAttacker;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "attackStrength", "", "getAttackStrength", "()F", "setAttackStrength", "(F)V", "filterEditorGroup", "", "mobType", "", "minecraft"})
        public static final class JumpAttacker
        extends ConfigurationGroup {
            @SerializedName(value="attackStrength")
            @EditorProperty(name="\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 \u0432 \u043f\u0440\u044b\u0436\u043a\u0435", min="0.0", max="100.0")
            private float attackStrength = 5.0f;

            public final float getAttackStrength() {
                return this.attackStrength;
            }

            public final void setAttackStrength(float f) {
                this.attackStrength = f;
            }

            @Override
            public boolean filterEditorGroup(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "mobType");
                return Intrinsics.areEqual(string, "chimera") || Intrinsics.areEqual(string, "snork");
            }

            public JumpAttacker() {
                super("jumpAttacker", "\u041f\u0440\u044b\u0433-\u043f\u0440\u044b\u0433");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b\u00a8\u0006."}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Pseudogiant;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "addStompAttackChance", "", "getAddStompAttackChance", "()D", "setAddStompAttackChance", "(D)V", "effectRange", "getEffectRange", "setEffectRange", "radDistance", "getRadDistance", "setRadDistance", "radPower", "", "getRadPower", "()F", "setRadPower", "(F)V", "stompAttackChance", "getStompAttackChance", "setStompAttackChance", "stompCooldown", "", "getStompCooldown", "()I", "setStompCooldown", "(I)V", "stompDamage", "getStompDamage", "setStompDamage", "stompDamageCurve", "getStompDamageCurve", "setStompDamageCurve", "stompImpulse", "getStompImpulse", "setStompImpulse", "stompRange", "getStompRange", "setStompRange", "filterEditorGroup", "", "mobType", "", "minecraft"})
        public static final class Pseudogiant
        extends ConfigurationGroup {
            @SerializedName(value="stompCooldown")
            @EditorProperty(name="\u0412\u0440\u0435\u043c\u044f \u043f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0438 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430", min="0.0", max="9999999.0")
            private int stompCooldown = 60;
            @SerializedName(value="stompRange")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u0443\u0440\u043e\u043d\u0430 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430", min="0.0", max="64.0")
            private double stompRange = 5.0;
            @SerializedName(value="effectRange")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u044d\u0444\u0444\u0435\u043a\u0442\u0430 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430", min="0.0", max="64.0")
            private double effectRange = 7.5;
            @SerializedName(value="stompDamage")
            @EditorProperty(name="\u0423\u0440\u043e\u043d\u0430 \u043e\u0442 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430", min="0.0", max="999999.0")
            private double stompDamage = 5.0;
            @SerializedName(value="stompImpulse")
            @EditorProperty(name="\u0418\u043c\u043f\u0443\u043b\u044c\u0441 \u043e\u0442 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430", min="0.0", max="999999.0")
            private double stompImpulse = 1.0;
            @SerializedName(value="stompDamageCurve")
            @EditorProperty(name="\u041a\u0440\u0438\u0432\u0430\u044f \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430 (1.0 - dist^y)", min="0.0", max="100.0")
            private double stompDamageCurve = 5.0;
            @SerializedName(value="stompAttackChance")
            @EditorProperty(name="\u0428\u0430\u043d\u0441 \u0430\u043a\u0442\u0438\u0432\u0430\u0446\u0438\u0438 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430", min="0.0", max="1.0")
            private double stompAttackChance = 0.25;
            @SerializedName(value="addStompAttackChance")
            @EditorProperty(name="\u0414\u043e\u043f.\u0448\u0430\u043d\u0441 \u0430\u043a\u0442\u0438\u0432\u0430\u0446\u0438\u0438 \u0441\u043f\u0435\u0446\u0443\u0434\u0430\u0440\u0430 \u0437\u0430 \u0432\u0440\u0430\u0433\u0430", min="0.0", max="1.0")
            private double addStompAttackChance = 0.25;
            @SerializedName(value="radDistance")
            @EditorProperty(name="\u0420\u0430\u0434\u0438\u0443\u0441 \u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438", min="0.01", max="16.0")
            private double radDistance = 3.25;
            @SerializedName(value="radPower")
            @EditorProperty(name="\u0421\u0438\u043b\u0430 \u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438", min="0.0", max="5000.0")
            private float radPower = 50.0f;

            public final int getStompCooldown() {
                return this.stompCooldown;
            }

            public final void setStompCooldown(int n) {
                this.stompCooldown = n;
            }

            public final double getStompRange() {
                return this.stompRange;
            }

            public final void setStompRange(double d) {
                this.stompRange = d;
            }

            public final double getEffectRange() {
                return this.effectRange;
            }

            public final void setEffectRange(double d) {
                this.effectRange = d;
            }

            public final double getStompDamage() {
                return this.stompDamage;
            }

            public final void setStompDamage(double d) {
                this.stompDamage = d;
            }

            public final double getStompImpulse() {
                return this.stompImpulse;
            }

            public final void setStompImpulse(double d) {
                this.stompImpulse = d;
            }

            public final double getStompDamageCurve() {
                return this.stompDamageCurve;
            }

            public final void setStompDamageCurve(double d) {
                this.stompDamageCurve = d;
            }

            public final double getStompAttackChance() {
                return this.stompAttackChance;
            }

            public final void setStompAttackChance(double d) {
                this.stompAttackChance = d;
            }

            public final double getAddStompAttackChance() {
                return this.addStompAttackChance;
            }

            public final void setAddStompAttackChance(double d) {
                this.addStompAttackChance = d;
            }

            public final double getRadDistance() {
                return this.radDistance;
            }

            public final void setRadDistance(double d) {
                this.radDistance = d;
            }

            public final float getRadPower() {
                return this.radPower;
            }

            public final void setRadPower(float f) {
                this.radPower = f;
            }

            @Override
            public boolean filterEditorGroup(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "mobType");
                return Intrinsics.areEqual(string, "pseudogigant");
            }

            public Pseudogiant() {
                super("pseudogigant", "\u041f\u0441\u0435\u0432\u0434\u043e\u0433\u0438\u0433\u0430\u043d\u0442");
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration$Companion$Krovosos;", "Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "()V", "chameleonHpThresold", "", "getChameleonHpThresold", "()F", "setChameleonHpThresold", "(F)V", "hpAbsorbTick", "getHpAbsorbTick", "setHpAbsorbTick", "hpSuckTick", "getHpSuckTick", "setHpSuckTick", "kissChance", "getKissChance", "setKissChance", "filterEditorGroup", "", "mobType", "", "minecraft"})
        public static final class Krovosos
        extends ConfigurationGroup {
            @SerializedName(value="chameleonHpThresold")
            @EditorProperty(name="\u0412\u044b\u043a\u043b.\u043d\u0435\u0432\u0438\u0434\u0438\u043c\u043e\u0441\u0442\u0438 \u043f\u0440\u0438 \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435 (%) <", min="0.0", max="1.0")
            private float chameleonHpThresold = 0.5f;
            @SerializedName(value="hpSuckTick")
            @EditorProperty(name="\u0423\u0440\u043e\u043d\u0430/\u0442\u0438\u043a \u043f\u0440\u0438 \u0441\u043e\u0441\u0430\u043d\u0438\u0438", min="0.0", max="999999.0")
            private float hpSuckTick = 0.5f;
            @SerializedName(value="hpAbsorbTick")
            @EditorProperty(name="\u0425\u0438\u043b/\u0442\u0438\u043a \u043f\u0440\u0438 \u0441\u043e\u0441\u0430\u043d\u0438\u0438", min="0.0", max="999999.0")
            private float hpAbsorbTick = 0.75f;
            @SerializedName(value="kissChance")
            @EditorProperty(name="\u0428\u0430\u043d\u0441 \u043f\u043e\u0446\u0435\u043b\u0443\u044f \u043f\u0440\u0438 \u0430\u0442\u0430\u043a\u0435", min="0.0", max="1.0")
            private float kissChance = 0.25f;

            public final float getChameleonHpThresold() {
                return this.chameleonHpThresold;
            }

            public final void setChameleonHpThresold(float f) {
                this.chameleonHpThresold = f;
            }

            public final float getHpSuckTick() {
                return this.hpSuckTick;
            }

            public final void setHpSuckTick(float f) {
                this.hpSuckTick = f;
            }

            public final float getHpAbsorbTick() {
                return this.hpAbsorbTick;
            }

            public final void setHpAbsorbTick(float f) {
                this.hpAbsorbTick = f;
            }

            public final float getKissChance() {
                return this.kissChance;
            }

            public final void setKissChance(float f) {
                this.kissChance = f;
            }

            @Override
            public boolean filterEditorGroup(@NotNull String string) {
                Intrinsics.checkParameterIsNotNull(string, "mobType");
                return Intrinsics.areEqual(string, "krovosos");
            }

            public Krovosos() {
                super("krovosos", "\u041a\u0440\u043e\u0432\u043e\u0441\u043e\u0441");
            }
        }
    }
}

