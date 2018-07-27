package com.framework.network.exception;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.HttpException;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class ExceptionHandle {
    ////////////////////////////////////////////////////////////////////////////////////////
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    ////////////////////////////////////////////////////////////////////////////////////////
    class ERROR {
        public static final int UNKNOWN = 1000;
        public static final int PARSE_ERROR = 1001;
        public static final int NETWORD_ERROR = 1002;
        public static final int HTTP_ERROR = 1003;
        public static final int SSL_ERROR = 1005;
    }
    ////////////////////////////////////////////////////////////////////////////////////////

    public static ResponeException handleException(Throwable e) {
        ResponeException responeException;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            responeException = new ResponeException(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    responeException.message = "网络错误";
                    break;
            }
            return responeException;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            responeException = new ResponeException(resultException, resultException.code);
            responeException.message = resultException.message;
            return responeException;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException) {
            responeException = new ResponeException(e, ERROR.PARSE_ERROR);
            responeException.message = "解析错误";
            return responeException;
        } else if (e instanceof ConnectException) {
            responeException = new ResponeException(e, ERROR.NETWORD_ERROR);
            responeException.message = "连接失败";
            return responeException;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            responeException = new ResponeException(e, ERROR.SSL_ERROR);
            responeException.message = "证书验证失败";
            return responeException;
        } else {
            responeException = new ResponeException(e, ERROR.UNKNOWN);
            responeException.message = "未知错误";
            return responeException;
        }
    }
}
