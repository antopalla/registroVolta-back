
-- ##########################################
-- DIARIO DI BORDO
-- ##########################################

INSERT INTO diario_di_bordo (azienda_ospitante, tutor_aziendale, inizio_tirocinio, fine_tirocinio, data_creazione, disattivato)
VALUES ('Azienda Alpha', 'Ing. Verdi', '2025-01-08', '2025-03-28', CURRENT_TIMESTAMP, false);

INSERT INTO diario_di_bordo (azienda_ospitante, tutor_aziendale, inizio_tirocinio, fine_tirocinio, data_creazione, disattivato)
VALUES ('Azienda Beta', 'Dott.ssa Bianchi', '2025-01-15', '2025-03-31', CURRENT_TIMESTAMP, false);

-- ##########################################
-- PAGINE DEL DIARIO DI BORDO
-- ##########################################

-- Pagina 1 per diario 1
INSERT INTO pagina (
    id_diario, disattivato, inizio_settimana, fine_settimana,
    obiettivi_settimanali, riferimenti_discipline, riflessioni_personali, data_compilazione
) VALUES (
             1, false, '2025-01-08', '2025-01-14',
             'Comprendere l’ambiente lavorativo',
             'Tecnologia, Sicurezza sul lavoro',
             'Settimana introduttiva molto interessante.',
             CURRENT_TIMESTAMP
         );

-- Pagina 2 per diario 1
INSERT INTO pagina (
    id_diario, disattivato, inizio_settimana, fine_settimana,
    obiettivi_settimanali, riferimenti_discipline, riflessioni_personali, data_compilazione
) VALUES (
             1, false, '2025-01-15', '2025-01-21',
             'Affiancamento al tutor aziendale',
             'Tecnologie informatiche, Project Management',
             'Ho iniziato a svolgere attività operative.',
             CURRENT_TIMESTAMP
         );

-- Pagina 1 per diario 2
INSERT INTO pagina (
    id_diario, disattivato, inizio_settimana, fine_settimana,
    obiettivi_settimanali, riferimenti_discipline, riflessioni_personali, data_compilazione
) VALUES (
             2, false, '2025-01-15', '2025-01-21',
             'Osservazione delle attività aziendali',
             'Organizzazione aziendale, Sicurezza',
             'Mi sto ambientando e sto conoscendo il team.',
             CURRENT_TIMESTAMP
         );


-- ##########################################
-- UTENTE ( Docenti, Tutor e Studenti)
-- ##########################################

-- Primo utente: Tutor (non admin)
INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, username, codice_fiscale, primo_accesso)
VALUES ('1970-01-01', false, 2, 'Tutor', NULL, NULL, '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'admin', 'PLNMRAA00A01H501Z', false);

-- Altri utenti (Docenti, Tutor e Studenti)
INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, username, codice_fiscale, primo_accesso)
VALUES ('1980-01-01', false, 0, 'Docente', 'Rossi', 'Mario', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'm.rossi', 'RSSMRA80A01H501Z', false);

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, codice_fiscale)
VALUES ('1975-05-15', false, 0, 'Docente', 'Bianchi', 'Luca', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'BNCMLC75E15H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, codice_fiscale)
VALUES ('1990-09-10', false, 1, 'Tutor', 'Verdi', 'Claudio', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'VRDCLD90P10H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, codice_fiscale)
VALUES ('1988-03-12', false, 0, 'Docente', 'Russo', 'Marco', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'RSSMRC88C12H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, codice_fiscale)
VALUES ('1992-11-23', false, 1, 'Tutor', 'Ferrari', 'Sara', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'FRRSR92S23H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, codice_fiscale)
VALUES ('1982-04-18', false, 0, 'Docente', 'Esposito', 'Paolo', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'ESPPLP82D18H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, codice_fiscale)
VALUES ('1995-06-30', false, 1, 'Tutor', 'Conti', 'Laura', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'CNTLRA95H30H501Z');

-- ##########################################
-- SEDE
-- ##########################################

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '00100', 'Roma', 'Via Roma 1', 'Sede Roma');

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '20100', 'Milano', 'Via Milano 2', 'Sede Milano');

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '40100', 'Bologna', 'Via Bologna 3', 'Sede Bologna');

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '10100', 'Torino', 'Via Torino 4', 'Sede Torino');

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '80100', 'Napoli', 'Via Napoli 5', 'Sede Napoli');

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '50100', 'Firenze', 'Via Firenze 6', 'Sede Firenze');

