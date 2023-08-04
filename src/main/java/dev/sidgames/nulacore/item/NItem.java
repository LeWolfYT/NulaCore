package dev.sidgames.nulacore.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class NItem extends Item {
    public NItem(ItemGroup group) {
        super(new Item.Settings().group(group));
    }

    public NItem(Item.Settings settings) {
        super(settings);
    }
}
