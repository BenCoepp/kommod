package de.bencoepp.kommod.command;

import de.bencoepp.kommod.entity.DoctorElement;
import de.bencoepp.kommod.repository.DoctorElementRepository;
import de.bencoepp.kommod.utils.CommandHelper;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;
import java.io.IOException;
import java.time.Instant;
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

    @Autowired
    private DoctorElementRepository doctorElementRepository;

    @CommandLine.Option(names = {"-v", "--verbose"},
            description = "show all information about readiness")
    boolean verbose;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        boolean ok = true;
        System.out.println("Doctor summary (to see all details, run kommod doctor -v):\n");
        checkDocker();
        return ok ? 0 : 1;
    }

    private void checkDocker() throws IOException {
        DoctorElement element = new DoctorElement();
        element.setTitle("Docker");
        element.setCommand("docker --version");
        element.setExecuted(Instant.now());
        element.setOutput(CommandHelper.execCmd(element.getCommand()));

        if(element.getOutput().contains("Docker version ")){
            element.setOk(true);
            element.setDescription(element.getOutput().replace("\n",""));
        }else{
            element.setOk(false);
            element.setDescription("Currently not installed");
        }

        element.setSaved(Instant.now());
        doctorElementRepository.save(element);
        element.print(verbose);
    }
}
