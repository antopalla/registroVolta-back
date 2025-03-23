-- ##########################################
-- UTENTE (solo Docenti e Tutor)
-- ##########################################

-- Primo utente: Tutor (non admin)
INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, username)
VALUES (NULL, false, 2, 'Tutor', NULL, NULL, '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'admin');

-- Altri utenti (Docenti, Tutor e Studenti)
INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1980-01-01', false, 0, 'Docente', 'Rossi', 'Mario', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1975-05-15', false, 0, 'Docente', 'Bianchi', 'Luca', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1990-09-10', false, 1, 'Tutor', 'Verdi', 'Claudio', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1988-03-12', false, 0, 'Docente', 'Russo', 'Marco', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1992-11-23', false, 1, 'Tutor', 'Ferrari', 'Sara', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1982-04-18', false, 0, 'Docente', 'Esposito', 'Paolo', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('1995-06-30', false, 1, 'Tutor', 'Conti', 'Laura', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password, username)
VALUES ('2004-06-30', false, 3, 'Studente', 'Conte', 'Virginia', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'v.conte');

INSERT INTO utente (data_nascita, disattivato, ruolo, tipo, cognome, nome, password)
VALUES ('2005-05-30', false, 3, 'Studente', 'Gialli', 'Isabella', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2');


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



-- ##########################################
-- STUDENTE
-- ##########################################
/*
INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 1, 'Rossi', 'Luigi');

INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 2, 'Verdi', 'Marta');

INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 3, 'Bianchi', 'Carla');

INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 4, 'Neri', 'Giorgio');

INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 5, 'Gialli', 'Francesca');

INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 6, 'Rossi', 'Stefano');

INSERT INTO studente (disattivato, id_corso, cognome, nome)
VALUES (false, 7, 'De Luca', 'Silvia');
*/


-- ##########################################
-- MODULO
-- ##########################################

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
-- LAYOUT
-- ##########################################

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-01 10:00:00', 'Layout A description', 'Layout A', '/path/to/layoutA');

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-02 11:00:00', 'Layout B description', 'Layout B', '/path/to/layoutB');

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-03 12:00:00', 'Layout C description', 'Layout C', '/path/to/layoutC');

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-04 13:00:00', 'Layout D description', 'Layout D', '/path/to/layoutD');

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-05 14:00:00', 'Layout E description', 'Layout E', '/path/to/layoutE');

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-06 15:00:00', 'Layout F description', 'Layout F', '/path/to/layoutF');

INSERT INTO layout (disattivato, data_creazione, descrizione, nome, path)
VALUES (false, '2023-01-07 16:00:00', 'Layout G description', 'Layout G', '/path/to/layoutG');



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
-- SCHEDA_VALUTAZIONE
-- ##########################################

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           8, 7, 9, 8, 7, 8, 9, false, 8, 7, 8, 9, 8, 7, 8, 9, 2, 1, 1, 1, 'Ottimo', '/firma/1.png', '/scheda/1.pdf'
       );

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           7, 8, 7, 8, 8, 7, 8, false, 7, 8, 7, 8, 7, 8, 7, 8, 3, 2, 2, 2, 'Buono', '/firma/2.png', '/scheda/2.pdf'
       );

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           9, 9, 8, 9, 9, 8, 9, false, 9, 8, 9, 8, 9, 8, 9, 8, 5, 3, 3, 3, 'Eccellente', '/firma/3.png', '/scheda/3.pdf'
       );

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           6, 7, 6, 7, 6, 7, 6, false, 6, 7, 6, 7, 6, 7, 6, 7, 7, 4, 4, 4, 'Soddisfacente', '/firma/4.png', '/scheda/4.pdf'
       );

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           8, 8, 8, 8, 8, 8, 8, false, 8, 8, 8, 8, 8, 8, 8, 8, 3, 5, 5, 5, 'Molto Buono', '/firma/5.png', '/scheda/5.pdf'
       );

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           7, 7, 7, 7, 7, 7, 7, false, 7, 7, 7, 7, 7, 7, 7, 7, 5, 6, 6, 6, 'Buono', '/firma/6.png', '/scheda/6.pdf'
       );

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (
           9, 8, 9, 8, 9, 8, 9, false, 9, 8, 9, 8, 9, 8, 9, 8, 7, 7, 7, 7, 'Eccellente', '/firma/7.png', '/scheda/7.pdf'
       );




-- ##########################################
-- ASSENZA
-- ##########################################

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 1.5, 1, 1);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 2.0, 2, 2);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 1.0, 3, 3);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 0.5, 4, 4);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 2.5, 5, 5);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 1.2, 6, 6);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 1.8, 7, 7);

INSERT INTO assenza (disattivato, durata, id_lezione, id_studente)
VALUES (false, 2.5, 5, 5);
