package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void catSleepShouldReturnString() {

        Cat cat = new Cat("Birman", "white", 6);
        assertEquals(cat.sleep(), "I'm sleeping. Don't touch me");
    }
    @Test
    void catHuntShouldReturnString() {

        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.hunt(), "I'm hunting right now");
    }

    @Test
    void catTigidikShouldReturnString() {

        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.tigidik(), "Tigidik");
    }

    @Test
    void catlickBallsShouldReturnString() {

        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.tigidik(), "Tigidik");
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"MON", "WED", "FRI"})
    void catOccupationOnDaysWhenSleeping(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.occupation(dayOfWeek), cat.sleep());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"THU", "TUE", "SAT"})
    void catOccupationOnDaysWhenHunting(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.occupation(dayOfWeek), cat.hunt());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"SUN"})
    void catOccupationOnDaysWhenTigidik(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.occupation(dayOfWeek), cat.tigidik());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"NONE"})
    void catOccupationOnDaysWhenLickingBalls(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Birman", "grey", 7);
        assertEquals(cat.occupation(dayOfWeek), cat.lickBalls());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @NullSource
    void catOccupationOnNull(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Birman", "grey", 7);

        Exception exception = assertThrows(NullPointerException.class, () ->
                cat.occupation(dayOfWeek));
        assertEquals("Cannot invoke \"DaysOfWeek.ordinal()\" because \"daysOfWeek\" is null", exception.getMessage());

    }


}
