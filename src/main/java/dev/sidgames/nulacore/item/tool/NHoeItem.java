package dev.sidgames.nulacore.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class NHoeItem extends HoeItem {
    public NHoeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(ItemGroup.TOOLS));
    }

    public NHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, ItemGroup group) {
        super(material, attackDamage, attackSpeed, new Settings().group(group));
    }

    public NHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
