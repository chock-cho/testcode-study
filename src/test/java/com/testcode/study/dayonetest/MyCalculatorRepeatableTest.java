package com.testcode.study.dayonetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MyCalculatorRepeatableTest {

    @RepeatedTest(5)
    @DisplayName("덧셈을 5번 단순 반복하며 테스트")
    public void repeatedTest(){
        // Arrange - 준비
        MyCalculator myCalculator = new MyCalculator(0.0);

        // Act- 행동
        myCalculator.add(10.0);

        // Assert - 단언/검증
        Assertions.assertEquals(10.0, myCalculator.getResult());
    }

    @ParameterizedTest
    @MethodSource("parameterizedTestParameters")
    @DisplayName("덧셈을 5번 파라미터 넣어주며 반복하며 테스트")
    public void parameterizedTest(Double addValue, Double expectValue){
        // Arrange - 준비
        MyCalculator myCalculator = new MyCalculator();

        // Act- 행동
        myCalculator.add(addValue);

        // Assert - 단언/검증
        Assertions.assertEquals(expectValue, myCalculator.getResult());
    }

    public static Stream<Arguments> parameterizedTestParameters(){
        return Stream.of(
                Arguments.of(10.0, 10.0),
                Arguments.of(8.0, 8.0),
                Arguments.of(4.0, 4.0),
                Arguments.of(16.0, 16.0),
                Arguments.of(13.0, 13.0)
                );
    }

    @ParameterizedTest
    @MethodSource("parameterizedComplicatedCalculateTestParameters")
    @DisplayName("파라미터를 넣으면 사칙연산 2번 반복테스트")
    public void parameterizedComplicatedCalculateTest(
            Double addValue,
            Double minusValue,
            Double multiplyValue,
            Double divideValue,
            Double expectedValue
    ) {
        // given
        MyCalculator myCalculator = new MyCalculator();

        // when
        Double result = myCalculator
                .add(10.0)
                .minus(4.0)
                .multiply(2.0)
                .divide(3.0)
                .getResult();

        Assertions.assertEquals(4.0, result);
    }

    public static Stream<Arguments> parameterizedComplicatedCalculateTestParameters(){
        return Stream.of(
                Arguments.of(10.0, 4.0, 2.0, 3.0, 4.0),
                Arguments.of(4.0, 2.0, 4.0, 4.0, 2.0)
                );
    }
}
