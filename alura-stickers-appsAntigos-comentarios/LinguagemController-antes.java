//LinguagemController antes
package linguagensapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // para representar esse recurso
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    private List<Linguagem> linguagens = 
        List.of(
            new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
            new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2)
        ); 

    @GetMapping(value="/linguagem-preferida") // metadado GetMapping
    public String processaLinguagemPreferida(){
        return "Oi, Java";
    }

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }


    
} */
