package codes.edaz.rideplayers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class KickPassengersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player)sender;
        List<Entity> passengers = p.getPassengers();

        if (passengers.size() == 0) {
            p.sendRawMessage("No passengers found!");
            return true;
        }

        for (Entity passenger : passengers) {
            p.removePassenger(passenger);
            p.sendRawMessage("Kicked " + passenger.getName() + " off of you.");
        }
        return true;
    }
}
