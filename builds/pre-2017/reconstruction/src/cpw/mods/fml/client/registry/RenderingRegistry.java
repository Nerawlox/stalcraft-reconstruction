/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.registry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;

public class RenderingRegistry {
    private static final RenderingRegistry INSTANCE = new RenderingRegistry();
    private int nextRenderId = 40;
    private Map<Integer, ISimpleBlockRenderingHandler> blockRenderers = Maps.newHashMap();
    private List<EntityRendererInfo> entityRenderers = Lists.newArrayList();

    public static int addNewArmourRendererPrefix(String string) {
        ifvk._f = ObjectArrays.concat(ifvk._f, string);
        return ifvk._f.length - 1;
    }

    public static void registerEntityRenderingHandler(Class<? extends Entity> clazz, Render render) {
        RenderingRegistry.instance().entityRenderers.add(new EntityRendererInfo(clazz, render));
    }

    public static void registerBlockHandler(ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler) {
        RenderingRegistry.instance().blockRenderers.put(iSimpleBlockRenderingHandler.getRenderId(), iSimpleBlockRenderingHandler);
    }

    public static void registerBlockHandler(int n, ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler) {
        RenderingRegistry.instance().blockRenderers.put(n, iSimpleBlockRenderingHandler);
    }

    public static int getNextAvailableRenderId() {
        return RenderingRegistry.instance().nextRenderId++;
    }

    @Deprecated
    public static int addTextureOverride(String string, String string2) {
        return -1;
    }

    public static void addTextureOverride(String string, String string2, int n) {
    }

    @Deprecated
    public static int getUniqueTextureIndex(String string) {
        return -1;
    }

    @Deprecated
    public static RenderingRegistry instance() {
        return INSTANCE;
    }

    public boolean renderWorldBlock(RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4) {
        if (!this.blockRenderers.containsKey(n4)) {
            return false;
        }
        ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler = this.blockRenderers.get(n4);
        return iSimpleBlockRenderingHandler.renderWorldBlock(iBlockAccess, n, n2, n3, block, n4, renderBlocks);
    }

    public void renderInventoryBlock(RenderBlocks renderBlocks, Block block, int n, int n2) {
        if (!this.blockRenderers.containsKey(n2)) {
            return;
        }
        ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler = this.blockRenderers.get(n2);
        iSimpleBlockRenderingHandler.renderInventoryBlock(block, n, n2, renderBlocks);
    }

    public boolean renderItemAsFull3DBlock(int n) {
        ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler = this.blockRenderers.get(n);
        return iSimpleBlockRenderingHandler != null && iSimpleBlockRenderingHandler.shouldRender3DInInventory();
    }

    public void loadEntityRenderers(Map<Class<? extends Entity>, Render> map) {
        for (EntityRendererInfo entityRendererInfo : this.entityRenderers) {
            map.put(entityRendererInfo.target, entityRendererInfo.renderer);
            entityRendererInfo.renderer.setRenderManager(RenderManager._b);
        }
    }

    private static class EntityRendererInfo {
        private Class<? extends Entity> target;
        private Render renderer;

        public EntityRendererInfo(Class<? extends Entity> clazz, Render render) {
            this.target = clazz;
            this.renderer = render;
        }
    }
}

