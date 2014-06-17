package air.model;

public class RestResponse {
    private String message;

    public RestResponse() {
    }

    public RestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
