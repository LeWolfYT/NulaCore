package dev.sidgames.nulacore.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class NSwordItem extends SwordItem {
    public NSwordItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(ItemGroup.TOOLS));
    }

    public NSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, ItemGroup group) {
        super(material, attackDamage, attackSpeed, new Settings().group(group));
    }

    public NSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
