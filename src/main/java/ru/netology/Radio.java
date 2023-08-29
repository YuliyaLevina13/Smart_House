package ru.netology
public class Radio {
    private int currentNumber;
    private int soundVolume;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    protected void next() {
        if (currentNumber == 9) {
            currentNumber = 0;
        } else {
            currentNumber = currentNumber + 1;
        }
    }

    protected void prev() {
        if (currentNumber == 0) {
            currentNumber = 9;
        } else {
            currentNumber = currentNumber - 1;
        }
    }

    protected void setCurrentNumber(int newCurrentNumber) {
        if (newCurrentNumber > 9) {
            return;
        }
        if (newCurrentNumber < 0) {
            return;
        }
        currentNumber = newCurrentNumber;
    }

    protected void setSoundVolume(int newSoundVolume) {
        soundVolume = newSoundVolume;
    }

    protected void volumeUp() {
        if (soundVolume < 100) {
            soundVolume = 100;
        } else {

            soundVolume = soundVolume + 1;
        }
    }

    protected void volumeDown() {
        if (soundVolume == 0) {
            soundVolume = 0;
        } else {
            soundVolume = soundVolume - 1;
        }
    }
}