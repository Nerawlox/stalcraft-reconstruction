/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import carpentersblocks.block.BlockCarpentersButton;
import carpentersblocks.block.BlockCarpentersDoor;
import carpentersblocks.block.BlockCarpentersGate;
import carpentersblocks.block.BlockCarpentersHatch;
import com.stalcraft.blocks.BlockBlueShelf;
import com.stalcraft.blocks.BlockCabinet;
import com.stalcraft.blocks.BlockCash;
import com.stalcraft.blocks.BlockMetalShelf;
import com.stalcraft.blocks.BlockStellage;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.blocks.BlockCarpentryBench;

public class eidj {
    private static List<zwaw<Block>> _a = new ArrayList<zwaw<Block>>();
    private static List<zwaw<Entity>> _b = new ArrayList<zwaw<Entity>>();

    public static zwat _a(Block block) {
        return eidj._a(_a, block);
    }

    public static zwat _a(Entity entity) {
        return eidj._a(_b, entity);
    }

    private static <T> zwat _a(List<zwaw<T>> list2, T t) {
        return list2.stream().filter(zwaw2 -> zwaw2._a(t)).map(zwaw2 -> zwaw2._d(t)).findFirst().orElse(null);
    }

    static {
        _a.add(new kjui("\u043d\u0430\u0436\u0430\u0442\u044c", "\u041a\u043d\u043e\u043f\u043a\u0430", scbx.class, BlockCarpentersButton.class));
        _a.add(new kjui("\u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c", "\u0412\u0435\u0440\u0441\u0442\u0430\u043a", BlockWorkbench.class, BlockCarpentryBench.class));
        _a.add(new kjui("\u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c", "\u041b\u044e\u043a", matg.class, BlockCarpentersHatch.class));
        _a.add(new kjui("\u043e\u0441\u043c\u043e\u0442\u0440\u0435\u0442\u044c", uyqj.class, rpoo.class, BlockBlueShelf.class, BlockCabinet.class, BlockCash.class, BlockMetalShelf.class, BlockStellage.class, BlockChest.class, BlockEnderChest.class, BlockDispenser.class, ejzq.class, BlockAnvil.class, BlockFurnace.class));
        _a.add(new kjui("\u043f\u043d\u0443\u0442\u044c", "\u0414\u0432\u0435\u0440\u044c", new Class[]{BlockDoor.class, BlockCarpentersDoor.class, BlockFenceGate.class, BlockCarpentersGate.class}){

            @Override
            protected boolean _a(Block block) {
                return super._a(block) && block.blockMaterial != Material._f;
            }
        });
        _a.add(new kjui("\u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c", new Class[]{gphy.class}){

            @Override
            protected boolean _a(Block block) {
                return super._a(block) && ((gphy)block)._f != null;
            }
        });
        _b.add(new eidj("\u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435", EntityPlayer.class));
        _b.add(new eidj("\u043e\u0431\u044b\u0441\u043a\u0430\u0442\u044c", EntityRagdollCorpse.class));
        _b.add(new eidj("\u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c", new Class[]{EntityNPCInterface.class}){

            @Override
            protected boolean _a(Entity entity) {
                return super._a(entity) && ((EntityNPCInterface)entity).display.showTip;
            }
        });
        _b.add(new eidj("\u043f\u043e\u0434\u043e\u0431\u0440\u0430\u0442\u044c", new Class[]{EntityItem.class}){

            @Override
            public String _b(Entity entity) {
                EntityItem entityItem = (EntityItem)entity;
                ItemStack itemStack = entityItem.getEntityItem();
                String string = itemStack._s();
                if (itemStack._b > 1) {
                    string = string + " (" + itemStack._b + ")";
                }
                return string;
            }
        });
    }

    public static class zwat {
        public String _a;
        public String _b;
    }

    private static abstract class zwaw<T> {
        private static zwat _a = new zwat();

        private zwaw() {
        }

        public final zwat _d(T t) {
            if (this._a(t)) {
                zwaw._a._a = this._b(t);
                zwaw._a._b = this._c(t);
                return _a;
            }
            return null;
        }

        protected abstract boolean _a(T var1);

        protected abstract String _b(T var1);

        protected String _c(T t) {
            return "\u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c";
        }
    }

    private static class kjui
    extends pidb {
        private final Class<? extends Block>[] _a;
        private final String _b;
        private final String _c;

        @SafeVarargs
        public kjui(String string, Class<? extends Block> ... classArray) {
            this(string, (String)null, classArray);
        }

        @SafeVarargs
        public kjui(String string, String string2, Class<? extends Block> ... classArray) {
            this._b = string;
            this._c = string2;
            this._a = classArray;
        }

        @Override
        protected boolean _a(Block block) {
            for (Class<? extends Block> clazz : this._a) {
                if (!clazz.isInstance(block)) continue;
                return true;
            }
            return false;
        }

        @Override
        protected String _b(Block block) {
            return this._b;
        }

        @Override
        public String _c(Block block) {
            return this._c == null ? super._c(block) : this._c;
        }

        @Override
        protected /* synthetic */ String _c(Object object) {
            return this._b((Block)object);
        }

        @Override
        public /* synthetic */ String _b(Object object) {
            return this._c((Block)object);
        }
    }

    private static class eidj
    extends ezey {
        private final Class<? extends Entity>[] _a;
        private final String _b;

        @SafeVarargs
        public eidj(String string, Class<? extends Entity> ... classArray) {
            this._b = string;
            this._a = classArray;
        }

        @Override
        protected boolean _a(Entity entity) {
            for (Class<? extends Entity> clazz : this._a) {
                if (!clazz.isInstance(entity)) continue;
                return true;
            }
            return false;
        }

        @Override
        protected String _c(Entity entity) {
            return this._b;
        }
    }

    private static abstract class ezey
    extends zwaw<Entity> {
        private ezey() {
        }

        @Override
        public String _b(Entity entity) {
            return entity.getTranslatedEntityName();
        }
    }

    private static abstract class pidb
    extends zwaw<Block> {
        private pidb() {
        }

        @Override
        public String _c(Block block) {
            return block.getLocalizedName();
        }

        @Override
        public /* synthetic */ String _b(Object object) {
            return this._c((Block)object);
        }
    }
}

