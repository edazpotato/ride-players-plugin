package codes.edaz.rideplayers.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.List;

public class ClickEntityListener implements Listener
{
    @EventHandler
    public void playerInteractsEntity(PlayerInteractEntityEvent e)
    {
        Player p = e.getPlayer();
        Entity t = e.getRightClicked();
//        p.chat("Clicked " + t.getName());
        if (t.getType() == EntityType.PLAYER) // Make sure they clicked a player
        {
//            p.chat(t.getName() + " is a player!");

            if (t.getPassengers().size() > 0) // If it has passengers
            {
                Entity topPassenger = this.recursivelyFindTopPassenger(t);
                if (!topPassenger.equals(p))
                {
                    topPassenger.addPassenger(p);
                }
            }
            else // If it has no passengers
            {
                t.addPassenger(p);
            }
        }
    }

    private Entity recursivelyFindTopPassenger(Entity e)
    {
//        System.out.println("Recursion function called on entity " + e.getName());
        List<Entity> passengers = e.getPassengers();

        if (passengers.size() == 0)
        {
            return e;
        }

        Entity passenger = passengers.get(0);
        Entity topPassenger = this.recursivelyFindTopPassenger(passenger);
        return topPassenger;
    }
}
