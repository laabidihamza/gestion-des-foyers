-- Université et Foyer
INSERT INTO foyer (id_foyer, nom_foyer) VALUES (1, 'Foyer Central');
INSERT INTO universite (id_universite, nom_universite, foyer_id_foyer) VALUES (1, 'Université de Tunis', 1);

-- Blocs
INSERT INTO bloc (id_bloc, nom_bloc, foyer_id_foyer) VALUES
                                                         (1, 'Bloc A', 1),
                                                         (2, 'Bloc B', 1);

-- Chambres
INSERT INTO chambre (id_chambre, numero_chambre, bloc_id_bloc) VALUES
                                                                   (1, 101, 1),
                                                                   (2, 102, 1),
                                                                   (3, 201, 2);

-- Étudiants
INSERT INTO etudiant (id_etudiant, nom_etudiant) VALUES
                                                     (1, 'Ahmed'),
                                                     (2, 'Sonia');

-- Réservations
INSERT INTO reservation (id_reservation, etudiant_id_etudiant, chambre_id_chambre) VALUES
                                                                                       (1, 1, 1),
                                                                                       (2, 2, 2);
