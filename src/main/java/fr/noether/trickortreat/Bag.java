package fr.noether.trickortreat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Bag {
    private final String[] content;

    public Bag(String... content) {
        this.content = content;
    }

    boolean isSuitableForChildren() {
        return this.hasEnoughCandiesForChildren() && !this.containsABomb();
    }

    public boolean hasEnoughCandiesForChildren() {
        return countFor("candy"::equals) >= 2;
    }

    public boolean containsABomb() {
        return countFor("bomb"::equals) > 0;
    }

    private long countFor(Predicate<String> filterByCandy) {
        return Arrays.stream(this.content)
                .filter(filterByCandy)
                .count();
    }
}
