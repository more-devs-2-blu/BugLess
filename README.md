# BugLess

Sistema para mapeamento de casos de dengue na região.

## Índice 

* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Requisitos](#requisitos)
* [Orientações técnicas](#orientações-técnicas)
* [Status do Projeto](#status)
* [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras)
* [Conclusão](#conclusão)

## Status

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

## Motivação

  Mapear os casos de dengue na região, como solução para o Hackathon do programa [+Devs2Blu](https://www.devs2blu.com.br/) realizado pela [Proway](https://www.proway.com.br) e apoiado pelas empresas:. <br> 
  
  * [DBR](https://www.dbrsa.com.br/)
  * [Govbr](https://www.govbr.com.br/)
  * [Mindera](https://mindera.com/)
  * [Philips](https://www.philips.com.br/)
  
## Descrição do projeto

  <p>Aplicação web para cadastros de casos positivos de dengue nos postos de saúde e ambulatórios gerais.
  Os cadastros serão efetuados por funcionários agentes de saúde previamente autenticados no sistema.
  O cadastro irá conter nome, sexo, idade e endereço do paciente, bem como a data do teste.
  A partir do endereço, vamos obter a localização geográfica para sinalizar os casos acumulados no mapa.</p>
  
  <a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/RV3NdMN5/Video-220524115921.gif' border='0' alt='Video-220524115921'/></a>
  
## Requisitos

Funcionais:

* Cadastro de caso com paciente
* Mostrar o número de casos por bairro.
* Integração com Google Maps API.
* Mostrar o mapa da cidade sinalizando os bairros com maior incidência.

Não funcionais: 

* Autenticação por login
* Validação via BeanValidator @CPF
* Consulta de API viacep.com.br/ws
  
## Orientações Técnicas

No arquivo 'BugLess\front-BugLess\node_modules\@agm\core\lib\services\google-maps-api-wrapper.d.ts' é necessário comentar ou excluir a linha com o conteúdo:<br> 'subscribeToMapEvent<N extends keyof google.maps.MapHandlerMap>(eventName: N): Observable<google.maps.MapHandlerMap[N]>;'

No arquivo <b>'BugLess\front-BugLess\node_modules\@agm\core\lib\services\managers\marker-manager.d.ts'</b> é necessário comentar ou excluir a linha com o conteúdo:<br>
  'createEventObservable<T extends (google.maps.MouseEvent | void)>(eventName: google.maps.MarkerMouseEventNames | google.maps.MarkerChangeOptionEventNames, marker: AgmMarker): Observable<T>;'
  
## Funcionalidades e Demonstração da Aplicação

> :construction: Projeto em construção :construction:

## Pessoas Desenvolvedoras

* Alessandro de Borba Ferreira  ([GitHub](https://github.com/alessandrobferreira) | [Linkedin](https://www.linkedin.com/in/alessandro-ferreira-a9199a115/))
* André Felipe Schwanz ([GitHub](https://github.com/Andre121193) | [Linkedin](https://www.linkedin.com/in/andr%C3%A9-schwanz-241a51216/))
* Douglas Lima da Luz ([GitHub](https://github.com/douglaslimaluz) | [Linkedin](https://www.linkedin.com/in/douglas-lima-da-luz-82895a19b/))
* José Augusto Klaumann ([GitHub](https://github.com/JoseKlaumann) | [Linkedin](https://www.linkedin.com/in/jos%C3%A9-augusto-klaumann-5258b6178/))
* Juliano Henrique Santos Vieira ([GitHub](https://github.com/jucabnu) | [Linkedin](https://www.linkedin.com/in/juliano-h-vieira/))
* Luan Lordello Guimarães Lima ([GitHub](https://github.com/LordeLuan) | [Linkedin](https://www.linkedin.com/in/luan-lordello-69aa58196/))

## Tecnologias Utilizadas

<div style="display: inline_block"> 
  <img align="center" alt="Java" height="40" width="30" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">   
  <img align="center" alt="logo spring" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />
  .
  <img align="center" alt="logo Angular" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/angularjs/angularjs-original.svg" />
  <img align="center" alt="typescript" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/typescript/typescript-original.svg" />  
  <img align="center" alt="Html5" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg">
  <img align="center" alt="Css3" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg">    
  <img align="center" alt="logo bootstrap" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-plain.svg" />
  <img align="center" alt="javascript" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" />
  .  
  <img align="center" alt="Mysql" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-plain.svg">       
  <img align="center" alt="Git" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg">       
 </div> 
 
## Conclusão

> :construction: Projeto em construção :construction:
