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
import net.minecraft.entity.player.EntityPlayer;
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
    implements kmew {
        CallGuiEditor() {
        }

        @Override
        public String func_71517_b() {
            return "mkgui";
        }

        @Override
        public String func_71518_a(nemo nemo2) {
            return null;
        }

        @Override
        public List func_71514_a() {
            return null;
        }

        @Override
        public void func_71515_b(nemo nemo2, String[] stringArray) {
            try {
                String string = nemo2.func_70005_c_();
                if (!(nemo2 instanceof EntityPlayer)) {
                    return;
                }
                EntityPlayer entityPlayer = (EntityPlayer)nemo2;
                ozlu ozlu2 = entityPlayer.func_130014_f_();
                int n = (int)entityPlayer.field_70165_t;
                int n2 = (int)entityPlayer.field_70163_u;
                int n3 = (int)entityPlayer.field_70161_v;
                entityPlayer.openGui(instance, 0, ozlu2, n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        @Override
        public boolean func_71519_b(nemo nemo2) {
            return true;
        }

        @Override
        public List func_71516_a(nemo nemo2, String[] stringArray) {
            return Lists.asList("mkgui", new String[0]);
        }

        @Override
        public boolean func_82358_a(String[] stringArray, int n) {
            return false;
        }

        public int compareTo(Object object) {
            return 0;
        }
    }
}

