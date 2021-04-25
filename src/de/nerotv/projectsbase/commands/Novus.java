package de.nerotv.projectsbase.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Novus implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("novus")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                if(p.getName().equalsIgnoreCase("DannyTheOne")) {
                    if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("1")) {
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Sehr verehrte Bürgerinnen und Bürger von Wolfshaven...");
                        } else if(args[0].equalsIgnoreCase("2")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Ich war bereits in mehreren Städten und nun auch hier...§7Sehr verehrte Zuhörerinnen und Zuhörer, hört mich an...");
                        } else if(args[0].equalsIgnoreCase("3")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §fDie Regierung lügt euch an! Und enthält euch §nwichtige§f Informationen vor! Und ihr werdet unter eurem Preis verkauft!");
                        } else if(args[0].equalsIgnoreCase("4")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Die Regierung, genauergesagt, die §fkorrupte§7 Organisation, die unsere Regierung brutal übernommen hat und §nbehauptet§7, das wäre nur zu unserem Schutze, ja ich rede von der §fSchadenskontroll- und Sicherungseinheit§7... §7Ich rede von der SkuSe, angeführt von §fAnthony TheOne§7.");
                        } else if(args[0].equalsIgnoreCase("5")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Der Ansatz der SkuSe ist ja schön und gut, jedoch nicht umzusetzen.");
                        } else if(args[0].equalsIgnoreCase("6")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Die SkuSe erschuf schon lange vor unserer Zeit eine zwei-Klassen Gesellschaft, eine Gesellschaft in welcher reiche Leute nur noch reicher werden und arme Leute nur noch ärmer.");
                        } else if(args[0].equalsIgnoreCase("7")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Hört mich an, Führungsriege der SkuSe, hört zu, was ich zu sagen habe, ihr seid unterwandert. Ja ganz recht, die SkuSe ist von BLACK unterwandert. BLACK versucht seit Jahrzehnten alles zu kontrollieren und zu steuern. Doch das alles hat jetzt einen Schluss...");
                        } else if(args[0].equalsIgnoreCase("8")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Schließt euch mir an, kämpft mit mir für Gleichheit und Freiheit und wir können diesem korrupten Staatssystem entfliehen, es zerstören und ein §fneues System§7 für die §eFreiheit§7 aller Bürgerinnen und Bürger schaffen.");
                        } else if(args[0].equalsIgnoreCase("9")){
                            Bukkit.broadcastMessage("§c§lNOVUS§8: §7Mein Name ist §eNovus§7 und ich bringe das Neue, das nie vergessene und das, was benötigt wird. Ich bin überall - §ferwartet mich§7.");
                        } else if(args[0].equalsIgnoreCase("run")) {
                            de.nerotv.projectsbase.api.Novus thread = new de.nerotv.projectsbase.api.Novus(p);
                            thread.run();
                        }
                    }
                }
            }
        }
        return false;
    }
}