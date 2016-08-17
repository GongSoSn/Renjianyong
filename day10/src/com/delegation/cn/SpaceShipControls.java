/**
 *
 */
package com.delegation.cn;

/**
 * @author renjianyong 演示和练习delegation(代理，委托)
 */
public class SpaceShipControls {
    private String name;

    void up() {
        System.out.println("SpaceShipControls up()... ...");
    }

    void down() {
        System.out.println("SpaceShipControls down()... ...");
    }

    void left() {
        System.out.println("SpaceShipControls left()... ...");
    }

    void right() {
        System.out.println("SpaceShipControls right()... ...");
    }
}
