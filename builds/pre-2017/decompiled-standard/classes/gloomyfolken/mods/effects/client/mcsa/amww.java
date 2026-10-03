/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.jxsn;
import gloomyfolken.mods.effects.client.mcsa.ugqi;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class amww
extends ugqi {
    public static ResourceLocation _a = new ResourceLocation("effects:textures/brdf.dds");
    public static ResourceLocation _b = new ResourceLocation("effects:textures/kubemas.dds");
    public static ResourceLocation _c = new ResourceLocation("effects:textures/kubemas_difuz.dds");

    @Override
    protected void loadLocations(jxsn jxsn2) {
        jxsn2._c("tBRDF");
        jxsn2._c("envMapHDR");
        jxsn2._c("envMapDiffuse");
    }

    @Override
    protected void loadUniforms(jxsn jxsn2, jgro jgro2) {
        if (eidj._J) {
            GL11.glEnable(34895);
        }
        int n = jgro2._e.length + 2;
        GL20.glUniform1i(jxsn2._a("tBRDF"), n++);
        GL20.glUniform1i(jxsn2._a("envMapHDR"), n++);
        GL20.glUniform1i(jxsn2._a("envMapDiffuse"), n++);
    }

    @Override
    protected void bindTextures(jxsn jxsn2, jgro jgro2) {
        int n = jgro2._e.length + 2;
        this._a(n++, _a);
        this._a(n++, _b);
        this._a(n++, _c);
    }

    private void _a(int n, ResourceLocation resourceLocation) {
        iwya._a(n + iwya._a);
        xpzm._E()._h._a(resourceLocation);
        iwya._a(iwya._a);
    }

    @Override
    protected String getFragmentUniformHook() {
        return srxe._b("/assets/effects/shaders/pbr_hook_uniforms.fsh");
    }

    @Override
    protected String getFragmentExitHook() {
        return srxe._b("/assets/effects/shaders/pbr_hook.fsh");
    }
}

