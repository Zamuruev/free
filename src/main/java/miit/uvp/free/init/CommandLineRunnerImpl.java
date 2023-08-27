package miit.uvp.free.init;

import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

public class CommandLineRunnerImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {




    }
}
