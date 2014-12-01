package com.netcrafter.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.netcrafter.mod.armor.GayArmor;
import com.netcrafter.mod.armor.RevolutionArmor;
import com.netcrafter.mod.blocks.RPGBlocks;
import com.netcrafter.mod.entity.boss.EntityGayArazhul;
import com.netcrafter.mod.entity.boss.EntityPumpkinMutant;
import com.netcrafter.mod.entity.boss.EntityTrollFace;
import com.netcrafter.mod.entity.monster.EntityGriefer;
import com.netcrafter.mod.entity.monster.EntityPumpkinMonster;
import com.netcrafter.mod.handler.BossHandler;
import com.netcrafter.mod.handler.CraftingHandler;
import com.netcrafter.mod.handler.EntityHandler;
import com.netcrafter.mod.handler.FuelHandler;
import com.netcrafter.mod.items.DurableItems;
import com.netcrafter.mod.items.RPGFood;
import com.netcrafter.mod.items.RPGItems;
import com.netcrafter.mod.melonland.WorldGen;
import com.netcrafter.mod.melonland.portal.MelonLandBlock;
import com.netcrafter.mod.melonland.portal.MelonLandPortal;
import com.netcrafter.mod.melonland.portal.MelonLandPortalActivator;
import com.netcrafter.mod.melonland.provider.WorldProviderMelonLand;
import com.netcrafter.mod.model.ModelGayArazhul;
import com.netcrafter.mod.model.ModelGriefer;
import com.netcrafter.mod.model.ModelPumpkinMonster;
import com.netcrafter.mod.model.ModelPumpkinMutant;
import com.netcrafter.mod.model.ModelTrollFace;
import com.netcrafter.mod.proxy.CommonProxy;
import com.netcrafter.mod.renderer.RenderGayArazhul;
import com.netcrafter.mod.renderer.RenderGriefer;
import com.netcrafter.mod.renderer.RenderPumpkinMonster;
import com.netcrafter.mod.renderer.RenderPumpkinMutant;
import com.netcrafter.mod.renderer.RenderTrollFace;
import com.netcrafter.mod.weapons.Generation;
import com.netcrafter.mod.weapons.RevBow;
import com.netcrafter.mod.weapons.Revolution;
import com.netcrafter.mod.weapons.Ultimate;
import com.netcrafter.mod.weapons.Weapons;
import com.netcrafter.mod.world.RPGWorldGen;
import com.netcrafter.mod.world.biome.RPGBiomes;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = LidlMelonRPG.modid, version = LidlMelonRPG.version)
public class LidlMelonRPG {
	
	//ModID
	public static final String modid = "LidlMelonRPG";
   public static final String version = "Alpha v.01";
    
    //MelonLand: Dimension
    public static Block portalMelonLand;
    public static Block blockMelonShard;
    public static Block melonActivator;
    public static int dimid = 2;
    
    //Creative Tabs
    public static CreativeTabs rpgMaterialTab;
    public static CreativeTabs rpgWeaponsTab;
    public static CreativeTabs rpgArmorsTab;
    public static CreativeTabs rpgMelonsTab;
    
   	//WorldGen
	RPGWorldGen eventWorldGen = new RPGWorldGen();
    
