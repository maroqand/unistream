package uz.upay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import uz.upay.unistream.service.ClientService;

@SpringBootApplication
@ComponentScan(basePackages = {"uz.upay.config","uz.upay.unistream"})
public class UnistreamApplication implements CommandLineRunner {

	@Autowired
	private ClientService clientService;

	public static void main(String[] args) {
		SpringApplication.run(UnistreamApplication.class, args);
	}

	@Override
	public void run(String... args) {
		clientService.getClient(1);
	}
}
