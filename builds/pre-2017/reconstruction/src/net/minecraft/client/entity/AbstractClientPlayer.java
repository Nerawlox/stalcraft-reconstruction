/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import gloomyfolken.mods.skinarmor.eidj;
import mcoptifine.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.eifc;
import net.minecraft.world.World;

public abstract class AbstractClientPlayer
extends EntityPlayer {
    public static final ResourceLocation locationStevePng = new ResourceLocation("textures/entity/steve.png");
    public ThreadDownloadImageData downloadImageSkin;
    public ThreadDownloadImageData downloadImageCape;
    public ResourceLocation locationSkin;
    public ResourceLocation locationCape;

    public AbstractClientPlayer(World world, String string) {
        super(world, string);
        this.setupCustomSkin();
    }

    public void setupCustomSkin() {
        System.out.println("Setting up custom skins");
        if (this.username != null && !this.username.isEmpty()) {
            this.locationSkin = AbstractClientPlayer.getLocationSkin(this.username);
            this.locationCape = AbstractClientPlayer.getLocationCape(this.username);
            this.downloadImageSkin = AbstractClientPlayer.getDownloadImageSkin(this.locationSkin, this.username);
            this.downloadImageCape = AbstractClientPlayer.getDownloadImageCape(this.locationCape, this.username);
            this.downloadImageCape._g = Config.isShowCapes();
        }
    }

    public ThreadDownloadImageData getTextureSkin() {
        return this.downloadImageSkin;
    }

    public ThreadDownloadImageData getTextureCape() {
        return this.downloadImageCape;
    }

    public ResourceLocation getLocationSkin() {
        ResourceLocation resourceLocation = eidj._a(this);
        return resourceLocation;
    }

    public ResourceLocation getLocationCape() {
        return this.locationCape;
    }

    public static ThreadDownloadImageData getDownloadImageSkin(ResourceLocation resourceLocation, String string) {
        return AbstractClientPlayer.getDownloadImage(resourceLocation, AbstractClientPlayer.getSkinUrl(string), locationStevePng, new scss());
    }

    public static ThreadDownloadImageData getDownloadImageCape(ResourceLocation resourceLocation, String string) {
        return AbstractClientPlayer.getDownloadImage(resourceLocation, AbstractClientPlayer.getCapeUrl(string), null, null);
    }

    public static ThreadDownloadImageData getDownloadImage(ResourceLocation resourceLocation, String string, ResourceLocation resourceLocation2, xbbs xbbs2) {
        TextureManager textureManager = Minecraft._E()._R();
        sctg sctg2 = textureManager._b(resourceLocation);
        if (sctg2 == null) {
            sctg2 = new ThreadDownloadImageData(string, resourceLocation2, xbbs2);
            textureManager._a(resourceLocation, sctg2);
        }
        return (ThreadDownloadImageData)sctg2;
    }

    public static String getSkinUrl(String string) {
        return String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", eifc._a(string));
    }

    public static String getCapeUrl(String string) {
        return String.format("http://skins.minecraft.net/MinecraftCloaks/%s.png", eifc._a(string));
    }

    public static ResourceLocation getLocationSkin(String string) {
        return new ResourceLocation("skins/" + eifc._a(string));
    }

    public static ResourceLocation getLocationCape(String string) {
        return new ResourceLocation("cloaks/" + eifc._a(string));
    }

    public static ResourceLocation getLocationSkull(String string) {
        return new ResourceLocation("skull/" + eifc._a(string));
    }
}

