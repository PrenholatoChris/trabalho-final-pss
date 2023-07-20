# trabalho-final-pss

Para utilizar o sistema é necessário ter o maven instalado.


Na pasta raiz do projeto execute ambos os comandos para adicionar as bibliotecas locais no repositório maven.

mvn install:install-file -Dfile=./SistemaLogger/target/SistemaLogger-1.0.jar -DgroupId=com -DartifactId=SistemaLogger -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=./validadorsenha-master/target/ValidadorSenha-1.08-SNAPSHOT.jar -DgroupId=com.pss -DartifactId=ValidadorSenha -Dversion=1.08 -Dpackaging=jar

