package org.bogdanets.jobboard.services;

import org.bogdanets.jobboard.entities.Company;
import org.bogdanets.jobboard.entities.Job;
import org.bogdanets.jobboard.entities.JobSeeker;

public interface ApplicationNetwork {

    public Company findCompany(long jobApplicationId);
    public Job findJob(long jobApplicationId);
    public JobSeeker findJobSeeker(long jobApplicationId);
}
