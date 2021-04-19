package com.abc.xyz.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

	Logger logger = LoggerFactory.getLogger(HelloApi.class);
	
//	@Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job job;

    @RequestMapping("/job")
    public String handle() throws Exception{
//    	JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
//        logger.debug("Batch job ends with status as " + jobExecution.getStatus());
    	return "job";
    }
    
	@RequestMapping("/")
	public String satHi(){
		return "Hi";
	}
}
