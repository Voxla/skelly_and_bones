package net.mcreator.skellyandbones.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.skellyandbones.init.SkellyAndBonesModItems;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;

public class SetPageTradesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0) == 0) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(7)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem1") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_SWORD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(8)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_SWORD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(8)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(SkellyAndBonesModItems.IRON_PIKE.get());
					_setstack.setCount(1);
					((Slot) _slots.get(8)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.STONE_SWORD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(8)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.BOW), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(8)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CROSSBOW), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(8)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		} else {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(8)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem1") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_SWORD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(77)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_SWORD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(7)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(SkellyAndBonesModItems.IRON_PIKE.get());
					_setstack.setCount(1);
					((Slot) _slots.get(7)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.STONE_SWORD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(7)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.BOW), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(7)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem1") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CROSSBOW), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(7)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(1) == 0) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(6)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem2") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.LEATHER_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(9)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CHAINMAIL_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(9)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(9)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(9)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(SkellyAndBonesModItems.IRON_KNIGHT_HELMET.get());
					_setstack.setCount(1);
					((Slot) _slots.get(9)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.SHIELD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(9)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		} else {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(9)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem2") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.LEATHER_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(6)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CHAINMAIL_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(6)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(6)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_HELMET), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(6)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(SkellyAndBonesModItems.IRON_KNIGHT_HELMET.get());
					_setstack.setCount(1);
					((Slot) _slots.get(6)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem2") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.SHIELD), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(6)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(2) == 0) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(5)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem3") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.LEATHER_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(10)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CHAINMAIL_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(10)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(10)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(10)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.LEATHER_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(10)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CHAINMAIL_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(10)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		} else {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(10)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem3") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.LEATHER_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(5)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CHAINMAIL_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(5)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(5)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(5)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.LEATHER_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(5)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem3") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.CHAINMAIL_CHESTPLATE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(5)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(3) == 0) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(4)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem4") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(11)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.WOODEN_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(11)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(11)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.STONE_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(11)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.WOODEN_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(11)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(11)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		} else {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(11)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity.getPersistentData().getDouble("playerTradeItem4") == 1) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.DIAMOND_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 2) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.WOODEN_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 3) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 4) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.STONE_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 5) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.WOODEN_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (entity.getPersistentData().getDouble("playerTradeItem4") == 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(new Random(), new ItemStack(Items.IRON_PICKAXE), 30, false));
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}
