
INSERT INTO t_companies (name, industry, registration_number, number_of_employees) VALUES
                                                                                       ('TechCorp', 'Software', 'REG12345', 500),
                                                                                       ('MediHealth', 'Healthcare', 'REG67890', 300),
                                                                                       ('EcoSolutions', 'Environmental', 'REG54321', 100);


INSERT INTO t_jobs (title, description, company_id, location, years_of_experience, salary) VALUES
                                                                                                              ('Software Engineer', 'Develop and maintain web applications.', 1, 'New York',  3, 90000),
                                                                                                              ('Data Analyst', 'Analyze and interpret data trends.', 1, 'San Francisco', 2, 75000),
                                                                                                              ('Nurse', 'Provide medical care to patients.', 2, 'Los Angeles',  1, 65000),
                                                                                                              ('Environmental Consultant', 'Assess and mitigate environmental risks.', 3, 'Chicago', 4, 80000);



INSERT INTO t_job_seekers (name, profession, years_of_experience, city, country, email, phone, public_account) VALUES
                                                                                                                                  ('Alice Johnson', 'Software Developer', 4, 'New York', 'USA', 'alice@example.com', '1234567890', true),
                                                                                                                                  ('Bob Smith', 'Data Analyst', 3, 'San Francisco', 'USA', 'bob@example.com', '0987654321', true),
                                                                                                                                  ('Charlie Brown', 'Nurse', 2, 'Los Angeles', 'USA',  'charlie@example.com', '1122334455', false),
                                                                                                                                  ('Diana Green', 'Environmental Consultant', 5, 'Chicago', 'USA', 'diana@example.com', '5566778899', true);


INSERT INTO t_job_applications (seeker_id, company_id, job_id, date_applied) VALUES
                                                                                 (1, 1, 1, CURRENT_DATE),
                                                                                 (2, 1, 2, CURRENT_DATE),
                                                                                 (3, 2, 3, CURRENT_DATE),
                                                                                 (4, 3, 4, CURRENT_DATE);