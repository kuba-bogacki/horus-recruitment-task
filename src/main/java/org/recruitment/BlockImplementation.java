package org.recruitment;

import java.util.Objects;

public class BlockImplementation implements Block {

    private String color;
    private String material;

    public BlockImplementation(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockImplementation that = (BlockImplementation) o;
        return color.equals(that.color) && material.equals(that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }

    @Override
    public String toString() {
        return "BlockImplementation = [color = " + color + ", material = " + material + "]";
    }
}
