# ZLI m223 Auth Beispiel mit Thorntail

## Setup

### OpenJDK 11.0.2a
 1. Die älteren Versionen können unter https://jdk.java.net/archive/gefunden werden.
 1. Es ist sicherzustellen, dass die Umgebungsvariabeln (java_path, u. A.) passend festgelegt wurden.
 1. Mit `java -version` kann der Erfolg der Installation überprüft werden.
 
### Maven 3.6.3 
 1. Installation von Maven 3.6.3
 1. Die Installationsdateien können unter https://maven.apache.org/download.cgi gefunden werden.
 1. Mit `mvn --version` kann überprüft werden, ob die richtige Version installiert ist.
 
### Docker 19.03.5-ce
 1. Unter Windows ist der Einsatz vonhttps://docs.docker.com/docker-for-windows/install/ zu empfehlen.
 1. Mit `docker --version` kann überprüft werden, ob die richtige Version installiert ist.

### Installation von Docker Compose 1.25.0
 1.  Unter Windows ist Docker Compose im Docker Client beinhaltet, ansonsten installieren.

## Ressourcen
Diese Links haben geholfen beim Erstellen:
- https://github.com/eclipse/microprofile-jwt-auth/tree/master/spec/src/main/asciidoc
- https://stackoverflow.com/questions/44474516/how-to-create-public-and-private-key-with-openssl
- https://docs.thorntail.io/2.5.0.Final/#_microprofile_jwt_rbac_auth
- https://stackoverflow.com/questions/11410770/load-rsa-public-key-from-file

