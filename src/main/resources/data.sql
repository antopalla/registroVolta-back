-- ##########################################
-- UTENTE (solo Docenti e Tutor)
-- ##########################################

-- Primo utente: Tutor (non admin)
INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES (NULL, false, 2, 1, 'Tutor', NULL, NULL, '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'admin');

-- Altri utenti (Docenti e Tutor)
INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1980-01-01', false, 0, 2, 'Docente', 'Rossi', 'Mario', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'mrossi');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1975-05-15', false, 0, 3, 'Docente', 'Bianchi', 'Luca', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'lbianchi');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1990-09-10', false, 1, 4, 'Tutor', 'Verdi', 'Claudio', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'cverdi');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1988-03-12', false, 0, 5, 'Docente', 'Russo', 'Marco', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'mrusso');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1992-11-23', false, 1, 6, 'Tutor', 'Ferrari', 'Sara', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'sferrari');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1982-04-18', false, 0, 7, 'Docente', 'Esposito', 'Paolo', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'pesposito');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1995-06-30', false, 1, 8, 'Tutor', 'Conti', 'Laura', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'lconti');


-- ##########################################
-- SEDE
-- ##########################################

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 1, '00100', 'Roma', 'Via Roma 1', 'Sede Roma');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 2, '20100', 'Milano', 'Via Milano 2', 'Sede Milano');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 3, '40100', 'Bologna', 'Via Bologna 3', 'Sede Bologna');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 4, '10100', 'Torino', 'Via Torino 4', 'Sede Torino');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 5, '80100', 'Napoli', 'Via Napoli 5', 'Sede Napoli');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 6, '50100', 'Firenze', 'Via Firenze 6', 'Sede Firenze');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 7, '70100', 'Palermo', 'Via Palermo 7', 'Sede Palermo');


-- ##########################################
-- CORSO
-- ##########################################

-- NOTA: il campo id_tutor deve fare riferimento a un utente con ruolo 1 (Tutor)
INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 1, 1, 1, 'Corso di Programmazione', 'Programmazione Base');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 2, 2, 4, 'Corso di Matematica', 'Algebra e Geometria');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 3, 3, 6, 'Corso di Fisica', 'Fisica Teorica');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 4, 4, 8, 'Corso di Chimica', 'Chimica Organica');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 5, 5, 1, 'Corso di Biologia', 'Biologia Generale');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 6, 6, 4, 'Corso di Informatica', 'Sistemi Operativi');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 7, 7, 6, 'Corso di Economia', 'Microeconomia');


-- ##########################################
-- STUDENTE
-- ##########################################

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 1, 1, 'Rossi', 'Luigi');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 2, 2, 'Verdi', 'Marta');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 3, 3, 'Bianchi', 'Carla');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 4, 4, 'Neri', 'Giorgio');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 5, 5, 'Gialli', 'Francesca');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 6, 6, 'Rossi', 'Stefano');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 7, 7, 'De Luca', 'Silvia');


-- ##########################################
-- MODULO
-- ##########################################

-- NOTA: il campo id_docente deve fare riferimento a un utente con ruolo 0 (Docente)
INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 1, 1, 2, 'Modulo A');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 2, 2, 3, 'Modulo B');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 3, 3, 2, 'Modulo C');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 4, 4, 5, 'Modulo D');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 5, 5, 3, 'Modulo E');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 6, 6, 7, 'Modulo F');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 7, 7, 2, 'Modulo G');


-- ##########################################
-- LAYOUT
-- ##########################################

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-01 10:00:00', 1, 'Layout A description', 'Layout A', '/path/to/layoutA');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-02 11:00:00', 2, 'Layout B description', 'Layout B', '/path/to/layoutB');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-03 12:00:00', 3, 'Layout C description', 'Layout C', '/path/to/layoutC');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-04 13:00:00', 4, 'Layout D description', 'Layout D', '/path/to/layoutD');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-05 14:00:00', 5, 'Layout E description', 'Layout E', '/path/to/layoutE');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-06 15:00:00', 6, 'Layout F description', 'Layout F', '/path/to/layoutF');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, '2023-01-07 16:00:00', 7, 'Layout G description', 'Layout G', '/path/to/layoutG');


