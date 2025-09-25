# Application de Transfert d'Argent

## Vue d'ensemble
Application Spring Boot de transfert d'argent utilisant Java 17, MySQL et l'architecture REST API. L'application permet la gestion d'utilisateurs, de comptes bancaires et de transactions.

## Architecture Technique

### Technologies utilisées
- **Framework**: Spring Boot 3.5.4
- **Langage**: Java 17
- **Base de données**: MySQL 8
- **ORM**: Spring Data JPA/Hibernate
- **Sécurité**: Spring Security (désactivée pour développement)
- **Build**: Maven
- **Outils**: Lombok, DevTools

### Structure du projet
```
src/main/java/com/transfert/transfert_argent/
├── DTO/                    # Objets de transfert de données
├── controller/             # Contrôleurs REST
├── model/                  # Entités JPA
├── repository/             # Repositories Spring Data
├── service/                # Services métier
├── security/               # Configuration sécurité
├── config/                 # Configuration
└── exception/              # Exceptions personnalisées
```

## Modèle de Données

### Entités principales
1. **Utilisateur** (`model/Utilisateur.java`)
   - `id` (Long, auto-généré)
   - `nom` (String)
   - `email` (String)

2. **Compte** (`model/Compte.java`)
   - `id` (Long, auto-généré)
   - `numero` (String)
   - `solde` (BigDecimal)
   - `owner` (ManyToOne → Utilisateur)

3. **Transaction** (`model/Transaction.java`)
   - `id` (Long, auto-généré)
   - `montant` (Double)
   - `motif` (String)
   - `dateTransaction` (LocalDateTime)
   - `expediteur` (ManyToOne → Utilisateur)
   - `destinataire` (ManyToOne → Utilisateur)

## Endpoints API

### UtilisateurController (`/api/utilisateurs`)
- `POST /api/utilisateurs` - Créer un utilisateur
- `GET /api/utilisateurs` - Lister tous les utilisateurs
- `GET /api/utilisateurs/{id}` - Obtenir utilisateur par ID
- `DELETE /api/utilisateurs/{id}` - Supprimer un utilisateur
- `GET /api/utilisateurs/login` - Connexion (GET)
- `POST /api/utilisateurs/login` - Connexion (POST)

### CompteController (`/api/comptes`)
- `POST /api/comptes` - Créer un compte
- `GET /api/comptes` - Lister tous les comptes

### TransactionController (`/api/transactions`)
- `POST /api/transactions` - Enregistrer une transaction
- `GET /api/transactions` - Lister toutes les transactions
- `GET /api/transactions/{id}` - Obtenir transaction par ID
- `DELETE /api/transactions/{id}` - Supprimer une transaction

## Configuration

### Base de données
```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/transfert_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

### CORS
- CompteController autorise `http://localhost:3000` pour frontend React

## Installation et Démarrage

### Prérequis
- Java 17
- MySQL 8
- Maven

### Étapes d'installation
1. Cloner le projet
2. Créer la base de données MySQL `transfert_db`
3. Configurer les paramètres de connexion dans `application.properties`
4. Exécuter `mvn spring-boot:run`

L'application sera disponible sur `http://localhost:8080`

## Problèmes de Sécurité Identifiés

⚠️ **Attention**: Cette application est en développement et présente des problèmes de sécurité

1. **Sécurité désactivée**
   - Toutes les requêtes sont autorisées sans authentification
   - Protection CSRF désactivée

2. **Authentification faible**
   - Comparaison de mots de passe en texte brut
   - Pas de chiffrement/hachage des mots de passe

3. **Endpoints de connexion multiples**
   - Deux endpoints de login différents (GET et POST)
   - Logique d'authentification incohérente

## Améliorations Recommandées

### Sécurité (Priorité élevée)
- [ ] Implémenter l'authentification JWT
- [ ] Chiffrer les mots de passe (BCrypt)
- [ ] Activer la sécurité Spring Security
- [ ] Ajouter la validation des entrées

### Modèle de données
- [ ] Ajouter le champ `motDePasse` dans l'entité Utilisateur
- [ ] Utiliser BigDecimal pour les montants de Transaction
- [ ] Ajouter des validations (@Valid, @NotNull)

### Architecture
- [ ] Implémenter les services métier manquants
- [ ] Ajouter la gestion d'erreurs globale
- [ ] Implémenter les DTOs pour les réponses
- [ ] Ajouter des tests unitaires

### Configuration
- [ ] Sécuriser la configuration de base de données
- [ ] Configurer des profils d'environnement (dev, prod)
- [ ] Ajouter la documentation API (Swagger)

## Tests

Pour exécuter les tests:
```bash
mvn test
```

## Licence

Ce projet est à des fins éducatives uniquement.