package de.nerotv.projectsbase.api;

import org.bukkit.entity.Player;

public class Novus implements Runnable {

    public Player p;

    public Novus (Player p) {
        this.p = p;
    }

    public void run() {
        p.performCommand("novus 1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 3");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 4");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 5");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 6");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 7");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 8");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("novus 9");

    }
}