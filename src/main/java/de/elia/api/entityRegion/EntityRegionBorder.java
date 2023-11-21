package de.elia.api.entityRegion;

import org.bukkit.Particle;

import org.jetbrains.annotations.NotNull;

public class EntityRegionBorder {

  public EntityRegionBorder(@NotNull EntityRegion region, @NotNull Particle particle) {
    for (int degree = 0; degree < 360; degree ++) {
      degree++;
      double radians = Math.toRadians(degree);
      double x = region.getRadius() * Math.cos(radians);
      double z = region.getRadius() * Math.sin(radians);
      region.getCenter().add(x, 0, z);
      region.getCenter().getWorld().spawnParticle(particle, region.getCenter(), 1);
      region.getCenter().subtract(x, 0, z);
    }
  }
}
