package com.ymg.boot.springboot.web;

import com.ymg.boot.springboot.web.dto.SampleResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }

    @GetMapping("/sample/dto")
    public SampleResponseDto sample(SampleResponseDto dto){
        return dto;
    }
}
