/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.auction;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;

@Mod(modid="znwauction", name="ZnW's Auction Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class AuctionMod {
    public static final String _a = "znwauction";
    @ezey(_a={eidj.CLIENT})
    public int _b;
    @Mod.Instance(value="znwauction")
    public static AuctionMod instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("auction", this.getClass());
        InvokeSideOnly.client(fMLPreInitializationEvent.getSide().isClient(), () -> {
            yfpk._a();
            dium._b();
        });
        InvokeSideOnly.frontend(fMLPreInitializationEvent.getSide().isServer(), () -> {});
    }
}

