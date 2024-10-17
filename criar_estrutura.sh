#!/bin/bash

# Definindo o diretório base
BASE_DIR="L:/VSCode/JAVA/DIO/Controle_Ponto_Acesso"

# Criando diretórios principais
mkdir -p "$BASE_DIR/src/main/java/com/dio/live/controller"
mkdir -p "$BASE_DIR/src/main/java/com/dio/live/model"
mkdir -p "$BASE_DIR/src/main/java/com/dio/live/repository"
mkdir -p "$BASE_DIR/src/main/java/com/dio/live/service"
mkdir -p "$BASE_DIR/src/main/java/com/dio/live/swagger"
mkdir -p "$BASE_DIR/src/main/resources"
mkdir -p "$BASE_DIR/src/test/java/com/dio/live"
mkdir -p "$BASE_DIR/gradle/wrapper"

# Criando arquivos de exemplo
touch "$BASE_DIR/src/main/java/com/dio/live/controller/JornadaTrabalhoController.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/BancoHoras.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/Calendario.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/CategoriaUsuario.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/Empresa.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/JornadaTrabalho.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/Localidade.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/Movimentacao.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/NivelAcesso.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/Ocorrencia.java"
touch "$BASE_DIR/src/main/java/com/dio/live/model/TipoData.java"
touch "$BASE_DIR/src/main/java/com/dio/live/repository/JornadaRepository.java"
touch "$BASE_DIR/src/main/java/com/dio/live/service/JornadaService.java"
touch "$BASE_DIR/src/main/java/com/dio/live/swagger/SwaggerConfig.java"
touch "$BASE_DIR/src/main/java/com/dio/live/LiveApplication.java"
touch "$BASE_DIR/src/main/resources/application.properties"
touch "$BASE_DIR/src/main/resources/schema.sql"
touch "$BASE_DIR/src/test/java/com/dio/live/JornadaTrabalhoControllerTest.java"
touch "$BASE_DIR/src/test/java/com/dio/live/JornadaServiceTest.java"
touch "$BASE_DIR/src/test/java/com/dio/live/ModelTests.java"
touch "$BASE_DIR/gradle/wrapper/gradle-wrapper.jar"
touch "$BASE_DIR/gradle/wrapper/gradle-wrapper.properties"
touch "$BASE_DIR/build.gradle"
touch "$BASE_DIR/README.md"
touch "$BASE_DIR/settings.gradle"

# Mensagem final
echo "Estrutura de pastas e arquivos criada com sucesso em $BASE_DIR"
