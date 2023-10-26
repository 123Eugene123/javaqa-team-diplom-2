package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    @Test
    public void shouldAddToPositiveBalanceWhenInitialBalanceIsZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddWhenInitialBalanceIsPositive() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_300, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddWhenAmountIsZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-2_000, 5_000, 15);
        });
    }

    @Test
    public void shouldAddToNegativeCreditBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, -5_000, 15);
        });
    }

    @Test
    public void shouldAddToNegativeRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );


        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceIsPositive() {
        CreditAccount account = new CreditAccount(
                2_000,
                10_000,
                10);

        account.pay(800);

        Assertions.assertEquals(1_200, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountPositive() {
        CreditAccount account = new CreditAccount(
                3_000,
                8_000,
                17);

        account.pay(3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                2_000,
                10_000,
                10);

        account.pay(-2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountIsZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                10_000,
                10);

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountMoreInitialBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                3_000,
                17);

        account.pay(2_500);

        Assertions.assertEquals(-500, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountMoreThanLimit() {
        CreditAccount account = new CreditAccount(
                2_000,
                3_000,
                17);

        account.pay(7_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNeedCalculationIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                10);

        account.pay(2_000);

        Assertions.assertEquals(-100, account.yearChange());
    }

    @Test
    public void shouldNeedCalculationIfBalancePositive() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                10);

        account.pay(1_000);

        Assertions.assertEquals(0, account.yearChange());
    }
}