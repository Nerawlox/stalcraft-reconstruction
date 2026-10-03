/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.core.client.gui.screens.GuiPlayerInteract;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.party.eidj;
import gloomyfolken.mods.party.ezey;
import gloomyfolken.mods.party.jgro;
import gloomyfolken.mods.party.tupg;
import gloomyfolken.mods.party.zwat;
import gloomyfolken.mods.party.zwaw;
import mods.pda.PdaMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyParty", name="GloomyFolken's Party Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyBundle;required-after:PdaMod")
public class PartyMod {
    public static final String _a = "GloomyParty";
    public static final Stat _b = Stat.register("par-tim", "\u0412\u0440\u0435\u043c\u0435\u043d\u0438 \u0432 \u043e\u0442\u0440\u044f\u0434\u0435", Stat.StatsCategory.EXPLORATION, StatsType.DURATION).incTimeCounter(entityPlayer -> zwaw._a((EntityPlayer)entityPlayer)._b != null);
    public static eidj _c = new eidj();
    @Mod.Instance(value="GloomyParty")
    public static PartyMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new ezey());
        if (fMLInitializationEvent.getSide() == Side.CLIENT) {
            InvokeSideOnly.client(this::_a);
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _a() {
        GloomyAPI.registerAssetsDir("party", PartyMod.class);
        MinecraftForge.EVENT_BUS.register(new jgro());
        PdaMod.getClientPda().registerPdaTab("party", "\u043e\u0442\u0440\u044f\u0434", tupg::new, 5);
        GloomyAPI.registerGameHandler(new zwat());
        GuiPlayerInteract.registerProvider("\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c \u0432 \u043e\u0442\u0440\u044f\u0434", new GuiPlayerInteract.PlayerInteractProvider(){

            @Override
            @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
            public void performFor(EntityPlayer entityPlayer) {
                new cthk(entityPlayer.username).sendClientToBackend();
            }

            @Override
            @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
            public boolean canApply(EntityPlayer entityPlayer) {
                return zwat._a._a(entityPlayer.username);
            }
        });
    }
}

