/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.TickType;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public interface BaseModProxy {
    public void modsLoaded();

    public void load();

    public String getName();

    public String getPriorities();

    public String getVersion();

    public boolean doTickInGUI(TickType var1, boolean var2, Object ... var3);

    public boolean doTickInGame(TickType var1, boolean var2, Object ... var3);

    public void generateSurface(ozlu var1, Random var2, int var3, int var4);

    public void generateNether(ozlu var1, Random var2, int var3, int var4);

    public int addFuel(int var1, int var2);

    public void takenFromCrafting(EntityPlayer var1, cvzo var2, mssh var3);

    public void takenFromFurnace(EntityPlayer var1, cvzo var2);

    public void onClientLogout(jjpj var1);

    public void onClientLogin(EntityPlayer var1);

    public void serverDisconnect();

    public void serverConnect(elai var1);

    public void receiveCustomPacket(jjqf var1);

    public void clientChat(String var1);

    public void onItemPickup(EntityPlayer var1, cvzo var2);

    public void serverCustomPayload(xbvu var1, jjqf var2);

    public void serverChat(xbvu var1, String var2);
}

