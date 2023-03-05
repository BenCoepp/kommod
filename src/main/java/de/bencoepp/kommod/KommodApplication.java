package de.bencoepp.kommod;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class KommodApplication implements CommandLineRunner, ExitCodeGenerator {

    private CommandLine.IFactory factory;
    private Kommod kommod;
    private int exitCode;

    KommodApplication(CommandLine.IFactory factory, Kommod kommod) {
        this.factory = factory;
        this.kommod = kommod;
    }

    @Override
    public void run(String... args) {
        // let picocli parse command line args and run the business logic
        exitCode = new CommandLine(kommod, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    public static void main(String[] args) {
        // let Spring instantiate and inject dependencies
        System.exit(SpringApplication.exit(SpringApplication.run(KommodApplication.class, args)));
    }

}
