package io.reade.testing.service;

import io.reade.testing.model.GitHubUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<GitHubUser> findUser(String gitHubUser) throws InterruptedException {
        logger.info("Looking up " + gitHubUser);
        String url = String.format("https://api.github.com/users/%s", gitHubUser);
        GitHubUser results = restTemplate.getForObject(url, GitHubUser.class);
        // Artifical delay of 1 for demo purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}
