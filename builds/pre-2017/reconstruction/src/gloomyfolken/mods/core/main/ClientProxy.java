/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.main;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.screens.GuiConfirmation;
import gloomyfolken.mods.core.client.gui.screens.GuiModGameOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiOptionsSlider;
import gloomyfolken.mods.core.main.CommonProxy;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.effects.client.main.pidb;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.RenderBlockFluidHook;
import org.apache.commons.lang3.ArrayUtils;

@ezey(_a={eidj.CLIENT})
public class ClientProxy
extends CommonProxy {
    public static final int STORED_NOTIFICATIONS = 50;
    public static final int DISPLAYED_NOTIFICATIONS = 3;
    public static ntte ticker;
    public static final File notificationsStorage;
    public dwtr controller;
    public static LinkedList<bqdo> notifications;
    public static boolean notificationsChanged;
    public static ntsy screenCenterMessage;
    public static cttw neiHelper;
    public static dfsc carpenterHelper;
    public static List<nttf> gameHandlers;
    private List<KeyBinding> bindings = new ArrayList<KeyBinding>();
    private List<ofux> handlers = new ArrayList<ofux>();
    public static KeyBinding answerBinding;
    public static KeyBinding viewNotification;
    public static KeyBinding interactBinding;
    public static KeyBinding useBinding;
    public static xqrx graphicsPreset;
    public static sbcg autoWaypoints;
    public static sbcg hideNotifications;
    public static sbcg hideThrowMarker;
    public static xqrx mouseSensitivity;
    public static xqrx musicVolume;
    public static xqrx soundVolume;
    public static xqrx blockRenderDistance;
    public static xqrx particleRenderDistance;
    public static xqrx decorblockRenderDistance;
    public static xqrx fov;
    public static jykp antialiasingMode;
    public static sbcg fxaaOn;
    public static jykp filteringModeModels;
    public static jykp filteringModeBlocks;
    public static jykp textureQualityBlocks;
    public static jykp particlesQuality;
    public static sbcg softParticles;
    public static jykp softLighting;
    public static jykp detailsAmount;
    public static sbcg animatedTextures;
    public static sbcg grass;
    public static jykp vegetation;
    public static EffectOptionBoolean multithreadLoading;
    public static sbcg memoryMapping;
    public static sbcg vsync;
    public static sbcg occlusionCulling;
    public static xqrx fpsLimit;
    public static jykp chunkLoaderType;
    public static sbcg dynamicLights;
    public static sbcg highRenderDistance;
    public static GuiScreen containerScreenParent;
    private static Runnable presetLowest;
    private static Runnable presetLow;
    private static Runnable presetMid;
    private static Runnable presetHigh;
    private static Runnable presetHighest;
    private static final int minRenderDistance = 32;
    private static final int maxRenderDistance = 128;
    private static final int renderDistanceTypes = 6;
    private static final Runnable[] presets;
    private static final String[] presetsNames;
    private static final String[] filteringModes;
    private static final String[] textureQualities;
    public static int PING;

    public KeyBinding addKeyBinding(KeyBinding keyBinding, ofux ofux2) {
        this.bindings.add(keyBinding);
        this.handlers.add(ofux2);
        return keyBinding;
    }

    @Override
    public void load() {
        uhip._a._a();
        ClientProxy.loadNotifications(notificationsStorage);
        ticker = new ntte();
        TickRegistry.registerTickHandler(ticker, Side.CLIENT);
        TickRegistry.registerTickHandler(new bqno(), Side.CLIENT);
        MinecraftForge.EVENT_BUS.register(new piuf());
        MinecraftForge.EVENT_BUS.register(new ntsz());
        neiHelper = new cttw();
        carpenterHelper = new dfsc();
        this.setupOldDefaultOptions();
        this.registerGameOptions();
        this.registerSoundOptions();
        this.registerVideoOptions();
        try {
            this.registerPerformanceOptions();
        }
        catch (Throwable throwable) {
            Logger.severe("EffectsAPI not found", new Object[0]);
            throwable.printStackTrace();
        }
        ytsw._b();
        McDummySlot.registerClickListener(Item.class, itemStack -> {
            ezfa ezfa2;
            if (itemStack._a() instanceof ezfa && (ezfa2 = (ezfa)((Object)itemStack._a()))._a_((ItemStack)itemStack)) {
                Minecraft minecraft = Minecraft._E();
                minecraft._a(ezfa2._a(minecraft._B, minecraft._t, (ItemStack)itemStack, -1));
            }
        });
        RenderingRegistry.registerBlockHandler(FluidRegistry.renderIdFluid, RenderBlockFluidHook.hookedInstance);
        Logger.info("Proxy loaded!", new Object[0]);
    }

    public void tickInGame() {
        if (neiHelper != null) {
            neiHelper._a();
        }
        for (nttf nttf2 : gameHandlers) {
            nttf2.onTickInGame();
        }
        if (screenCenterMessage != null && screenCenterMessage._a()) {
            screenCenterMessage = null;
        }
        if (ntte._b % 20L == 0L) {
            new ycxm(System.currentTimeMillis()).sendToServer();
        }
    }

    private static void loadNotifications(File file) {
        if (!file.exists()) {
            return;
        }
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));){
            Collection<bqdo> collection = bqdo._a(dataInputStream);
            notifications.clear();
            notifications.addAll(collection);
            ClientProxy.cleanUpNotifications();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        notifications.sort(Comparator.comparing(bqdo::_b));
        ClientProxy.cleanUpNotifications();
    }

    private static void cleanUpNotifications() {
        while (notifications.size() > 50) {
            notifications.removeFirst();
            notificationsChanged = true;
        }
    }

    public static void publishNotification(bqdo bqdo2) {
        notifications.add(bqdo2);
        ClientProxy.cleanUpNotifications();
        bqdo2._a = System.currentTimeMillis();
        notificationsChanged = true;
    }

    public static void publishScreenCenterMessage(ntsy ntsy2) {
        if (screenCenterMessage == null || ClientProxy.screenCenterMessage._b <= ntsy2._b) {
            screenCenterMessage = ntsy2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void saveNotifications() {
        LinkedList<bqdo> linkedList = notifications;
        synchronized (linkedList) {
            System.out.println("Saving " + notifications.size() + " notifications...");
            ClientProxy.storeNotifications(notificationsStorage);
        }
    }

    private static void storeNotifications(File file) {
        if (file.exists()) {
            file.delete();
        }
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));){
            bqdo._a(notifications, dataOutputStream);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void setupOldDefaultOptions() {
        dynamicLights = new sbcg("use_flashlight", "\u0414\u0438\u043d\u0430\u043c\u0438\u0447\u0435\u0441\u043a\u043e\u0435 \u043e\u0441\u0432\u0435\u0449\u0435\u043d\u0438\u0435", true);
        highRenderDistance = new sbcg("high_entity_render_distance", "\u0414\u0430\u043b\u044c\u043d\u044f\u044f \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0430 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439", true);
    }

    private void registerGameOptions() {
        mouseSensitivity = new xqrx("mouse_sensitivity", "\u0427\u0443\u0432\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043c\u044b\u0448\u0438", 100, 0, 200){

            @Override
            public String getName() {
                String string = String.valueOf(this.value) + "%";
                if (this.value == this.getMinValue()) {
                    string = "\u041c\u0438\u043d\u0438\u043c\u0443\u043c";
                } else if (this.value == this.getMaxValue()) {
                    string = "\u041c\u0430\u043a\u0441\u0438\u043c\u0443\u043c";
                }
                return this.localizedName + ": " + string;
            }

            @Override
            public void onChanged(boolean bl) {
                Minecraft._E()._M.setOptionFloatValue(EnumOptions._d, this.getSliderValue());
            }
        };
        autoWaypoints = new sbcg("use_auto_waypoints", "\u0410\u0432\u0442\u043e\u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u043c\u0435\u0442\u043e\u043a", true);
        hideNotifications = new sbcg("hide_notifications", "\u0421\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u043d\u043d\u044b\u0435 \u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u044f", true);
        hideThrowMarker = new sbcg("hide_throw_marker", "\u0421\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u043c\u0430\u0440\u043a\u0435\u0440 \u0431\u0440\u043e\u0441\u043a\u0430", false);
        GloomyAPI.registerOption(mouseSensitivity);
        GloomyAPI.registerOption(autoWaypoints);
        GloomyAPI.registerOption(hideNotifications);
        GloomyAPI.registerOption(hideThrowMarker);
    }

    private void registerSoundOptions() {
        soundVolume = new xqrx("sound_volume", "\u0413\u0440\u043e\u043c\u043a\u043e\u0441\u0442\u044c \u0437\u0432\u0443\u043a\u043e\u0432", 50, 0, 100){

            @Override
            public void onChanged(boolean bl) {
                Minecraft._E()._M.setOptionFloatValue(EnumOptions._b, this.getSliderValue());
            }
        };
        musicVolume = new xqrx("music_volume", "\u0413\u0440\u043e\u043c\u043a\u043e\u0441\u0442\u044c \u043c\u0443\u0437\u044b\u043a\u0438", 50, 0, 100){

            @Override
            public void onChanged(boolean bl) {
                Minecraft._E()._M.setOptionFloatValue(EnumOptions._a, this.getSliderValue());
            }
        };
        GloomyAPI.registerSoundOption(soundVolume);
        GloomyAPI.registerSoundOption(musicVolume);
    }

    private void registerVideoOptions() {
        graphicsPreset = new xqrx("graphics_preset", "\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e \u0433\u0440\u0430\u0444\u0438\u043a\u0438", 3, 0, presets.length - 1){
            private boolean ignoreChangeEvent;
            private int prevValue;
            {
                this.ignoreChangeEvent = false;
                this.prevValue = this.value;
            }

            @Override
            public String getName() {
                return this.localizedName + ": " + presetsNames[this.value];
            }

            @Override
            public void onSliderChanged(GuiOptionsSlider guiOptionsSlider) {
                int n = presets.length - 1;
                guiOptionsSlider.sliderValue = (float)((int)((double)(guiOptionsSlider.sliderValue * (float)n) + 0.5)) / (float)n;
                super.onSliderChanged(guiOptionsSlider);
            }

            @Override
            public void onChanged(boolean bl) {
                if (bl && this.prevValue != this.value) {
                    this.prevValue = this.value;
                    presets[this.value].run();
                }
            }

            @Override
            public void load(Configuration configuration) {
                super.load(configuration);
                this.prevValue = this.value;
            }

            @Override
            public void applyLoadedState() {
            }
        };
        decorblockRenderDistance = new xqrx("tiles_render_distance", "\u0414\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0438 \u0434\u0435\u043a\u043e\u0440. \u0431\u043b\u043e\u043a\u043e\u0432", 64, 32, 128){

            @Override
            public void onSliderChanged(GuiOptionsSlider guiOptionsSlider) {
                guiOptionsSlider.sliderValue = (float)((int)((double)(guiOptionsSlider.sliderValue * 6.0f) + 0.5)) / 6.0f;
                super.onSliderChanged(guiOptionsSlider);
            }
        };
        particleRenderDistance = new xqrx("particle_render_distance", "\u0414\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0438 \u0447\u0430\u0441\u0442\u0438\u0446", 64, 32, 128){

            @Override
            public void onSliderChanged(GuiOptionsSlider guiOptionsSlider) {
                guiOptionsSlider.sliderValue = (float)((int)((double)(guiOptionsSlider.sliderValue * 6.0f) + 0.5)) / 6.0f;
                super.onSliderChanged(guiOptionsSlider);
            }
        };
        blockRenderDistance = new xqrx("blocks_render_distance", "\u0414\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0438 \u0431\u043b\u043e\u043a\u043e\u0432", 64, 32, 128){

            @Override
            public void onSliderChanged(GuiOptionsSlider guiOptionsSlider) {
                guiOptionsSlider.sliderValue = (float)((int)((double)(guiOptionsSlider.sliderValue * 6.0f) + 0.5)) / 6.0f;
                super.onSliderChanged(guiOptionsSlider);
            }

            @Override
            public void onChanged(boolean bl) {
                uhip._a._a(this.value);
            }
        };
        fov = new xqrx("fov", "\u041f\u043e\u043b\u0435 \u0437\u0440\u0435\u043d\u0438\u044f", 70, 70, 110){

            @Override
            public void onChanged(boolean bl) {
                Minecraft._E()._M.setOptionFloatValue(EnumOptions._e, this.getSliderValue());
                Minecraft._E()._M.saveOptions();
            }
        };
        antialiasingMode = new jykp("antialiasing_mode", "\u0421\u0433\u043b\u0430\u0436\u0438\u0432\u0430\u043d\u0438\u0435", 0, new String[]{"NONE", "MSAA2X", "MSAA4X", "MSAA8X", "CSAA8X", "CSAA16X", "CSAA8xQ", "CSAA16xQ"});
        fxaaOn = new sbcg("fxaa", "FXAA", false);
        filteringModeModels = new jykp("filtering_mode", "\u0424\u0438\u043b\u044c\u0442\u0440\u0430\u0446\u0438\u044f \u043c\u043e\u0434\u0435\u043b\u0435\u0439", pidb._c().ordinal(), filteringModes){

            @Override
            public void onChanged(boolean bl) {
                pidb._a(anxd.values()[this.value]);
                qmdg._a._c();
            }
        };
        filteringModeBlocks = new jykp("filtering_mode_blocks", "\u0424\u0438\u043b\u044c\u0442\u0440\u0430\u0446\u0438\u044f \u0431\u043b\u043e\u043a\u043e\u0432", 4, filteringModes){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._a(anxd.values()[this.value]);
            }
        };
        int n = uhip._a._c(textureQualities.length - 1);
        String[] stringArray = new String[n + 1];
        System.arraycopy(textureQualities, 0, stringArray, 0, stringArray.length);
        textureQualityBlocks = new jykp("texture_quality_blocks", "\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e \u0442\u0435\u043a\u0441\u0442\u0443\u0440 \u0431\u043b\u043e\u043a\u043e\u0432", n - 1, stringArray){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._d(this.value);
            }

            @Override
            public void load(Configuration configuration) {
                this.value = uhip._a._c(configuration.get("general", this.unlocalizedName, this.value).getInt(this.value));
                sctd._f._r = uhip._a._b(this.value);
            }
        };
        particlesQuality = new jykp("particles_quality", "\u0420\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u0438\u0435 \u0447\u0430\u0441\u0442\u0438\u0446", 0, new String[]{"\u0421\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435", "\u041d\u0438\u0437\u043a\u043e\u0435"});
        softParticles = new sbcg("soft_particles", "\u041c\u044f\u0433\u043a\u0438\u0435 \u0447\u0430\u0441\u0442\u0438\u0446\u044b", true);
        softLighting = new jykp("soft_lighting", "\u041c\u044f\u0433\u043a\u043e\u0435 \u043e\u0441\u0432\u0435\u0449\u0435\u043d\u0438\u0435", 2, new String[]{"\u0412\u044b\u043a\u043b", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435"}){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._e(this.value);
            }
        };
        detailsAmount = new jykp("details_amount", "\u0414\u0435\u0442\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u044f", 1, new String[]{"\u041d\u0438\u0437\u043a\u0430\u044f", "\u0421\u0440\u0435\u0434\u043d\u044f\u044f", "\u0412\u044b\u0441\u043e\u043a\u0430\u044f", "\u041c\u0430\u043a\u0441\u0438\u043c\u0443\u043c"}){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._a(this.value > 0);
                MinecraftForge.EVENT_BUS.post(new xqrl(this.value));
            }
        };
        animatedTextures = new sbcg("animated_textures", "\u0410\u043d\u0438\u043c\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0435 \u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b", false){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._b(false);
            }
        };
        grass = new sbcg("grass", "\u0422\u0440\u0430\u0432\u0430", true){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._c(this.enabled);
            }
        };
        vegetation = new jykp("vegetation", "\u0420\u0430\u0441\u0442\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c", 0, new String[]{"\u041d\u0438\u0437\u043a\u0430\u044f", "\u0421\u0440\u0435\u0434\u043d\u044f\u044f", "\u0412\u044b\u0441\u043e\u043a\u0430\u044f"}){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._f(this.value);
            }
        };
        GloomyAPI.registerVideoOption(graphicsPreset);
        GloomyAPI.registerVideoOption(blockRenderDistance);
        GloomyAPI.registerVideoOption(particleRenderDistance);
        GloomyAPI.registerVideoOption(decorblockRenderDistance);
        GloomyAPI.registerVideoOption(fov);
        GloomyAPI.registerVideoOption(antialiasingMode);
        GloomyAPI.registerVideoOption(fxaaOn);
        GloomyAPI.registerVideoOption(filteringModeModels);
        GloomyAPI.registerVideoOption(filteringModeBlocks);
        GloomyAPI.registerVideoOption(textureQualityBlocks);
        GloomyAPI.registerVideoOption(particlesQuality);
        GloomyAPI.registerVideoOption(softParticles);
        GloomyAPI.registerVideoOption(softLighting);
        GloomyAPI.registerVideoOption(detailsAmount);
        GloomyAPI.registerVideoOption(animatedTextures);
        GloomyAPI.registerVideoOption(grass);
        GloomyAPI.registerVideoOption(vegetation);
    }

    private void registerPerformanceOptions() {
        fpsLimit = new xqrx("fps_limit", "\u041b\u0438\u043c\u0438\u0442 \u043a\u0430\u0434\u0440\u043e\u0432", 200, 30, 200){

            @Override
            public String getName() {
                String string = String.valueOf(this.value);
                if (this.value == this.getMaxValue()) {
                    string = "Max FPS";
                }
                return this.localizedName + ": " + string;
            }

            @Override
            public void onChanged(boolean bl) {
                uhip._a._a((float)(this.value - this.getMinValue()) / (float)(this.getMaxValue() - this.getMinValue()));
            }
        };
        vsync = new sbcg("vsyncEnabled", "\u0412\u0435\u0440\u0442\u0438\u043a\u0430\u043b\u044c\u043d\u0430\u044f \u0441\u0438\u043d\u0445\u0440\u043e\u043d\u0438\u0437\u0430\u0446\u0438\u044f", false){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._d(this.enabled);
            }
        };
        chunkLoaderType = new jykp("chunk_loader_type_new", "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430 \u0447\u0430\u043d\u043a\u043e\u0432", 1, new String[]{"\u0421\u0442\u0430\u043d\u0434\u0430\u0440\u0442", "\u041c\u0443\u043b\u044c\u0442\u0438\u043f\u043e\u0442\u043e\u0447\u043d\u0430\u044f"}){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._g(this.value);
            }
        };
        occlusionCulling = new sbcg("occlusion_culling", "Occlusion Culling", true){

            @Override
            public void onChanged(boolean bl) {
                uhip._a._e(this.enabled);
            }
        };
        multithreadLoading = new EffectOptionBoolean("multithread_loading", "\u041c\u0443\u043b\u044c\u0442\u0438\u043f\u043e\u0442\u043e\u0447\u043d\u0430\u044f \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0430", pidb._d()){

            @Override
            public void onChanged(boolean bl) {
                pidb._b(this.enabled);
            }
        };
        memoryMapping = new EffectOptionBoolean("memory_mapping", "Memory mapped \u0444\u0430\u0439\u043b\u044b", pidb._f()){

            @Override
            public void onChanged(boolean bl) {
                pidb._d(this.enabled);
            }
        };
        GloomyAPI.registerPerformanceOption(fpsLimit);
        GloomyAPI.registerPerformanceOption(vsync);
        GloomyAPI.registerPerformanceOption(chunkLoaderType);
        GloomyAPI.registerPerformanceOption(occlusionCulling);
        GloomyAPI.registerPerformanceOption(multithreadLoading);
        GloomyAPI.registerPerformanceOption(memoryMapping);
    }

    @Override
    public void registerRenderers() {
    }

    public void initWorldStatics() {
        if (Minecraft._E()._r == null) {
            if (Minecraft._E()._t != null) {
                ncwh._a(Minecraft._E()._t)._c();
            }
            for (nttf nttf2 : gameHandlers) {
                nttf2.onGameJoined();
            }
        }
    }

    public void onWorldLoaded(pkix pkix2) {
        if (pkix2 == null && Minecraft._E()._r != null) {
            for (nttf nttf2 : gameHandlers) {
                nttf2.onGameLeft();
            }
            screenCenterMessage = null;
        }
    }

    private bqdo getLastNotification() {
        LinkedList<bqdo> linkedList = notifications;
        if (linkedList.isEmpty()) {
            return null;
        }
        return (bqdo)linkedList.get(linkedList.size() - 1);
    }

    public static void openConfirmation(bqdo bqdo2) {
        iuww iuww2 = bqdo2._e();
        GuiConfirmation guiConfirmation = new GuiConfirmation(null, iuww2.getConfirmationText(bqdo2)).setOnConfirm(() -> iuww2.onAction(bqdo2, true)).setOnDecline(() -> iuww2.onAction(bqdo2, false));
        Minecraft._E()._a(guiConfirmation);
    }

    private void registerControlKeys() {
        GameSettings gameSettings = Minecraft._E()._M;
        gameSettings.keyBindUseItem._d = -5;
        gameSettings.keyBindings = ArrayUtils.removeElement(gameSettings.keyBindings, gameSettings.keyBindUseItem);
        answerBinding = this.addKeyBinding(new KeyBinding("\u041e\u0442\u0432\u0435\u0442\u0438\u0442\u044c \u043d\u0430 \u0437\u0430\u043f\u0440\u043e\u0441", 21), () -> {
            bqdo bqdo2 = this.getLastNotification();
            if (bqdo2 == null) {
                return;
            }
            iuww iuww2 = bqdo2._e();
            if (iuww2.getViewType(bqdo2) == iuww.kjui._a) {
                ClientProxy.openConfirmation(bqdo2);
                notifications.remove(bqdo2);
                notificationsChanged = true;
            }
        });
        viewNotification = this.addKeyBinding(new KeyBinding("\u041f\u0440\u043e\u0441\u043c\u043e\u0442\u0440\u0435\u0442\u044c \u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u0435", 37), () -> {
            bqdo bqdo2 = this.getLastNotification();
            if (bqdo2 == null) {
                return;
            }
            iuww iuww2 = bqdo2._e();
            if (iuww2.getViewType(bqdo2) == iuww.kjui._b) {
                iuww2.onAction(bqdo2, false);
                if (ClientProxy.hideNotifications.enabled) {
                    notifications.remove(bqdo2);
                    notificationsChanged = true;
                }
            }
        });
        interactBinding = this.addKeyBinding(new KeyBinding("\u0412\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c", 33), () -> {
            Minecraft minecraft = Minecraft._E();
            if (minecraft._t == null) {
                return;
            }
            MovingObjectPosition movingObjectPosition = minecraft._L;
            if (movingObjectPosition == null) {
                return;
            }
            if (MinecraftForge.EVENT_BUS.post(new piyh(minecraft._t, movingObjectPosition))) {
                return;
            }
            if (movingObjectPosition._c == EnumMovingObjectType._b) {
                new ncww(movingObjectPosition._i.entityId).sendToServer();
                movingObjectPosition._i.interactFirst(minecraft._t);
            } else {
                float f = (float)movingObjectPosition._h._c - (float)movingObjectPosition._d;
                float f2 = (float)movingObjectPosition._h._d - (float)movingObjectPosition._e;
                float f3 = (float)movingObjectPosition._h._e - (float)movingObjectPosition._f;
                new mqvh(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f, movingObjectPosition._g, f, f2, f3).sendToServer();
                int n = minecraft._r.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f);
                Block block = Block.blocksList[n];
                if (block != null) {
                    block.onBlockActivated(minecraft._r, movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f, minecraft._t, movingObjectPosition._g, f, f2, f3);
                }
            }
        });
        useBinding = this.addKeyBinding(new KeyBinding("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442", -99), () -> {
            int n;
            int n2;
            Minecraft minecraft = Minecraft._E();
            if (minecraft._t == null) {
                return;
            }
            if (minecraft._t.capabilities._d) {
                minecraft._b(1);
                return;
            }
            MovingObjectPosition movingObjectPosition = minecraft._L;
            boolean bl = true;
            ItemStack itemStack = minecraft._t.inventory._a();
            int n3 = n2 = itemStack != null ? itemStack._b : 0;
            if (movingObjectPosition != null && movingObjectPosition._c == EnumMovingObjectType._b) {
                new sbez(movingObjectPosition._i.entityId).sendToServer();
                if (MinecraftForge.EVENT_BUS.post(new bqug(minecraft._t, movingObjectPosition._i, itemStack))) {
                    bl = false;
                    minecraft._t.swingItem();
                }
            }
            if (movingObjectPosition != null && movingObjectPosition._c == EnumMovingObjectType._a) {
                boolean bl2;
                int n4 = movingObjectPosition._d;
                n = movingObjectPosition._e;
                int n5 = movingObjectPosition._f;
                int n6 = movingObjectPosition._g;
                boolean bl3 = bl2 = !ForgeEventFactory.onPlayerInteract(minecraft._t, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, n4, n, n5, n6).isCanceled();
                if (bl2 && this.useItemOnBlock(minecraft._t, minecraft._r, itemStack, n4, n, n5, n6, movingObjectPosition._h)) {
                    bl = false;
                    minecraft._t.swingItem();
                }
            }
            if (itemStack == null) {
                return;
            }
            if (itemStack._b == 0) {
                minecraft._t.inventory._a[minecraft._t.inventory._c] = null;
            } else if (itemStack._b != n2 || minecraft._j._i()) {
                minecraft._D.itemRenderer.resetEquippedProgress();
            }
            if (bl) {
                ItemStack itemStack2 = minecraft._t.inventory._a();
                int n7 = n = !ForgeEventFactory.onPlayerInteract(minecraft._t, PlayerInteractEvent.Action.RIGHT_CLICK_AIR, 0, 0, 0, -1).isCanceled() ? 1 : 0;
                if (n != 0 && itemStack2 != null && this.sendUseItem(minecraft._t, minecraft._r, itemStack2)) {
                    minecraft._D.itemRenderer.resetEquippedProgress2();
                }
            }
        });
        KeyBinding[] keyBindingArray = new KeyBinding[this.bindings.size()];
        for (int i = 0; i < keyBindingArray.length; ++i) {
            keyBindingArray[i] = this.bindings.get(i);
        }
        boolean[] blArray = new boolean[this.bindings.size()];
        for (int i = 0; i < blArray.length; ++i) {
            blArray[i] = true;
        }
        this.controller = new dwtr(keyBindingArray, blArray, this.handlers);
        KeyBindingRegistry.registerKeyBinding(this.controller);
    }

    private boolean useItemOnBlock(EntityPlayer entityPlayer, World world, ItemStack itemStack, int n, int n2, int n3, int n4, Vec3 vec3) {
        ItemBlock itemBlock;
        vlzh vlzh2 = Minecraft._E()._j;
        vlzh2._f();
        float f = (float)vec3._c - (float)n;
        float f2 = (float)vec3._d - (float)n2;
        float f3 = (float)vec3._e - (float)n3;
        if (itemStack != null && itemStack._a() != null && itemStack._a().onItemUseFirst(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3)) {
            return true;
        }
        if (itemStack != null && itemStack._a() instanceof ItemBlock && !(itemBlock = (ItemBlock)itemStack._a()).canPlaceItemBlockOnSide(world, n, n2, n3, n4, entityPlayer, itemStack)) {
            return false;
        }
        new fmbw(n, n2, n3, n4, f, f2, f3).sendToServer();
        if (itemStack == null) {
            return false;
        }
        if (vlzh2._k._d()) {
            int n5 = itemStack._j();
            int n6 = itemStack._b;
            boolean bl = itemStack._a(entityPlayer, world, n, n2, n3, n4, f, f2, f3);
            itemStack._b(n5);
            itemStack._b = n6;
            return bl;
        }
        if (!itemStack._a(entityPlayer, world, n, n2, n3, n4, f, f2, f3)) {
            return false;
        }
        if (itemStack._b <= 0) {
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, itemStack));
        }
        return true;
    }

    private boolean sendUseItem(EntityPlayer entityPlayer, World world, ItemStack itemStack) {
        vlzh vlzh2 = Minecraft._E()._j;
        vlzh2._f();
        new wnrx().sendToServer();
        int n = itemStack._b;
        ItemStack itemStack2 = itemStack._a(world, entityPlayer);
        if (itemStack2 == itemStack && itemStack2._b == n) {
            return false;
        }
        entityPlayer.inventory._a[entityPlayer.inventory._c] = itemStack2;
        if (itemStack2._b <= 0) {
            entityPlayer.inventory._a[entityPlayer.inventory._c] = null;
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, itemStack2));
        }
        return true;
    }

    @Override
    public void postLoad() {
        this.registerControlKeys();
        zwrx._a();
        try {
            Class<KeyBindingRegistry> clazz = KeyBindingRegistry.class;
            Field field = clazz.getDeclaredField("keyHandlers");
            field.setAccessible(true);
            Set set = (Set)field.get(KeyBindingRegistry.instance());
            for (KeyBindingRegistry.KeyHandler keyHandler : set) {
                Field field2;
                int n;
                if (!keyHandler.getClass().getName().equals("poersch.minecraft.util.keyhandler.KeyReleasedHandler") || (n = (field2 = keyHandler.getClass().getDeclaredField("id")).getInt(keyHandler)) != 0) continue;
                Logger.finest("Removing Toggle BetterGrass key binding!", new Object[0]);
                Field field3 = KeyBindingRegistry.KeyHandler.class.getDeclaredField("keyBindings");
                field3.setAccessible(true);
                field3.set(keyHandler, new KeyBinding[0]);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void loadOptions() {
        Configuration configuration = GloomyCore.mcconfig;
        for (anpn anpn2 : GuiModGameOptions.options) {
            anpn2.load(configuration);
        }
        for (anpn anpn2 : GuiModVideoOptions.options) {
            anpn2.load(configuration);
        }
    }

    public static boolean isGameRunning() {
        Minecraft minecraft = Minecraft._E();
        return minecraft._r != null && (!minecraft._I() || minecraft._B == null || !minecraft._B.doesGuiPauseGame());
    }

    public void registerGameHandler(nttf nttf2) {
        gameHandlers.add(nttf2);
    }

    static {
        notificationsStorage = new File(Minecraft._E()._P, "./config/notifications.dat");
        notifications = new LinkedList();
        notificationsChanged = false;
        gameHandlers = new ArrayList<nttf>();
        presetLowest = () -> {
            ClientProxy.blockRenderDistance.value = 64;
            ClientProxy.particleRenderDistance.value = 32;
            ClientProxy.decorblockRenderDistance.value = 32;
            ClientProxy.antialiasingMode.value = 0;
            ClientProxy.fxaaOn.enabled = false;
            ClientProxy.filteringModeModels.value = 0;
            ClientProxy.textureQualityBlocks.value = 1;
            ClientProxy.filteringModeBlocks.value = 0;
            ClientProxy.particlesQuality.value = 1;
            ClientProxy.softLighting.value = 0;
            ClientProxy.softParticles.enabled = false;
            ClientProxy.detailsAmount.value = 0;
            ClientProxy.grass.enabled = false;
            ClientProxy.animatedTextures.enabled = false;
            ClientProxy.vegetation.value = 0;
        };
        presetLow = () -> {
            ClientProxy.blockRenderDistance.value = 96;
            ClientProxy.particleRenderDistance.value = 48;
            ClientProxy.decorblockRenderDistance.value = 48;
            ClientProxy.antialiasingMode.value = 0;
            ClientProxy.fxaaOn.enabled = false;
            ClientProxy.filteringModeModels.value = 1;
            ClientProxy.textureQualityBlocks.value = 1;
            ClientProxy.filteringModeBlocks.value = 1;
            ClientProxy.particlesQuality.value = 1;
            ClientProxy.softLighting.value = 1;
            ClientProxy.softParticles.enabled = false;
            ClientProxy.detailsAmount.value = 1;
            ClientProxy.grass.enabled = false;
            ClientProxy.animatedTextures.enabled = false;
            ClientProxy.vegetation.value = 1;
        };
        presetMid = () -> {
            ClientProxy.blockRenderDistance.value = 112;
            ClientProxy.particleRenderDistance.value = 64;
            ClientProxy.decorblockRenderDistance.value = 64;
            ClientProxy.antialiasingMode.value = 0;
            ClientProxy.fxaaOn.enabled = true;
            ClientProxy.filteringModeModels.value = 2;
            ClientProxy.textureQualityBlocks.value = 2;
            ClientProxy.filteringModeBlocks.value = 2;
            ClientProxy.particlesQuality.value = 0;
            ClientProxy.softLighting.value = 1;
            ClientProxy.softParticles.enabled = false;
            ClientProxy.detailsAmount.value = 2;
            ClientProxy.grass.enabled = false;
            ClientProxy.animatedTextures.enabled = false;
            ClientProxy.vegetation.value = 2;
        };
        presetHigh = () -> {
            ClientProxy.blockRenderDistance.value = 128;
            ClientProxy.particleRenderDistance.value = 80;
            ClientProxy.decorblockRenderDistance.value = 80;
            ClientProxy.antialiasingMode.value = 1;
            ClientProxy.fxaaOn.enabled = true;
            ClientProxy.filteringModeModels.value = 4;
            ClientProxy.textureQualityBlocks.value = 3;
            ClientProxy.filteringModeBlocks.value = 4;
            ClientProxy.particlesQuality.value = 0;
            ClientProxy.softLighting.value = 2;
            ClientProxy.softParticles.enabled = true;
            ClientProxy.detailsAmount.value = 2;
            ClientProxy.grass.enabled = true;
            ClientProxy.animatedTextures.enabled = false;
            ClientProxy.vegetation.value = 2;
        };
        presetHighest = () -> {
            ClientProxy.blockRenderDistance.value = 128;
            ClientProxy.particleRenderDistance.value = 96;
            ClientProxy.decorblockRenderDistance.value = 96;
            ClientProxy.antialiasingMode.value = 1;
            ClientProxy.fxaaOn.enabled = true;
            ClientProxy.filteringModeModels.value = 5;
            ClientProxy.textureQualityBlocks.value = 3;
            ClientProxy.filteringModeBlocks.value = 5;
            ClientProxy.particlesQuality.value = 0;
            ClientProxy.softLighting.value = 2;
            ClientProxy.softParticles.enabled = true;
            ClientProxy.detailsAmount.value = 2;
            ClientProxy.grass.enabled = true;
            ClientProxy.animatedTextures.enabled = true;
            ClientProxy.vegetation.value = 2;
        };
        presets = new Runnable[]{presetLowest, presetLow, presetMid, presetHigh, presetHighest};
        presetsNames = new String[]{"\u041c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435", "\u041d\u0438\u0436\u0435 \u0441\u0440\u0435\u0434\u043d\u0435\u0433\u043e", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0448\u0435 \u0441\u0440\u0435\u0434\u043d\u0435\u0433\u043e", "\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435"};
        filteringModes = new String[]{"\u041d\u0435\u0442", "\u0411\u0438\u043b\u0438\u043d\u0435\u0439\u043d\u0430\u044f", "\u0422\u0440\u0438\u043b\u0438\u043d\u0435\u0439\u043d\u0430\u044f", "\u0410\u043d\u0438\u0437\u043e\u0442\u0440\u043e\u043f\u043d\u0430\u044f 2\u0445", "\u0410\u043d\u0438\u0437\u043e\u0442\u0440\u043e\u043f\u043d\u0430\u044f 4\u0445", "\u0410\u043d\u0438\u0437\u043e\u0442\u0440\u043e\u043f\u043d\u0430\u044f 8\u0445", "\u0410\u043d\u0438\u0437\u043e\u0442\u0440\u043e\u043f\u043d\u0430\u044f 16\u0445"};
        textureQualities = new String[]{"\u041d\u0438\u0437\u043a\u043e\u0435", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435", "\u041c\u0430\u043a\u0441\u0438\u043c\u0443\u043c"};
        PING = 0;
    }

    public static abstract class EffectOptionBoolean
    extends sbcg {
        public EffectOptionBoolean(String string, String string2, boolean bl) {
            super(string, string2, bl);
        }

        @Override
        public void save(Configuration configuration) {
            pidb._g();
        }

        @Override
        public void load(Configuration configuration) {
            if (configuration.hasKey("general", this.getName())) {
                this.enabled = configuration.get("general", this.getName(), this.enabled).getBoolean(this.enabled);
            }
            this.onChanged(false);
        }
    }
}

