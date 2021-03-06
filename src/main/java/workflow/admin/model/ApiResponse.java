package workflow.admin.model;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private int code;
    private String message;
    private Object data;

    public ApiResponse(HttpStatus code, String message, Object data) {

        this.code = code.value();
        this.message = message;
        this.data = data;
    }
    
    public ApiResponse(HttpStatus code, String message) {

        this.code = code.value();
        this.message = message;
    }
    
    public ApiResponse(Object data) {

        this.code = HttpStatus.OK.value();
        this.data = data;
    }
    
    public ApiResponse() {
        this.code = HttpStatus.OK.value();
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

}