package org.bogdanets.jobboard.repositories;

import org.bogdanets.jobboard.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

    @Query("""
        SELECT s FROM JobSeeker s
        WHERE s.publicProfile = TRUE
        AND s.profession LIKE :profession""")
    List<JobSeeker> findAllByProfession(@Param("profession") String profession);

    @Query("""
        SELECT s FROM JobSeeker s
        WHERE s.publicProfile = TRUE
        AND S.city = :city""")
    List<JobSeeker> findAllByCityAndPublicProfileIsTrue(@Param("city") String city);

    @Query("""
        SELECT s FROM JobSeeker s
        WHERE s.publicProfile = TRUE
        AND s.country = :country""")
    List<JobSeeker> findAllByCountryAndPublicProfileIsTrue(@Param("country") String country);

    @Query("""
        SELECT s FROM JobSeeker s
        WHERE s.publicProfile = TRUE
        AND s.profession LIKE :profession
        AND s.lastActive >= :date""")
    List<JobSeeker> findAllByProfessionAndLastActiveAfter(@Param("profession") String profession, @Param("date") LocalDate date);

    @Query("""
        SELECT s FROM JobSeeker s
        WHERE s.publicProfile = TRUE
        AND s.profession LIKE :profession
        AND s.experience >= :experience""")
    List<JobSeeker> findAllByProfessionAndExperienceGreaterThanEqual(@Param("profession") String profession, @Param("experience") int experience);

    @Query("""
           SELECT js FROM JobSeeker js
           JOIN js.skills s
           WHERE s in :skills AND js.publicProfile = TRUE
           GROUP BY js
           ORDER BY s.size DESC""")
    List<JobSeeker> findAllBySkills(@Param("skills") Collection<String> skills);
}