INSERT INTO sede (disattivato, cap, citta, indirizzo, nome)
VALUES (false, '70100', 'Palermo', 'Via Palermo 7', 'Sede Palermo');


-- ##########################################
-- CORSO
-- ##########################################

-- NOTA: il campo id_tutor deve fare riferimento a un utente con ruolo 1 (Tutor)
INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 1, 1, 'Corso di Programmazione', 'Programmazione Base');

INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 2, 4, 'Corso di Matematica', 'Algebra e Geometria');

INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 3, 6, 'Corso di Fisica', 'Fisica Teorica');

INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 4, 8, 'Corso di Chimica', 'Chimica Organica');

INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 5, 1, 'Corso di Biologia', 'Biologia Generale');

INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 6, 4, 'Corso di Informatica', 'Sistemi Operativi');

INSERT INTO corso (disattivato, id_sede, id_tutor, descrizione, nome)
VALUES (false, 7, 6, 'Corso di Economia', 'Microeconomia');


INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, username, id_corso, codice_fiscale)
VALUES ('2004-06-30', false, 3, 'Studente', 'Conte', 'Virginia', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'v.conte', 2, 'CNTVIR04H30H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, id_corso, codice_fiscale)
VALUES ('2005-05-30', false, 3, 'Studente', 'Gialli', 'Isabella', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 3, 'GILISA05E70H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, id_corso, codice_fiscale)
VALUES ('2004-03-03', false,3, 'Studente' , 'Avella', 'Samuele','$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 3, 'AVLSML04C03H501Z');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, id_corso, codice_fiscale)
VALUES ('2004-11-04', false,3, 'Studente' , 'Bartolo', 'Giulia','$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 2, 'BRTGLI04S44H501Z');



-- NOTA: il campo id_docente deve fare riferimento a un utente con ruolo 0 (Docente)
INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 1, 2, 'Modulo A');

INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 2, 3, 'Modulo B');

INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 3, 2, 'Modulo C');

INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 4, 5, 'Modulo D');

INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 5, 3, 'Modulo E');

INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 6, 7, 'Modulo F');

INSERT INTO modulo (disattivato, id_corso, id_docente, denominazione)
VALUES (false, 7, 2, 'Modulo G');


-- ##########################################
-- LEZIONE
-- ##########################################

-- NOTA: il campo id_docente (per la lezione) deve essere un Docente (ruolo 0)
INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-01', false, '12:00:00', '10:00:00', 1, 2, 1, 'Lezione 1: Introduzione');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-02', false, '13:00:00', '11:00:00', 2, 3, 2, 'Lezione 2: Fondamenti');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-03', false, '14:00:00', '12:00:00', 3, 2, 3, 'Lezione 3: Avanzato');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-04', false, '15:00:00', '13:00:00', 4, 5, 4, 'Lezione 4: Esperimenti');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-05', false, '16:00:00', '14:00:00', 5, 3, 5, 'Lezione 5: Teoria');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-06', false, '17:00:00', '15:00:00', 6, 7, 6, 'Lezione 6: Laboratorio');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-07', false, '18:00:00', '16:00:00', 7, 7, 7, 'Lezione 7: Conclusione');


-- ##########################################
-- ASSENZA
-- ##########################################

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 1.5, 1, 10);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 2.0, 2, 11);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 1.0, 3, 12);
