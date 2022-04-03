FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /home/app

COPY src src
COPY pom.xml pom.xml
RUN mvn -f /home/app/pom.xml clean package -q

FROM openjdk:11.0-jre-slim-buster

LABEL "edu.poniperro.ExamenGalleyGrubDockerizado"="Examen Galley Grub Dockerizado"
LABEL version=1.0-SNAPSHOT
LABEL mantainer="jouardiouardi@cifpfbmoll.eu"


WORKDIR $HOME/app

COPY --from=build /usr/src/app/target/*.jar ./ExamenGalleyGrubDockerizado.jar
CMD ["java","-jar","/usr/local/lib/ExamenGalleyGrubDockerizado.jar"]

# Para dockerizar
ENTRYPOINT ["java", "-jar", "ExamenGalleyGrubDockerizado.jar"]