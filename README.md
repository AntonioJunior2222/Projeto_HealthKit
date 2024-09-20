# Monitoramento de Pacientes com Esclerose Múltipla

Este repositório contém dois projetos desenvolvidos como parte do estudo e monitoramento de pacientes com Esclerose Múltipla (EM), utilizando sensores de movimento (acelerômetro e giroscópio) de dispositivos Android. O objetivo é explorar o uso de tecnologias móveis no acompanhamento da saúde de pacientes com EM, visando detectar mudanças de equilíbrio e prevenir quedas.

## Projetos

### 1. Visualizador de Dados de Sensores (Acelerômetro e Giroscópio)

Este projeto didático tem como objetivo apresentar visualmente os dados brutos coletados pelos sensores de acelerômetro e giroscópio do dispositivo Android. Ele foi desenvolvido para auxiliar na compreensão do comportamento dos sensores e como os dados variam de acordo com os movimentos do usuário.

#### Funcionalidades:
- Exibição em tempo real dos dados do acelerômetro e giroscópio.
- Interface simples para fins educacionais.
  
#### Como utilizar:
1. Clone este repositório.
2. Abra o projeto no Android Studio.
3. Conecte seu dispositivo Android e execute o aplicativo.

### 2. Coletor e Monitor de Dados de Movimento

Este projeto tem como objetivo coletar os dados dos sensores do dispositivo e exibi-los em um gráfico de pontos. O sistema de monitoramento é capaz de calcular variações no equilíbrio do usuário e, futuramente, poderá emitir alertas em caso de instabilidade, ajudando na prevenção de quedas.

#### Funcionalidades:
- Coleta contínua dos dados de acelerômetro e giroscópio.
- Plotagem dos dados em gráficos de pontos.
- Sistema para monitorar variações de equilíbrio (em desenvolvimento).

#### Como utilizar:
1. Clone este repositório.
2. Abra o projeto no Android Studio.
3. Conecte seu dispositivo Android e execute o aplicativo.
4. O aplicativo começará a coletar os dados e exibi-los em um gráfico.

## Tecnologias Utilizadas

- **Android Studio**: Ambiente de desenvolvimento integrado (IDE) utilizado para desenvolver ambos os projetos.
- **Kotlin**: Linguagem de programação usada para escrever o código.
- **APIs de Sensores Android**: Para acessar os dados do acelerômetro e giroscópio do dispositivo.
- **Bibliotecas de Gráficos**: Para a visualização dos dados em gráficos de pontos (no segundo projeto).

## Instalação

1. Certifique-se de ter o [Android Studio](https://developer.android.com/studio) instalado.
2. Clone este repositório:
    ```
    git clone https://github.com/seuusuario/nome-do-repositorio.git
    ```
3. Abra o projeto no Android Studio.
4. Conecte seu dispositivo Android ou configure um emulador.
5. Compile e execute o projeto.
