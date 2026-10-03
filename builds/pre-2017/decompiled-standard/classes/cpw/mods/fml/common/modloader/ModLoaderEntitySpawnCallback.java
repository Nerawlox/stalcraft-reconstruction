/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import com.google.common.base.Function;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;

public class ModLoaderEntitySpawnCallback
implements Function<EntitySpawnPacket, Entity> {
    private BaseModProxy mod;
    private EntityRegistry.EntityRegistration registration;
    private boolean isAnimal;

    public ModLoaderEntitySpawnCallback(BaseModProxy baseModProxy, EntityRegistry.EntityRegistration entityRegistration) {
        this.mod = baseModProxy;
        this.registration = entityRegistration;
    }

    @Override
    public Entity apply(EntitySpawnPacket entitySpawnPacket) {
        return ModLoaderHelper.sidedHelper.spawnEntity(this.mod, entitySpawnPacket, this.registration);
    }
}

