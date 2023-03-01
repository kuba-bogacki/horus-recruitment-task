package org.recruitment;

import java.util.List;

public class CompositeBlockImplementation implements CompositeBlock {

    private List<Block> blockList;

    public CompositeBlockImplementation(final List<Block> blockList) {
        this.blockList = blockList;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blockList;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }
}
