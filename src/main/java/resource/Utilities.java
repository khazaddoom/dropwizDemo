package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@Path("/")
public class Utilities {
    private final int defaultSize;

    public Utilities(int defaultSize) {
        this.defaultSize = defaultSize;
    }

    @GET
    public String getBrands(@QueryParam("size") Optional<Integer> size) {
        System.out.println("Size sent was" + size.orElse(defaultSize));
//        System.out.println("Defaultsize was" + defaultSize);
        return "Hello world!";
    }
}
