package com.aws.dynamodb;

import com.aws.dynamodb.entity.Person;
import com.aws.dynamodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@SpringBootApplication
public class Application {

	private final PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/person/{personId}")
	public Person getPerson(@PathVariable String personId) {
		return repository.findByPersonId(personId);
	}

	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {
		return repository.save(person);
	}

	@PutMapping("/person")
	public Person updatePerson( @RequestBody Person person) {
		return repository.updatePerson(person);
	}

	@DeleteMapping("/person")
	public String deletePerson(@RequestBody Person person) {
		return repository.deletePerson(person);
	}
}
