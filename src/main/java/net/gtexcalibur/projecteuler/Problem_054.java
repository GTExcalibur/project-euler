package net.gtexcalibur.projecteuler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 54 - Poker hands
 * <pre>
 *

 In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

     High Card: Highest value card.
     One Pair: Two cards of the same value.
     Two Pairs: Two different pairs.
     Three of a Kind: Three cards of the same value.
     Straight: All cards are consecutive values.
     Flush: All cards of the same suit.
     Full House: Three of a kind and a pair.
     Four of a Kind: Four cards of the same value.
     Straight Flush: All cards are consecutive values of same suit.
     Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

 The cards are valued in the order:
 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

 If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.

 Consider the following five hands dealt to two players:
 Hand	 	Player 1	 	Player 2	 	Winner
 1	 	5H 5C 6S 7S KD
 Pair of Fives
 	 	2C 3S 8S 8D TD
 Pair of Eights
 	 	Player 2
 2	 	5D 8C 9S JS AC
 Highest card Ace
 	 	2C 5C 7D 8S QH
 Highest card Queen
 	 	Player 1
 3	 	2D 9C AS AH AC
 Three Aces
 	 	3D 6D 7D TD QD
 Flush with Diamonds
 	 	Player 2
 4	 	4D 6S 9H QH QC
 Pair of Queens
 Highest card Nine
 	 	3D 6D 7H QD QS
 Pair of Queens
 Highest card Seven
 	 	Player 1
 5	 	2H 2D 4C 4D 4S
 Full House
 With Three Fours
 	 	3C 3D 3S 9S 9D
 Full House
 with Three Threes
 	 	Player 1

 The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

 How many hands does Player 1 win?

 * </pre>
 */
public class Problem_054 {

    private static boolean isRoyalFlush(Set<String> player) {
        return false;
    }

    private static int compareRoyalFlush(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isStraightFlush(Set<String> player) {
        return false;
    }

    private static int compareStraightFlush(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isFourOfAKind(Set<String> player) {
        return false;
    }

    private static int compareFourOfAKind(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isFullHouse(Set<String> player) {
        return false;
    }

    private static int compareFullHouse(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isFlush(Set<String> player) {
        return false;
    }

    private static int compareFlush(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isStraight(Set<String> player) {
        return false;
    }

    private static int compareStraight(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isThreeOfAKind(Set<String> player) {
        return false;
    }

    private static int compareThreeOfAKind(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isTwoPairs(Set<String> player) {
        return false;
    }

    private static int compareTwoPairs(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isPair(Set<String> player) {
        return false;
    }

    private static int comparePair(Set<String> player1, Set<String> player2) {
        return 0;
    }

    private static boolean isHighCard(Set<String> player) {
        return true;
    }

    private static int compareHighCard(Set<String> player1, Set<String> player2) {
        return 0;
    }

    enum PlayerHand {
        ROYAL_FLUSH(Problem_054::isRoyalFlush, Problem_054::compareRoyalFlush),
        STRAIGHT_FLUSH(Problem_054::isStraightFlush, Problem_054::compareStraightFlush),
        FOUR_OF_A_KIND(Problem_054::isFourOfAKind, Problem_054::compareFourOfAKind),
        FULL_HOUSE(Problem_054::isFullHouse, Problem_054::compareFullHouse),
        FLUSH(Problem_054::isFlush, Problem_054::compareFlush),
        STRAIGHT(Problem_054::isStraight, Problem_054::compareStraight),
        THREE_OF_A_KIND(Problem_054::isThreeOfAKind, Problem_054::compareThreeOfAKind),
        TWO_PAIRS(Problem_054::isTwoPairs, Problem_054::compareTwoPairs),
        ONE_PAIR(Problem_054::isPair, Problem_054::comparePair),
        HIGH_CARD(Problem_054::isHighCard, Problem_054::compareHighCard);

        private final Predicate<Set<String>> cardCheck;
        private final Comparator<Set<String>> equalCheck;

        PlayerHand(Predicate<Set<String>> cardCheck, Comparator<Set<String>> equalCheck) {
            this.cardCheck = cardCheck;
            this.equalCheck = equalCheck;
        }

        public boolean doesMatch(Set<String> player) {
            return cardCheck.test(player);
        }

        public int compare(Set<String> player1, Set<String> player2) {
            return equalCheck.compare(player1, player2);
        }
    }

    private static int compare(Set<String> player1, Set<String> player2) {
        PlayerHand playerHand1 = Arrays.stream(
                PlayerHand.values()
        ).filter(ph -> ph.doesMatch(player1)).findFirst().orElse(PlayerHand.HIGH_CARD);
        PlayerHand playerHand2 = Arrays.stream(
                PlayerHand.values()
        ).filter(ph -> ph.doesMatch(player2)).findFirst().orElse(PlayerHand.HIGH_CARD);

        int compare = playerHand1.compareTo(playerHand2);
        if(compare == 0) {
            return playerHand1.compare(player1, player2);
        } else {
            return compare;
        }
    }

    public static void main(String[] args) {

    }



}
