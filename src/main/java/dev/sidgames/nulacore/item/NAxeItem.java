package dev.sidgames.nulacore.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class NAxeItem extends AxeItem {
    public NAxeItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Item.Settings().group(ItemGroup.TOOLS));
    }

    public NAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, ItemGroup group) {
        super(material, attackDamage, attackSpeed, new Item.Settings().group(group));
    }

    public NAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
