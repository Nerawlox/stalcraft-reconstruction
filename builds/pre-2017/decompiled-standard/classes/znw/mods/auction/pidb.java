/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.auction;

import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.player.EntityPlayer;
import znw.mods.auction.eidj;

public enum pidb {
    _a{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new eidj();
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new mcnh(jjgc2);
        }
    }
    ,
    _b{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new eidj();
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new mcnh(jjgc2, true);
        }
    }
    ,
    _c{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new cwsz(true, entityPlayer.field_71071_by);
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new dzvh(jjgc2);
        }
    }
    ,
    _d{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new cwsz(false, entityPlayer.field_71071_by);
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new oitm(jjgc2);
        }
    }
    ,
    _e{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.field_71071_by);
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new lqmm(jjgc2);
        }
    }
    ,
    _f{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.field_71071_by)._a(true);
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new bcpn((elxl)jjgc2);
        }
    }
    ,
    _g{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.field_71071_by)._a(true);
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new knjj((elxl)jjgc2);
        }
    }
    ,
    _h{

        @Override
        public jjgc _a(EntityPlayer entityPlayer) {
            return new elxl(entityPlayer.field_71071_by)._a(true);
        }

        @Override
        public zybc _a(jjgc jjgc2) {
            return new ukfw((elxl)jjgc2);
        }
    };


    public abstract jjgc _a(EntityPlayer var1);

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public abstract zybc _a(jjgc var1);
}

