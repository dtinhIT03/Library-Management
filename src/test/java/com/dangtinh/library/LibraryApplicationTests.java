package com.dangtinh.library;

import com.dangtinh.library.service.AuthorService;
import com.dangtinh.library.dto.response.AuthorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibraryApplicationTests {

	@Autowired
	AuthorService authorService;
	@Test
	void contextLoads() {
		List<AuthorResponse> authorResponses = authorService.getAllAuthors();
		authorResponses.stream().map((author) ->{
			System.out.println(author.toString());
            return null;
        });
	}

}
