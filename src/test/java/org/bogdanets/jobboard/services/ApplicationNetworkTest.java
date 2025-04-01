package org.bogdanets.jobboard.services;

import org.bogdanets.jobboard.config.ApplicationNetworkConfig;
import org.bogdanets.jobboard.entities.Company;
import org.bogdanets.jobboard.entities.Job;
import org.bogdanets.jobboard.entities.JobSeeker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ApplicationNetworkConfig.class)
@EnableJpaRepositories("org.bogdanets.jobboard.repositories")
@EntityScan("org.bogdanets.jobboard.entities")
public class ApplicationNetworkTest {


    private ApplicationNetwork applicationNetwork;


    @Autowired
    public void setApplicationNetwork(ApplicationNetwork applicationNetwork) {
        this.applicationNetwork = applicationNetwork;
    }


    @Test
    public void testNetwork() {
        long id = 1;
        Job job = applicationNetwork.findJob(id);
        Company company = applicationNetwork.findCompany(id);
        JobSeeker jobSeeker = applicationNetwork.findJobSeeker(id);

        assertEquals("Alice Johnson", jobSeeker.getName());
        assertEquals("TechCorp", company.getName());
        assertEquals("Software Engineer", job.getTitle());
    }
}