-- ##########################################
-- LEZIONE
-- ##########################################

-- NOTA: il campo id_docente (per la lezione) deve essere un Docente (ruolo 0)
INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-01', false, '12:00:00', '10:00:00', 1, 1, 2, 1, 'Lezione 1: Introduzione');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-02', false, '13:00:00', '11:00:00', 2, 2, 3, 2, 'Lezione 2: Fondamenti');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-03', false, '14:00:00', '12:00:00', 3, 3, 2, 3, 'Lezione 3: Avanzato');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-04', false, '15:00:00', '13:00:00', 4, 4, 5, 4, 'Lezione 4: Esperimenti');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-05', false, '16:00:00', '14:00:00', 5, 5, 3, 5, 'Lezione 5: Teoria');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-06', false, '17:00:00', '15:00:00', 6, 6, 7, 6, 'Lezione 6: Laboratorio');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-02-07', false, '18:00:00', '16:00:00', 7, 7, 7, 7, 'Lezione 7: Conclusione');


-- ##########################################
-- SCHEDA_VALUTAZIONE
-- ##########################################

-- NOTA: il campo id_docente (per la scheda) deve essere un Docente (ruolo 0)
INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (8, 7, 9, 8, 7, 8, 9, false, 8, 7, 8, 9, 8, 7, 8, 9, 1, 2, 1, 1, 1, 'Ottimo', '/firma/1.png', '/scheda/1.pdf');

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (7, 8, 7, 8, 8, 7, 8, false, 7, 8, 7, 8, 7, 8, 7, 8, 2, 3, 2, 2, 2, 'Buono', '/firma/2.png', '/scheda/2.pdf');

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (9, 9, 8, 9, 9, 8, 9, false, 9, 8, 9, 8, 9, 8, 9, 8, 3, 5, 3, 3, 3, 'Eccellente', '/firma/3.png', '/scheda/3.pdf');

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (6, 7, 6, 7, 6, 7, 6, false, 6, 7, 6, 7, 6, 7, 6, 7, 4, 7, 4, 4, 4, 'Soddisfacente', '/firma/4.png', '/scheda/4.pdf');

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (8, 8, 8, 8, 8, 8, 8, false, 8, 8, 8, 8, 8, 8, 8, 8, 5, 3, 5, 5, 5, 'Molto Buono', '/firma/5.png', '/scheda/5.pdf');

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (7, 7, 7, 7, 7, 7, 7, false, 7, 7, 7, 7, 7, 7, 7, 7, 6, 5, 6, 6, 6, 'Buono', '/firma/6.png', '/scheda/6.pdf');

INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione, collaborazione_colleghi, collaborazione_docenti, collaborazione_tutor,
    comunicazione, conoscenza_concetti_tecnici, conoscenza_concetti_teorici, disattivato, impegno, integrazione_gruppo,
    livello_preparazione_ingresso, livello_preparazione_uscita, motivazione, rispetto_regole, socializzazione,
    uso_linguaggio_terminologia, id, id_docente, id_layout, id_modulo, id_studente, giudizio_complessivo, path_firma, path_scheda
)
VALUES (9, 8, 9, 8, 9, 8, 9, false, 9, 8, 9, 8, 9, 8, 9, 8, 7, 7, 7, 7, 7, 'Eccellente', '/firma/7.png', '/scheda/7.pdf');


-- ##########################################
-- ASSENZA
-- ##########################################

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.5, 1, 1, 1);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 2.0, 2, 2, 2);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.0, 3, 3, 3);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 0.5, 4, 4, 4);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 2.5, 5, 5, 5);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.2, 6, 6, 6);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.8, 7, 7, 7);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 2.5, 8, 5, 5);
