/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

public class jyqh
extends kjwj {
    public final List<String> _b;

    public jyqh(int n, String string, String string2, List<String> list2, int n2, int n3, List<String> list3) {
        super(n, string, string2, list2, n2);
        this._b = list3;
        this.setMaxDamage(n3);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            for (String string : this._b) {
                string = StringUtils.replace(string, "@p", entityPlayer.username);
                if (itemStack._e != null && itemStack._e._c("buyer")) {
                    string = StringUtils.replace(string, "@b", itemStack._e._j("buyer"));
                }
                Logger.info("Player " + entityPlayer.username + " used item " + this.itemID + " to execute command: " + string, new Object[0]);
                MinecraftServer minecraftServer = MinecraftServer._I();
                if (minecraftServer instanceof ujth) {
                    ((ujth)minecraftServer)._a(string, minecraftServer);
                    continue;
                }
                minecraftServer._a(string);
            }
        }
        if (itemStack._k() > 0) {
            itemStack._b(itemStack._j() + 1);
            if (itemStack._j() >= itemStack._k()) {
                --itemStack._b;
            }
        }
        return itemStack;
    }
}

