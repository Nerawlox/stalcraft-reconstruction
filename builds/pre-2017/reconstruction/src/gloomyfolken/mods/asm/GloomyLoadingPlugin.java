/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.hooklib.minecraft.PrimaryClassTransformer;
import gloomyfolken.mods.asm.GloomyTransformer;
import gloomyfolken.mods.asm.MicroTransformer;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Type;

public class GloomyLoadingPlugin
implements IFMLLoadingPlugin {
    private static final String _c = "gloomyfolken/mods/asm/GloomyHooks";
    public static final boolean _a = "true".equals(System.getProperty("singleplayer"));
    static List<MicroTransformer> _b = new ArrayList<MicroTransformer>();

    private static void registerTransformer(String string) {
        try {
            Class<?> clazz = Class.forName(string);
            Constructor<?> constructor = clazz.getConstructor(new Class[0]);
            Object obj = constructor.newInstance(new Object[0]);
            if (obj instanceof MicroTransformer) {
                _b.add((MicroTransformer)obj);
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
    }

    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{GloomyTransformer.class.getName(), PrimaryClassTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.inventory.Slot").setTargetMethod("onSlotChanged").setHookClass(_c).setHookMethod("onSlotChanged").addThisToHookMethodParameters().build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("codechicken.nei.SpawnerRenderer").setTargetMethod("renderInventoryItem").addTargetMethodParameters("net.minecraft.client.renderer.RenderBlocks").addTargetMethodParameters("net.minecraft.item.ItemStack").setReturnCondition(ReturnCondition.ALWAYS).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("CustomSky").setTargetMethod("renderSky").addTargetMethodParameters("net.minecraft.world.World").addTargetMethodParameters("net.minecraft.client.renderer.texture.TextureManager").addTargetMethodParameters(Type.FLOAT_TYPE, Type.FLOAT_TYPE).setReturnCondition(ReturnCondition.ALWAYS).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("org.bukkit.craftbukkit.v1_6_R3.entity.CraftEntity").setTargetMethod("setLastDamageCause").addTargetMethodParameters("org.bukkit.event.entity.EntityDamageEvent").setReturnCondition(ReturnCondition.ALWAYS).build());
        HookLoader.registerHookContainer(_c);
        HookLoader.registerHookContainer("gloomyfolken/mods/asm/GloomyStartHooks");
        HookLoader.registerHookContainer("gloomyfolken/mods/asm/NetworkHooks");
        HookLoader.registerHookContainer("gloomyfolken/mods/asm/ItemAtlasHooks");
        this.registerFileWriteBlockerHooks();
        for (MicroTransformer microTransformer : _b) {
            microTransformer.registerHooks();
        }
    }

    private void registerFileWriteBlockerHooks() {
        String string = "gloomyfolken/mods/asm/FileWriteBlocker";
        HookLoader.registerHookContainer(string);
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("codechicken.nei.PlayerSave").setTargetMethod("save").setHookClass(string).setHookMethod("getBlockFileWrite").setReturnCondition(ReturnCondition.ON_TRUE).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("codechicken.nei.NEIServerConfig").setTargetMethod("saveWorldCompound").setHookClass(string).setHookMethod("getBlockFileWrite").setReturnCondition(ReturnCondition.ON_TRUE).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.smart.moving.config.SmartMovingConfig").setTargetMethod("saveToOptionsFile").addTargetMethodParameters(Type.getType(File.class)).setHookClass(string).setHookMethod("getBlockFileWrite").setReturnCondition(ReturnCondition.ON_TRUE).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("org.bukkit.configuration.file.FileConfiguration").setTargetMethod("save").addTargetMethodParameters(Type.getType(File.class)).setHookClass(string).setHookMethod("getBlockFileWrite").setReturnCondition(ReturnCondition.ON_TRUE).build());
    }

    static {
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.effects.client.asm.EffectsMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.handcuffs.HandcuffsMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.stalker.misc.StalkerMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.smartfix.SmartfixMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.skinarmor.SkinArmorMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.stalker.mobs.StalkerMobsMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.stalker.player.SkeletalSteveMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.physics.ragdolls.RagdollsMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.bigstacks.BigStacksMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("nichiecode.epicka.misc.EpickaMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.stalker.respawn.util.RespawnMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("noppes.npcs.CustomMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("mods.sound.SoundMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("mods.regions.RegionsMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.prestitch.PrestitchMicroTransformer");
        GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.weapon.WeaponMicroTransformer");
        if (!_a) {
            GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.anticheat.AnticheatMicroTransformer");
            GloomyLoadingPlugin.registerTransformer("znw.mods.stalkerguide.StalkerguideMicroTransformer");
            GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.ejection.EjectionMicroTransformer");
            GloomyLoadingPlugin.registerTransformer("gloomyfolken.mods.bundle.BundleMicroTransformer");
            GloomyLoadingPlugin.registerTransformer("mods.chat.ChatMicrotransformer");
            GloomyLoadingPlugin.registerTransformer("mods.pda.AchievementMicrotransformer");
        }
    }
}

