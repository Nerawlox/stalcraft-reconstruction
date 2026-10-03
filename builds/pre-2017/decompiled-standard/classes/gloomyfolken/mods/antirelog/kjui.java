/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.antirelog;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.antirelog.eidj;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class kjui {
    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("AntiRelog", new eidj(mquk2._a));
    }

    @ForgeSubscribe(priority=EventPriority.LOWEST)
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(RenderPlayerEvent.Pre pre) {
        if (!pre.isCanceled() && eidj._a((EntityPlayer)pre.entityPlayer)._b._b().booleanValue()) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, -0.6f, 0.0f);
        }
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(RenderPlayerEvent.Post post) {
        if (eidj._a((EntityPlayer)post.entityPlayer)._b._b().booleanValue()) {
            GL11.glPopMatrix();
        }
    }

    @ForgeSubscribe
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(ncux ncux2) {
        if (eidj._a((EntityPlayer)ncux2._a)._b._b().booleanValue()) {
            ncux2._m.field_78795_f = -1.5707964f;
            ncux2._n.field_78795_f = -1.5707964f;
            ncux2._m.field_78796_g = 0.20943952f;
            ncux2._n.field_78796_g = -0.20943952f;
        }
    }
}

