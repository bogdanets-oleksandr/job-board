package org.bogdanets.jobboard.repositories;

import org.bogdanets.jobboard.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String title);

    Company findById(long id);

    Company findByRegistrationNumber(String registrationNumber);

    List<Company> findAllByIndustry(String industry);

    @Query("SELECT c FROM Company c where c.numberOfEmployees <= :employees")
    List<Company> findAllByNumberOfEmployeesLessThanEqual(@Param("employees") int numberOfEmployees);

    @Query("SELECT c FROM Company c where c.numberOfEmployees >= :employees")
    List<Company> findAllByNumberOfEmployeesGreaterThanEqual(@Param("employees") int numberOfEmployees);

}
