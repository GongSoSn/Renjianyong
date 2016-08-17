/**
 *
 */
package com.delegation.cn;

/**
 * @author renjianyong
 *
 */
public class SpaceShipExtends extends SpaceShipControls {
    private String name;

    public SpaceShipExtends(String n) {
        name = n;
    }

    public static void main(String[] args) {
        SpaceShipExtends ship = new SpaceShipExtends("Extends");
        ship.down();
        ship.left();
        ship.up();
        ship.right();
    }
}
