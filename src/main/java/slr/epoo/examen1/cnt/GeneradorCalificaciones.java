/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slr.epoo.examen1.cnt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import slr.epoo.examen1.mdl.Evaluacion;

/**
 *
 * @author Aaron
 */
@Controller
@RequestMapping("/calificaciones")
public class GeneradorCalificaciones {
    private static final Logger logger = Logger.getLogger(GeneradorCalificaciones.class.getName());
    
    private ArrayList<Evaluacion> generarCalificaciones(){
        ArrayList<Evaluacion> a = new ArrayList<>();
            a.add(new Evaluacion("Petra", (float) 5.8));
            a.add(new Evaluacion("Jose", (float) 7.4));
            a.add(new Evaluacion("Roberta", (float) 8.6));
            return a;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/servicio-calificaciones", headers = {"Accept=Application/JSON"})
    public @ResponseBody String servicioCalificaciones() throws IOException{
        String res;
        JsonFactory fc = new JsonFactory(null);
        ObjectMapper ob = new ObjectMapper(fc);
        try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
            JsonGenerator jg = ob.getJsonFactory().createJsonGenerator(out);
            jg.writeObject(java.util.Collections.singletonMap("object", generarCalificaciones()));
            res = out.toString();
        }
        logger.log(Level.INFO, res);
        return res;
    }
}
