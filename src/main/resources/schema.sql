DROP TABLE IF EXISTS t_job_applications;
DROP TABLE IF EXISTS t_job_seeker_skills;
DROP TABLE IF EXISTS t_job_seekers;
DROP TABLE IF EXISTS t_job_skills;
DROP TABLE IF EXISTS t_jobs;
DROP TABLE IF EXISTS t_companies;

CREATE TABLE t_companies (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             industry VARCHAR(255),
                             registration_number VARCHAR(255) UNIQUE,
                             number_of_employees INT CHECK (number_of_employees >= 0)
);

CREATE TABLE t_jobs (
                        id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description TEXT NOT NULL,
                        company_id INT NOT NULL,
                        location VARCHAR(255),
                        years_of_experience INT CHECK (years_of_experience >= 0),
                        post_date DATE DEFAULT CURRENT_DATE,
                        salary DOUBLE PRECISION CHECK (salary >= 0),
                        CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES t_companies(id) ON DELETE CASCADE
);

CREATE TABLE t_job_seekers (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               profession VARCHAR(255),
                               years_of_experience INT CHECK (years_of_experience >= 0),
                               city VARCHAR(255),
                               country VARCHAR(255),
                               email VARCHAR(255) UNIQUE NOT NULL,
                               phone VARCHAR(15),
                               last_active_date DATE DEFAULT CURRENT_DATE,
                               public_account BOOLEAN DEFAULT false
);

CREATE TABLE t_job_applications (
                                    id BIGSERIAL PRIMARY KEY,
                                    seeker_id INT NOT NULL,
                                    company_id INT NOT NULL,
                                    job_id INT NOT NULL,
                                    date_applied DATE DEFAULT CURRENT_DATE,
                                    CONSTRAINT fk_company_applications FOREIGN KEY (company_id) REFERENCES t_companies(id) ON DELETE CASCADE,
                                    CONSTRAINT fk_seeker FOREIGN KEY (seeker_id) REFERENCES t_job_seekers(id) ON DELETE CASCADE,
                                    CONSTRAINT fk_job_applications FOREIGN KEY (job_id) REFERENCES t_jobs(id) ON DELETE CASCADE
);