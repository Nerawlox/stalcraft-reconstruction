/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.smart.render.mod.Client;
import net.smart.render.mod.Mod;
import net.smart.render.mod.None;
import net.smart.render.mod.Server;
import net.smart.utilities.Assert;
import net.smart.utilities.Install;

public class mod_SmartRender
extends BaseMod {
    public final Mod mod = !Assert.singleton(mod_SmartRender.class, "Smart Render", ModLoader.getLogger()) ? None.create(this) : (Install.hasClient ? Client.create(this) : Server.create(this));

    public static void doNotAddRenderer() {
        Client.doNotAddRenderer();
    }

    @Override
    public void load() {
        this.mod.load();
    }

    public void addRenderer(Map map) {
        this.mod.addRenderer(map);
    }

    @Override
    public void registerAnimation(Minecraft minecraft) {
        this.mod.registerAnimation(minecraft);
    }

    @Override
    public boolean onTickInGame(float f, Minecraft minecraft) {
        return this.mod.onTickInGame(f, minecraft);
    }

    @Override
    public String getName() {
        return this.mod.getName();
    }

    @Override
    public String getVersion() {
        return this.mod.getVersion();
    }

    @Override
    public String toString() {
        return this.mod.toString();
    }
}

