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
}
