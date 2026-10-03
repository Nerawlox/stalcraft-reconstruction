/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.ClientBrandRetriever
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;

@SideOnly(value=Side.CLIENT)
class auh
implements Callable {
    final atv a;

    auh(atv par1Minecraft) {
        this.a = par1Minecraft;
    }

    public String a() {
        String s2 = ClientBrandRetriever.getClientModName();
        return !s2.equals("vanilla") ? "Definitely; Client brand changed to '" + s2 + "'" : (atv.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.");
    }

    public Object call() {
        return this.a();
    }
}

