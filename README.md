# Variant Viewer

This is a simple app that searches for genes and produces a table of its gene variants.
Features include: gene search, type-ahead search, and tabular data table view.

## Pre-requisites
1. Nodejs 
2. JDK 1.8

## Running in production mode
Install the dependencies
```
./install.sh 
```
Run the server locally at http://localhost:9000
```
./start_app.sh
```
Stop the server
```
./stop_app.sh
```

## Running in development mode
Database binding will be lazy (won't initiate until needed by a function); however, this is the fastest way to get going
```
./sbt run
```
And then go to http://localhost:4200 to see the running web application.
Backend server will be serving in http://localhost:9000.
Both stacks will be watching for changes.
This project's sbt includes a launcher/wrapper, but if you have SBT installed, you can run yours instead.

## REST Api Endpoints

#### Gene search
Search for gene names based on a given prefix
```
GET /api/v1/genes

Example usage: localhost:9000/api/v1/genes?prefix=BRCA
```
#### Variant Retrieval
Get gene variants based on a gene name
```
GET /api/v1/geneVariants

Example usage: localhost:9000/api/v1/geneVariants?geneName=BRCA1
```


## Tech stack
- Web Framework - PlayFramework: based on a lightweight, stateless, web-friendly architecture
- Backend - Java 8, Scala
- Database - PostgreSQL 10
- Frontend - Angular 6, Typescript, HTML, CSS

#### Notable 3rd Party Libraries/Plugins/Tools
- RxJs
- Guice (DI framework)
- Ebeans (ORM)
- Angular Material Component
- Bulma (CSS)
- Sbt (build tool)
- Angular CLI - Tool for init, dev, scaffold Angular apps

## Utility scripts
#### DDL file for setting up postgresql tables
```
./scripts/sql/create_table_gene_gene_variants.sql
```
#### Py3 - Take raw .tsv variant data and create a bulk insert SQL
Outputs two files, a gene_sql_data.sql file and variant_sql_data.sql file which should be ran
in respective order due to foreign key dependencies
```
./scripts/python/convert_raw_variants_to_sql.py -f variant_results.tsv
```

## Note
This project was generated using PlayFramework starter project (https://www.playframework.com/getting-started) and 
AngularCli with support from java-play-angular-seed which helped hook the front end (Angular instead of scala views) 
to the back end using proper hooks
https://github.com/yohangz/java-play-angular-seed

#### Files of interest for the hookings
- FrontendBuild.scala
- FrontendCommands.scala
- FrontendController.scala