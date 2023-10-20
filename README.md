# Micro Benchmark using Project Loom

## About The Project

This project contains 2 projects using Spring Boot, to compare the performance between them.

The goal of this project is to see some differences between Java 17 and Java 21 with Virtual Threads.

* Demo
* Demo Loom

## Built With

* Java 17 and Java 21
* Spring Boot
* Grafana
* InfluxDb
* K6


## Getting Started

To run this project you should have the [Prerequisites](#Prerequisites)

### Prerequisites

* Java 17
* Java 21
* Docker

### Installation

1. Go to [docker folder](docker) and run the command:

`docker-compose up`

This command will start the Grafana and the InfluxDB.

2. Start the application you want to measure.\
For example: go to [demo folder](demo) and run this command:

`./mvnw spring-boot:run`

3. Run K6 to generate the data

If you are using [demo-loom project](demo-loom) use this command

`docker-compose run k6 run /scripts/http-get-loom.js`

If you are using [demo project](demo) use this command

`docker-compose run k6 run /scripts/http-get.js`

4. See the results in Grafana.

To see the results in Grafana you can follow this article: https://medium.com/@nairgirish100/k6-with-docker-compose-influxdb-grafana-344ded339540

I do recommend to use this dashboard, which contains more information: https://grafana.com/grafana/dashboards/10660-k6-load-testing-results/

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/AmazingFeature)
3. Commit your Changes (git commit -m 'Add some AmazingFeature')
4. Push to the Branch (git push origin feature/AmazingFeature)
5. Open a Pull Request

## License

Distributed under the MIT License. See LICENSE.txt for more information.

## References

* https://grafana.com/grafana/dashboards/10660-k6-load-testing-results/
* https://k6.io/docs/using-k6/k6-options/how-to/
* https://medium.com/@nairgirish100/k6-with-docker-compose-influxdb-grafana-344ded339540