package jar.us.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("app started");
    }
}
