/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.network.IGuiHandler;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ModLoaderGuiHelper
implements IGuiHandler {
    private BaseModProxy mod;
    private Set<Integer> ids;
    private Container container;
    private int currentID;

    ModLoaderGuiHelper(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
        this.ids = Sets.newHashSet();
    }

    @Override
    public Object getServerGuiElement(int n, EntityPlayer entityPlayer, World world, int n2, int n3, int n4) {
        return this.container;
    }

    @Override
    public Object getClientGuiElement(int n, EntityPlayer entityPlayer, World world, int n2, int n3, int n4) {
        return ModLoaderHelper.getClientSideGui(this.mod, entityPlayer, n, n2, n3, n4);
    }

    public void injectContainerAndID(Container container, int n) {
        this.container = container;
        this.currentID = n;
    }

    public Object getMod() {
        return this.mod;
    }

    public void associateId(int n) {
        this.ids.add(n);
    }
}

