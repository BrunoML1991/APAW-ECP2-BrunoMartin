package api;

import http.*;

import static org.junit.jupiter.api.Assertions.*;

public abstract class RequestIT {

    protected HttpRequest createPostRequest(String path, Object body) {
        return HttpRequest.builder().path(path).body(body).post();
    }

    protected void checkBAD_REQUEST(HttpRequest request) {
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    protected void checkNOT_FOUND(HttpRequest request) {
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    protected void checkOK(HttpRequest request) {
        final HttpResponse[] response = new HttpResponse[1];
        assertDoesNotThrow(() -> response[0] = new Client().submit(request));
        assertEquals(HttpStatus.OK, response[0].getStatus());
    }

}
