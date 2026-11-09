package itamio.greetall;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("greetall")
public class GreetAllMod {
    public GreetAllMod() {
        MinecraftForge.EVENT_BUS.addListener(this::onRegisterCommands);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("greetall").requires(s -> s.hasPermission(0))
            .executes(ctx -> {
                ctx.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.literal("Hello, everyone!"), false);
                return 1;
            }));
    }
}
