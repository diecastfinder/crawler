# Crawler

## How to run in IDE:
1. Run service with default configuration - "Completed initialization in X ms" - should be in console.
2. In http client call POST http://localhost:8083/api/v1/crawler/find with body  
   <code>{\
   "name": "Mercedes SL",\
   "minPrice": 500,\
   "maxPrice": 2000,\
   "currency": "PLN"\
   }</code>

3. See results in response, if nothing returned, check such request has results in downstream service \
   https://allegrolokalnie.pl/oferty/kolekcje-i-sztuka/q/


## Configuration
port - application.properties

## Mocks
### Mocky 
https://run.mocky.io/v3/ec3ab6e4-b36e-4864-86d5-0b07543ca775
delete mock - https://designer.mocky.io/manage/delete/ec3ab6e4-b36e-4864-86d5-0b07543ca775/<token>
token in keepass

### wireMock
https://wanted.wiremockapi.cloud/crawler/find - to call
https://app.wiremock.cloud/mock-apis/1z0k5/stubs/706ce144-a0e0-43e2-b090-5969f813ae42 - to manage
