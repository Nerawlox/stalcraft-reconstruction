/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.stalkerguide;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.GloomyStartHooks;
import gloomyfolken.mods.core.main.GloomyAPI;
import java.io.File;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import znw.mods.stalkerguide.kjui;

@Mod(modid="znwstalkerguide", name="ZnW's Stalker Guide Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class StalkerguideMod {
    public static final String _a = "znwstalkerguide";
    @Mod.Instance(value="znwstalkerguide")
    public static StalkerguideMod instance;
    @ezey(_a={eidj.CLIENT})
    public static mcne _b;
    private Configuration _c;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("stalkerguide", this.getClass());
        if (fMLPreInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                this._c = new Configuration(new File(GloomyStartHooks._a, "assets/stalkerguide/znwstalkerguide.cfg"));
            });
        } else {
            InvokeSideOnly.frontend(() -> {});
        }
        MinecraftForge.EVENT_BUS.register(new kjui());
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        fMLServerStartingEvent.registerServerCommand(new kmew(){

            @Override
            public String func_71517_b() {
                return "tutorialreset";
            }

            @Override
            public String func_71518_a(nemo nemo2) {
                return "type in /tutorialreset";
            }

            @Override
            public List func_71514_a() {
                return null;
            }

            @Override
            public void func_71515_b(nemo nemo2, String[] stringArray) {
                if (nemo2 instanceof EntityPlayer) {
                    EntityPlayer entityPlayer = (EntityPlayer)nemo2;
                    if (stringArray != null && stringArray.length > 0) {
                        if ("true".equals(stringArray[0])) {
                            ncwh._c(entityPlayer)._a("tutorialCompleted", false);
                            ncwh._c(entityPlayer)._a("tutorialStage", 0);
                        }
                        if ("false".equals(stringArray[0])) {
                            ncwh._c(entityPlayer)._a("tutorialCompleted", true);
                        } else {
                            try {
                                ncwh._c(entityPlayer)._a("tutorialCompleted", false);
                                ncwh._c(entityPlayer)._a("tutorialStage", Integer.parseInt(stringArray[0]));
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                    }
                }
            }

            @Override
            public boolean func_71519_b(nemo nemo2) {
                return dzfd._I().__ag()._g(nemo2.func_70005_c_());
            }

            @Override
            public List func_71516_a(nemo nemo2, String[] stringArray) {
                return Lists.newArrayList("tutorialreset");
            }

            @Override
            public boolean func_82358_a(String[] stringArray, int n) {
                return false;
            }

            public int compareTo(Object object) {
                return 0;
            }
        });
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                _b = new mcne();
                _b._a(this._c);
            });
        } else {
            InvokeSideOnly.frontend(() -> {});
        }
    }
}

