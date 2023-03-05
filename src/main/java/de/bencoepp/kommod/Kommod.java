package de.bencoepp.kommod;

import de.bencoepp.kommod.command.DoctorCommand;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "kommod", mixinStandardHelpOptions = true, version = "0.0.1",
        description = "The all in one tool for project analyzes",
        commandListHeading = "%nCommands:%n%nThe most commonly used probatio commands are:%n",
        footer = "%nSee 'kommod help <command>' to read about a specific subcommand or concept.",
        subcommands = {
                DoctorCommand.class,
                CommandLine.HelpCommand.class
        })
public class Kommod implements Callable<Integer> {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    public Integer call() throws Exception {
        boolean ok = true;
        spec.commandLine().usage(System.err);
        return ok ? 0 : 1;
    }
}
