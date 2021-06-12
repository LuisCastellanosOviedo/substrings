package co.com.refactor.dataaccess.da.access;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAConnection {

    @Value("${social.media.app.db.port}")
    private int port;

    @Value("${social.media.app.db.hostUrl}")
    private String hostUrl;

    @Bean
    public Connection getConnection() {

        // aca no entro en detalles , aca se crea la conexion y se retorna un objeto relacionada a este , no se
        // usan repositories para respetar parte de la definicion de la prueba
        return new Connection(port, hostUrl);
    }
}
