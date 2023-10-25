package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() { // Пополнить на сумму меньше максимума
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);
        int expected = 2_000 + 3_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldBooleanAddLessThanZero() { // Пополнить на отрицательную сумму
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.add(-1_000));
    }

    @Test
    public void shouldBooleanAddZero() { // Пополнить на ноль
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.add(0));
    }

    @Test
    public void shouldBooleanAddLessThanMaxBalance() { // Пополнить на сумму меньше максимума
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertTrue(account.add(1_000));
    }

    @Test
    public void shouldBooleanAddMaxBalance() { // Пополнить на сумму для получения максимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertTrue(account.add(8_000));
    }

    @Test
    public void shouldBooleanAddMoreThanMaxBalance() { // Пополнить на сумму меньше максимума
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.add(11_000));
    }

    @Test
    public void shouldAddNegativeRating() { // пополнить на отрицательную сумму
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-3_000);
        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddZero() { // пополнить на ноль
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);
        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddMoreThanMaxBalance() { // Пополнить на сумму больше максимума
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);
        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddForMaxBalance() { // Пополнить на сумму для получения максимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);
        int expected = 10_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldExceptionalSituationNegativeRate() {//выброс исключения при отрицательной ставке
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000,
                    1_000,
                    10_000,
                    -5);
        });
    }

    @Test
    public void shouldExceptionalSituationNegativeMinBalance() {//выброс исключения при отрицательном минимальном балансе
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000,
                    -1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldExceptionalSituationForInitialLessMin() {//выброс исключения при текущем балансе меньше минимального
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000,
                    3_000,
                    10_000,
                    5);
        });
    }


    @Test
    public void shouldExceptionalSituationForMinEqualsMax() {//выброс исключения при равных значениях максимального и минимального баланса
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000,
                    2000,
                    2000,
                    5);
        });
    }

    @Test
    public void shouldExceptionalSituationForInitialBalance() {//выброс исключения при отрицательном начальном балансе
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-2_000,
                    1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldExceptionalSituationInitialMoreMaxBalance() {//выброс исключения при текуцщем балансе  выше максимально
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(15_000,
                    1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldExceptionalSituationMinBalanceMoreMaxBalance() {//выброс исключения при минимальном балансе выше максимально
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(15_000,
                    11_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldExceptionalSituationInitialBalanceMoreMaxBalance() {//выброс исключения при минимальном балансе выше максимально
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(15_000,
                    1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldPayNegativeAmount() { // платеж на отрицательную сумму
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-1_000);
        int expected = 2_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayOnZero() { // платеж на ноль
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);
        int expected = 2_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayMoreThanMinBalance() { // платеж на сумму выше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);
        int expected = 1_500;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayLessThanMinBalance() { // платеж на сумму меньше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_500);
        int expected = 2_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayEqualsMinBalance() { // платеж на сумму меньше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);
        int expected = 1_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayLessThanZero() { // платеж, результатом котрого является отрицательный баланс счета
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);
        int expected = 2_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChange() { // расчет процентов
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );

        int expected = 300;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldZeroYearChange() { // расчет процентов при ставке 0
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }
}
