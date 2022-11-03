package ru.netology.service;

import static org.junit.Assert.*;
public class CashbackHackServiceTest {
    CashbackHackService cashbackHackService = new CashbackHackService();

    //покупка в пределах лимита
    @org.junit.Test
    public void showHowMuchToSpendIfThePurchaseIsLessThanTheLimit() {

        int actual = cashbackHackService.remain(500);
        int expected = 500;

        assertEquals(actual, expected);
    }

    //покупка больше лимита
    @org.junit.Test
    public void showHowMuchToSpendIfThePurchaseIsOverThanTheLimit() {

        int actual = cashbackHackService.remain(1500);
        int expected = 0;

        assertEquals(actual, expected);
    }

    //покупка равна лимиту
    @org.junit.Test
    public void showHowMuchToSpendIfThePurchaseIsEqualToTheLimit() {

        int actual = cashbackHackService.remain(1000);
        int expected = 0;

        assertEquals(actual, expected);
    }

    //верхнее граничные значения - меньше
    @org.junit.Test
    public void upperLimitValueLessThanLimit() {

        int actual = cashbackHackService.remain(999);
        int expected = 1;

        assertEquals(actual, expected);
    }

    //верхнее граничные значения - больше
    @org.junit.Test
    public void upperLimitValueGreaterThanLimit() {

        int actual = cashbackHackService.remain(1001);
        int expected = 0;

        assertEquals(actual, expected);
    }

    //покупка ноль
    @org.junit.Test
    public void ifPurchaseEqualNull() {

        int actual = cashbackHackService.remain(0);
        int expected = 1000;

        assertEquals(actual, expected);
    }

    //покупка отрицательная
    @org.junit.Test
    public void ifPurchaseNegative() {

        int actual = cashbackHackService.remain(-1);
        int expected = 1000;

        assertEquals(actual, expected);
    }

    //нижнее граничное значение
    @org.junit.Test
    public void bottonLimitValueGreaterThanLimit() {

        int actual = cashbackHackService.remain(1);
        int expected = 999;

        assertEquals(actual, expected);
    }
}