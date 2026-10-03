/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.guimaker;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import znw.mods.guimaker.client.GuiEditorMain;

public class GuiMakerHandler
implements IGuiHandler {
    public static final int MAIN_EDITOR = 0;

    @Override
    public Object getServerGuiElement(int n, EntityPlayer entityPlayer, World world, int n2, int n3, int n4) {
        return new Container(){

            @Override
            public boolean canInteractWith(EntityPlayer entityPlayer) {
                return true;
            }
        };
    }

    @Override
    public Object getClientGuiElement(int n, EntityPlayer entityPlayer, World world, int n2, int n3, int n4) {
        switch (n) {
            case 0: {
                return new GuiEditorMain();
            }
        }
        return null;
    }
}

