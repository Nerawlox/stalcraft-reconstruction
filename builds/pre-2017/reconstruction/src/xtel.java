/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class xtel
extends BiomeGenBase {
    public xtel(int n) {
        super(n);
        this._J.clear();
        this._K.clear();
        this._L.clear();
        this._M.clear();
        this._J.add(new yffo(EntityGhast.class, 50, 4, 4));
        this._J.add(new yffo(EntityPigZombie.class, 100, 4, 4));
        this._J.add(new yffo(EntityMagmaCube.class, 1, 4, 4));
    }
}

