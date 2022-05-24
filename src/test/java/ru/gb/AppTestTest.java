package ru.gb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AppTestTest {
    private AppTest appTest;

    @BeforeEach
    void setUp() {
        appTest = new AppTest();
    }

    private static Stream<Arguments> provideArgsForMethodArrayFrom4() {
        return Stream.of(
                Arguments.of(new int[]{1,2,6,5,4,2,6,5,4,3}, new int[]{3}),
                Arguments.of(new int[]{1,2,6,5,4,2,4,5,3,3}, new int[]{5,3,3}),
                Arguments.of(new int[]{1,2,6,5,4,2,6,5,0,3}, new int[]{2,6,5,0,3}),
                Arguments.of(new int[]{1,2,6,5,4,2,6,5,3}, new int[]{2,6,5,3}),
                Arguments.of(new int[]{1,2,6,5,4,2,6,4,5,3}, new int[]{5,3})
        );
    }
 private static Stream<Arguments> provideArgsForMethodchekArrayInclude1or4() {
        return Stream.of(
                Arguments.of(new int[]{1,2,6,5,4,2,6,5,4,3}, true),
                Arguments.of(new int[]{1,2,6,5,2,5,3,3}, false),
                Arguments.of(new int[]{1,2,6,5,4,2,6,5,0,3}, true),
                Arguments.of(new int[]{2,6,5,4,2,6,5,3}, false),
                Arguments.of(new int[]{1,2,6,5,4,2,6,4,5,3}, true)
        );
    }


    @ParameterizedTest
    @MethodSource("provideArgsForMethodArrayFrom4")
    void getArrayFrom4(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, appTest.getArrayFrom4(array));
    }

    @Test
    void getArrayFrom4() {
        int[] array = new int[] {1,2,3,5,6};
        Assertions.assertThrows(RuntimeException.class, () ->appTest.getArrayFrom4(array));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForMethodchekArrayInclude1or4")
    void chekArrayInclude1or4(int[] array, boolean result) {
        Assertions.assertEquals(result, appTest.chekArrayInclude1or4(array));
    }
}