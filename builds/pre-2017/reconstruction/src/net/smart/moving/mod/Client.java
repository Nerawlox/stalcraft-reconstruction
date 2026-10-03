/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.mod;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.smart.moving.LocalUserNameProvider;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingComm;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingHelper;
import net.smart.moving.SmartMovingPacketStream;
import net.smart.moving.SmartMovingServerComm;
import net.smart.moving.config.SmartMovingOptions;
import net.smart.moving.mod.Server;
import net.smart.utilities.Assert;
import net.smart.utilities.Install;
import net.smart.utilities.Name;
import net.smart.utilities.Reflect;
import net.smart.utilities.ResourcePack;

public class Client
extends Server {
    private boolean hasRenderer = Install.hasRenderPlayerAPI;

    public static Client create(mod_SmartMoving mod_SmartMoving2) {
        Logger logger = ModLoader.getLogger();
        Assert.client(logger);
        Assert.clientPlayerAPI(logger);
        Assert.serverPlayerAPI(logger);
        return new Client(mod_SmartMoving2);
    }

    public Client(mod_SmartMoving mod_SmartMoving2) {
        super(mod_SmartMoving2);
        net.smart.moving.playerapi.SmartMoving.register();
        if (this.hasRenderer) {
            Class clazz = Reflect.LoadClass(BaseMod.class, new Name("net.smart.moving.render.playerapi.SmartMoving"), true);
            Method method = Reflect.GetMethod(clazz, new Name("register"), new Class[0]);
            Reflect.Invoke(method, null, new Object[0]);
        } else {
            net.smart.render.mod.Client.doNotAddRenderer();
        }
        SmartMovingServerComm.localUserNameProvider = new LocalUserNameProvider();
    }

    @Override
    public void load() {
        if (!this.hasRenderer) {
            this.hasRenderer = SmartMovingContext.registerAnimation(null);
        }
        ModLoader.setInGameHook(this.mod, true, true);
        ModLoader.registerPacketChannel(this.mod, SmartMovingPacketStream.Id);
        net.smart.moving.playerapi.SmartMovingFactory.initialize();
        this.checkForPresentModsAndInitializeOptions();
        SmartMovingContext.initialize(Minecraft._E()._M, false, ModLoader.getLogger());
        ResourcePack.remove(this.mod.getClass().getSimpleName());
        rpdf.instance = new SmartMovingHelper();
    }

    @Override
    public void modsLoaded() {
    }

    @Override
    public void addRenderer(Map map) {
        if (!this.hasRenderer) {
            this.hasRenderer = SmartMovingContext.registerAnimation(map);
        }
    }

    @Override
    public void registerAnimation(Minecraft minecraft) {
        if (!this.hasRenderer) {
            this.hasRenderer = SmartMovingContext.registerAnimation(null);
        }
    }

    @Override
    public boolean onTickInGame(float f, Minecraft minecraft) {
        SmartMovingContext.onTickInGame();
        return true;
    }

    public void checkForPresentModsAndInitializeOptions() {
        List<BaseMod> list = ModLoader.getLoadedMods();
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        for (int i = 0; i < list.size(); ++i) {
            BaseMod baseMod = list.get(i);
            String string = baseMod.getClass().getSimpleName();
            if (string.equals("mod_RedPowerWiring")) {
                bl = true;
                continue;
            }
            if (string.equals("mod_BuildCraftTransport")) {
                bl2 = true;
                continue;
            }
            if (string.equals("mod_Liquid")) {
                bl3 = true;
                continue;
            }
            if (string.equals("mod_FCBetterThanWolves")) {
                bl4 = true;
                continue;
            }
            if (string.equals("mod_SinglePlayerCommands")) {
                bl5 = true;
                continue;
            }
            if (string.equals("mod_ASGrapplingHook")) {
                bl7 = true;
                continue;
            }
            if (!string.equals("mod_BetterMisc")) continue;
            bl8 = true;
        }
        bl6 = Reflect.CheckClasses(BaseMod.class, Install.RopesPlusCore);
        SmartMovingOptions.initialize(bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8);
    }

    @Override
    public void clientCustomPayload(bscn bscn2, Packet250CustomPayload packet250CustomPayload) {
        SmartMovingPacketStream.receivePacket(packet250CustomPayload, SmartMovingComm.instance, null);
    }

    @Override
    public void receiveCustomPacket(Packet250CustomPayload packet250CustomPayload) {
        SmartMovingPacketStream.receivePacket(packet250CustomPayload, SmartMovingComm.instance, null);
    }

    @Override
    public void onPacket250Received(EntityPlayer entityPlayer, Packet250CustomPayload packet250CustomPayload) {
        SmartMovingPacketStream.receivePacket(packet250CustomPayload, SmartMovingServerComm.instance, net.smart.moving.playerapi.SmartMoving.getServerPlayerBase(entityPlayer));
    }

    @Override
    public SmartMoving getInstance(EntityPlayer entityPlayer) {
        return SmartMovingFactory.getInstance(entityPlayer);
    }
}

