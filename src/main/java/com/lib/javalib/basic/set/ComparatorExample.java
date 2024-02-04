package com.lib.javalib.basic.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
    private int score;
}

class AgeComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
}

class ScoreComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getScore() - o2.getScore();
    }
}

@Slf4j
public class ComparatorExample {
    public static void main(String[] args) {
        User u1 = new User("Li", 18, 20000);
        User u2 = new User("Zhang", 30, 10000);

        Comparator<User> ageComparator = new AgeComparator();
        log.debug("User {}'s age > {}'s age? {}",u1.getName(), u2.getName(), ageComparator.compare(u1, u2) > 0);

        Comparator<User> scoreComparator = new ScoreComparator();
        log.debug("User {}'s score > {}'s score? {}",u1.getName(), u2.getName(), scoreComparator.compare(u1, u2) > 0);
    }
}
