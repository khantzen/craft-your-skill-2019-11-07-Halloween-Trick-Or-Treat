package fr.noether.trickortreat;

import java.util.List;

public class Halloween {
    private final static String TRICK_OR_TREAT = "Trick or treat!";
    private final static String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";

    public static String trickOrTreat(int childrenCount, List<Bag> bags) {
        long count = bags.stream()
                .filter(Bag::isSuitableForChildren)
                .count();

        if (count >= childrenCount) {
            return THANK_YOU_STRANGE_UNCLE;
        }
        return TRICK_OR_TREAT;
    }
}
