/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.server;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.MapDifference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.EntitySpawnAdjustmentPacket;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.network.ModMissingPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.entity.Entity;
import net.minecraft.util.gomc;

public class FMLServerHandler
implements IFMLSidedHandler {
    private static final FMLServerHandler INSTANCE = new FMLServerHandler();
    private dzfd server;
    private static final Pattern assetENUSLang = Pattern.compile("assets/(.*)/lang/en_US.lang");

    private FMLServerHandler() {
        FMLCommonHandler.instance().beginLoading(this);
    }

    @Override
    public void beginServerLoading(dzfd dzfd2) {
        this.server = dzfd2;
        Loader.instance().loadMods();
    }

    @Override
    public void finishServerLoading() {
        Loader.instance().initializeMods();
        LanguageRegistry.reloadLanguageTable();
        GameData.initializeServerGate(1);
    }

    @Override
    public void haltGame(String string, Throwable throwable) {
        throw new RuntimeException(string, throwable);
    }

    @Override
    public dzfd getServer() {
        return this.server;
    }

    public static FMLServerHandler instance() {
        return INSTANCE;
    }

    @Override
    public List<String> getAdditionalBrandingInformation() {
        return ImmutableList.of();
    }

    @Override
    public Side getSide() {
        return Side.SERVER;
    }

    @Override
    public void showGuiScreen(Object object) {
    }

    @Override
    public Entity spawnEntityIntoClientWorld(EntityRegistry.EntityRegistration entityRegistration, EntitySpawnPacket entitySpawnPacket) {
        return null;
    }

    @Override
    public void adjustEntityLocationOnClient(EntitySpawnAdjustmentPacket entitySpawnAdjustmentPacket) {
    }

    @Override
    public void sendPacket(cezg cezg2) {
        throw new RuntimeException("You cannot send a bare packet without a target on the server!");
    }

    @Override
    public void displayMissingMods(ModMissingPacket modMissingPacket) {
    }

    @Override
    public void handleTinyPacket(elai elai2, yexp yexp2) {
    }

    @Override
    public void setClientCompatibilityLevel(byte by) {
    }

    @Override
    public byte getClientCompatibilityLevel() {
        return 0;
    }

    @Override
    public boolean shouldServerShouldBeKilledQuietly() {
        return false;
    }

    @Override
    public void disconnectIDMismatch(MapDifference<Integer, ItemData> mapDifference, elai elai2, jjpj jjpj2) {
    }

    @Override
    public void addModAsResource(ModContainer modContainer) {
        File file = modContainer.getSource();
        try {
            if (file.isDirectory()) {
                this.searchDirForENUSLanguage(file, "");
            } else {
                this.searchZipForENUSLanguage(file);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    private void searchZipForENUSLanguage(File file) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        for (ZipEntry zipEntry : Collections.list(zipFile.entries())) {
            Matcher matcher = assetENUSLang.matcher(zipEntry.getName());
            if (!matcher.matches()) continue;
            FMLLog.fine("Injecting found translation data in zip file %s at %s into language system", file.getName(), zipEntry.getName());
            gomc._a(zipFile.getInputStream(zipEntry));
        }
        zipFile.close();
    }

    private void searchDirForENUSLanguage(File file, String string) throws IOException {
        for (File file2 : file.listFiles()) {
            Matcher matcher;
            String string2 = string + file2.getName();
            if (file2.isDirectory()) {
                this.searchDirForENUSLanguage(file2, string2 + '/');
            }
            if (!(matcher = assetENUSLang.matcher(string2)).matches()) continue;
            FMLLog.fine("Injecting found translation data at %s into language system", string2);
            gomc._a(new FileInputStream(file2));
        }
    }

    @Override
    public void updateResourcePackList() {
    }

    @Override
    public String getCurrentLanguage() {
        return "en_US";
    }

    @Override
    public void serverStopped() {
    }
}

