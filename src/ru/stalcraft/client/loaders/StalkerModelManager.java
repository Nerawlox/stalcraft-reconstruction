/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  bim
 *  bio
 *  bjo
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustom
 *  net.minecraftforge.client.model.techne.TechneModel
 */
package ru.stalcraft.client.loaders;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.techne.TechneModel;
import ru.stalcraft.client.loaders.MultithreadLoadingTexture;

public class StalkerModelManager {
    private HashMap models = new HashMap();
    private HashSet loadingTextures = new HashSet();
    private bim tm;
    private Map mapTextureObjects;

    public StalkerModelManager() {
        Map mapTextureObjects;
        this.tm = atv.w().N;
        this.mapTextureObjects = mapTextureObjects = (Map)ReflectionHelper.getPrivateValue(bim.class, (Object)this.tm, (String[])new String[]{"mapTextureObjects", "field_110585_a", "a"});
    }

    public void tick() {
        Iterator it2 = this.loadingTextures.iterator();
        bjo resource = null;
        while (it2.hasNext()) {
            resource = (bjo)it2.next();
            if (!this.mapTextureObjects.containsKey(resource)) continue;
            if (this.mapTextureObjects.get(resource) instanceof MultithreadLoadingTexture) {
                ((MultithreadLoadingTexture)((Object)this.mapTextureObjects.get(resource))).upload();
            }
            it2.remove();
        }
    }

    public IModelCustom getModel(String dir, String name) {
        if (!this.models.containsKey(name)) {
            this.models.put(name, null);
            new ModelLoader(dir, name).start();
            return null;
        }
        return (IModelCustom)this.models.get(name);
    }

    public void tryLoadTexture(bjo texture) {
        if (!this.loadingTextures.contains(texture) && !this.mapTextureObjects.containsKey(texture)) {
            this.loadingTextures.add(texture);
            new TextureLoader(texture).start();
        }
    }

    public boolean tryBindTexture(bjo texture) {
        if (this.mapTextureObjects.containsKey(texture) && !this.loadingTextures.contains(texture)) {
            this.tm.a(texture);
            return true;
        }
        return false;
    }

    static IModelCustom addModel(String dir, String name) throws Exception {
        String resourceName = "/assets/stalker/models/" + dir + "/" + name;
        IModelCustom model = null;
        model = AdvancedModelLoader.loadModel((String)resourceName);
        if (model instanceof TechneModel) {
            StalkerModelManager.fixModel((bbo)((TechneModel)model));
        }
        return model;
    }

    private static void fixModel(bbo model) {
        for (bcu mr : model.r) {
            mr.i = !mr.i;
            mr.d += 23.4f;
        }
    }

    private class ModelLoader
    extends Thread {
        private String modelName;
        private String dir;

        public ModelLoader(String dir, String modelName) {
            this.modelName = modelName;
            this.dir = dir;
        }

        @Override
        public void run() {
            try {
                StalkerModelManager.this.models.put(this.modelName, StalkerModelManager.addModel(this.dir, this.modelName));
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private class TextureLoader
    extends Thread {
        private bjo resource;

        public TextureLoader(bjo texture) {
            this.resource = texture;
        }

        @Override
        public void run() {
            MultithreadLoadingTexture texture = new MultithreadLoadingTexture(this.resource);
            StalkerModelManager.this.tm.a(this.resource, (bio)texture);
        }
    }
}

