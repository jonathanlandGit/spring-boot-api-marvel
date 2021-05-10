package com.jonathanland;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MarvelHeroesApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllHeroes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hero")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hero/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hero/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewHero() throws Exception {
        String newHero = "{\"name\":\"Thor\",\"description\":\"Jacked.\",\"yearsOld\":200000,\"topComicBookPrice\":2000000}";
        mockMvc.perform(MockMvcRequestBuilders.post("/hero")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newHero)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
