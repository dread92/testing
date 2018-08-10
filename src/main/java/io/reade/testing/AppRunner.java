package io.reade.testing;

import io.reade.testing.model.GitHubUser;
import io.reade.testing.service.GitHubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService gitHubLookupService;

    @Autowired
    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick off multiple, asynchronous lookups.
//        CompletableFuture<GitHubUser> page1 = gitHubLookupService.findUser("PivotalSoftware");
//        CompletableFuture<GitHubUser> page2 = gitHubLookupService.findUser("CloudFoundry");
//        CompletableFuture<GitHubUser> page3 = gitHubLookupService.findUser("Spring-Projects");
//        CompletableFuture<GitHubUser> page4 = gitHubLookupService.findUser("dread92");
//        CompletableFuture<GitHubUser> page5 = gitHubLookupService.findUser("adminrobert");
//        CompletableFuture<GitHubUser> page6 = gitHubLookupService.findUser("fabpot");
//        CompletableFuture<GitHubUser> page7 = gitHubLookupService.findUser("andrew");
//        CompletableFuture<GitHubUser> page8 = gitHubLookupService.findUser("taylorotwell");
//        CompletableFuture<GitHubUser> page9 = gitHubLookupService.findUser("egoist");
//        CompletableFuture<GitHubUser> page10 = gitHubLookupService.findUser("HugoGiraudel");
//        CompletableFuture<GitHubUser> page11 = gitHubLookupService.findUser("ornicar");
//        CompletableFuture<GitHubUser> page12 = gitHubLookupService.findUser("bebraw");
//        CompletableFuture<GitHubUser> page13 = gitHubLookupService.findUser("nelsonic");
//        CompletableFuture<GitHubUser> page14 = gitHubLookupService.findUser("alexcrichton");
        CompletableFuture<GitHubUser> page15 = gitHubLookupService.findUser("jonathanong");

        // Wait until threads complete
        CompletableFuture.allOf(
//                page1,
//                page2,
//                page3,
//                page4,
//                page5,
//                page6,
//                page7,
//                page8,
//                page9,
//                page10,
//                page11,
//                page12,
//                page13,
//                page14,
                page15
        ).join();

        //Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start ));
//        logger.info("--> " + page1.get());
//        logger.info("--> " + page2.get());
//        logger.info("--> " + page3.get());
//        logger.info("--> " + page4.get());
//        logger.info("--> " + page5.get());
//        logger.info("--> " + page6.get());
//        logger.info("--> " + page7.get());
//        logger.info("--> " + page8.get());
//        logger.info("--> " + page9.get());
//        logger.info("--> " + page10.get());
//        logger.info("--> " + page11.get());
//        logger.info("--> " + page12.get());
//        logger.info("--> " + page13.get());
//        logger.info("--> " + page14.get());
        logger.info("--> " + page15.get());
    }
}
