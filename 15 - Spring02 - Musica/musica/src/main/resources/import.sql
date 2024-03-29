INSERT INTO tabela_funcao (autoridade) VALUES ('ROLE_ADMIN');
INSERT INTO tabela_funcao (autoridade) VALUES ('ROLE_OPERATOR');

INSERT INTO tabela_usuario (nome, sobrenome, email, senha) VALUES ('Airton','senna','senna@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG' );
INSERT INTO tabela_usuario (nome, sobrenome, email, senha) VALUES ('Alain','Prost','prost@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tabela_usuario (nome, sobrenome, email, senha) VALUES ('Rubens','Barrichello','rb@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tabela_usuario_funcao (usuario_id, funcao_id) VALUES (1L,1L);
INSERT INTO tabela_usuario_funcao (usuario_id, funcao_id) VALUES (1L,2L);
INSERT INTO tabela_usuario_funcao (usuario_id, funcao_id) VALUES (2L,2L);
INSERT INTO tabela_usuario_funcao (usuario_id, funcao_id) VALUES (3L,2L);


INSERT INTO tabela_pais (nome) VALUES ('Estados Unidos');
INSERT INTO tabela_pais (nome) VALUES ('Brasil');
INSERT INTO tabela_pais (nome) VALUES ('Inglaterra');
INSERT INTO tabela_pais (nome) VALUES ('Argentina');
INSERT INTO tabela_pais (nome) VALUES ('México');

INSERT INTO tabela_estado (nome) VALUES ('Califórnia');
INSERT INTO tabela_estado (nome) VALUES ('East London');
INSERT INTO tabela_estado (nome) VALUES ('Rio Grande do Sul');
INSERT INTO tabela_estado (nome) VALUES ('São Paulo');
INSERT INTO tabela_estado (nome) VALUES ('Rio de Janeiro');
INSERT INTO tabela_estado (nome) VALUES ('Washington');
INSERT INTO tabela_estado (nome) VALUES ('Minas Gerais');

INSERT INTO tabela_cidade (nome) VALUES ('Los Angeles');
INSERT INTO tabela_cidade (nome) VALUES ('Leyton');
INSERT INTO tabela_cidade (nome) VALUES ('Porto Alegre');
INSERT INTO tabela_cidade (nome) VALUES ('São Paulo');
INSERT INTO tabela_cidade (nome) VALUES ('Rio de Janeiro');
INSERT INTO tabela_cidade (nome) VALUES ('Seattle');
INSERT INTO tabela_cidade (nome) VALUES ('Laguna');

INSERT INTO tabela_genero (nome) VALUES ('Rock');
INSERT INTO tabela_genero (nome) VALUES ('Rock Progressivo');
INSERT INTO tabela_genero (nome) VALUES ('Heavy Metal');
INSERT INTO tabela_genero (nome) VALUES ('Trash Metal');
INSERT INTO tabela_genero (nome) VALUES ('Blues');
INSERT INTO tabela_genero (nome) VALUES ('Jazz');
INSERT INTO tabela_genero (nome) VALUES ('Samba');
INSERT INTO tabela_genero (nome) VALUES ('Bossa Nova');
INSERT INTO tabela_genero (nome) VALUES ('Intrumental');

INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id, genero_id) VALUES ('Metallica', true, 1, 1, 1, 4);
INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id, genero_id) VALUES ('Iron Maiden', true, 3, 2, 2, 3);
INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id, genero_id) VALUES ('Pearl Jam', true, 1, 6, 6, 1);
INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id, genero_id) VALUES ('Molotov', true, 5, 6, 6, 1);

INSERT INTO tabela_festival (nome, data_evento) VALUES ('Rock In Rio', TIMESTAMP WITH TIME ZONE '2023-07-13T20:00:07Z');
INSERT INTO tabela_festival (nome, data_evento) VALUES ('Fuji Rock Festival', TIMESTAMP WITH TIME ZONE '2023-07-13T20:00:07Z');
INSERT INTO tabela_festival (nome, data_evento) VALUES ('Lollapalooza', TIMESTAMP WITH TIME ZONE '2023-07-13T20:00:07Z');
INSERT INTO tabela_festival (nome, data_evento) VALUES ('Montreux Jazz Festival', TIMESTAMP WITH TIME ZONE '2023-07-13T20:00:07Z');
INSERT INTO tabela_festival (nome, data_evento) VALUES ('Summerfest', TIMESTAMP WITH TIME ZONE '2023-07-13T20:00:07Z');

INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (1, 1);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (1, 2);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (1, 3);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (2, 3);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (2, 2);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (3, 1);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (3, 2);
INSERT INTO tabela_festival_artista (festival_id, artista_id) VALUES (3, 3);

INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Kill ''Em All', 1983, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Ride The Lightning', 1984, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Master Of Puppets', 1986, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('... And Justice For All', 1988, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Metallica', 1991, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Load', 1996, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('ReLoad', 1997, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Garage Inc', 1998, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('St. Anger', 2003, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Death Magnetic', 2008, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Hardwired--- to Self-Desctruct', 2016, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Iron Maiden', 1980, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Killers', 1981, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('The Number of the Beast', 1982, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Piece of Mind', 1983, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Powerslave', 1984, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Somewhere in Time', 1986, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Seventh Son of a Seventh Son', 1988, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('No Prayer for the Dying', 1990, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Fear of the Dark', 1992, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('The X Factor', 1995, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Virtual XI', 1998, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Brave New World', 2000, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Dance of Death', 2003, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('A Matter of Life and Death', 2006, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('The Final Frontier', 2010, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('The Book of Souls', 2015, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Senjutsu', 2021, 2, 3);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Ten', 1991, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Vs.', 1993, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Vitalogy', 1994, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('No Code', 1996, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Yield', 1998, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Binaural', 2000, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Riot Act', 2002, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Pearl Jam', 2006, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Backspacer', 2009, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Lightning Bolt', 2013, 3, 1);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Gigaton', 2020, 3, 1);

