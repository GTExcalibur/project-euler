package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by George Turner on 10/21/2017.
 */
public class Problem_054_Test {

    @Test
    public void test_hand1() {
        Set<String> player1 = Stream.of("5H", "5C", "6S", "7S", "KD").collect(Collectors.toSet());
        Set<String> player2 = Stream.of("2C", "3S", "8S", "8D", "TD").collect(Collectors.toSet());

        Assert.assertTrue(Problem_054.compare(player1, player2) < 0);
        Assert.assertFalse(Problem_054.compare(player1, player2) > 0);
    }

    @Test
    public void test_hand2() {
        Set<String> player1 = Stream.of("5D", "8C", "9S", "JS", "AC").collect(Collectors.toSet());
        Set<String> player2 = Stream.of("2C", "5C", "7D", "8S", "QH").collect(Collectors.toSet());

        Assert.assertFalse(Problem_054.compare(player1, player2) < 0);
        Assert.assertTrue(Problem_054.compare(player1, player2) > 0);
    }

    @Test
    public void test_hand3() {
        Set<String> player1 = Stream.of("2D", "9C", "AS", "AH", "AC").collect(Collectors.toSet());
        Set<String> player2 = Stream.of("3D", "6D", "7D", "TD", "QD").collect(Collectors.toSet());

        Assert.assertTrue(Problem_054.compare(player1, player2) < 0);
        Assert.assertFalse(Problem_054.compare(player1, player2) > 0);
    }

    @Test
    public void test_hand4() {
        Set<String> player1 = Stream.of("4D", "6S", "9H", "QH", "QC").collect(Collectors.toSet());
        Set<String> player2 = Stream.of("3D", "6D", "7H", "QD", "QS").collect(Collectors.toSet());

        Assert.assertFalse(Problem_054.compare(player1, player2) < 0);
        Assert.assertTrue(Problem_054.compare(player1, player2) > 0);
    }

    @Test
    public void test_hand5() {
        Set<String> player1 = Stream.of("2H", "2D", "4C", "4D", "4S").collect(Collectors.toSet());
        Set<String> player2 = Stream.of("3C", "3D", "3S", "9S", "9D").collect(Collectors.toSet());

        Assert.assertFalse(Problem_054.compare(player1, player2) < 0);
        Assert.assertTrue(Problem_054.compare(player1, player2) > 0);
    }

    @Test
    public void test_classification_royalFlush() {
        Assert.assertTrue(Problem_054.PlayerHand.ROYAL_FLUSH.doesMatch(Stream.of("TC", "JC", "QC", "KC", "AC").collect(Collectors.toSet())));
        Assert.assertFalse(Problem_054.PlayerHand.ROYAL_FLUSH.doesMatch(Stream.of("TC", "JC", "QC", "KC", "9C").collect(Collectors.toSet())));
        Assert.assertFalse(Problem_054.PlayerHand.ROYAL_FLUSH.doesMatch(Stream.of("TC", "JC", "QC", "KC", "AS").collect(Collectors.toSet())));
    }

    @Test
    public void test_classification_straightFlush() {
        Assert.assertTrue(Problem_054.PlayerHand.STRAIGHT_FLUSH.doesMatch(Stream.of("TC", "JC", "QC", "KC", "9C").collect(Collectors.toSet())));
        Assert.assertFalse(Problem_054.PlayerHand.STRAIGHT_FLUSH.doesMatch(Stream.of("TC", "JC", "QC", "KC", "8C").collect(Collectors.toSet())));
        Assert.assertFalse(Problem_054.PlayerHand.STRAIGHT_FLUSH.doesMatch(Stream.of("TC", "JC", "QC", "KC", "9S").collect(Collectors.toSet())));
    }
}
