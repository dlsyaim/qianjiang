package com.ks.qianjiang.tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTaskTwo implements Tasklet {
    Logger logger = LoggerFactory.getLogger(getClass());
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTaskTwo start..");
        logger.trace("MyTaskTwo接口");
        // ... your code

        System.out.println("MyTaskTwo done..");
        return RepeatStatus.FINISHED;
    }
}