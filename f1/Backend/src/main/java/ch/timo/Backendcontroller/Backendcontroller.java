package ch.timo.Backendcontroller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class Backendcontroller {

    @ResponseBody
    @RequestMapping(path = "/drivers")
    public String Drivers() throws IOException {
        
        return new String(Backendcontroller.class.getResourceAsStream("../../../json-files/drivers.json").readAllBytes());
    }

}
