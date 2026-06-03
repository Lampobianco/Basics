-- =============================================
-- Script creazione tabelle db_academy_05_2026
-- =============================================

USE db_academy_05_2026;

-- Tabella uffici (deve esistere prima di dipendenti)
CREATE TABLE IF NOT EXISTS uffici (
    id_ufficio   INT          AUTO_INCREMENT PRIMARY KEY,
    nome_ufficio VARCHAR(50)  NOT NULL
);

-- Tabella dipendenti
CREATE TABLE IF NOT EXISTS dipendenti (
    id_dipendente   INT            AUTO_INCREMENT PRIMARY KEY,
    nome            VARCHAR(200)   NOT NULL,
    cognome         VARCHAR(200)   NOT NULL,
    data_assunzione DATE           NOT NULL,
    telefono        VARCHAR(10)    NOT NULL,
    mansioni        VARCHAR(50)    NOT NULL DEFAULT 'impiegato',
    stipendio       DECIMAL(10,0)  NOT NULL,
    id_ufficio      INT,
    FOREIGN KEY (id_ufficio) REFERENCES uffici(id_ufficio)
);

-- Tabella clienti
CREATE TABLE IF NOT EXISTS clienti (
    id_cliente      INT          AUTO_INCREMENT PRIMARY KEY,
    denominazione   VARCHAR(255) NOT NULL,
    p_iva           VARCHAR(16)  NOT NULL,
    indirizzo       VARCHAR(255) NOT NULL,
    telefono        VARCHAR(10)  NOT NULL
);
