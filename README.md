# 🌿 Système Intelligent de Gestion d'Irrigation

Ce projet est une solution complète basée sur une architecture microservices pour la surveillance et la gestion automatisée de l'irrigation agricole via des capteurs IoT.

## 📝 Description
Le système permet de collecter des données environnementales en temps réel (humidité, température, etc.) et de piloter l'irrigation de manière intelligente et optimisée. Grâce à une architecture distribuée, le système garantit une haute disponibilité et une scalabilité horizontale.

### ✨ Fonctionnalités Clés
- **Collecte de données IoT** : Réception asynchrone et traitement des mesures via **Apache Kafka**.
- **Gestion Microservices** : Découverte dynamique via **Eureka** et configuration centralisée avec **Spring Cloud Config**.
- **Dashboard Interactif** : Interface utilisateur moderne développée en **Angular** pour le monitoring en temps réel.
- **Communication Hybride** : Utilisation de REST pour les échanges synchrones et Kafka pour les flux de données asynchrones.

## 🛠 Technologies Utilisées

### 🚀 Backend (Architecture Microservices)
- **Java 17** & **Spring Boot 3.5.9
- **Spring Cloud** (Eureka, Config Server, Gateway)
- **Spring Data JPA** (MySQL)
- **Apache Kafka** (Message Broker)

### 🎨 Frontend
- **Angular 17+**
- **Nginx** (Serveur de production optimisé)

### 🏗 Infrastructure & DevOps
- **MySQL 8** (Base de données relationnelle)
- **Docker & Docker Compose** (Conteneurisation Multi-stage)
- **Kubernetes (K8s)** (Templates de déploiement Cloud-Native)

## 📂 Structure du Repository
La propreté du dépôt est organisée comme suit :
- 📁 **Backend** : Services Spring Boot.
- 📁 **frontend_irrigation** : Application Angular.
- 📁 **deployment** : Configuration Docker et Kubernetes.
  - 📁 **docker/** : TOUS les Dockerfiles du projet (MsEureka, Gateway, etc.).
  - 📁 **kubernetes/** : Manifests YAML (Deployments, Services, ConfigMaps).
  - 📄 `docker-compose.yml` : Orchestration complète.

## 🚀 Installation et Exécution

### 🏗 Exécution via Docker (Recommandé)
Le projet utilise des builds multi-stages pour compiler les services sans nécessiter d'outils locaux (Java/Node.js).

1. Accédez au dossier de déploiement :
   ```bash
   cd deployment
   ```
2. Build et lancement des conteneurs :
   ```bash
   docker-compose up --build
   ```
3. **Points d'accès :**
   - **Frontend App** : [http://localhost](http://localhost)
   - **Eureka Dashboard** : [http://localhost:4040](http://localhost:4040)
   - **Gateway API** : [http://localhost:5000](http://localhost:5000)

### ☸️ Déploiement Kubernetes
Les fichiers se trouvent dans `deployment/kubernetes/`.

```bash
kubectl apply -f deployment/kubernetes/namespace.yml
kubectl apply -f deployment/kubernetes/infrastructure/
kubectl apply -f deployment/kubernetes/microservices/
kubectl apply -f deployment/kubernetes/frontend/
```

---
*Projet développé dans le cadre d'une gestion intelligente de l'irrigation.*
