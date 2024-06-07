package com3592.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void add() {
        // 创建Calculator对象
        Main calculator = new Main();
        int result = calculator.add(10, 5);

        // 测试add方法
        assertEquals(15, result, "10 + 5 应该等于 15");
    }
}