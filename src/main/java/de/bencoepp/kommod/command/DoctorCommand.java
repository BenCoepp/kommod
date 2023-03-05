package de.bencoepp.kommod.command;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "doctor",
        sortOptions = false,
        headerHeading = "@|bold,underline Usage:|@%n%n",
        synopsisHeading = "%n",
        descriptionHeading = "%n@|bold,underline Description:|@%n%n",
        parameterListHeading = "%n@|bold,underline Parameters:|@%n",
        optionListHeading = "%n@|bold,underline Options:|@%n",
        header = "check system readiness for use",
        description = "check your system for some of the most command tools and software required to work efficiently")
public class DoctorCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-v", "--verbose"},
            description = "show all information about readiness")
    boolean verbose;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        boolean ok = true;
        System.out.println("test test");
        return ok ? 0 : 1;
    }
}
