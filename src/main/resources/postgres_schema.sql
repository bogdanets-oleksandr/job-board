CREATE TABLE companies (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           industry VARCHAR(255),
                           registration_number VARCHAR(255) UNIQUE,
                           number_of_employees INT CHECK (number_of_employees >= 0)
);

CREATE TABLE jobs (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT NOT NULL,
                      company_id INT NOT NULL,
                      location VARCHAR(255),
                      needed_skills TEXT[],
                      years_of_experience INT CHECK (years_of_experience >= 0),
                      post_date DATE DEFAULT CURRENT_DATE,
                      salary DOUBLE PRECISION CHECK (salary >= 0),
                      CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
);

CREATE TABLE job_skills (
                            job_id INT NOT NULL,
                            skill TEXT NOT NULL,
                            CONSTRAINT fk_job FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE
);

CREATE TABLE job_seekers (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             profession VARCHAR(255),
                             years_of_experience INT CHECK (years_of_experience >= 0),
                             city VARCHAR(255),
                             country VARCHAR(255),
                             skills TEXT[],
                             email VARCHAR(255) UNIQUE NOT NULL,
                             phone_number VARCHAR(15),
                             last_active_date DATE DEFAULT CURRENT_DATE,
                            public_account BOOLEAN DEFAULT false
);

CREATE TABLE job_seeker_skills (
                                   job_seeker_id INT NOT NULL,
                                   skill TEXT NOT NULL,
                                   CONSTRAINT fk_job_seeker FOREIGN KEY (job_seeker_id) REFERENCES job_seekers(id) ON DELETE CASCADE
);

CREATE TABLE job_applications (
                                  id BIGSERIAL PRIMARY KEY,
                                  seeker_id INT NOT NULL,
                                  company_id INT NOT NULL,
                                  job_id INT NOT NULL,
                                  date_applied DATE DEFAULT CURRENT_DATE,
                                  CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE,
                                  CONSTRAINT fk_seeker FOREIGN KEY (seeker_id) REFERENCES job_seekers(id) ON DELETE CASCADE,
                                  CONSTRAINT fk_job FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE
);

