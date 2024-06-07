
# Use uma imagem base com Java instalado
FROM openjdk:17-jdk-slim

# Crie um diretório para a aplicação
WORKDIR /app

# Copie todos os arquivos do diretório quarkus-app para o diretório /app dentro do container
COPY target/ /app/

# Especificar o comando para rodar o JAR
CMD ["java", "-jar", "/app/quarkus-app/quarkus-run.jar"]