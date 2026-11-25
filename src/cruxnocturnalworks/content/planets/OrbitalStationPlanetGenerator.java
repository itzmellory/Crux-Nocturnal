package cruxnocturnalworks.content.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.maps.planet.SerpuloPlanetGenerator;

public class OrbitalStationPlanetGenerator extends SerpuloPlanetGenerator {
    private final Color water1 = Color.valueOf("6d7cdf");
    private final Color water2 = Color.valueOf("6058ba");
    private final Color iceWater1 = Color.valueOf("9fa7de");
    private final Color iceWater2 = Color.valueOf("828edd");
    private final Color ice1 = Color.valueOf("b2c3cb");
    private final Color ice2 = Color.valueOf("97adb5");
    private final Color blueIce1 = Color.valueOf("aab2d2");
    private final Color blueIce2 = Color.valueOf("8e9fc1");
    private final Color cap1 = Color.valueOf("d3dce7");
    private final Color cap2 = Color.valueOf("bad2e2");
    private final float capThreshold = 1.13f;
    private final float ridgeThreshold = 0.42f;

    public OrbitalStationPlanetGenerator() {
        baseSeed = 12345;
    }

    @Override
    public float getHeight(Vec3 position) {
        return rawHeight(position);
    }

    @Override
    public void getColor(Vec3 position, Color out) {
        float poles = Math.abs(position.y);
        float base = Simplex.noise3d(seed, 6, 0.7f, 0.8f, position.x, position.y, position.z);
        float t = Mathf.clamp(Mathf.round(base, 0.15f));
        float height = rawHeight(position);
        float slope = getSlope(position, 0.05f);
        float cliffs = Ridged.noise3d(baseSeed, position.x, position.y, position.z, 5, 2f);

        if (height > 0f || slope > 0.08f) {
            if (poles + base * 0.5f > capThreshold) {
                out.set(cap1).lerp(cap2, t);
                return;
            }
            float factor = (poles - ridgeThreshold) / ((capThreshold - 0.2f) - ridgeThreshold);
            if (factor * cliffs > 0.2f) {
                out.set(blueIce1).lerp(blueIce2, t);
            } else {
                out.set(ice1).lerp(ice2, t);
            }
            return;
        }

        float waterFactor = (poles - ridgeThreshold * 0.8f) / (capThreshold - ridgeThreshold * 0.8f);
        float spike = Simplex.noise3d(seed + 2, 8, 0.55f, 1.4f, position.x, position.y, position.z);
        if (waterFactor > 0f && cliffs > 0.18f) {
            out.set(iceWater1).lerp(iceWater2, cliffs);
        } else if (spike * base * waterFactor * 2f > 0.23f) {
            out.set(iceWater1).lerp(iceWater2, spike);
        } else {
            out.set(water1).lerp(water2, t);
        }
    }

    private float rawHeight(Vec3 position) {
        float poles = Math.abs(position.y);
        float base = Simplex.noise3d(seed, 6, 0.7f, 0.8f, position.x, position.y, position.z);
        float cliffs = Ridged.noise3d(baseSeed, position.x, position.y, position.z, 5, 2f);

        if (poles + base * 0.5f > capThreshold) {
            return 0.23f + Simplex.noise3d(seed, 5, 0.7f, 0.86f, position.x, position.y, position.z) * 0.7f;
        }
        if (poles > ridgeThreshold) {
            float factor = (poles - ridgeThreshold) / ((capThreshold - 0.2f) - ridgeThreshold);
            return cliffs * factor > 0.05f ? cliffs * 0.37f : 0f;
        }
        if (poles > 0.3f) {
            float spike = Simplex.noise3d(seed + 2, 8, 0.55f, 1.4f, position.x, position.y, position.z);
            if (spike > 0.8f) {
                float factor = Mathf.clamp((poles - 0.4f) / (ridgeThreshold - 0.4f));
                return (spike - 0.8f) / 0.2f * 0.3f * factor;
            }
        }
        float berg = Simplex.noise3d(seed + 1, 5, 0.6f, 1.3f, position.x, position.y, position.z);
        if (berg > 0.65f) {
            return Mathf.pow((berg - 0.65f) / 0.35f, 0.5f) * 0.5f;
        }
        return 0f;
    }

    private float getSlope(Vec3 position, float sampleRadius) {
        float center = getHeight(position);
        Vec3[] samples = {
            position.cpy().add(sampleRadius, 0f, 0f),
            position.cpy().add(-sampleRadius, 0f, 0f),
            position.cpy().add(0f, 0f, sampleRadius),
            position.cpy().add(0f, 0f, -sampleRadius)
        };
        float sum = 0f;
        for (Vec3 sample : samples) {
            sum += Math.abs(center - getHeight(sample));
        }
        return sum / samples.length;
    }
                                               }
