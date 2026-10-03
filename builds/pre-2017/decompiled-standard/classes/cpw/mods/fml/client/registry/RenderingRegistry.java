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
import net.minecraft.entity.Entity;

public class RenderingRegistry {
    private static final RenderingRegistry INSTANCE = new RenderingRegistry();
    private int nextRenderId = 40;
    private Map<Integer, ISimpleBlockRenderingHandler> blockRenderers = Maps.newHashMap();
    private List<EntityRendererInfo> entityRenderers = Lists.newArrayList();

    public static int addNewArmourRendererPrefix(String string) {
        ifvk._f = ObjectArrays.concat(ifvk._f, string);
        return ifvk._f.length - 1;
    }

    public static void registerEntityRenderingHandler(Class<? extends Entity> clazz, tfvm tfvm2) {
        RenderingRegistry.instance().entityRenderers.add(new EntityRendererInfo(clazz, tfvm2));
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

    public boolean renderWorldBlock(htvc htvc2, sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4) {
        if (!this.blockRenderers.containsKey(n4)) {
            return false;
        }
        ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler = this.blockRenderers.get(n4);
        return iSimpleBlockRenderingHandler.renderWorldBlock(sdrg2, n, n2, n3, twgu2, n4, htvc2);
    }

    public void renderInventoryBlock(htvc htvc2, twgu twgu2, int n, int n2) {
        if (!this.blockRenderers.containsKey(n2)) {
            return;
        }
        ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler = this.blockRenderers.get(n2);
        iSimpleBlockRenderingHandler.renderInventoryBlock(twgu2, n, n2, htvc2);
    }

    public boolean renderItemAsFull3DBlock(int n) {
        ISimpleBlockRenderingHandler iSimpleBlockRenderingHandler = this.blockRenderers.get(n);
        return iSimpleBlockRenderingHandler != null && iSimpleBlockRenderingHandler.shouldRender3DInInventory();
    }

    public void loadEntityRenderers(Map<Class<? extends Entity>, tfvm> map) {
        for (EntityRendererInfo entityRendererInfo : this.entityRenderers) {
            map.put(entityRendererInfo.target, entityRendererInfo.renderer);
            entityRendererInfo.renderer.func_76976_a(gqqu._b);
        }
    }

    private static class EntityRendererInfo {
        private Class<? extends Entity> target;
        private tfvm renderer;

        public EntityRendererInfo(Class<? extends Entity> clazz, tfvm tfvm2) {
            this.target = clazz;
            this.renderer = tfvm2;
        }
    }
}

