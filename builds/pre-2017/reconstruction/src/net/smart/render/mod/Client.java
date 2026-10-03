/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.mod;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.smart.render.SmartRenderContext;
import net.smart.render.mod.Server;
import net.smart.render.statistics.SmartStatisticsContext;
import net.smart.render.statistics.playerapi.SmartStatistics;
import net.smart.render.statistics.playerapi.SmartStatisticsFactory;
import net.smart.utilities.Assert;
import net.smart.utilities.Install;
import net.smart.utilities.Name;
import net.smart.utilities.Reflect;
import net.smart.utilities.ResourcePack;

public class Client
extends Server {
    private static boolean addRenderer = true;
    private boolean hasRenderer = Install.hasRenderPlayerAPI;

    public static Client create(mod_SmartRender mod_SmartRender2) {
        Logger logger = ModLoader.getLogger();
        Assert.client(logger);
        Assert.clientPlayerAPI(logger);
        return new Client(mod_SmartRender2);
    }

    public Client(mod_SmartRender mod_SmartRender2) {
        super(mod_SmartRender2);
        SmartStatistics.register();
        if (this.hasRenderer) {
            Class clazz = Reflect.LoadClass(BaseMod.class, new Name("net.smart.render.playerapi.SmartRender"), true);
            Method method = Reflect.GetMethod(clazz, new Name("register"), new Class[0]);
            Reflect.Invoke(method, null, new Object[0]);
        }
    }

    public static void doNotAddRenderer() {
        addRenderer = false;
    }

    @Override
    public void load() {
        if (!this.hasRenderer && addRenderer) {
            this.hasRenderer = SmartRenderContext.registerAnimation(null);
        }
        ModLoader.setInGameHook(this.mod, true, true);
        SmartStatisticsFactory.initialize();
        ResourcePack.remove(this.mod.getClass().getSimpleName());
    }

    @Override
    public void addRenderer(Map map) {
        if (!this.hasRenderer && addRenderer) {
            this.hasRenderer = SmartRenderContext.registerAnimation(map);
        }
    }

    @Override
    public void registerAnimation(Minecraft minecraft) {
        if (!this.hasRenderer && addRenderer) {
            this.hasRenderer = SmartRenderContext.registerAnimation(null);
        }
    }

    @Override
    public boolean onTickInGame(float f, Minecraft minecraft) {
        SmartStatisticsContext.onTickInGame();
        return true;
    }

    @Override
    public String toString() {
        return "Smart Render 1.1";
    }
}

