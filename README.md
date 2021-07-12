#
# Projeto para WK Techs

##  Sobre

>Projeto para criar um sistema web envolvendo um banco de dados, uma aplicação back-end e uma front-end com a finalidade de processar uma massa de dados fornecida e gerar dashboards com as informações obtidas nos dados

>Informações que precisam ser extraídas : 
>- Quantos candidatos temos nessa lista em cada estado do Brasil? 
>- IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / 
altura^2) 
>- Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30) 
>- Qual a média de idade para cada tipo sanguíneo? 
>- A quantidade de possíveis doadores para cada tipo sanguíneo receptor.
    
>Tecnologias Principais :
>- MySQL
>- Spring Boot, Spring Data, Swagger
>- Angular 12
    

    
#
## Como rodar
<br> 

>## 1. MySQL : 
>- Disponibilize o serviço na máquina local ou serviço cloud
>- Apenas crie uma database pois todas as tabelas serão criadas pelo SpringBoot
>- Importante ter :
>   - __Url__ : localhost:3306 por exemplo
>   - __Database__ : criada no passo anterior
>   - __User__ : usuário de acesso
>   -  __Password__ : senha do usuário
>- pois serão usadas como argumentos para __Spring__

>## 2. Spring : 
>- Clone o serviço BK e na pasta raiz utilize o seguinte código:
>      - ```mvn clean install package -DskipTests```
>- Antes de subir a aplicação, certifique-se de ter as seguintes variáveis de ambiente
>      - ```database.name```
>      - ```database.user```
>      - ```database.password```
>      - ```database.url```
>- Rode o seguinte comando:
>   - ```mvn spring-boot:run ```

> ### Observações :
>- Se não tiver o Maven instalado, utilize o __mvnw__ no lugar do __mvn__
>- As variáveis podem ser alteradas diretamente no código, em __application-deploy.properties__

> ### Swagger :
> Caso queira ver a documentação swagger, pode encontra-la em __resourses/blood_bank_api.yaml__ ou clicando nesta [documentação online](https://app.swaggerhub.com/apis-docs/andre_faustino/blood_bank_service/1.0.0)

>### 3 Angular : 
>-  Clone o serviço FR e na pasta __/bloodbank__ utilize o comando :
>      - ``ng serve``
>- Atenção:
>   - Certifque-se de ter o __npm__ e __angular__ instalados
>   - Por padrão, a aplicação irá buscar o serviço Spring em __http://localhost:8080__. Caso esteja em outro endereço, por favor altere em __environment.ts__ a propriedade __baseUrl__ para o endereço correto

#
## Como usar
<br>

> Por hora, a página web apenas aceita arquivos JSON para alimentar o sistema

> Uma vez inseridos os dados, utilize a aba Dashboard para visualizar as informações

> Formato exemplo de arquivo JSON:
```json
[
	{
		"nome": "Milena Analu Pires",
		"cpf": "775.256.099-50",
		"rg": "44.084.541-5",
		"data_nasc": "23\/05\/1964",
		"sexo": "Feminino",
		"mae": "Isadora Marli",
		"pai": "Noah Severino César Pires",
		"email": "mmilenaanalupires@keffin.com.br",
		"cep": "39801-678",
		"endereco": "Rua Kurt W. Rothe",
		"numero": 675,
		"bairro": "Castro Pires",
		"cidade": "Teófilo Otoni",
		"estado": "MG",
		"telefone_fixo": "(33) 3611-4613",
		"celular": "(33) 98481-0191",
		"altura": 1.53,
		"peso": 80,
		"tipo_sanguineo": "O-"
	}, ...
]
```