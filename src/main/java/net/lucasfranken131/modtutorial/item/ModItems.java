package net.lucasfranken131.modtutorial.item;

import net.lucasfranken131.modtutorial.ModTutorial;
import net.lucasfranken131.modtutorial.item.custom.FireInator;
import net.lucasfranken131.modtutorial.item.custom.FuelItem;
import net.lucasfranken131.modtutorial.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModTutorial.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIREINATOR = ITEMS.register("fireinator", ()-> new FireInator(new Item.Properties().durability(300).fireResistant()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", () -> new MetalDetectorItem(new Item.Properties().durability(300)));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> COCA_COLA = ITEMS.register("coca_cola", () -> new Item(new Item.Properties().food(ModFoods.COCA_COLA)));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone", () -> new FuelItem(new Item.Properties(), 400));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
