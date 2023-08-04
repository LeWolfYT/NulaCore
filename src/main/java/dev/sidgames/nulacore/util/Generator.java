package dev.sidgames.nulacore.util;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static Item generateItem(Item item, Identifier id) {
        return Registry.register(Registry.ITEM, id, item);
    }

    public static Block generateBlock(Block block, Identifier id) {
        return Registry.register(Registry.BLOCK, id, block);
    }

    public static BlockItem generateBlockItem(Block block, Identifier id, ItemGroup group) {
        return Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(group)));
    }

    public static BlockItem generateBlockItem(Block block, Identifier id, Item.Settings settings) {
        return Registry.register(Registry.ITEM, id, new BlockItem(block, settings));
    }

    public static <T> List<T> generateFromList(List<T> items, List<Identifier> ids, List<Item.Settings> settings) {
        List<Object> Generated = new ArrayList<>();
        if (items.size() != ids.size() && ids.size() != settings.size()) {
            throw new IllegalStateException("Lists are not of the same size.");
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Block) {
                Generated.add(generateBlock((Block) items.get(i), ids.get(i)));
                Generated.add(generateBlockItem((Block) items.get(i), ids.get(i), settings.get(i)));
            } else if (items.get(i) instanceof Item) {
                Generated.add(generateItem((Item) items.get(i), ids.get(i)));
            } else {
                throw new IllegalArgumentException("All objects in list must be either Block or Item.");
            }
        }
        return (List<T>) Generated;
    }
}
