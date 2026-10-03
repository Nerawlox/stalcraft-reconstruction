/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityFootprintsFX;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterFootprintsRenderer
extends BlockRenderer
implements ITextureLoadingCallback {
    public static dwan[] iconFootprint;
    protected static Map<Class, dwan[]> iconMap;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconFootprint = BetterFootprintsRenderer.registerBlockIconsOrCallback("footprint", "sand", this);
        iconMap.clear();
        Set set = jgro._a.entrySet();
        for (Map.Entry entry : set) {
            dwan[] dwanArray = BetterFootprintsRenderer.registerBlockIcons("footprint_" + ((String)entry.getKey()).toLowerCase());
            if (dwanArray == null) continue;
            iconMap.put((Class)entry.getValue(), dwanArray);
        }
    }

    protected static dwan getIconFromMap(Class clazz, float f) {
        dwan[] dwanArray = iconMap.get(clazz);
        return dwanArray != null ? dwanArray[(int)(f * (float)(dwanArray.length - 1) + 0.5f)] : null;
    }

    @Override
    public boolean onEntityWalking(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if ((Integer)BetterGrassAndLeavesMod.renderFootprintsFX.value != 0 && ozlu2.func_72799_c(n, n2 + 1, n3)) {
            float f = (float)Math.random();
            dwan dwan2 = BetterFootprintsRenderer.getIconFromMap(entity.getClass(), f);
            if (dwan2 == null) {
                if (iconFootprint == null) {
                    return false;
                }
                dwan2 = iconFootprint[(int)(f * (float)(iconFootprint.length - 1) + 0.5f)];
                if (dwan2 == null) {
                    return false;
                }
            }
            float f2 = (float)dwan2.func_94211_a() / (float)twgu.field_71981_t.func_71858_a(0, 0).func_94211_a();
            if (entity instanceof EntityLiving && ((EntityLiving)entity).func_70631_g_()) {
                f2 *= 0.5f;
            }
            if ((Integer)BetterGrassAndLeavesMod.renderFootprintsFX.value == 1) {
                this.minecraft._w._a(new EntityFootprintsFX(ozlu2, entity.field_70165_t, (double)n2 + (twgu2 == twgu.field_72037_aS ? (double)(1 + ozlu2.func_72805_g(n, n2, n3) & 7) / 8.0 : 1.0), entity.field_70161_v, f2, -(entity.field_70177_z * 3.141593f) / 180.0f, dwan2, ((int)entity.field_82151_R & 1) == 0, null, twgu2.field_71990_ca));
            } else {
                this.minecraft._w._a(new EntityFootprintsFX(ozlu2, entity.field_70165_t, (double)n2 + (twgu2 == twgu.field_72037_aS ? (double)(1 + ozlu2.func_72805_g(n, n2, n3) & 7) / 8.0 : 1.0), entity.field_70161_v, f2, -(entity.field_70177_z * 3.141593f) / 180.0f, dwan2, true, entity, twgu2.field_71990_ca));
            }
            return false;
        }
        return false;
    }

    @Override
    public BufferedImage onTextureLoading(dhji dhji2, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setClip((int)((double)n / 4.0), (int)((double)n / 4.0 * 1.5), (int)((double)n / 4.0), (int)((double)n / 4.0));
        graphics2D.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        graphics2D.fillRect(0, 0, n, n);
        graphics2D.dispose();
        return bufferedImage2;
    }

    static {
        iconMap = new HashMap<Class, dwan[]>();
    }
}

