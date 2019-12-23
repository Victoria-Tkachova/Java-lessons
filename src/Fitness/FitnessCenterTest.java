package Fitness;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FitnessCenterTest {
    static FitnessCenter center;

    @BeforeAll
    static void mehtodBeforeAll () {
        System.out.println("Before All");
        center = new FitnessCenter();

    }

    @BeforeEach
    void testMethod () {
        System.out.println("Before");
 }

    @org.junit.jupiter.api.Test
    @Order(3)
    void recruitTrainer() {
        boolean positiveResult = center.recruitTrainer(new Trainers("Smith", SportTypes.SWIMMING, 60), 1);
        boolean negativeResult = center.recruitTrainer(new Trainers("Smith", SportTypes.SWIMMING, 60), 0);
        assertTrue(positiveResult);
        assertFalse(negativeResult);
    }

    @org.junit.jupiter.api.Test
    void testCheckYear () {
        boolean positiveResult = center.checkCurrentYear(LocalDate.now(), 2019);
        boolean negativeResult = center.checkCurrentYear(LocalDate.now(), 2018);
        assertTrue(positiveResult);
        assertFalse(negativeResult);
    }

    @Test
    @Order(2)
    void testCheckDay () {
        boolean positiveResult = center.checkWorkingDay(LocalDate.now());
        boolean negativeResult = center.checkWorkingDay(LocalDate.of(2019, 12, 25));
        assertTrue(positiveResult);
        assertFalse(negativeResult);
    }

    @Test
    @Order(1)
    void testAddHoliday () {
        boolean positiveResult = center.addHoliday(LocalDate.of(2019, 12, 25));
        boolean negativeResult = center.addHoliday(LocalDate.of(2019, 12, 25));
        assertTrue(positiveResult);
        assertFalse(negativeResult);
    }

    @ParameterizedTest
    @ValueSource (strings = {"Monday, 12/23/2019, 08:00 AM"})
    void testDayFormat (String day) {
        LocalDateTime positiveTesting = center.checkDateFormat(day);
    }

    @ParameterizedTest
    @Order(4)
    @ValueSource (strings = {"Smith"})
    void testChooseTrainer (String trainer) {
        ArrayList<Trainers> positiveResult = center.chooseFitnessTrainer(trainer);
    }

    @ParameterizedTest
    @Order(5)
    @ValueSource (strings = {"SWIMMING"})
    void testChooseSportType (String sportType) {
        ArrayList<Trainers> positiveResult = center.chooseSportType(sportType);
    }


    @AfterEach
    void finishMethod () {
        System.out.println("After");
    }

    @AfterAll
    static void methodAfterAll () {
        System.out.println("After All");
    }

}