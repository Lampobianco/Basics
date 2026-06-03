-- =============================================
-- Script creazione tabelle db_academy_05_2026
-- =============================================

USE db_academy_05_2026;

-- Tabella uffici (deve esistere prima di dipendenti)
CREATE TABLE IF NOT EXISTS uffici (
    id_ufficio  INT          AUTO_INCREMENT PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL
);

-- Tabella dipendenti
CREATE TABLE IF NOT EXISTS dipendenti (
    id_dipendente   INT            AUTO_INCREMENT PRIMARY KEY,
    nome            VARCHAR(100)   NOT NULL,
    cognome         VARCHAR(100)   NOT NULL,
    data_assunzione DATE,
    telefono        VARCHAR(20),
    mansione        VARCHAR(100),
    stipendio       DECIMAL(10,2),
    id_ufficio      INT,
    code            VARCHAR(50),
    FOREIGN KEY (id_ufficio) REFERENCES uffici(id_ufficio)
);

-- Tabella clienti
CREATE TABLE IF NOT EXISTS clienti (
    id_cliento      INT          AUTO_INCREMENT PRIMARY KEY,
    denominazione   VARCHAR(200),
    p_iva           VARCHAR(20),
    indirizzo       VARCHAR(200),
    telefono        VARCHAR(20)
);
