package api;

import api.apiControllers.IconicCharacterApiController;
import api.apiControllers.ReviewApiController;
import api.apiControllers.VideogameApiController;
import api.dtos.IconicCharacterDto;
import api.dtos.ReviewDto;
import api.dtos.VideogameDto;
import api.entities.Category;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    ReviewApiController reviewApiController = new ReviewApiController();
    IconicCharacterApiController iconicCharacterApiController = new IconicCharacterApiController();
    VideogameApiController videogameApiController = new VideogameApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request, response);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
                    break;
                default:
                    this.requestInvalid(request);
            }
        } catch (ArgumentNotValidException | IllegalArgumentException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.isEqualsPath(ReviewApiController.REVIEWS)) {
            httpResponse.setBody(this.reviewApiController.create((ReviewDto) httpRequest.getBody()));
        } else if (httpRequest.isEqualsPath(IconicCharacterApiController.ICONIC_CHARACTER)) {
            httpResponse.setBody(this.iconicCharacterApiController.create((IconicCharacterDto) httpRequest.getBody()));
        } else if (httpRequest.isEqualsPath(VideogameApiController.VIDEOGAME)) {
            httpResponse.setBody(videogameApiController.create((VideogameDto) httpRequest.getBody()));
        } else {
            this.requestInvalid(httpRequest);
        }
    }

    private void doPut(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.isEqualsPath(ReviewApiController.REVIEWS + ReviewApiController.ID_ID)) {
            httpResponse.setBody(this.reviewApiController.update(httpRequest.getPath(1), (ReviewDto) httpRequest.getBody()));
        } else {
            this.requestInvalid(httpRequest);
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(VideogameApiController.VIDEOGAME + VideogameApiController.ID_ID)) {
            videogameApiController.delete(request.getPath(1));
        } else {
            this.requestInvalid(request);
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(VideogameApiController.VIDEOGAME)) {
            response.setBody(videogameApiController.readAll());
        } else if (request.isEqualsPath(ReviewApiController.REVIEWS + ReviewApiController.SEARCH)) {
            response.setBody(reviewApiController.find(request.getParams().get("q")));
        } else {
            this.requestInvalid(request);
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(VideogameApiController.VIDEOGAME + VideogameApiController.ID_ID + VideogameApiController.CATEGORY)) {
            videogameApiController.updateCategory(request.getPath(1), (Category) request.getBody());
        } else {
            this.requestInvalid(request);
        }
    }

    private void requestInvalid(HttpRequest request) {
        throw new RequestInvalidException("method error: " + request.getMethod());
    }

}
