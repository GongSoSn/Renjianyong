/**
 *
 */
package com.delegation.cn;

/**
 * @author renjianyong
 *
 */
public class SpaceShipDele {
    private String name;
    private SpaceShipControls shipFather;

    public SpaceShipDele(String name) {
        this.name = name;
    }

    void up() {
        shipFather = new SpaceShipControls();
        shipFather.up();
        // shipFather.name;
    }

    public static void main(String[] args) {
        SpaceShipDele ship = new SpaceShipDele("Delegation");
        ship.up();
    }
}
