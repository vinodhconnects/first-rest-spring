package com.restservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.restservices.controllers.PeopleAPI;

@SpringBootTest
@AutoConfigureMockMvc
class FirstRestServiceApplicationTests {

	@Autowired
	private PeopleAPI api;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	   assertThat(api).isNotNull()	;
	}
	
	@Test
	public void checkThis() throws Exception {
		mockMvc.perform(get("/api/people")).andExpect(status().isOk());
	}

}
