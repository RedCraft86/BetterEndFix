package com.redcraft86.betterendfix.mixin;

import java.util.Set;
import java.util.List;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.loading.FMLLoader;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public class MixinPlugin implements IMixinConfigPlugin {
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    public boolean shouldApplyMixin(String targetClass, String mixinClass) {
        if (mixinClass.endsWith("BlueprintMixin")) {
            LOGGER.info("Applying BetterEndFix for Blueprint");
            return isModIncluded("blueprint");
        }
        if (mixinClass.endsWith("LionfishMixin")) {
            LOGGER.info("Applying BetterEndFix for Lionfish API");
            return isModIncluded("lionfishapi");
        }
        return true;
    }

    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() { return null; }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {}

    @Override
    public List<String> getMixins() { return null; }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {}

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {}

    private static boolean isModIncluded(String modID) {
        return FMLLoader.getLoadingModList().getModFileById(modID) != null;
    }
}
