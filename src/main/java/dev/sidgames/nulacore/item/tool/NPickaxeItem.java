package dev.sidgames.nulacore.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class NPickaxeItem extends PickaxeItem {
    public NPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(ItemGroup.TOOLS));
    }

    public NPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, ItemGroup group) {
        super(material, attackDamage, attackSpeed, new Settings().group(group));
    }

    public NPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
