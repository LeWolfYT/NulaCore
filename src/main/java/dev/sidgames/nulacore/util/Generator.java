package dev.sidgames.nulacore.util;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Generator {
    public static Item generateItem(Item item, Identifier id) {
        return Registry.register(Registry.ITEM, id, item);
    }

    public static Block generateBlock(Block block, Identifier id) {
        return Registry.register(Registry.BLOCK, id, block);
    }

    public static BlockItem generatrBlockItem(Block block, Identifier id, ItemGroup group) {
        return Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(group)));
    }

    public static BlockItem generatrBlockItem(Block block, Identifier id, Item.Settings settings) {
        return Registry.register(Registry.ITEM, id, new BlockItem(block, settings));
    }

    public static BlockItem generateBlockItem(Block block, Identifier id, ItemGroup group) {
        return Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(group)));
    }

    public static BlockItem generateBlockItem(Block block, Identifier id, Item.Settings settings) {
        return Registry.register(Registry.ITEM, id, new BlockItem(block, settings));
    }

    public static List<Object> generateFromList(List<Object> items, List<Identifier> ids, List<Item.Settings> settings) {
        List<Object> Generated = new ArrayList()
        if (not (items.size() == ids.size() == settings.size())) {
            throw new IllegalStateException("Lists are not of the same size.");
        }
        for (i = 0; i < items.size(); i++) {
            if (items[i] instanceof Block) {
                Generated.add(generateBlock(items[i], ids[i]));
                Generated.add(generateBlockItem(items[i], ids[i], settings[i]));
            } else if (items[i] instanceof Item) {
                Generated.add(generateItem(items[i], ids[i]));
            } else {
                throw new IllegalArgumentException("All objects in list must be either Block or Item.");
            }
        }
        return Generated
    }
}
