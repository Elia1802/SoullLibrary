package de.elia.api.entityRegion;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class EntityRegionBuilder {

  @NotNull
  public static Collection<LivingEntity> getAllEntitiesInRegion(@NotNull EntityRegion region){
    return region.getCenter().getNearbyLivingEntities(region.getRadius());
  }

  public boolean containsEntity(@NotNull LivingEntity entity, @NotNull EntityRegion region){
    if (entity.getLocation().distance(region.getCenter()) < region.getRadius()) {
      return true;
    }else return false;
  }

  public static void delete(@NotNull EntityRegion region) {
    region.delete();
  }

  @NotNull
  public static EntityRegion create(@NotNull Location center, double radius, @NotNull LivingEntity regionOwner, boolean pvp, boolean pvpWithProjectile){
    return new EntityRegion(center, radius, regionOwner, pvp, pvpWithProjectile);
  }

  public static void createEntityRegionBorder(EntityRegion region, Particle particle){
    new EntityRegionBorder(region, particle);
  }

}
