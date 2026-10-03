/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.auction;

import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import znw.mods.auction.eidj;

public enum pidb {
    _a{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new eidj();
        }

        @Override
        public GuiContainer _a(Container container) {
            return new mcnh(container);
        }
    }
    ,
    _b{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new eidj();
        }

        @Override
        public GuiContainer _a(Container container) {
            return new mcnh(container, true);
        }
    }
    ,
    _c{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new cwsz(true, entityPlayer.inventory);
        }

        @Override
        public GuiContainer _a(Container container) {
            return new dzvh(container);
        }
    }
    ,
    _d{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new cwsz(false, entityPlayer.inventory);
        }

        @Override
        public GuiContainer _a(Container container) {
            return new oitm(container);
        }
    }
    ,
    _e{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.inventory);
        }

        @Override
        public GuiContainer _a(Container container) {
            return new lqmm(container);
        }
    }
    ,
    _f{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.inventory)._a(true);
        }

        @Override
        public GuiContainer _a(Container container) {
            return new bcpn((elxl)container);
        }
    }
    ,
    _g{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.inventory)._a(true);
        }

        @Override
        public GuiContainer _a(Container container) {
            return new knjj((elxl)container);
        }
    }
    ,
    _h{

        @Override
        public Container _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.inventory)._a(true);
        }

        @Override
        public GuiContainer _a(Container container) {
            return new ukfw((elxl)container);
        }
    };


    public abstract Container _a(EntityPlayer var1);

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public abstract GuiContainer _a(Container var1);
}

