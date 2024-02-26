#!/bin/bash

# Eureka Server
echo "Exécution du Serveur Eureka"
cd ./EurekaServer/ || exit
mvn clean install
mvn spring-boot:run &

# Attente pour laisser le serveur démarrer
sleep 20

# User Module
echo "Exécution du module des User"
cd ../3MC-User || exit
mvn clean install
mvn spring-boot:run &

# Attente pour laisser le Module User démarrer
sleep 20

# Notification Module
echo "Exécution du module des Notifications"
cd ../3MC-Notification || exit
mvn clean install
mvn spring-boot:run &

# Attente pour laisser le Module Notifications démarrer
sleep 20

# Offre Module
echo "Exécution du module des Transaction"
cd ../3MC-Transaction || exit
mvn clean install
mvn spring-boot:run &

# Attente pour laisser le Module Transaction démarrer
sleep 20

# Offre Module
echo "Exécution du module des Offre"
cd ../3MC-Offre || exit
mvn clean install
mvn spring-boot:run &

# Attente pour laisser le Module Offre démarrer
sleep 20

# Offre Module
echo "Exécution du module de Chat"
cd ../3MC-Chat || exit
mvn clean install
mvn spring-boot:run &