/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.primitives.UnsignedBytes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.jgro;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityRegistry {
    private static final EntityRegistry INSTANCE = new EntityRegistry();
    private BitSet availableIndicies;
    private ListMultimap<ModContainer, EntityRegistration> entityRegistrations = ArrayListMultimap.create();
    private Map<String, ModContainer> entityNames = Maps.newHashMap();
    private BiMap<Class<? extends Entity>, EntityRegistration> entityClassRegistrations = HashBiMap.create();

    public static EntityRegistry instance() {
        return INSTANCE;
    }

    private EntityRegistry() {
        this.availableIndicies = new BitSet(256);
        this.availableIndicies.set(1, 255);
        for (Object k : jgro._c.keySet()) {
            this.availableIndicies.clear((Integer)k);
        }
    }

    public static void registerModEntity(Class<? extends Entity> clazz, String string, int n, Object object, int n2, int n3, boolean bl) {
        EntityRegistry.instance().doModEntityRegistration(clazz, string, n, object, n2, n3, bl);
    }

    private void doModEntityRegistration(Class<? extends Entity> clazz, String string, int n, Object object, int n2, int n3, boolean bl) {
        ModContainer modContainer = FMLCommonHandler.instance().findContainerFor(object);
        EntityRegistration entityRegistration = new EntityRegistration(modContainer, clazz, string, n, n2, n3, bl);
        try {
            this.entityClassRegistrations.put(clazz, entityRegistration);
            this.entityNames.put(string, modContainer);
            if (!jgro._b.containsKey(clazz)) {
                String string2 = String.format("%s.%s", modContainer.getModId(), string);
                jgro._b.put(clazz, string2);
                jgro._a.put(string2, clazz);
                FMLLog.finest("Automatically registered mod %s entity %s as %s", modContainer.getModId(), string, string2);
            } else {
                FMLLog.fine("Skipping automatic mod %s entity registration for already registered class %s", modContainer.getModId(), clazz.getName());
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            FMLLog.log(Level.WARNING, illegalArgumentException, "The mod %s tried to register the entity (name,class) (%s,%s) one or both of which are already registered", modContainer.getModId(), string, clazz.getName());
            return;
        }
        this.entityRegistrations.put(modContainer, entityRegistration);
    }

    public static void registerGlobalEntityID(Class<? extends Entity> clazz, String string, int n) {
        if (jgro._b.containsKey(clazz)) {
            ModContainer modContainer = Loader.instance().activeModContainer();
            String string2 = "unknown";
            if (modContainer != null) {
                string2 = modContainer.getModId();
            } else {
                FMLLog.severe("There is a rogue mod failing to register entities from outside the context of mod loading. This is incredibly dangerous and should be stopped.", new Object[0]);
            }
            FMLLog.warning("The mod %s tried to register the entity class %s which was already registered - if you wish to override default naming for FML mod entities, register it here first", string2, clazz);
            return;
        }
        n = EntityRegistry.instance().validateAndClaimId(n);
        jgro._a(clazz, string, n);
    }

    private int validateAndClaimId(int n) {
        int n2 = n;
        if (n < -128) {
            FMLLog.warning("Compensating for modloader out of range compensation by mod : entityId %d for mod %s is now %d", n, Loader.instance().activeModContainer().getModId(), n2);
            n2 += 3000;
        }
        if (n2 < 0) {
            n2 += 127;
        }
        try {
            UnsignedBytes.checkedCast(n2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            FMLLog.log(Level.SEVERE, "The entity ID %d for mod %s is not an unsigned byte and may not work", n, Loader.instance().activeModContainer().getModId());
        }
        if (!this.availableIndicies.get(n2)) {
            FMLLog.severe("The mod %s has attempted to register an entity ID %d which is already reserved. This could cause severe problems", Loader.instance().activeModContainer().getModId(), n);
        }
        this.availableIndicies.clear(n2);
        return n2;
    }

    public static void registerGlobalEntityID(Class<? extends Entity> clazz, String string, int n, int n2, int n3) {
        if (jgro._b.containsKey(clazz)) {
            ModContainer modContainer = Loader.instance().activeModContainer();
            String string2 = "unknown";
            if (modContainer != null) {
                string2 = modContainer.getModId();
            } else {
                FMLLog.severe("There is a rogue mod failing to register entities from outside the context of mod loading. This is incredibly dangerous and should be stopped.", new Object[0]);
            }
            FMLLog.warning("The mod %s tried to register the entity class %s which was already registered - if you wish to override default naming for FML mod entities, register it here first", string2, clazz);
            return;
        }
        EntityRegistry.instance().validateAndClaimId(n);
        jgro._a(clazz, string, n, n2, n3);
    }

    public static void addSpawn(Class<? extends EntityLiving> clazz, int n, int n2, int n3, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        for (BiomeGenBase biomeGenBase : biomeGenBaseArray) {
            List list = biomeGenBase._a(enumCreatureType);
            for (yffo yffo2 : list) {
                if (yffo2._a != clazz) continue;
                yffo2.itemWeight = n;
                yffo2._b = n2;
                yffo2._c = n3;
                break;
            }
            list.add(new yffo(clazz, n, n2, n3));
        }
    }

    public static void addSpawn(String string, int n, int n2, int n3, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        Class clazz = (Class)jgro._a.get(string);
        if (EntityLiving.class.isAssignableFrom(clazz)) {
            EntityRegistry.addSpawn(clazz, n, n2, n3, enumCreatureType, biomeGenBaseArray);
        }
    }

    public static void removeSpawn(Class<? extends EntityLiving> clazz, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        for (BiomeGenBase biomeGenBase : biomeGenBaseArray) {
            Iterator iterator = biomeGenBase._a(enumCreatureType).iterator();
            while (iterator.hasNext()) {
                yffo yffo2 = (yffo)iterator.next();
                if (yffo2._a != clazz) continue;
                iterator.remove();
            }
        }
    }

    public static void removeSpawn(String string, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        Class clazz = (Class)jgro._a.get(string);
        if (EntityLiving.class.isAssignableFrom(clazz)) {
            EntityRegistry.removeSpawn(clazz, enumCreatureType, biomeGenBaseArray);
        }
    }

    public static int findGlobalUniqueEntityId() {
        int n = EntityRegistry.instance().availableIndicies.nextSetBit(0);
        if (n < 0) {
            throw new RuntimeException("No more entity indicies left");
        }
        return n;
    }

    public EntityRegistration lookupModSpawn(Class<? extends Entity> clazz, boolean bl) {
        Class<? extends Entity> clazz2 = clazz;
        do {
            EntityRegistration entityRegistration;
            if ((entityRegistration = (EntityRegistration)this.entityClassRegistrations.get(clazz2)) == null) continue;
            return entityRegistration;
        } while (bl = !Object.class.equals(clazz2 = clazz2.getSuperclass()));
        return null;
    }

    public EntityRegistration lookupModSpawn(ModContainer modContainer, int n) {
        for (EntityRegistration entityRegistration : this.entityRegistrations.get(modContainer)) {
            if (entityRegistration.getModEntityId() != n) continue;
            return entityRegistration;
        }
        return null;
    }

    public boolean tryTrackingEntity(EntityTracker entityTracker, Entity entity) {
        EntityRegistration entityRegistration = this.lookupModSpawn(entity.getClass(), true);
        if (entityRegistration != null) {
            entityTracker._a(entity, entityRegistration.getTrackingRange(), entityRegistration.getUpdateFrequency(), entityRegistration.sendsVelocityUpdates());
            return true;
        }
        return false;
    }

    @Deprecated
    public static EntityRegistration registerModLoaderEntity(Object object, Class<? extends Entity> clazz, int n, int n2, int n3, boolean bl) {
        String string = (String)jgro._b.get(clazz);
        if (string == null) {
            throw new IllegalArgumentException(String.format("The ModLoader mod %s has tried to register an entity tracker for a non-existent entity type %s", Loader.instance().activeModContainer().getModId(), clazz.getCanonicalName()));
        }
        EntityRegistry.instance().doModEntityRegistration(clazz, string, n, object, n2, n3, bl);
        return (EntityRegistration)EntityRegistry.instance().entityClassRegistrations.get(clazz);
    }

    public class EntityRegistration {
        private Class<? extends Entity> entityClass;
        private ModContainer container;
        private String entityName;
        private int modId;
        private int trackingRange;
        private int updateFrequency;
        private boolean sendsVelocityUpdates;
        private Function<EntitySpawnPacket, Entity> customSpawnCallback;
        private boolean usesVanillaSpawning;

        public EntityRegistration(ModContainer modContainer, Class<? extends Entity> clazz, String string, int n, int n2, int n3, boolean bl) {
            this.container = modContainer;
            this.entityClass = clazz;
            this.entityName = string;
            this.modId = n;
            this.trackingRange = n2;
            this.updateFrequency = n3;
            this.sendsVelocityUpdates = bl;
        }

        public Class<? extends Entity> getEntityClass() {
            return this.entityClass;
        }

        public ModContainer getContainer() {
            return this.container;
        }

        public String getEntityName() {
            return this.entityName;
        }

        public int getModEntityId() {
            return this.modId;
        }

        public int getTrackingRange() {
            return this.trackingRange;
        }

        public int getUpdateFrequency() {
            return this.updateFrequency;
        }

        public boolean sendsVelocityUpdates() {
            return this.sendsVelocityUpdates;
        }

        public boolean usesVanillaSpawning() {
            return this.usesVanillaSpawning;
        }

        public boolean hasCustomSpawning() {
            return this.customSpawnCallback != null;
        }

        public Entity doCustomSpawning(EntitySpawnPacket entitySpawnPacket) throws Exception {
            return this.customSpawnCallback.apply(entitySpawnPacket);
        }

        public void setCustomSpawning(Function<EntitySpawnPacket, Entity> function, boolean bl) {
            this.customSpawnCallback = function;
            this.usesVanillaSpawning = bl;
        }
    }
}

