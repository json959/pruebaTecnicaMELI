create database pruebaMeli;
use pruebaMeli;

create table IF NOT EXISTS dna(
	dna_id INT AUTO_INCREMENT PRIMARY KEY,
    dna VARCHAR(500) NOT NULL,
    is_mutan BIT(1) NOT NULL
);