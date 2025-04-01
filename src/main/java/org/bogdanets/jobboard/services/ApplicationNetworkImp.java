package org.bogdanets.jobboard.services;

import org.bogdanets.jobboard.entities.Company;
import org.bogdanets.jobboard.entities.Job;
import org.bogdanets.jobboard.entities.JobSeeker;
import org.bogdanets.jobboard.repositories.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationNetworkImp implements ApplicationNetwork {

    private final JobApplicationRepository applicationRepository;

    @Autowired
    public ApplicationNetworkImp(JobApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Company findCompany(long jobApplicationId) {
        return applicationRepository.findById(jobApplicationId).get().getJob().getCompany();

    }

    @Override
    public Job findJob(long jobApplicationId) {
        return applicationRepository.findById(jobApplicationId).get().getJob();
    }

    @Override
    public JobSeeker findJobSeeker(long jobApplicationId) {
        return applicationRepository.findById(jobApplicationId).get().getJobSeeker();
    }
}