    //Tool Material
    public static ToolMaterial ModMaterial = EnumHelper.addToolMaterial("ModMaterial", 2, 4000, 10.0F, 10.0F, 10);
    public static ToolMaterial CheatMaterial = EnumHelper.addToolMaterial("CheatMaterial", 0, 59, 2.0F, 1.0F, 20);
    public static ToolMaterial GriefMaterial = EnumHelper.addToolMaterial("GriefMaterial", 2, 4000, 10.0F, 7.0F, 20);
    public static ToolMaterial HomoMaterial = EnumHelper.addToolMaterial("HomoMaterial", 2, 4000, 10.0F, 16.0F, 40);
    public static ToolMaterial NinjaMaterial = EnumHelper.addToolMaterial("NinjaMaterial", 2, 4000, 10.0F, 4.0F, 20);
    public static ToolMaterial UltraNinjaMaterial = EnumHelper.addToolMaterial("UltraNinjaMaterial", 10, 8000, 40.0F, 40.0F, 50);
    public static ToolMaterial Furzblade = EnumHelper.addToolMaterial("Furzblade", 10, 8000, 40.0F, 96.0F, 50);
    public static ToolMaterial Generation = EnumHelper.addToolMaterial("Generation", 18, 8000, 40.0F, 440.0F, 80);
    public static ToolMaterial NinjaMelon = EnumHelper.addToolMaterial("NinjaMelon", 20, 8000, 496.0F, 496.0F, 100);
    public static ToolMaterial Ultimate = EnumHelper.addToolMaterial("Ultimate", 30, 10000, 4440.0F, 4440.0F, 500);
    
    //Armor Material
    public static ArmorMaterial GayMaterial =  EnumHelper.addArmorMaterial("GayMaterial", 3000, new int[] {8, 16, 12, 20}, 500);
    public static ArmorMaterial Revolution = EnumHelper.addArmorMaterial("Revolution", 6000, new int[] {16, 32, 24, 40}, 1000);
    
    @Instance(modid)
	public static LidlMelonRPG instance;
    
    //Weapons
    public static Item itemModBlade;
    public static Item itemCheaterSword;
    public static Item itemGrieferSword;
    public static Item itemHomoSword;
    public static Item itemNinjaKatana;
    public static Item itemUltraNinja;
    public static Item itemRevolution;
    public static Item itemPreGeneration;
    public static Item itemFurzblade;
    public static Item itemGeneration;
    public static Item itemNinjaMelon;
    public static Item itemUltimate;
    public static Item itemRevBow;
    
    //Armor
    public static int gayHelmID;
    public static int gayChestID;
    public static int gayLegsID;
    public static int gayBootsID;
    
    public static Item gayHelm;
    public static Item gayChest;
    public static Item gayLegs;
    public static Item gayBoots;
    
    public static int revolutionHelmID;
    public static int revolutionChestID;
    public static int revolutionLegsID;
    public static int revolutionBootsID;
    
    public static Item revolutionHelm;
    public static Item revolutionChest;
    public static Item revolutionLegs;
    public static Item revolutionBoots;
    
    //Blocks
    public static Block blockLidl;
    public static Block blockGrief;
    public static Block blockTroll;
    public static Block blockYTroll;
    public static Block blockLucky;
    public static Block blockRoman;
    public static Block blockFurzPortal;
    public static Block blockFurz;
    public static Block blockKKBlock;
    public static Block blockUCSBlock;
    
    //Items
    public static Item itemMelonShard;
    public static Item itemPumpkinBlood;
    public static Item itemActionFigur;
    public static Item itemPlastik;
    public static Item itemLidlIngot;
    public static Item itemGrieferIngot;
    public static Item itemGayIngot;
    public static Item itemObsidianIngot;
    public static Item itemRomanDeath;
    public static Item itemChaosNugget;
    public static Item itemLuckyIngot;
    public static Item itemRomanIngot;
    public static Item itemFurzShard;
    public static Item itemHardenedFart;
    public static Item itemStolenMelons;
    public static Item itemJBCD;
    public static Item itemNGPShard;
    public static Item itemBieberSpawnegg;
    public static Item itemChaosShard;
    public static Item itemUCShard;
    public static Item itemNGPKnife;
    public static Item itemHalfIron;
    
