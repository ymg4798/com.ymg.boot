package com.ymg.boot.springboot.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Slf4j
@RequiredArgsConstructor
@Configurable // 스프링 batch의 job은 Configuratble 을 등록해야한다.
public class sampleJop {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job sample() {
        return jobBuilderFactory.get("sample")// sample batch job 생성
                .start(simpleStep1())
                .build();
    }

    public Step simpleStep1(){
        return stepBuilderFactory.get("simpleStep1")// simpleStep batch step설정
                .tasklet((contribution, chunkContext) -> {// step에서 단일 수행 커스텀 기능
                    log.info(">>> step1");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
