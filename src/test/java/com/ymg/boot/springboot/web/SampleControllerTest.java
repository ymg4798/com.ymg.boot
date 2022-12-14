package com.ymg.boot.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SampleController.class)// Contoller, ContollerAdvice를 사용할 때 쓴다.
@MockBean(JpaMetamodelMappingContext.class)
public class SampleControllerTest {

    @Autowired
    private MockMvc mvc; // Api 테스트를 할때 사용한다.

    @Test
    public void Sample_리턴값() throws Exception {
        String sample = "sample";

        mvc.perform(get("/sample"))
                .andExpect(status().isOk()) // perform의 결과 검증
                .andExpect(content().string(sample)); // 값 검증
    }

    @Test
    public void SampleDto_test() throws Exception {
        String name = "ymk";
        int amount = 29;

        mvc.perform(get("/sample/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
