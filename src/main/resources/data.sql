-- ==========================================================
-- Inserimento degli utenti (utente)
-- ==========================================================
INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES (NULL, false, 2, 1, 'Tutor', NULL, NULL, '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'admin');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1990-01-01', false, 1, 2, 'Docente', 'Rossi', 'Mario', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'mrossi');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1985-05-20', false, 2, 3, 'Tutor', 'Bianchi', 'Luigi', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'lbianchi');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1978-03-15', false, 1, 4, 'Docente', 'Verdi', 'Paolo', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'pverdi');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1992-07-07', false, 0, 5, 'Supporto', 'Neri', 'Giulia', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'gneri');

INSERT INTO utente (data_nascita, disattivato, ruolo, id, tipo, cognome, nome, password, username)
VALUES ('1980-11-11', false, 2, 6, 'Tutor', 'Sanna', 'Marco', '$2a$10$7CUjHOceP3XreTaJ6P0zM.bGlsvg73Ei7atdPO3KUiTxKo8R0lhc2', 'msanna');


-- ==========================================================
-- Inserimento delle sedi (sede)
-- ==========================================================
INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 1, '00100', 'Roma', 'Via Roma 1', 'Sede Roma');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 2, '20100', 'Milano', 'Via Milano 2', 'Sede Milano');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 3, '80100', 'Napoli', 'Via Napoli 3', 'Sede Napoli');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 4, '10100', 'Torino', 'Via Torino 4', 'Sede Torino');

INSERT INTO sede (disattivato, id, cap, citta, indirizzo, nome)
VALUES (false, 5, '50100', 'Firenze', 'Via Firenze 5', 'Sede Firenze');


-- ==========================================================
-- Inserimento dei corsi (corso)
-- ==========================================================
-- Nota: i corsi fanno riferimento a una sede e a un tutor (id_tutor);
-- qui usiamo gli utenti con id 2 e 5 (ruolo Tutor) per rispettare il vincolo.
INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 1, 1, 2, 'Corso di Informatica', 'Informatica Base');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 2, 2, 5, 'Corso di Matematica', 'Matematica');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 3, 3, 2, 'Corso di Fisica', 'Fisica');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 4, 4, 5, 'Corso di Chimica', 'Chimica');

INSERT INTO corso (disattivato, id, id_sede, id_tutor, descrizione, nome)
VALUES (false, 5, 5, 2, 'Corso di Biologia', 'Biologia');


-- ==========================================================
-- Inserimento degli studenti (studente)
-- ==========================================================
-- I record degli studenti faranno riferimento a corsi già inseriti.
INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 1, 1, 'Rossi', 'Anna');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 2, 2, 'Bianchi', 'Luca');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 3, 3, 'Verdi', 'Carla');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 4, 4, 'Neri', 'Paolo');

INSERT INTO studente (disattivato, id, id_corso, cognome, nome)
VALUES (false, 5, 5, 'Gialli', 'Maria');


-- ==========================================================
-- Inserimento dei moduli (modulo)
-- ==========================================================
-- Ogni modulo fa riferimento a un corso e a un docente (id_docente);
-- qui usiamo gli utenti con id 1 e 3 (ruolo Docente).
INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 1, 1, 1, 'Modulo 1: Fondamenti');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 2, 2, 3, 'Modulo 2: Avanzato');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 3, 3, 1, 'Modulo 3: Teoria');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 4, 4, 3, 'Modulo 4: Pratica');

INSERT INTO modulo (disattivato, id, id_corso, id_docente, denominazione)
VALUES (false, 5, 5, 1, 'Modulo 5: Laboratorio');


-- ==========================================================
-- Inserimento dei layout (layout)
-- ==========================================================
INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, CURRENT_TIMESTAMP, 1, 'Layout standard', 'Standard', '/layouts/standard1.pdf');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, CURRENT_TIMESTAMP, 2, 'Layout alternativo', 'Alternativo', '/layouts/alt2.pdf');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, CURRENT_TIMESTAMP, 3, 'Layout moderno', 'Moderno', '/layouts/moderno3.pdf');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, CURRENT_TIMESTAMP, 4, 'Layout classico', 'Classico', '/layouts/classico4.pdf');

