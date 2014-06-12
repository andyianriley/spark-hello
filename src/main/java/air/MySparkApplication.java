package air;

import spark.servlet.SparkApplication;

import static spark.Spark.get;

public class MySparkApplication implements SparkApplication {
    @Override
    public void init() {
        get("/hello",(request, response) -> {
            return "Hello World!";
        });
    }
}
