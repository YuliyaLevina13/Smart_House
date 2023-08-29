package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldNextRadioStation() { // Включение следующей радиостанции
        radio.setCurrentNumber(1);
        radio.next();
        int expected = 2;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevStation() { //включение предыдущей радиостанции
        radio.setCurrentNumber(5);
        radio.prev();
        int expected = 4;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldResetStation() { // возврат на изначальную радиостанцию
        radio.setCurrentNumber(9);
        radio.next();
        int expected = 0;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchToLastStation() { // переключаем на последнюю радиостанцию
        radio.setCurrentNumber(0);
        radio.prev();
        int expected = 9;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchStartingStation() { //переключение на первую радиостанцию
        radio.setCurrentNumber(10);
        int expected = 0;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintNumberEqualZeroStation() {  //возврат на нулевую радиостанцию
        radio.setCurrentNumber(-1);
        int expected = 0;
        int actual = radio.getCurrentNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddVolumeUp() { // увеличиваем  громкость
        radio.setSoundVolume(8);
        radio.volumeUp();
        int expected = 9;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldVolumeDown() {   //уменьшаем громкость;
        radio.setSoundVolume(3);
        radio.volumeDown();
        int expected = 2;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddSound() { //громкость достигнув максимума не изменяется
        radio.setSoundVolume(100);
        radio.volumeUp();
        int expected = 100;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotChangeSound() {    //громкость достигнув минимума не изменяется
        radio.setSoundVolume(0);
        radio.volumeDown();
        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }
}