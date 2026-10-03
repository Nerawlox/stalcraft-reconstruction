/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.guimaker;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import gloomyfolken.mods.core.main.GloomyAPI;
import java.util.List;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import znw.mods.guimaker.GuiMakerHandler;

@Mod(modid="znwguimaker", name="ZnW's GuiMaker Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class GuiMakerMod {
    public static final String modid = "znwguimaker";
    @Mod.Instance(value="znwguimaker")
    public static GuiMakerMod instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("guimaker", this.getClass());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        NetworkRegistry.instance().registerGuiHandler(this, new GuiMakerHandler());
    }

    @Mod.EventHandler
    public void initServer(FMLServerStartingEvent fMLServerStartingEvent) {
        fMLServerStartingEvent.registerServerCommand(new CallGuiEditor());
    }

    static class CallGuiEditor
    implements ICommand {
        CallGuiEditor() {
        }

        @Override
        public String getCommandName() {
            return "mkgui";
        }

        @Override
        public String getCommandUsage(ICommandSender iCommandSender) {
            return null;
        }

        @Override
        public List getCommandAliases() {
            return null;
        }

        @Override
        public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
            try {
                String string = iCommandSender.getCommandSenderName();
                if (!(iCommandSender instanceof EntityPlayer)) {
                    return;
                }
                EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
                World world = entityPlayer.getEntityWorld();
                int n = (int)entityPlayer.posX;
                int n2 = (int)entityPlayer.posY;
                int n3 = (int)entityPlayer.posZ;
                entityPlayer.openGui(instance, 0, world, n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        @Override
        public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
            return true;
        }

        @Override
        public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
            return Lists.asList("mkgui", new String[0]);
        }

        @Override
        public boolean isUsernameIndex(String[] stringArray, int n) {
            return false;
        }

        public int compareTo(Object object) {
            return 0;
        }
    }
}

