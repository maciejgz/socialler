package pl.mg.socialler.exception;

import pl.mg.socialler.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by m on 2015-07-12.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException exception) {
        ErrorMessage message = new ErrorMessage();
        message.setErrorCode(404);
        message.setErrorMessage(exception.getMessage());
        message.setDocumentation("no doc");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(message)
                .build();
    }
}
