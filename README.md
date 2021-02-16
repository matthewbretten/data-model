# example-json-data-model

This project is an example of how to create a framework for defining and building json objects as Java pojos and then 
packaging this so it can be used by other projects, particularly focusing on generating large amounts of random test 
data. It includes the ability to convert the java pojo back to json so it can be easily incorporated into defining data
for HTTP requests (such as driving the data used by a load testing tool such as Gatling).