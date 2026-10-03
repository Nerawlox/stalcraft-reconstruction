/*
 * Decompiled with CFR 0.152.
 */
package mods.sound;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;
import mods.sound.SoundBlock;
import mods.sound.client.ClientSoundController;
import mods.sound.client.SoundDebugCommand;
import mods.sound.client.SoundStarterThread;
import mods.sound.client.SoundTickCommand;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="SoundMod")
public class SoundMod {
    public static final ResourceLocation SOUNDS_CONFIG = new ResourceLocation("stalkersounds", "sounds_locations.json");
    public static boolean visualDebug = false;
    public static SoundBlock soundBlock;
    @ezey(_a={eidj.CLIENT})
    public static sbcg simulateEnvironment;
    @Mod.Instance(value="SoundMod")
    public static SoundMod instance;
    @ezey(_a={eidj.CLIENT})
    public ClientSoundController soundController;
    @ezey(_a={eidj.CLIENT})
    public static SoundStarterThread starterThread;
    public static long mainThreadId;

    @Mod.EventHandler
    @ezey(_a={eidj.CLIENT})
    public void preLoad(FMLPreInitializationEvent fMLPreInitializationEvent) {
        mainThreadId = Thread.currentThread().getId();
        MinecraftForge.EVENT_BUS.register(EnvironmentProcessor.instance);
        simulateEnvironment = new sbcg("simulate_environment", "\u0421\u0438\u043c\u0443\u043b\u044f\u0446\u0438\u044f \u0437\u0432\u0443\u043a\u043e\u0432\u043e\u0433\u043e \u043e\u043a\u0440\u0443\u0436\u0435\u043d\u0438\u044f", true);
        GloomyAPI.registerSoundOption(simulateEnvironment);
    }

    @Mod.EventHandler
    public void onLoad(FMLInitializationEvent fMLInitializationEvent) {
        soundBlock = (SoundBlock)new SoundBlock(3999).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.sound");
        GameRegistry.registerBlock((Block)soundBlock, "soundblock");
        LanguageRegistry.addName(soundBlock, "\u0418\u0441\u0442\u043e\u0447\u043d\u0438\u043a \u0437\u0432\u0443\u043a\u0430");
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> this.initClient());
        InvokeSideOnly.frontend(fMLInitializationEvent.getSide().isServer(), () -> {});
    }

    @ezey(_a={eidj.CLIENT})
    public void initClient() {
        starterThread = new SoundStarterThread();
        starterThread.setName("SoundStarterThread");
        starterThread.start();
        this.soundController = new ClientSoundController();
        this.soundController.loadSoundsFrom("stalkersounds", "/");
        MinecraftForge.EVENT_BUS.register(this.soundController);
        GloomyAPI.registerGameHandler(this.soundController);
        GloomyAPI.registerAssetsDir("stalkersounds", SoundMod.class);
        ClientCommandHandler.instance.registerCommand(new SoundDebugCommand());
        ClientCommandHandler.instance.registerCommand(new SoundTickCommand());
    }

    static {
        mainThreadId = -1L;
    }
}

