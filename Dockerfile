FROM java:8
EXPOSE 8080
ADD /target/Instructionator-InstructionsMS-0.0.1-SNAPSHOT.jar Instructionator-InstructionsMS-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Instructionator-InstructionsMS-0.0.1-SNAPSHOT.jar"]
