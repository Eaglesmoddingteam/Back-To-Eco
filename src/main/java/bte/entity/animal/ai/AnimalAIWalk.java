package bte.entity.animal.ai;

import bte.entity.EntityBteAnimal;
import btf.main.Main;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class AnimalAIWalk extends EntityAIBase {
	EntityBteAnimal<?> entity;

	public AnimalAIWalk(EntityBteAnimal<?> entity) {
		this.entity=entity;
	}
	
	@Override
	public boolean shouldExecute() {
		return true;
	}
	
	private double getspeed() {
		World worldIn = this.entity.getEntityWorld();
		BlockPos pos = this.entity.getPosition();
		Biome biomeIn = worldIn.getBiome(pos);
		return this.entity.BIOMESIN.contains(biomeIn) ? 1.0 : 0.5;
	}
	
	@Override
	public void startExecuting() {
		Main.LOGGER.info("Starting walking");
		World worldIn = this.entity.getEntityWorld();
		BlockPos pos = this.entity.getPosition();
		Biome biomeIn = worldIn.getBiome(pos);
		Vec3d v = getPosition();
		if(this.entity.BIOMESIN.contains(biomeIn) && this.entity.BIOMESIN.contains(worldIn.getBiome(new BlockPos(v.x, v.y, v.z))))
		this.entity.getMoveHelper().setMoveTo(v.x, v.y, v.z, getspeed());
		else {
		v = getPosition();
		if(this.entity.BIOMESIN.contains(biomeIn) && this.entity.BIOMESIN.contains(worldIn.getBiome(new BlockPos(v.x, v.y, v.z))))
			this.entity.getMoveHelper().setMoveTo(v.x, v.y, v.z, getspeed());
		else
			this.entity.getMoveHelper().setMoveTo(v.x, v.y, v.z, 0.5);
		}
	}
	
	protected Vec3d getPosition()
    {
        if (this.entity.isInWater())
        {
            Vec3d vec3d = RandomPositionGenerator.getLandPos(this.entity, 15, 7);
            return vec3d == null ?  RandomPositionGenerator.findRandomTarget(this.entity, 10, 7) : vec3d;
        }
        else
        {
            return RandomPositionGenerator.getLandPos(this.entity, 10, 7); 
        }
    }

}
