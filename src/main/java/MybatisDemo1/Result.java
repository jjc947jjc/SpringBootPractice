package MybatisDemo1;

public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result(){}

    public static Result success (Object data){
        Result r = new Result();
        r.code=1;
        r.message="成功！！！";
        r.data=data;
        return r;
    }
    public static Result error(String mismessage){
        Result r = new Result();
        r.code=0;
        r.message=mismessage;
        return r;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
