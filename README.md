# ZLI m223 Auth Beispiel mit Thorntail

## Setup

### OpenJDK 11.0.2a
 1. Installation von OpenJDK 11.0.2a  
    - Unter Windows die übliche Installationsroutine ausführen. Die älteren Versionen können unter https://jdk.java.net/archive/ gefunden werden.
    - Unter Ubuntu kann diese Version mit `apt install openjdk-11-jdk` installiert werden.
 1. Es ist sicherzustellen, dass die Umgebungsvariabeln (java_path, u. A.) passend festgelegt wurden.
 1. Mit `java -version` kann der Erfolg der Installation überprüft werden.
 
### Maven 3.6.3 oder neuer
 1. Installation von Maven 3.6.3
    - Unter Windows die Hinweise auf https://maven.apache.org/install.html befolgen.
    - Unter Ubuntu kann diese Version mit `apt install maven` installiert werden.
 1. Die Installationsdateien können unter https://maven.apache.org/download.cgi gefunden werden.
 1. Mit `mvn --version` kann überprüft werden, ob die richtige Version installiert ist.
 
### Docker 19.03.5-ce oder neuer
 1. Installation von Docker
    - Unter Windows ist der Einsatz von https://docs.docker.com/docker-for-windows/install/ zu empfehlen.
    - Unter Ubuntu die Anweisungen von https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository befolgen.
 1. Mit `docker --version` kann überprüft werden, ob die richtige Version installiert ist.

### Installation von Docker Compose 1.25.0 oder neuer
 1. Installation von Docker Compose
    - Unter Windows ist Docker Compose im Docker Client beinhaltet, ansonsten installieren.
    - Unter Ubuntu die Anweisungen von https://docs.docker.com/compose/install/#install-compose befolgen.
 1. Mit `docker-compose --version` kann überprüft werden, ob die richtige Version installiert ist.

### Starten der PostgreSQL-Datenbank
 1. Das Verzeichnis des Repositories in einer Eingabeaufforderungöffnen.
 1. Docker Compose mit `docker-compose up -d` ausführen.

### Starten des Backends
 1. Es ist sicherzustellen, dass der Port `8080` nicht beleget ist.
 1. Im Verzeichnis des Backends das Buildscript mit Maven ausführen: `mvn thorntail:run`
 1. `http://localhost:8080/` sollte der Server nach dem Start verfügbar sein.
 1. Die Endpoints sind in den Kontrollern beschrieben. Mit einem HTTP Client (Postman, Postwoman, Insomnia, ..) können Sie Abfragen generieren.

## Ressourcen
Diese Links haben geholfen beim Erstellen:
- https://github.com/eclipse/microprofile-jwt-auth/tree/master/spec/src/main/asciidoc
- https://stackoverflow.com/questions/44474516/how-to-create-public-and-private-key-with-openssl
- https://docs.thorntail.io/2.5.0.Final/#_microprofile_jwt_rbac_auth
- https://stackoverflow.com/questions/11410770/load-rsa-public-key-from-file