    @SidedProxy(clientSide = "com.netcrafter.mod.proxy.ClientProxy", serverSide = "com.netcrafter.mod.proxy.CommonProxy")
	public static CommonProxy proxy;
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent preEvent){
    	
    	//MelonLand: Dimension
    	portalMelonLand = new MelonLandPortal().setBlockName("MelonLandPortal").setCreativeTab(LidlMelonRPG.rpgMelonsTab);
    	melonActivator = new MelonLandPortalActivator().setBlockName("MelonLandPortalActivator").setCreativeTab(LidlMelonRPG.rpgMelonsTab);
    	
    	//Biomes
    	RPGBiomes.init();
    	
    	//CreativeTabs
    	rpgMaterialTab = new CreativeTabs("rpgMaterial") {
    		@SideOnly(Side.CLIENT)
    		public Item getTabIconItem() {
    			return Item.getItemFromBlock(LidlMelonRPG.blockMelonShard);
    		}
    	};
    	
    	rpgWeaponsTab = new CreativeTabs("rpgWeapons") {
    		@SideOnly(Side.CLIENT)
    		public Item getTabIconItem() {
    			return Item.getItemFromBlock(LidlMelonRPG.portalMelonLand);
    		}
    	};
    	
    	rpgArmorsTab = new CreativeTabs("rpgArmors") {
    		@SideOnly(Side.CLIENT)
    		public Item getTabIconItem() {
    			return Item.getItemFromBlock(LidlMelonRPG.blockFurzPortal);
    		}	
    	};
    	
    	rpgMelonsTab = new CreativeTabs("rpgMelons") {
    		@SideOnly(Side.CLIENT)
    		public Item getTabIconItem() {
    			return Item.getItemFromBlock(LidlMelonRPG.melonActivator);
    		}	
    	};

    	//Weapons
    	itemModBlade = new Weapons(ModMaterial).setUnlocalizedName("ModBlade");
    	itemCheaterSword = new Weapons(CheatMaterial).setUnlocalizedName("CheaterSword");
    	itemGrieferSword = new Weapons(GriefMaterial).setUnlocalizedName("GrieferSword");
    	itemHomoSword = new Weapons(HomoMaterial).setUnlocalizedName("HomoSword");
    	itemNinjaKatana = new Weapons(NinjaMaterial).setUnlocalizedName("NinjaKatana");
    	itemUltraNinja = new Weapons(UltraNinjaMaterial).setUnlocalizedName("UltraNinja");
    	itemRevolution = new Revolution(UltraNinjaMaterial).setUnlocalizedName("Revolution");
    	itemPreGeneration = new Revolution(Furzblade).setUnlocalizedName("PreGeneration");
    	itemFurzblade = new Weapons(Furzblade).setUnlocalizedName("Furzblade");
    	itemGeneration = new Generation(Generation).setUnlocalizedName("Generation");
    	itemNinjaMelon = new Weapons(NinjaMelon).setUnlocalizedName("NinjaMelon");
    	itemUltimate = new Ultimate(Ultimate).setUnlocalizedName("Ultimate");
    	itemRevBow = new RevBow().setUnlocalizedName("RevBow");
    	
    	//Armor
    	gayHelm = new GayArmor(GayMaterial, gayHelmID, 0).setUnlocalizedName("GayHelm");
    	gayChest = new GayArmor(GayMaterial, gayChestID, 1).setUnlocalizedName("GayChest");
    	gayLegs = new GayArmor(GayMaterial, gayLegsID, 2).setUnlocalizedName("GayLegs");
    	gayBoots = new GayArmor(GayMaterial, gayBootsID, 3).setUnlocalizedName("GayBoots");
    	
        revolutionHelm = new RevolutionArmor(Revolution, revolutionHelmID, 0).setUnlocalizedName("RevolutionHelm");
        revolutionChest = new RevolutionArmor(Revolution, revolutionChestID, 1).setUnlocalizedName("RevolutionChest");
        revolutionLegs = new RevolutionArmor(Revolution, revolutionLegsID, 2).setUnlocalizedName("RevolutionLegs");
        revolutionBoots = new RevolutionArmor(Revolution, revolutionBootsID, 3).setUnlocalizedName("RevolutionBoots");
    	
    	//Blocks
    	blockMelonShard = new MelonLandBlock().setBlockName("MelonShardBlock");
    	blockGrief = new RPGBlocks(Material.rock).setBlockName("Grief");
    	blockLidl = new RPGBlocks(Material.rock).setBlockName("Lidl");
        blockTroll = new RPGBlocks(Material.rock).setBlockName("Troll");
    	blockYTroll = new RPGBlocks(Material.rock).setBlockName("YTroll");
        blockLucky = new RPGBlocks(Material.rock).setBlockName("Lucky");
    	blockRoman = new RPGBlocks(Material.rock).setBlockName("Roman");
    	blockFurzPortal = new RPGBlocks(Material.rock).setBlockName("FurzPortal");
    	blockFurz = new RPGBlocks(Material.rock).setBlockName("Furz");
    	blockKKBlock = new RPGBlocks(Material.rock).setBlockName("KKBlock");
    	blockUCSBlock = new RPGBlocks(Material.rock).setBlockName("UCSBlock");
    	
    	//Items
    	itemNGPKnife = new DurableItems().setUnlocalizedName("NGPKnife");
    	itemHalfIron = new RPGItems().setUnlocalizedName("HalfIron");
    	itemMelonShard = new RPGItems().setUnlocalizedName("MelonShard");
    	itemPumpkinBlood = new RPGItems().setUnlocalizedName("PumpkinBlood");
    	itemActionFigur = new RPGItems().setUnlocalizedName("ActionFigur");
    	itemPlastik = new RPGItems().setUnlocalizedName("Plastik");
    	itemLidlIngot = new RPGItems().setUnlocalizedName("LidlIngot");
    	itemGrieferIngot = new RPGItems().setUnlocalizedName("GrieferIngot");
    	itemGayIngot = new RPGItems().setUnlocalizedName("GayIngot");
    	itemObsidianIngot = new RPGItems().setUnlocalizedName("ObsidianIngot");
    	itemRomanDeath = new RPGItems().setUnlocalizedName("RomanDeath");
    	itemChaosNugget = new RPGItems().setUnlocalizedName("ChaosNugget");
    	itemLuckyIngot = new RPGItems().setUnlocalizedName("LuckyIngot");
    	itemRomanIngot = new RPGItems().setUnlocalizedName("RomanIngot");
    	itemFurzShard = new RPGItems().setUnlocalizedName("FurzShard");
    	itemHardenedFart = new RPGItems().setUnlocalizedName("HardenedFart");
    	itemStolenMelons = new RPGItems().setUnlocalizedName("StolenMelons");
    	itemJBCD = new RPGItems().setUnlocalizedName("JBCD");
    	itemNGPShard = new RPGItems().setUnlocalizedName("NGPShard");
    	itemBieberSpawnegg = new RPGItems().setUnlocalizedName("BieberSpawnegg");
    	itemChaosShard = new RPGFood(6, (float) 0.6, true).setUnlocalizedName("ChaosShard");
    	itemUCShard = new RPGItems().setUnlocalizedName("UCShard");
    	
    	//MelonLand: Dimension Registry
    	GameRegistry.registerBlock(portalMelonLand, "MelonLandPortal");
    	GameRegistry.registerBlock(melonActivator, "MelonLandPortalActivator");
    	
    	//Weapon Registry
    	GameRegistry.registerItem(itemModBlade, "ModBlade");
    	GameRegistry.registerItem(itemCheaterSword, "CheaterSword");
    	GameRegistry.registerItem(itemGrieferSword, "GrieferSword");
    	GameRegistry.registerItem(itemHomoSword, "HomoSword");
    	GameRegistry.registerItem(itemNinjaKatana, "NinjaKatana");
    	GameRegistry.registerItem(itemUltraNinja, "UltraNinja");
    	GameRegistry.registerItem(itemRevolution, "Revolution");
    	GameRegistry.registerItem(itemPreGeneration, "PreGeneration");
    	GameRegistry.registerItem(itemFurzblade, "Furzblade");
    	GameRegistry.registerItem(itemGeneration, "Generation");
    	GameRegistry.registerItem(itemNinjaMelon, "NinjaMelon");
    	GameRegistry.registerItem(itemUltimate, "Ultimate");
    	GameRegistry.registerItem(itemRevBow, "RevBow");
    	
    	//Armor Registry
    	GameRegistry.registerItem(gayHelm, "GayHelm");
    	GameRegistry.registerItem(gayChest, "GayChest");
    	GameRegistry.registerItem(gayLegs, "GayLegs");
    	GameRegistry.registerItem(gayBoots, "GayBoots");
    	
    	GameRegistry.registerItem(revolutionHelm, "RevolutionHelm");
    	GameRegistry.registerItem(revolutionChest, "RevolutionChest");
    	GameRegistry.registerItem(revolutionLegs, "RevolutionLegs");
    	GameRegistry.registerItem(revolutionBoots, "RevolutionBoots");
    	
    	//Block Registry
    	GameRegistry.registerBlock(blockMelonShard, "MelonShardBlock");
    	GameRegistry.registerBlock(blockGrief, "Grief");
    	GameRegistry.registerBlock(blockLidl, "Lidl");
    	GameRegistry.registerBlock(blockTroll, "Troll");
    	GameRegistry.registerBlock(blockYTroll, "YTroll");
    	GameRegistry.registerBlock(blockLucky, "Lucky");
    	GameRegistry.registerBlock(blockRoman, "Roman");
    	GameRegistry.registerBlock(blockFurzPortal, "FurzPortal");
    	GameRegistry.registerBlock(blockFurz, "Furz");
    	GameRegistry.registerBlock(blockKKBlock, "KKBlock");
    	GameRegistry.registerBlock(blockUCSBlock, "UCSBlock");
    	
    	//Item Registry
    	GameRegistry.registerItem(itemHalfIron, "HalfIron");
    	GameRegistry.registerItem(itemNGPKnife, "NGPKnife");
    	GameRegistry.registerItem(itemMelonShard, "MelonShard");
    	GameRegistry.registerItem(itemPumpkinBlood, "PumpkinBlood");
    	GameRegistry.registerItem(itemActionFigur, "ActionFigur");
    	GameRegistry.registerItem(itemPlastik, "Plastik");
    	GameRegistry.registerItem(itemLidlIngot, "LidlIngot");
    	GameRegistry.registerItem(itemGrieferIngot, "GrieferIngot");
    	GameRegistry.registerItem(itemGayIngot, "GayIngot");
    	GameRegistry.registerItem(itemObsidianIngot, "ObsidianIngot");
    	GameRegistry.registerItem(itemRomanDeath, "RomanDeath");
    	GameRegistry.registerItem(itemChaosNugget, "ChaosNugget");
    	GameRegistry.registerItem(itemLuckyIngot, "LuckyIngot");
    	GameRegistry.registerItem(itemRomanIngot, "RomanIngot");
    	GameRegistry.registerItem(itemFurzShard, "FurzShard");
    	GameRegistry.registerItem(itemHardenedFart, "HardenedFart");
    	GameRegistry.registerItem(itemStolenMelons, "StolenMelons");
    	GameRegistry.registerItem(itemJBCD, "JBCD");
    	GameRegistry.registerItem(itemNGPShard, "NGPShard");
    	GameRegistry.registerItem(itemBieberSpawnegg, "BieberSpawnegg");
    	GameRegistry.registerItem(itemChaosShard, "ChaosShard");
    	GameRegistry.registerItem(itemUCShard, "UCShard");
    	
    	//WorldGen Registry
    	GameRegistry.registerWorldGenerator(new RPGWorldGen(), 1);
    	
    	//Entity Registry
    	EntityRegistry.registerGlobalEntityID(EntityPumpkinMonster.class, "PumpkinMonster", 106, 0, 0);
    	EntityRegistry.registerGlobalEntityID(EntityPumpkinMutant.class, "PumpkinMutant", 107, 0, 1);
    	EntityRegistry.registerGlobalEntityID(EntityGayArazhul.class, "GayArazhul", 108, 0, 1);
    	EntityRegistry.registerGlobalEntityID(EntityGriefer.class, "Griefer", 109, 0, 1);
    	EntityRegistry.registerGlobalEntityID(EntityTrollFace.class, "TrollFace", 110, 0, 1);
    	
    	//Rendering Registry
    	RenderingRegistry.registerEntityRenderingHandler(EntityPumpkinMonster.class, new RenderPumpkinMonster(new ModelPumpkinMonster(), 0.3F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGriefer.class, new RenderGriefer(new ModelGriefer(), 0.3F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityPumpkinMutant.class, new RenderPumpkinMutant(new ModelPumpkinMutant(), 0.4F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGayArazhul.class, new RenderGayArazhul(new ModelGayArazhul(), 0.4F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTrollFace.class, new RenderTrollFace(new ModelTrollFace(), 0.4F));
    	
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event){
    	
    	FMLCommonHandler.instance().bus().register(new CraftingHandler());
    	
    	//Dimension Managers
    	DimensionManager.registerProviderType(dimid, WorldProviderMelonLand.class, false);
    	DimensionManager.registerDimension(dimid, dimid);
    	
    	//Recipes
    	GameRegistry.addShapelessRecipe(new ItemStack(itemHalfIron, 2), new Object[]{new ItemStack(itemNGPKnife, 1, OreDictionary.WILDCARD_VALUE), Items.iron_ingot});
    	GameRegistry.addRecipe(new ItemStack(itemNGPKnife), new Object[]{" I ", " I ", " N ", 'I', Items.iron_sword, 'N', itemNGPShard});
    	GameRegistry.addRecipe(new ItemStack(blockMelonShard), new Object[]{"   ", " MM", " MM", 'M', itemMelonShard});
    	GameRegistry.addRecipe(new ItemStack(blockRoman), new Object[]{"   ", " MM", " MM", 'M', itemRomanIngot});
    	GameRegistry.addRecipe(new ItemStack(blockFurz), new Object[]{"   ", " MM", " MM", 'M', itemHardenedFart});
    	GameRegistry.addRecipe(new ItemStack(blockUCSBlock), new Object[]{"   ", " MM", " MM", 'M', itemUCShard});
    	GameRegistry.addRecipe(new ItemStack(blockGrief), new Object[]{"OXO", "XOX", "OXO", 'O', itemGrieferIngot, 'X', itemGayIngot});
    	GameRegistry.addRecipe(new ItemStack(itemMelonShard), new Object[]{"GMG", "MDM", "OOO", 'G', Items.ghast_tear, 'D', Items.diamond, 'M', Items.melon, 'O', Blocks.obsidian});
    	GameRegistry.addRecipe(new ItemStack(itemChaosShard), new Object[]{"COC", "DCD", "MMM", 'C', itemChaosNugget, 'D', Items.diamond, 'M', itemMelonShard, 'O', Blocks.obsidian});
    	GameRegistry.addRecipe(new ItemStack(blockKKBlock), new Object[]{"FKF", "KOK", "FKF", 'F', itemHardenedFart, 'K', Blocks.pumpkin, 'O', Blocks.obsidian});
    	GameRegistry.addRecipe(new ItemStack(blockLidl), new Object[]{"LLL", "LLL", "LLL", 'L', blockLidl});
    	GameRegistry.addRecipe(new ItemStack(melonActivator), new Object[]{"MM ", "M M", " MM", 'M', itemMelonShard});
    	
        //Weapon Recipes
    	GameRegistry.addRecipe(new ItemStack(itemModBlade), new Object[]{" X ", " X ", "S", 'X', itemMelonShard, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemHomoSword), new Object[]{"GOG", "DOD", "GSG", 'G', blockGrief , 'O', Blocks.obsidian, 'D', Items.diamond, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemUltraNinja), new Object[]{"XRX", "LRL", "CSC", 'X', itemLidlIngot, 'R', itemRomanIngot, 'L', itemLuckyIngot, 'C', itemChaosNugget, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemRevolution), new Object[]{" X ", "XXX", "S", 'X', itemChaosNugget, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemPreGeneration), new Object[]{"CFC", "CFC", "OSO", 'C', itemChaosNugget, 'F', itemHardenedFart, 'O', Blocks.obsidian, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemFurzblade), new Object[]{"OFO", "OFO", "CSC", 'O', Blocks.obsidian, 'F', itemHardenedFart, 'C', itemChaosNugget, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemGeneration), new Object[]{"OCO", "OCO", "DSD", 'O', Blocks.obsidian, 'C', itemChaosShard, 'D', Items.diamond, 'S', Items.stick});  
    	GameRegistry.addRecipe(new ItemStack(itemNinjaMelon), new Object[]{"ONO", "ONO", "CSC", 'O', Blocks.obsidian, 'C', itemChaosShard, 'N', itemNGPShard, 'S', Items.stick});  
    	GameRegistry.addRecipe(new ItemStack(itemUltimate), new Object[]{"OUO", "CUC", "USU", 'O', Blocks.obsidian, 'U', itemUCShard, 'C', itemChaosNugget, 'S', Items.stick});
    	
    	//Armor Recipes
    	GameRegistry.addRecipe(new ItemStack(revolutionHelm), new Object[]{"XXX", "X X", "   ", 'X', itemChaosNugget});
    	GameRegistry.addRecipe(new ItemStack(revolutionChest), new Object[]{"X X", "XXX", "XXX", 'X', itemChaosNugget});
    	GameRegistry.addRecipe(new ItemStack(revolutionLegs), new Object[]{"XXX", "X X", "X X", 'X', itemChaosNugget});
    	GameRegistry.addRecipe(new ItemStack(revolutionBoots), new Object[]{"   ", "X X", "X X", 'X', itemChaosNugget});
    	
    	//Smelting
    	GameRegistry.addSmelting(itemPlastik, new ItemStack(itemLidlIngot, 16), 16);
    	GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(itemObsidianIngot), 16);
    	GameRegistry.addSmelting(blockGrief, new ItemStack(blockTroll), 16);
    	GameRegistry.addSmelting(blockLucky, new ItemStack(itemLuckyIngot, 4), 16);
    	GameRegistry.addSmelting(itemRomanDeath, new ItemStack(itemRomanIngot, 64), 16);
    	GameRegistry.addSmelting(blockRoman, new ItemStack(blockFurzPortal), 16);
    	GameRegistry.addSmelting(itemFurzShard, new ItemStack(itemHardenedFart), 16);
    	GameRegistry.addSmelting(itemStolenMelons, new ItemStack(itemMelonShard), 16);
    	GameRegistry.addSmelting(itemJBCD, new ItemStack(itemBieberSpawnegg), 16);
    	
    	//Handler
    	GameRegistry.registerFuelHandler(new FuelHandler());
    	
    	//Entities
    	EntityHandler.registerVioletFieldsMonsters(EntityPumpkinMonster.class, "PumpkinMonster");
    	EntityHandler.registerGrieferMonsters(EntityGriefer.class, "Griefer");
    	
    	//Bosses
    	BossHandler.registerBosses(EntityPumpkinMutant.class, "PumpkinMutant");
    	BossHandler.registerBosses(EntityGayArazhul.class, "GayArazhul");
    	BossHandler.registerBosses(EntityTrollFace.class, "TrollFace");
    	
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent postEvent){
    	
    }
  	
} 
