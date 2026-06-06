
# ReceiverDemo - BroadcastReceiver Lab

## Description
Application Android démontrant l'utilisation des BroadcastReceivers (statiques et dynamiques) avec les palettes de couleurs personnalisées.

## Fonctionnalités
- Détection dynamique du mode avion (AirplaneMode)
- Détection statique du démarrage système (BOOT_COMPLETED)
- Envoi et réception de broadcasts personnalisés
- Interface utilisateur avec palette Monochromatique

## Palette de Couleurs Utilisée
- Rouge Sang : #5C1010
- Marron Foncé : #6F0000
- Rouge Brique : #940000
- Crimson Éclatant : #C30101
- Beige Chaud : #EEDC82
- Or : #D4AF37

## Structure du Projet
```
app/src/main/java/com/example/receiverdemo/
├── MainActivity.java          # Activité principale
├── FlightModeHandler.java     # Receiver dynamique (mode avion)
├── StartupHandler.java        # Receiver statique (démarrage)
└── MessageHandler.java        # Receiver pour broadcast custom
```

## Composants
- **FlightModeHandler** : Écoute les changements du mode avion (receiver dynamique)
- **StartupHandler** : Réagit au démarrage du téléphone (receiver statique, manifest)
- **MessageHandler** : Reçoit les broadcasts personnalisés de l'application

## Prérequis
- Android Studio Hedgehog | 2023.1.1 ou supérieur
- Minimum SDK : API 24 (Android 7.0)
- Target SDK : API 34 (Android 14)
- Gradle 8.0+

## Installation
1. Clonez ou téléchargez le projet
2. Ouvrez avec Android Studio
3. Synchronisez les dépendances Gradle
4. Lancez l'application sur émulateur ou appareil physique
