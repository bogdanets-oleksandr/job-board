package org.bogdanets.jobboard.repositories;

import org.bogdanets.jobboard.entities.Job;
import org.bogdanets.jobboard.entities.JobApplication;
import org.bogdanets.jobboard.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findAllByJob(Job job);

    List<JobApplication> findAllByJobSeeker(JobSeeker jobSeeker);

    @Query("""
            SELECT j FROM JobApplication j
            WHERE j.job = :job
            AND j.dateApplied > :date""")
    List<JobApplication> findAllByJobAndDateAppliedAfter(@Param("job") Job job, @Param("date") LocalDate date);

    @Query("""
            SELECT j FROM JobApplication j
            WHERE j.jobSeeker = :jobSeeker
            AND j.dateApplied > :date""")
    List<JobApplication> findAllByJobSeekerAndDateAppliedAfter(@Param("jobSeeker") JobSeeker jobSeeker, @Param("date") LocalDate date);
}
