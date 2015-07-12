package pl.mg.socialler.bean;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;

/**
 * Created by m on 2015-07-11.
 */
public class MessageFilerBean {
    @MatrixParam("param")
    public String matrixparam;

    @HeaderParam("headerParam")
    public String headerParam;

    @CookieParam("cookieParam")
    public String cookieParam;
}
