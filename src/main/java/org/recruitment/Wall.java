package org.recruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(final CompositeBlock compositeBlock) {
        this.blocks = generateListIfBlocksIsNull(compositeBlock.getBlocks());
    }

    public Wall(final List<Block> blocks) {
        this.blocks = generateListIfBlocksIsNull(blocks);
    }

    @Override
    public Optional<Block> findBlockByColor(final String color) {
        return this.blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(final String material) {
        return this.blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    private List<Block> generateListIfBlocksIsNull(final List<Block> blocks){
        return Objects.isNull(blocks) ? new ArrayList<>() : blocks;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return blocks.equals(wall.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }

    @Override
    public String toString() {
        return "Wall = [blocks = " + blocks + "]";
    }
}
