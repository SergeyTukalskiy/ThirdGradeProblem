package com;

public class Main {

    public static int amount = 0;                           // поле для подсчета способов
    public static int money = 1000;                         // сумма, которую необходимо разменять

    public static void main(String[] args) {
        start();
    }
    // начало прохода по дереву
    public static void start() {
        long timeStart = System.currentTimeMillis();
        inc10(0);                                  // проход во ветке с 10
        inc4(0);                                   // проход во ветке с 4
        inc2(0);                                   // проход во ветке с 2
        inc1(0);                                   // проход во ветке с 1
        long timeEnd = System.currentTimeMillis();
        System.out.println("Количество способов разменять " + money + " рублей купюрами по 50, 100, 200 и 500 рублей: " + amount);
        long timeElapsed = timeEnd - timeStart;

        // подсчет времени, затраченного на вычисление
        String timeText;
        if (timeElapsed == 0) {
            timeText = "<1";
        } else {
            timeText = Long.toString(timeElapsed);
        }
        System.out.println("Время, затраченное на вычисление(в миллисекундах): " + timeText);
    }

    // описание одного из методов обхода дерева
    public static void inc10(int number) {
        int res = number + 500;                             // попытка увеличить сумму
        if (res < money) {
            inc10(res);                                     // рекурсивный запуск попытки увеличить сумму
            inc4(res);                                      // при неудаче, запуск прохождения по другим веткам
            inc2(res);
            inc1(res);
        } else {
            if (res == money) {
                amount++;
            }
        }
    }
    //метод, аналогичный предыдущему
    public static void inc4(int number) {
        int res = number + 200;
        if (res < money) {
            inc4(res);
            inc2(res);
            inc1(res);
        } else {
            if (res == money) {
                amount++;
            }
        }
    }

    public static void inc2(int number) {
        int res = number + 100;
        if (res < money) {
            inc2(res);
            inc1(res);
        } else {
            if (res == money) {
                amount++;
            }
        }
    }

    public static void inc1(int number) {
        int res = number + 50;
        if (res < money) {
            inc1(res);
        } else {
            if (res == money) {
                amount++;
            }
        }
    }
}
