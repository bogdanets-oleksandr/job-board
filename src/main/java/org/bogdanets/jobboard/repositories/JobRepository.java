package org.bogdanets.jobboard.repositories;

import org.bogdanets.jobboard.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Job findById(long id);

    List<Job> findAllByTitle(String title);

    List<Job> findAllByDateAfter(LocalDate dateAfter);

    List<Job> findAllByCompany_Name(String companyName);

    List<Job> findAllByCompany_Id(Long companyId);

    List<Job> findAllByLocation(String location);

    @Query("""
           SELECT j FROM Job j
           WHERE UPPER(j.title) LIKE UPPER(:title)
           AND j.salary >= :salary""")
    List<Job> findAllByTitleContainsIgnoreCaseAndSalaryGreaterThanEqual(@Param("title") String title, @Param("salary") BigDecimal salary);

    @Query("""
           SELECT j FROM Job j
           WHERE UPPER(j.location) LIKE UPPER(:location)
           AND j.salary >= :salary""")
    List<Job> findAllByLocationAndSalaryGreaterThanEqual(@Param("location") String location, @Param("salary") BigDecimal salary);

    @Query("""
            SELECT j FROM Job j
            WHERE j.title LIKE :title
            AND j.yearsOfExperience <= :yearsOfExperience""")
    List<Job> findAllByTitleAndYearsOfExperienceLessThanEqual(@Param("title") String title, @Param("yearsOfExperience") int yearsOfExperience);

    @Query("""
           SELECT j FROM Job j
           JOIN j.skills s
           WHERE s in :skills
           GROUP BY j
           ORDER BY s.size DESC""")
    List<Job> findByAllSkills(@Param("skills") Collection<String> skills);


}
