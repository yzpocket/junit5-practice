package com.sparta.junit5practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test // 예측값이 맞는지
    @DisplayName("assertEquals")
    void test1() {
        Double result = calculator.operate(5, "/", 2);
        assertEquals(2.5, result); // 예측값, 결과값넣으면, 결과에 대한 판정
    }

    @Test // 오류메시지 추가하는것
    @DisplayName("assertEquals - Supplier") // 오류메시지 함께 전달
    void test1_1() {
        Double result = calculator.operate(5, "/", 0);
        // 테스트 실패 시 메시지 출력 (new Supplier<String>())
        assertEquals(2.5, result, () -> "연산자 혹은 분모가 0이 아닌지 확인해보세요!");
    }

    @Test // 예측이 틀린지
    @DisplayName("assertNotEquals") //NotEquals라 예측과 틀렸을때 통과
    void test1_2() {
        Double result = calculator.operate(5, "/", 0);
        assertNotEquals(2.5, result);
    }

    @Test //true인지, false인지
    @DisplayName("assertTrue 와 assertFalse")
    void test2() {
        assertTrue(calculator.validateNum(9)); // true를 예측
        assertFalse(calculator.validateNum(0)); // false를 예측
    }

    @Test //null이 아닌지, null인지
    @DisplayName("assertNotNull 과 assertNull")
    void test3() {
        Double result1 = calculator.operate(5, "/", 2);
        assertNotNull(result1); //null이 아닌것을 예측
        Double result2 = calculator.operate(5, "/", 0);
        assertNull(result2); //null임을 예측
    }

    @Test // 예외를 실행하는지 아닌지 테스트
    @DisplayName("assertThrows")
    void test4() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.operate(5, "?", 2));
        assertEquals("잘못된 연산자입니다.", exception.getMessage());
    }
}
