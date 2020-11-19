package cn.swu.pigeon.utils;


import lombok.Data;

@Data
public class Result<T> {
    private String msg;
    private int status;
    private T data;

    public static Result success(Object obj) {
        Result result = new Result();
        result.setMsg(Contants.SUCCESS_MSG);
        result.setStatus(Contants.SUCCESS_STATUS_200);
        result.setData(obj);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setMsg(Contants.ERROR_MSG);
        result.setStatus(Contants.ERROR_STATUS_404);
        return result;
    }
}


