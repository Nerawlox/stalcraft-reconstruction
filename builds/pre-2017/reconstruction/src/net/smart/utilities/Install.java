/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

import cpw.mods.fml.common.FMLCommonHandler;
import java.lang.reflect.Field;
import java.util.logging.Logger;
import net.minecraft.logging.ILogAgent;
import net.minecraft.logging.LogAgent;
import net.smart.utilities.Name;
import net.smart.utilities.Reflect;

public class Install {
    public static final Name Main = new Name("net.minecraft.client.main.Main");
    public static final Name ModLoader = new Name("net.minecraft.src.ModLoader", "ModLoader");
    public static final Name ForgeHooks = new Name("net.minecraftforge.common.ForgeHooks");
    public static final Name Bukkit = new Name("org.bukkit.Bukkit");
    public static final Name RopesPlusCore = new Name("atomicstryker.ropesplus.common.RopesPlusCore");
    public static final Name ModBlockFence = new Name("net.minecraft.src.modBlockFence", "modBlockFence");
    public static final Name MacroModCore = new Name("net.eq2online.macros.core.MacroModCore");
    public static final Name BlockSturdyLadder = new Name("mods.chupmacabre.ladderKit.sturdyLadders.BlockSturdyLadder");
    public static final Name BlockRopeLadder = new Name("mods.chupmacabre.ladderKit.ropeLadders.BlockRopeLadder");
    public static final Name ForgeHooksClient = new Name("net.minecraftforge.client.ForgeHooksClient");
    public static final Name RopesPlusClient = new Name("atomicstryker.ropesplus.client.RopesPlusClient");
    public static final Name RopesPlusClient_onZipLine = new Name("onZipLine");
    public static final Name NetServerHandler_minecraftServer = new Name("mcServer", "field_72573_d", "d");
    public static final Name NetServerHandler_ticksForFloatKick = new Name("ticksForFloatKick", "field_72572_g", "f");
    public static final Name NetworkListenThread_playerList = new Name("connections", "_b", "c");
    public static final Name Minecraft_resourcePacks = new Name("defaultResourcePacks", "__al", "aq");
    public static final Name GuiNewChat_chatMessageList = new Name("chatLines", "_c", "c");
    public static final Name PlayerControllerMP_currentGameType = new Name("currentGameType", "_k", "k");
    public static final Name ModelRenderer_compiled = new Name("compiled", "field_78812_q", "t");
    public static final Name ModelRenderer_compileDisplayList = new Name("compileDisplayList", "func_78788_d", "d");
    public static final Name ModelRenderer_displayList = new Name("displayList", "field_78811_r", "u");
    public static final Name RenderPlayer_modelBipedMain = new Name("modelBipedMain", "field_77109_a", "f");
    public static final Name RenderPlayer_modelArmorChestplate = new Name("modelArmorChestplate", "field_77108_b", "g");
    public static final Name RenderPlayer_modelArmor = new Name("modelArmor", "field_77111_i", "h");
    public static final Name RenderManager_entityRenderMap = new Name("entityRenderMap", "_a", "q");
    public static final Name LogAgent_logger = new Name("serverLogger", "_a", "a");
    public static final Name ForgeHooks_onLivingJump = new Name("onLivingJump");
    public static final Name ModifiableAttributeInstance_attributeValue = new Name("_h", "_h", "h");
    public static final boolean hasClient = FMLCommonHandler.instance().getEffectiveSide().isClient();
    public static final boolean hasClientPlayerAPI = Install.hasAPI("Client");
    public static final boolean hasServerPlayerAPI = Install.hasAPI("Server");
    public static final boolean hasRenderPlayerAPI = Install.hasAPI("Render");
    public static final boolean hasModLoader = Reflect.CheckClasses(Install.class, ModLoader);
    public static final boolean hasMinecraftForge = Reflect.CheckClasses(Install.class, ForgeHooks);
    public static final boolean hasBukkit = Reflect.CheckClasses(Install.class, Bukkit);
    public final String obfuscatedName;
    public final String deobfuscatedName;
    private static final Field _logger = Reflect.GetField(LogAgent.class, LogAgent_logger);

    private static boolean hasAPI(String string) {
        String string2 = "api.player." + string.substring(0, 1).toLowerCase() + string.substring(1) + "." + string + "Player";
        return Reflect.CheckClasses(Install.class, new Name(string2 + "API"), new Name(string2 + "BaseSorter"));
    }

    public Install(String string) {
        this(string, null);
    }

    public Install(String string, String string2) {
        this.deobfuscatedName = string;
        this.obfuscatedName = string2;
    }

    public static Logger getLogger(ILogAgent iLogAgent) {
        return iLogAgent instanceof LogAgent ? (Logger)Reflect.GetField(_logger, iLogAgent) : null;
    }
}

