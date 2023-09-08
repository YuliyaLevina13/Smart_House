package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RadioTest {
        Radio netologyFm = new Radio();

        //тестируем станции
        @Test
        public void shouldGetCurrentStation() {
            netologyFm.setCurrentStation(0);
            netologyFm.setCurrentStation(-1);
            netologyFm.setCurrentStation(11);
            assertEquals(0, netologyFm.getCurrentStation());
        }

        @Test
        public void shouldPressNextStation() {
            netologyFm.setCurrentStation(0);
            netologyFm.pressNextStation();
            assertEquals(1, netologyFm.getCurrentStation());

            netologyFm.setCurrentStation(10);
            netologyFm.pressNextStation();
            assertEquals(0, netologyFm.getCurrentStation());

            netologyFm.setCurrentStation(-1);
            netologyFm.pressNextStation();
            assertEquals(0, netologyFm.getCurrentStation());

            netologyFm.setCurrentStation(11);
            netologyFm.pressNextStation();
            assertEquals(1, netologyFm.getCurrentStation());
        }

        @Test
        public void shouldPressPrevStation() {
            netologyFm.setCurrentStation(0);
            netologyFm.pressPrevStation();
            assertEquals(10, netologyFm.getCurrentStation());

            netologyFm.setCurrentStation(10);
            netologyFm.pressPrevStation();
            assertEquals(9, netologyFm.getCurrentStation());
        }

        @Test
        public void shouldGetToMaxStation() {
            assertEquals(10, netologyFm.getMaxRadioStation());
        }

        @Test
        public void shouldSetMaxStation() {
            netologyFm.setMaxRadioStation(-1);
            netologyFm.setMaxRadioStation(0);
            netologyFm.setMaxRadioStation(11);
            assertEquals(11, netologyFm.getMaxRadioStation());
        }

        @Test
        public void shouldGetToMinStation() {
            assertEquals(0, netologyFm.getMinRadioStation());
        }

        @Test
        public void shouldSetMinStation() {
            netologyFm.setMinRadioStation(-1);
            netologyFm.setMinRadioStation(0);
            netologyFm.setMinRadioStation(11);
            assertEquals(11, netologyFm.getMinRadioStation());
        }

        //тестируем громкость
        @Test
        public void shouldSetCurrentVolume() {
            netologyFm.setCurrentVolume(101);
            assertEquals(0, netologyFm.getCurrentVolume());

            netologyFm.setCurrentVolume(-1);
            assertEquals(100, netologyFm.getCurrentVolume());

            netologyFm.setCurrentVolume(8);
            assertEquals(8, netologyFm.getCurrentVolume());
        }

        @Test
        public void shouldGetMinVolume() {
            assertEquals(0, netologyFm.getMinVolume());
        }

        @Test
        public void shouldGetMaxVolume() {
            assertEquals(100, netologyFm.getMaxVolume());
        }

        @Test
        public void shouldSetMinVolume() {
            netologyFm.setMaxVolume(100);
            netologyFm.setMinVolume(1);
            assertEquals(1, netologyFm.getMinVolume());
        }

        @Test
        public void shouldSetMaxVolume() {
            netologyFm.setMinVolume(1);
            netologyFm.setMaxVolume(101);
            assertEquals(101, netologyFm.getMaxVolume());
        }

        @Test
        public void shouldPressVolumeUp() {
            netologyFm.setCurrentVolume(4);
            netologyFm.pressVolumeUp();
            assertEquals(5, netologyFm.getCurrentVolume());

            netologyFm.setCurrentVolume(100);
            netologyFm.pressVolumeUp();
            assertEquals(0, netologyFm.getCurrentVolume());
        }

        @Test
        public void shouldPressVolumeDown() {
            netologyFm.setCurrentVolume(4);
            netologyFm.pressVolumeDown();
            assertEquals(3, netologyFm.getCurrentVolume());

            netologyFm.setCurrentVolume(0);
            netologyFm.pressVolumeDown();
            assertEquals(100, netologyFm.getCurrentVolume());
        }

        //тестируем конструктор с возможностью задавать количество радиостанций при создании объекта
        @Test
        public void shouldCreateStationsWithLimits() {
            Radio radio = new Radio(1);
            assertEquals(0, radio.getMaxRadioStation());

            Radio radio1 = new Radio(100);
            assertEquals(99, radio1.getMaxRadioStation());

            Radio radio2 = new Radio(10);
            assertEquals(0, radio2.getMinRadioStation());
        }
    }