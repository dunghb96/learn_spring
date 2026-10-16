-- Patients & Checkups (bài test N+1 / Batch fetch)
CREATE TABLE IF NOT EXISTS patients (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    citizen_id VARCHAR(12) UNIQUE,
    created_at DATETIME(6)
);

CREATE TABLE IF NOT EXISTS checkups (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    diagnosis VARCHAR(255),
    patient_id BIGINT,
    CONSTRAINT fk_checkups_patient FOREIGN KEY (patient_id) REFERENCES patients (id)
);
