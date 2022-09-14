package com.ymg.boot.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleResponseDtoTest {

    @Test
    public void 롬복_테스트(){

        String name = "ymk";
        int amount = 29;

        SampleResponseDto dto = new SampleResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
