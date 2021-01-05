package com.example.revision;

import com.example.revision.model.Stream;
import com.example.revision.model.Viewer;
import com.example.revision.repository.StreamRepository;
import com.example.revision.repository.ViewerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RevisionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext=
        SpringApplication.run (RevisionApplication.class, args);
        StreamRepository streamRepository=
                configurableApplicationContext.getBean (StreamRepository.class);
        ViewerRepository viewerRepository=
                configurableApplicationContext.getBean (ViewerRepository.class);
        Viewer oussema =new Viewer ("Oussema twil");
        Viewer elleuch=new Viewer ("Mohamed elleuch");
        Viewer msetti =new Viewer ("Mohamed msetti");

        List<Viewer> viewers= Arrays.asList (oussema,elleuch,  msetti);

        Stream cookingStream = new Stream ("Djej routi");
        Stream gamingStream=new Stream ("League of legeneds ");

        List<Stream> streams = Arrays.asList (cookingStream,gamingStream);

        streamRepository.saveAll (streams);

        oussema.followedStream (gamingStream);
        elleuch.followedStream (cookingStream);
        msetti.followedStream (gamingStream);

        viewerRepository.saveAll (viewers);
    }

}
