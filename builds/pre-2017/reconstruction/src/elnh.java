/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class elnh
extends BiomeDecorator {
    public WorldGenerator _a;

    public elnh(BiomeGenBase biomeGenBase) {
        super(biomeGenBase);
        this._a = new cwkj(Block.whiteStone.blockID);
    }

    @Override
    public void decorate() {
        this.generateOres();
        if (this.randomGenerator.nextInt(5) == 0) {
            int n = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            int n2 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            int n3 = this.currentWorld.getTopSolidOrLiquidBlock(n, n2);
            this._a._a(this.currentWorld, this.randomGenerator, n, n3, n2);
        }
        if (this.chunk_X == 0 && this.chunk_Z == 0) {
            EntityDragon entityDragon = new EntityDragon(this.currentWorld);
            entityDragon.setLocationAndAngles(0.0, 128.0, 0.0, this.randomGenerator.nextFloat() * 360.0f, 0.0f);
            this.currentWorld.spawnEntityInWorld(entityDragon);
        }
    }
}