INSERT INTO layout (disattivato, data_creazione, id, descrizione, nome, path)
VALUES (false, CURRENT_TIMESTAMP, 5, 'Layout custom', 'Custom', '/layouts/custom5.pdf');


-- ==========================================================
-- Inserimento delle lezioni (lezione)
-- ==========================================================
-- Ogni lezione fa riferimento a un corso, a un docente e a un modulo.
INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-10-01', false, '10:30:00', '09:00:00', 1, 1, 1, 1, 'Lezione introduttiva corso 1');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-10-02', false, '11:30:00', '10:00:00', 2, 2, 3, 2, 'Lezione base corso 2');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-10-03', false, '10:00:00', '08:30:00', 3, 3, 1, 3, 'Lezione teorica corso 3');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-10-04', false, '10:45:00', '09:15:00', 4, 4, 3, 4, 'Lezione pratica corso 4');

INSERT INTO lezione (data, disattivato, ora_fine, ora_inizio, id, id_corso, id_docente, id_modulo, descrizione)
VALUES ('2023-10-05', false, '12:30:00', '11:00:00', 5, 5, 1, 5, 'Lezione laboratorio corso 5');


-- ==========================================================
-- Inserimento delle assenze (assenza)
-- ==========================================================
-- Ogni record di assenza fa riferimento a una lezione e a uno studente.
INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.5, 1, 1, 1);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.0, 2, 2, 2);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 2.0, 3, 3, 3);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 0.5, 4, 4, 4);

INSERT INTO assenza (disattivato, durata, id, id_lezione, id_studente)
VALUES (false, 1.0, 5, 5, 5);


-- ==========================================================
-- Inserimento delle schede di valutazione (scheda_valutazione)
-- ==========================================================
-- Ogni scheda fa riferimento a un docente, a un layout, a un modulo e a uno studente.
INSERT INTO scheda_valutazione (
    capacita_collegamento_organizzazione,
    collaborazione_colleghi,
    collaborazione_docenti,
    collaborazione_tutor,
    comunicazione,
    conoscenza_concetti_tecnici,
    conoscenza_concetti_teorici,
    disattivato,
    impegno,
    integrazione_gruppo,
    livello_preparazione_ingresso,
    livello_preparazione_uscita,
    motivazione,
    rispetto_regole,
    socializzazione,
    uso_linguaggio_terminologia,
    id,
    id_docente,
    id_layout,
    id_modulo,
    id_studente,
    giudizio_complessivo,
    path_firma,
    path_scheda
)
VALUES
    (4, 3, 5, 4, 3, 4, 4, false, 5, 4, 3, 4, 5, 4, 3, 4, 1, 1, 1, 1, 1, 'Buono', '/firma/firma1.png', '/scheda/scheda1.pdf'),
    (3, 4, 4, 3, 4, 5, 3, false, 4, 4, 4, 4, 4, 5, 3, 4, 2, 3, 2, 2, 2, 'Ottimo', '/firma/firma2.png', '/scheda/scheda2.pdf'),
    (5, 5, 4, 4, 5, 4, 5, false, 5, 4, 3, 4, 4, 4, 5, 5, 3, 1, 3, 3, 3, 'Eccellente', '/firma/firma3.png', '/scheda/scheda3.pdf'),
    (3, 3, 3, 3, 3, 3, 3, false, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 4, 4, 4, 'Soddisfacente', '/firma/firma4.png', '/scheda/scheda4.pdf'),
    (4, 4, 4, 4, 4, 4, 4, false, 4, 4, 4, 4, 4, 4, 4, 4, 5, 1, 5, 5, 5, 'Buono', '/firma/firma5.png', '/scheda/scheda5.pdf');
