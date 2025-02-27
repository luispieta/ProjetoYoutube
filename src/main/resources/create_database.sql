CREATE DATABASE IF NOT EXISTS projeto_video;
USE projeto_video;

CREATE TABLE IF NOT EXISTS inscritos(
	id INT NOT NULL AUTO_INCREMENT,
	usuario VARCHAR(255) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    idade INT,
    sexo CHAR(6),
    totalAssistido INT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS video(
	id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    avaliacao INT, 
    views INT,
    curtidas INT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS visualizacao(
	id INT NOT NULL AUTO_INCREMENT,
    espectador INT NOT NULL,
    video_rodando INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(espectador) REFERENCES inscritos(id),
    FOREIGN KEY(video_rodando) REFERENCES video(id)
);