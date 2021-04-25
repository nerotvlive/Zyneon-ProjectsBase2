package de.nerotv.projectsbase.api;

import org.bukkit.entity.Player;

public class Start implements Runnable {

    public Player p;

    public Start (Player p) {
        this.p = p;
    }

    public void run() {
        p.performCommand("argria 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("argria 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("argria 3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("argria 4");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("argria 5");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.performCommand("argria 6");
    }
}