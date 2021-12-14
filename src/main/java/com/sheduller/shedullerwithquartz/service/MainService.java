package com.sheduller.shedullerwithquartz.service;

import com.sheduller.shedullerwithquartz.component.Task;
import com.sheduller.shedullerwithquartz.config.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service(value = "main")
public class MainService {
    @Autowired
    Jobs jobs;
    @Autowired
    TaskScheduler taskScheduler;
    public void run(){
        for (var job : jobs.getJobs()) {
            taskScheduler.scheduleWithFixedDelay(new Task(job), job.getDelay());
          //  taskScheduler.schedule(new Task(job) , new CronTrigger())
        }
    }
}
