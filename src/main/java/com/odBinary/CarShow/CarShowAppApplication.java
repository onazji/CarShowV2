package com.odBinary.CarShow;
import com.odBinary.CarShow.entity.Car;
import com.odBinary.CarShow.entity.Owner;
import com.odBinary.CarShow.entity.User;
import com.odBinary.CarShow.repository.CarRepository;
import com.odBinary.CarShow.repository.OwnerRepository;
import com.odBinary.CarShow.repository.UserRepository;
import com.odBinary.CarShow.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarShowAppApplication implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(CarShowAppApplication.class);

	public static void main(String[] args) {


		SpringApplication.run(CarShowAppApplication.class, args);
		logger.info("Application started");


	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Jack", "Biden");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		List<Car> cars = Arrays.asList(

				new Car("Ford", "Mustang", "Red", "ADF_1121", 2021, 49000, owner1),
				new Car("Nissan", "Leaf", "Gray", "EBF_1221", 2020, 32500, owner2),
				new Car("Toyota", "Camry", "Silver", "CDF_3123", 2021, 32000, owner1),
				new Car("Toyota", "Corolla", "White", "DDF_3421", 2023, 40000, owner2)
		);
		carRepository.saveAll(cars);
		carRepository.findAll().forEach(car -> logger.info(car.getBrand() + " " + car.getModel()));
		// Username: user, password: userPass

		userRepository.save(new User(
				"user",
				"$2y$10$dc3e3saiBRuwAmihOB0cWe8cI./MVgKIrdq9uCukCnRXYoNgYR1e6",
				"USER"));
		// Username: admin, password: adminPass
		userRepository.save(new User(
				"admin",
				"$2y$10$VKlPOmlBxacyOtoGuASJuu6F0E4Gf/VfiWsVZSHlr3xHzjn9DQ68W",
				"ADMIN"));


	}



}