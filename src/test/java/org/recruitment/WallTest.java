package org.recruitment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class WallTest {

    private CompositeBlock compositeBlock;
    private Wall wall;
    private static final String COLOR_BLUE = "Blue";
    private static final String COLOR_WHITE = "White";


    @BeforeEach
    void setUp() {
        final List<Block> blockList = createCompositeBlock();
        compositeBlock = new CompositeBlockImplementation(blockList);
        wall = new Wall(compositeBlock);
    }

    @Test
    @DisplayName("Check findBlockByColor method when given existing color, not existing color and when color is null")
    void testListByBlockColor() {
        //when
        Optional<Block> expectedBlue = wall.findBlockByColor(COLOR_BLUE);
        Optional<Block> expectedEmpty = wall.findBlockByColor(COLOR_WHITE);
        Optional<Block> expectedEmptyWhenGivenNullValue = wall.findBlockByColor(null);

        //then
        Assertions.assertTrue(expectedBlue.isPresent());
        Assertions.assertTrue(expectedEmpty.isEmpty());
        Assertions.assertTrue(expectedEmptyWhenGivenNullValue.isEmpty());
    }

    @Test
    @DisplayName("Check findBlocksByMaterial method when given existing material, not existing material and when material is null")
    void testListByBlockMaterial() {
        //given
        List<Block> blockListToTest = List.of(
                new BlockImplementation("Blue", "Clay"),
                new BlockImplementation("Yellow", "Clay"),
                new BlockImplementation("Blue", "Clay")
        );
        List<Block> emptyBlockList = List.of();

        //when
        List<Block> expectedClayMaterialList = wall.findBlocksByMaterial("Clay");
        List<Block> expectedEmptyListWhenGivenNonExistingMaterial = wall.findBlocksByMaterial("Glass");
        List<Block> expectedEmptyListWhenGivenNull = wall.findBlocksByMaterial(null);

        //then
        Assertions.assertEquals(blockListToTest, expectedClayMaterialList);
        Assertions.assertEquals(emptyBlockList, expectedEmptyListWhenGivenNonExistingMaterial);
        Assertions.assertEquals(emptyBlockList, expectedEmptyListWhenGivenNull);
    }

    @Test
    @DisplayName("Check number of all components in the wall")
    void testCountOfElements() {
        //when
        int numberOfElementsInWall = wall.count();

        //then
        Assertions.assertEquals(6, numberOfElementsInWall);
    }

    private List<Block> createCompositeBlock() {
        return List.of(
                new BlockImplementation("Blue", "Clay"), new BlockImplementation("Yellow", "Clay"),
                new BlockImplementation("Purple", "Concrete"), new BlockImplementation("Blue", "Concrete"),
                new BlockImplementation("Grey", "Concrete"), new BlockImplementation("Blue", "Clay")
        );
    }
}

