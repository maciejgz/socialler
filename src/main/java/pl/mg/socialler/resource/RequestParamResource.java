package pl.mg.socialler.resource;

import pl.mg.socialler.bean.MessageFilerBean;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by m on 2015-07-11.
 */
@Path("/paramtest")
@Produces("text/plain")
public class RequestParamResource {

    @GET
    /**
     * @RequestParam - parametr na liœcie argumentów w zapytaniu, standardowy
     @MatrixParam - w adresie po znaku ‘;’, np. http://localhost:9080/socialler/webapi/paramtest;param=value
     Raczej rzadko u¿ywany
     @HeaderParam - parametry w headerze - standard dla logowania, sessionId, tokenów, itp.
     @CookieParam - wartoœæ przechowywana w ciasteczku
     @FormParam - w jax rs nie jest u¿ywany, bo nie ma formularzy

     */
    public String paramsTest(@MatrixParam("param") String matrixparam, @HeaderParam("headerParam") String headerParam, @CookieParam("cookieParam") String cookieParam) {
        return "matrixParam" + matrixparam + ";" + "headerParam=" + headerParam + ";cookieParam=" + cookieParam;
    }

    @GET
    @Path("/beanparam")
    public String paramsBeanTest(@BeanParam MessageFilerBean filterBean) {
        return "matrixParam" + filterBean.matrixparam + ";" + "headerParam=" + filterBean.headerParam + ";cookieParam=" + filterBean.cookieParam;
    }

    @GET
    @Path("context")
    public String getParamUsingContext(@Context UriInfo uriInfo) {
        System.out.println(uriInfo.getAbsolutePath());
        return "test";
    }

}
