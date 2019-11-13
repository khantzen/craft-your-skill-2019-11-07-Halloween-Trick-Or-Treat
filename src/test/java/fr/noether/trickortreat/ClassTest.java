package fr.noether.trickortreat;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassTest {

    private final static String TRICK_OR_TREAT = "Trick or treat!";
    private final static String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";

    @Test
    public void bags_amount_should_be_the_same_as_the_children_count() {
        var answer =  Halloween.trickOrTreat(2, List.of(bagOfTwoCandies(), bagOfTwoCandies()));
        assertThat(answer).isEqualTo(THANK_YOU_STRANGE_UNCLE);
    }

    @Test
    public void bags_amount_should_not_be_less_than_children_count() {
        var answer = Halloween.trickOrTreat(2, List.of(bagOfTwoCandies()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
        answer = Halloween.trickOrTreat(3, List.of(bagOfTwoCandies(), bagOfTwoCandies()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
        answer = Halloween.trickOrTreat(2, List.of(bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoCandies()));
        assertThat(answer).isEqualTo(THANK_YOU_STRANGE_UNCLE);
    }

    @Test
    public void children_should_have_at_least_two_candies() {
        String answer = Halloween
                .trickOrTreat(2, List.of(bagOfTwoCandies(), new Bag()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    @Test
    public void bag_have_one_candy() {
        String answer = Halloween
                .trickOrTreat(2, List.of(bagOfTwoCandies(), new Bag("candy")));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    @Test
    public void first_bag_have_one_candy() {
        String answer = Halloween
                .trickOrTreat(2, List.of(new Bag("candy"), new Bag("candy")));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    @Test
    public void bag_with_candy_and_apple() {
        String answer = Halloween
                .trickOrTreat(2, List.of(new Bag("candy", "apple"), bagOfTwoCandies()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
        answer = Halloween
                .trickOrTreat(2, List.of(new Bag("candy", "apple", "candy"), bagOfTwoCandies()));
        assertThat(answer).isEqualTo(THANK_YOU_STRANGE_UNCLE);
    }

    @Test
    public void bag_with_bomb_should_return_trick_or_treat() {
        String answer = Halloween
                .trickOrTreat(2, List.of(new Bag("candy", "candy", "bomb"), bagOfTwoCandies()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    @Test
    public void more_bag_than_children() {
        String answer = Halloween
                .trickOrTreat(2,
                        List.of(new Bag("candy", "candy", "bomb"),
                                bagOfTwoCandies(),
                                bagOfTwoCandies()));
        assertThat(answer).isEqualTo(THANK_YOU_STRANGE_UNCLE);
        answer = Halloween
                .trickOrTreat(2,
                        List.of(new Bag("candy", "candy", "bomb"),
                                new Bag("candy", "candy", "bomb"),
                                bagOfTwoCandies()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    @Test
    public void each_children_should_have_the_same_amount_of_candy() {
        String answer = Halloween
                .trickOrTreat(3,
                        List.of(new Bag("candy", "candy", "candy"),
                                bagOfTwoCandies(),
                                bagOfTwoCandies()));
        assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    private Bag bagOfTwoCandies() {
        return new Bag("candy", "candy");
    }
}
