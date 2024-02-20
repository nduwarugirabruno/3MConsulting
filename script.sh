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
cd ./3MC-User || exit
mvn clean install
mvn spring-boot:run &

# Attente pour laisser le Module User démarrer
sleep 20

# Notification Module
echo "Exécution du module des Notifications"
cd ./3MC-Notification || exit
mvn clean install
mvn spring-boot:run &