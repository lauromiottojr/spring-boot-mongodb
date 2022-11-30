package com.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodb.dtos.AuthorDTO;
import com.mongodb.dtos.CommentDTO;
import com.mongodb.models.Post;
import com.mongodb.models.User;
import com.mongodb.repositories.PostRepository;
import com.mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// deleteAll
		userRepo.deleteAll();
		postRepo.deleteAll();

		// new users
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepo.saveAll(Arrays.asList(maria, alex, bob));

		// new posts
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para SP!!! ABS",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia!", "Acordei feliz!", new AuthorDTO(maria));

		// comments
		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("21/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("21/03/2018"), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);

		postRepo.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));

		userRepo.save(maria);
	}

}
