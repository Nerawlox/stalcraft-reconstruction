/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.collect.MapDifference;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.EntitySpawnAdjustmentPacket;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.network.ModMissingPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.relauncher.Side;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;

public interface IFMLSidedHandler {
    public List<String> getAdditionalBrandingInformation();

    public Side getSide();

    public void haltGame(String var1, Throwable var2);

    public void showGuiScreen(Object var1);

    public Entity spawnEntityIntoClientWorld(EntityRegistry.EntityRegistration var1, EntitySpawnPacket var2);

    public void adjustEntityLocationOnClient(EntitySpawnAdjustmentPacket var1);

    public void beginServerLoading(MinecraftServer var1);

    public void finishServerLoading();

    public MinecraftServer getServer();

    public void sendPacket(Packet var1);

    public void displayMissingMods(ModMissingPacket var1);

    public void handleTinyPacket(NetHandler var1, yexp var2);

    public void setClientCompatibilityLevel(byte var1);

    public byte getClientCompatibilityLevel();

    public boolean shouldServerShouldBeKilledQuietly();

    public void disconnectIDMismatch(MapDifference<Integer, ItemData> var1, NetHandler var2, jjpj var3);

    public void addModAsResource(ModContainer var1);

    public void updateResourcePackList();

    public String getCurrentLanguage();

    public void serverStopped();
}

