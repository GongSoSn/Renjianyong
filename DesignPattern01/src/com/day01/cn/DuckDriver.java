/**
 *
 */
package com.day01.cn;

/**
 * @author renjianyong
 *
 */
public class DuckDriver {
    public static void main(String[] args) {
        RedDuck duckRed = new RedDuck();
        BlueDuck duckBlue = new BlueDuck();
        RubberDuck duckRubber = new RubberDuck();

        duckBlue.fly();
        duckBlue.swim();
        duckBlue.display();
        duckBlue.quack();

        System.out.println("\n*********************************");

        duckRed.quack();
        duckRed.swim();
        duckRed.display();
        duckRed.fly();

        System.out.println("\n*********************************");

        // duckRubber.quack();
        duckRubber.swim();
        duckRubber.display();
        // duckRubber.fly();
    }
}
