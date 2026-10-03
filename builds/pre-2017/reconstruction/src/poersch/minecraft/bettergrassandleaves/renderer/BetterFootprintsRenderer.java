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
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityFootprintsFX;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterFootprintsRenderer
extends BlockRenderer
implements ITextureLoadingCallback {
    public static Icon[] iconFootprint;
    protected static Map<Class, Icon[]> iconMap;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconFootprint = BetterFootprintsRenderer.registerBlockIconsOrCallback("footprint", "sand", this);
        iconMap.clear();
        Set set = jgro._a.entrySet();
        for (Map.Entry entry : set) {
            Icon[] iconArray = BetterFootprintsRenderer.registerBlockIcons("footprint_" + ((String)entry.getKey()).toLowerCase());
            if (iconArray == null) continue;
            iconMap.put((Class)entry.getValue(), iconArray);
        }
    }

    protected static Icon getIconFromMap(Class clazz, float f) {
        Icon[] iconArray = iconMap.get(clazz);
        return iconArray != null ? iconArray[(int)(f * (float)(iconArray.length - 1) + 0.5f)] : null;
    }

    @Override
    public boolean onEntityWalking(Block block, World world, int n, int n2, int n3, Entity entity) {
        if ((Integer)BetterGrassAndLeavesMod.renderFootprintsFX.value != 0 && world.isAirBlock(n, n2 + 1, n3)) {
            float f = (float)Math.random();
            Icon icon = BetterFootprintsRenderer.getIconFromMap(entity.getClass(), f);
            if (icon == null) {
                if (iconFootprint == null) {
                    return false;
                }
                icon = iconFootprint[(int)(f * (float)(iconFootprint.length - 1) + 0.5f)];
                if (icon == null) {
                    return false;
                }
            }
            float f2 = (float)icon.getIconWidth() / (float)Block.stone.getIcon(0, 0).getIconWidth();
            if (entity instanceof EntityLiving && ((EntityLiving)entity).isChild()) {
                f2 *= 0.5f;
            }
            if ((Integer)BetterGrassAndLeavesMod.renderFootprintsFX.value == 1) {
                this.minecraft._w._a(new EntityFootprintsFX(world, entity.posX, (double)n2 + (block == Block.snow ? (double)(1 + world.getBlockMetadata(n, n2, n3) & 7) / 8.0 : 1.0), entity.posZ, f2, -(entity.rotationYaw * 3.141593f) / 180.0f, icon, ((int)entity.distanceWalkedOnStepModified & 1) == 0, null, block.blockID));
            } else {
                this.minecraft._w._a(new EntityFootprintsFX(world, entity.posX, (double)n2 + (block == Block.snow ? (double)(1 + world.getBlockMetadata(n, n2, n3) & 7) / 8.0 : 1.0), entity.posZ, f2, -(entity.rotationYaw * 3.141593f) / 180.0f, icon, true, entity, block.blockID));
            }
            return false;
        }
        return false;
    }

    @Override
    public BufferedImage onTextureLoading(TextureAtlasSprite textureAtlasSprite, BufferedImage bufferedImage) {
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
        iconMap = new HashMap<Class, Icon[]>();
    }
}

