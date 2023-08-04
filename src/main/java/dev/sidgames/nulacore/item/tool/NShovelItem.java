package dev.sidgames.nulacore.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class NShovelItem extends ShovelItem {
    public NShovelItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(ItemGroup.TOOLS));
    }

    public NShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, ItemGroup group) {
        super(material, attackDamage, attackSpeed, new Settings().group(group));
    }

    public NShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
